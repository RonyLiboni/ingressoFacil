package br.com.gft.ingressofacil.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gft.ingressofacil.model.CasaDeShow;
import br.com.gft.ingressofacil.model.Evento;
import br.com.gft.ingressofacil.service.CasaDeShowService;
import br.com.gft.ingressofacil.service.EventoService;

@Controller
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	@Autowired
	private CasaDeShowService casaDeShowService;
	
	@GetMapping
	public String listarEventos(Model model, Evento evento) {
		
		List<Evento> listaEventos = eventoService.listarEventos();
		model.addAttribute("listaEventos", listaEventos);
		List<CasaDeShow> listaCasaDeShow = casaDeShowService.listarCasasDeShow();
		model.addAttribute("listaCasaDeShow", listaCasaDeShow);
		
		return "/admin/eventos";
	}
	
	@PostMapping("cadastrar")
	public String cadastrarEvento(@Valid Evento evento,BindingResult result, Model model ) {
		evento.setQuantidadeIngressosDisponiveis(evento.getQuantidadeIngressos());
		
		if(result.hasErrors()) 
			return listarEventos(model, evento);
		
		if(evento.getImagemDoEvento().equals(null) 
				|| evento.getImagemDoEvento().equals("") ) //se o adm nao colocar uma imagem essa é a padrao
			evento.setImagemDoEvento("https://ancoracomunicacao.com.br/images/up/News/72/1200x800-1/72a50b5-musica-1200x1200.jpg");
				
		try {
			eventoService.salvar(evento);
		} catch (Exception e) { //Se a string da imagem é muito grande, a imagem nao entra no banco, entao fiz esse tratamento para colocar uma imagem padrao
			evento.setImagemDoEvento("https://ancoracomunicacao.com.br/images/up/News/72/1200x800-1/72a50b5-musica-1200x1200.jpg");
			eventoService.salvar(evento);
		}		
		
		return "redirect:/evento";
	}
		
	@GetMapping("editar")
	public String editarEvento(Long id, Model model) {
		Evento evento = eventoService.acharPeloId(id);
		model.addAttribute("qtdIngressosVendidos", evento.getQuantidadeIngressosVendidos());
		model.addAttribute("evento", evento);		
		model.addAttribute("mensagem", "Agora você pode alterar os dados que precisa!");
		return listarEventos(model, evento);
	}
	
	@GetMapping("deletar")
	public String deletarEvento(Long id, Model model) {
		try {
			eventoService.deletarPeloId(id);
		} catch (EmptyResultDataAccessException e) {
			Evento evento =new Evento();
			model.addAttribute("evento", evento);
			model.addAttribute("mensagem", "O evento com id="+id+" não existe");
			return listarEventos(model, evento);
		}
				
		return "redirect:/evento";
	}
	
	@GetMapping("inserirEventos")
	public String popularEventos() {
		CasaDeShow casaDeShow=casaDeShowService.listarCasasDeShow().get(0);
		eventoService.popularBancoComEventos(casaDeShow);		
		
		return "redirect:/evento";
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public String onError() {
		return "redirect:/evento";
	}
	
}

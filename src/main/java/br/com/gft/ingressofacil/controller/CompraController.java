package br.com.gft.ingressofacil.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.gft.ingressofacil.model.Evento;
import br.com.gft.ingressofacil.model.Ingresso;
import br.com.gft.ingressofacil.service.ClienteService;
import br.com.gft.ingressofacil.service.EventoService;


@Controller
@RequestMapping("/comprar")
public class CompraController {
	
	@Autowired
	private EventoService eventoService;
	@Autowired
	private ClienteService clienteService;
	
	
	@GetMapping
	public String escolherQuantidadeDeIngressos( Model model, @RequestParam Long id, Ingresso ingresso ) {
	
		Evento evento = eventoService.acharPeloId(id);		
		model.addAttribute("evento", evento);
		
		return "cliente/comprarIngressos";
	}
	
	
	@PostMapping("/resumoCompra")
	public ModelAndView resumoCompra(Ingresso ingresso, @RequestParam Long id, Principal principal, RedirectAttributes redirectAttributes) {
		
		ModelAndView mv = new ModelAndView("redirect:/minhasCompras");
		
		eventoService.atualizaDadosDoEvento(id, ingresso.getQuantidadeIngressosComprados());
		ingresso = eventoService.toIngresso(id, ingresso);
		
		clienteService.atualizaHistoricoDoCliente(principal.getName(), ingresso);
		
		redirectAttributes.addFlashAttribute("mensagem", "Compra concluida com sucesso!");
		redirectAttributes.addFlashAttribute("ingresso", ingresso);
			
		return mv;
	}
	
	
	
}

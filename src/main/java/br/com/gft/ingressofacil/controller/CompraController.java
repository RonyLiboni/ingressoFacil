package br.com.gft.ingressofacil.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.gft.ingressofacil.model.Evento;
import br.com.gft.ingressofacil.model.Ingresso;
import br.com.gft.ingressofacil.service.EventoService;


@Controller
@RequestMapping("/comprar")
public class CompraController {
	
	@Autowired
	private EventoService eventoService;
	
	
	
	@GetMapping
	public String escolherQuantidadeDeIngressos( Model model, Ingresso ingresso, Long id ) {
	
		Evento evento = eventoService.acharPeloId(id);
		
		model.addAttribute("evento", evento);
		model.addAttribute("ingresso", ingresso);
		
		
		return "cliente/comprarIngressos";
	}
	
	
	@PostMapping("/resumoCompra")
	public String resumoCompra(Ingresso ingresso, Model model,Evento evento,  Integer quantidadeIngressosComprados) {
		
		
		
		
		return "redirect:/home";
	}
	
	@PostMapping
	public String finalizarCompra() {
		
		return "";
	}
	
}

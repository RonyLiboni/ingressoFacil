package br.com.gft.ingressofacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gft.ingressofacil.model.Evento;
import br.com.gft.ingressofacil.service.EventoService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private EventoService eventoService;
	
	@GetMapping
	public String listarEventos(Model model, Evento evento) {
		List<Evento> listaEventos = eventoService.listarEventos();
		model.addAttribute("listaEventos", listaEventos);
		return "home";
	}
}

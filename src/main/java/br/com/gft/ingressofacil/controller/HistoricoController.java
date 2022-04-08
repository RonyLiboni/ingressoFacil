package br.com.gft.ingressofacil.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gft.ingressofacil.model.Ingresso;
import br.com.gft.ingressofacil.service.ClienteService;

@Controller
@RequestMapping("/minhasCompras")
public class HistoricoController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public String listarComprasDoCliente(Model model, Principal principal) {
		
		List<Ingresso> listaIngressos = clienteService.listarIngressos(principal.getName());
		model.addAttribute("listaIngressos", listaIngressos);
		
		if(listaIngressos.isEmpty())
			model.addAttribute("mensagem", "Você ainda não comprou ingressos conosco!");
			
		
		return "cliente/minhasCompras";
	}

	
	
}

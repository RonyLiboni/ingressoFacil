package br.com.gft.ingressofacil.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gft.ingressofacil.model.Cliente;
import br.com.gft.ingressofacil.repository.UserRepository;
import br.com.gft.ingressofacil.service.ClienteService;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public String cadastrarCliente(Model model, Cliente cliente) {
		return "cadastrar";
	}
	
	@PostMapping("cadastrarCliente")
	public String cadastrarCliente(@Valid Cliente cliente, BindingResult result , Model model){
		if(result.hasErrors()) 
			return cadastrarCliente(model, cliente);
		
		boolean usuarioExistente = userRepository.findById(cliente.getUsername()).isPresent();
		if (usuarioExistente) {
			model.addAttribute("mensagem","Usuario ja existe, tente outro");
			return "cadastrar";
		}
		
		clienteService.salvar(cliente);
		return "redirect:/login";
	}
	
		
}

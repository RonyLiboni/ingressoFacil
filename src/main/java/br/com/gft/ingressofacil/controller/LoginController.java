package br.com.gft.ingressofacil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	@GetMapping
	public String realizarLogin() {
		return "login";
	}
}

package br.com.gft.ingressofacil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.gft.ingressofacil.model.Authorities;
import br.com.gft.ingressofacil.model.Cliente;
import br.com.gft.ingressofacil.model.Ingresso;
import br.com.gft.ingressofacil.model.Users;
import br.com.gft.ingressofacil.repository.AuthoritiesRepository;
import br.com.gft.ingressofacil.repository.ClienteRepository;
import br.com.gft.ingressofacil.repository.UserRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AuthoritiesRepository authoritiesRepository;
	
	public void salvar(Cliente cliente) {
		criarUsuarioNoBancoDeDados(cliente);
		
		clienteRepository.save(cliente);
	}
	
	
	private void criarUsuarioNoBancoDeDados(Cliente cliente) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();	
		String encodedPassword = encoder.encode(cliente.getPassword());
		
		
		Users user = new Users();
		user.setEnabled(true);
		user.setPassword(encodedPassword);
		user.setUsername(cliente.getUsername());
		userRepository.save(user);
		
		Authorities auth = new Authorities();
		auth.setAuthority("ROLE_USER");
		auth.setUsername(cliente.getUsername());
		authoritiesRepository.save(auth);
		
	}


	public Cliente acharPeloId(String id) {
		Cliente cliente = clienteRepository.findById(id).get();
		return cliente;
	}


	public void atualizaHistoricoDoCliente(String username, Ingresso ingresso) {
		Cliente cliente = clienteRepository.findByUsername(username);
		cliente.adicionaIngresso(ingresso);
		clienteRepository.save(cliente);
		
	}


	public List<Ingresso> listarIngressos(String username) {
		Cliente cliente = clienteRepository.findByUsername(username);
		return cliente.getIngressos();
	}
	
	
	
}

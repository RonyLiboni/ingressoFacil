package br.com.gft.ingressofacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gft.ingressofacil.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, String>{
	
	Cliente findByUsername(String username);
}

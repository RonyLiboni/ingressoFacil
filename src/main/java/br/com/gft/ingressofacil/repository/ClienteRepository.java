package br.com.gft.ingressofacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.gft.ingressofacil.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, String>{
	
	Cliente findByUsername(String username);
	
	@Query(value = "SELECT SUM(quantidade_ingressos_comprados) AS quantidade FROM ingresso_facil.cliente_ingressos "
			+ "WHERE ingresso_facil.cliente_ingressos.evento_id = :eventoId" ,nativeQuery = true)
	Integer quantidadeDeIngressosVendidosPorEvento(Long eventoId);
	
	
}

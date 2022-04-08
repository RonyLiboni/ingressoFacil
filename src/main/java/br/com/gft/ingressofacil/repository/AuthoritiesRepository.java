package br.com.gft.ingressofacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gft.ingressofacil.model.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, String> {

}

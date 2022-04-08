package br.com.gft.ingressofacil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gft.ingressofacil.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{

}

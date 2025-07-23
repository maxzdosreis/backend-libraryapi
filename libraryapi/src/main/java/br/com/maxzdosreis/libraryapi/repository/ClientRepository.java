package br.com.maxzdosreis.libraryapi.repository;

import br.com.maxzdosreis.libraryapi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByClientId(Long clientId);
}

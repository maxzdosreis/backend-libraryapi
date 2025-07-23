package br.com.maxzdosreis.libraryapi.repository;

import br.com.maxzdosreis.libraryapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByLogin(String login);

    Usuario findByEmail(String email);
}

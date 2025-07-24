package br.com.maxzdosreis.libraryapi.validator;

import br.com.maxzdosreis.libraryapi.dto.AutorComLivrosDTO;
import br.com.maxzdosreis.libraryapi.dto.AutorDTO;
import br.com.maxzdosreis.libraryapi.exception.DuplicateRegistration;
import br.com.maxzdosreis.libraryapi.model.Autor;
import br.com.maxzdosreis.libraryapi.repository.AutorRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AutorValidator {

    public AutorRepository repository;

    public AutorValidator(AutorRepository repository) {
        this.repository = repository;
    }

    public void validarAutor(Autor autor) {
        if (existeAutorCadastrado(autor)) {
            throw new DuplicateRegistration(("Autor já cadastrado!"));
        }
    }

    private boolean existeAutorCadastrado(Autor autor) {
        Optional<Autor> autorEncontrado = repository.findByNomeAndDataNascimentoAndNacionalidade(
                autor.getNome(), autor.getDataNascimento(), autor.getNacionalidade()
        );

        if(autor.getId() == null){
            return autorEncontrado.isPresent();
        }
        return !autor.getId().equals(autorEncontrado.get().getId()) && autorEncontrado.isPresent();
    }
}

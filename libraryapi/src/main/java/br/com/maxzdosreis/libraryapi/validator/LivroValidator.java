package br.com.maxzdosreis.libraryapi.validator;

import br.com.maxzdosreis.libraryapi.exception.DuplicateRegistration;
import br.com.maxzdosreis.libraryapi.exception.InvalidFieldException;
import br.com.maxzdosreis.libraryapi.model.Livro;
import br.com.maxzdosreis.libraryapi.repository.LivroRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LivroValidator {

    private static final int ANO_EXIGENCIA_PRECO = 2018;

    private final LivroRepository repository;

    public LivroValidator(LivroRepository repository) {
        this.repository = repository;
    }

    public void validar(Livro livro) {
        if(existeLivroComIsbn(livro)){
            throw new DuplicateRegistration("ISBN já registrado!");
        }

        if(isPrecoObrigatorioNulo(livro)){
            throw new InvalidFieldException("preco", "Para livros com ano de publicação a partir de 2018, o preço é obrigatório");
        }
    }

    private boolean isPrecoObrigatorioNulo(Livro livro){
        return livro.getPreco() == null && livro.getDataPublicacao().getYear() >= ANO_EXIGENCIA_PRECO;
    }

    private boolean existeLivroComIsbn(Livro livro){
        Optional<Livro> livroEncontrado = repository.findByIsbn(livro.getIsbn());

        if (livro.getId() == null) {
            return livroEncontrado.isPresent();
        }

        return livroEncontrado
                .map(Livro::getId)
                .stream()
                .anyMatch(id -> !id.equals(livro.getId()));
    }
}

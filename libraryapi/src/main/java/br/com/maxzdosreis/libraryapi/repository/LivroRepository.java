package br.com.maxzdosreis.libraryapi.repository;

import br.com.maxzdosreis.libraryapi.model.Autor;
import br.com.maxzdosreis.libraryapi.model.GeneroLivro;
import br.com.maxzdosreis.libraryapi.model.Livro;
import br.com.maxzdosreis.libraryapi.model.Usuario;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long>, JpaSpecificationExecutor<Livro> {
    Page<Livro> findByAutor(Autor autor, Pageable pageable);

    // select * from livro where id_autor = id
    List<Livro> findByAutor(Autor autor);

    // select * from livro where titulo = titulo
    List<Livro> findByTitulo(String titulo);

    // select * from livro where isbn = ?
    Optional<Livro> findByIsbn(String isbn);

    // select * from livro where titulo = ? and preco = ?
    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    // select * from livro where titulo = ? or isbn = ?
    List<Livro> findByTituloOrIsbnOrderByTitulo(String titulo, String isbn);

    // select * from livro where data_publicacao between ? and ?
    List<Livro> findByDataPublicacaoBetween(LocalDate inicio, LocalDate fim);

    // select l.* from livro as l order by l.titulo
    @Query("select l from Livro as l order by l.titulo, l.preco")
    List<Livro> listarTodosOrdenadoPorTituloAndPreco();

    // select a.* from livro l join autor a on a.id = l.id_autor
    @Query("select a from Livro l join l.autor a")
    List<Autor> listarAutoresDosLivros();

    // select distinct l.* from livro l
    @Query("select distinct l.titulo from Livro l")
    List<String> listarNomesDiferentesLivros();

    @Query("""
        select l.genero
        from Livro l
        join l.autor a
        where a.nacionalidade = 'Brasileira'
        order by l.genero
    """)
    List<String> listarGenerosAutoresBrasileiros();

    @Query("select l from Livro l where l.genero = :genero order by :paramOrdenacao")
    List<Livro> findByGenero(
            @PathParam("genero")GeneroLivro generoLivro,
            @PathParam("paramOrdenacao") String nomePropriedade
    );

    @Query("select l from Livro l where l.genero = ?2 order by ?1 ")
    List<Livro> findByGeneroPositionalParameters(String nomePropriedade, GeneroLivro generoLivro);

    @Modifying
    @Transactional
    @Query("delete from Livro where genero = ?1")
    void deleteByGenero(GeneroLivro generoLivro);

    @Modifying
    @Transactional
    @Query("update Livro set dataPublicacao = ?1")
    void updateDataPublicacao(LocalDate novaData);

    boolean existsByAutor(Autor autor);
}

package br.com.maxzdosreis.libraryapi.dto;

import br.com.maxzdosreis.libraryapi.model.GeneroLivro;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class LivroDTO {

    private Long id;

    @NotBlank(message = "ISBN é obrigatório")
    private String isbn;

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotNull(message = "Data de publicação é obrigatória")
    @PastOrPresent(message = "A data de publicação não pode estar no futuro")
    private LocalDate dataPublicacao;

    @NotNull(message = "Gênero é obrigatório")
    private GeneroLivro genero;

    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.0", inclusive = true, message = "O preço deve ser maior ou igual a zero")
    private BigDecimal preco;

    @NotNull(message = "Autor é obrigatório")
    @Valid
    private AutorDTO autor;

    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    @NotNull(message = "Usuário é obrigatório")
    @Valid
    private UsuarioDTO usuario;

    public LivroDTO() {}

    public LivroDTO(Long id, String isbn, String titulo, LocalDate dataPublicacao, GeneroLivro genero, BigDecimal preco, AutorDTO autor, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao, UsuarioDTO usuario) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
        this.genero = genero;
        this.preco = preco;
        this.autor = autor;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.usuario = usuario;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public LocalDate getDataPublicacao() { return dataPublicacao; }

    public void setDataPublicacao(LocalDate dataPublicacao) { this.dataPublicacao = dataPublicacao; }

    public GeneroLivro getGenero() { return genero; }

    public void setGenero(GeneroLivro genero) { this.genero = genero; }

    public BigDecimal getPreco() { return preco; }

    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public AutorDTO getAutor() { return autor; }

    public void setAutor(AutorDTO autor) { this.autor = autor; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }

    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    public UsuarioDTO getUsuario() { return usuario; }

    public void setUsuario(UsuarioDTO usuario) { this.usuario = usuario; }
}

package br.com.maxzdosreis.libraryapi.model;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAnyElement;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "livro")
@EntityListeners(AuditingEntityListener.class)
public class Livro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30, nullable = false)
    private GeneroLivro genero;

    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal preco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Livro() {}

    public Livro(Long id, Usuario usuario, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao, Autor autor, BigDecimal preco, GeneroLivro genero, LocalDate dataPublicacao, String titulo, String isbn) {
        this.id = id;
        this.usuario = usuario;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.autor = autor;
        this.preco = preco;
        this.genero = genero;
        this.dataPublicacao = dataPublicacao;
        this.titulo = titulo;
        this.isbn = isbn;
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

    public Autor getAutor() { return autor; }

    public void setAutor(Autor autor) { this.autor = autor; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }

    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return Objects.equals(id, livro.id) && Objects.equals(isbn, livro.isbn) && Objects.equals(titulo, livro.titulo) && Objects.equals(dataPublicacao, livro.dataPublicacao) && Objects.equals(genero, livro.genero) && Objects.equals(preco, livro.preco) && Objects.equals(autor, livro.autor) && Objects.equals(dataCadastro, livro.dataCadastro) && Objects.equals(dataAtualizacao, livro.dataAtualizacao) && Objects.equals(usuario, livro.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isbn, titulo, dataPublicacao, genero, preco, autor, dataCadastro, dataAtualizacao, usuario);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", genero=" + genero +
                ", preco=" + preco +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                ", usuario=" + usuario +
                '}';
    }
}

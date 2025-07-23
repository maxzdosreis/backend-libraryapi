package br.com.maxzdosreis.libraryapi.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "autor", schema = "public")
@EntityListeners(AuditingEntityListener.class)
public class Autor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nacionalidade;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private List<Livro> livros;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Autor() {}

    public Autor(Long id, String nome, LocalDate dataNascimento, String nacionalidade, LocalDateTime dataCadastro, LocalDateTime dataAtualizacao, Usuario usuario, List<Livro> livros) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.usuario = usuario;
        this.livros = livros;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getNacionalidade() { return nacionalidade; }

    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    public List<Livro> getLivros() { return livros; }

    public void setLivros(List<Livro> livros) { this.livros = livros; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }

    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getDataAtualizacao() { return dataAtualizacao; }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(nome, autor.nome) && Objects.equals(dataNascimento, autor.dataNascimento) && Objects.equals(nacionalidade, autor.nacionalidade) && Objects.equals(livros, autor.livros) && Objects.equals(dataCadastro, autor.dataCadastro) && Objects.equals(dataAtualizacao, autor.dataAtualizacao) && Objects.equals(usuario, autor.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dataNascimento, nacionalidade, livros, dataCadastro, dataAtualizacao, usuario);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataAtualizacao=" + dataAtualizacao +
                ", usuario=" + usuario +
                '}';
    }
}

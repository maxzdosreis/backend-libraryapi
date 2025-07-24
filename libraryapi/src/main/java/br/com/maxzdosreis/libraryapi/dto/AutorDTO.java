package br.com.maxzdosreis.libraryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AutorDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser no passado")
    private LocalDate dataNascimento;

    @NotBlank(message = "Nacionalidade é obrigatória")
    private String nacionalidade;

    private LocalDateTime dataCadastro;
    private LocalDateTime dataAlteracao;

    @NotNull(message = "Usuário é obrigatório")
    private UsuarioDTO usuario;

    public AutorDTO() {}

    public AutorDTO(Long id, String nome, LocalDate dataNascimento, String nacionalidade, LocalDateTime dataCadastro, LocalDateTime dataAlteracao, UsuarioDTO usuario) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nacionalidade = nacionalidade;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.usuario = usuario;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getNacionalidade() { return nacionalidade; }

    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade; }

    public LocalDateTime getDataCadastro() { return dataCadastro; }

    public void setDataCadastro(LocalDateTime dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getDataAlteracao() { return dataAlteracao; }

    public void setDataAlteracao(LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }

    public UsuarioDTO getUsuario() { return usuario; }

    public void setUsuario(UsuarioDTO usuario) { this.usuario = usuario; }
}

package br.com.maxzdosreis.libraryapi.dto;

import jakarta.validation.constraints.NotBlank;

public class LivroResumoDTO {

    private Long id;

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    public LivroResumoDTO() {}

    public LivroResumoDTO(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
}

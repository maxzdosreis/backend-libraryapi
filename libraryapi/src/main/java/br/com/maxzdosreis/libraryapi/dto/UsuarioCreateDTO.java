package br.com.maxzdosreis.libraryapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class UsuarioCreateDTO {

    private Long id;

    @NotBlank(message = "Login é obrigatório")
    @Size(min = 3, max = 50, message = "Login deve ter entre 3 e 50 caracteres")
    private String login;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
    private String senha;

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotNull(message = "Pelo menos um papel (role) deve ser definido")
    private List<@NotBlank String> roles;

    public UsuarioCreateDTO() {}

    public UsuarioCreateDTO(Long id, String login, String senha, String email, List<String> roles) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public List<String> getRoles() { return roles; }

    public void setRoles(List<String> roles) { this.roles = roles; }
}

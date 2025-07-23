package br.com.maxzdosreis.libraryapi.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Column(unique = true, nullable = false)
    private String email;

    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "roles", columnDefinition = "varchar[]")
    private List<String> roles;

    public Usuario() {}

    public Usuario(Long id, List<String> roles, String email, String senha, String login) {
        this.id = id;
        this.roles = roles;
        this.email = email;
        this.senha = senha;
        this.login = login;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public List<String> getRoles() { return roles; }

    public void setRoles(List<String> roles) { this.roles = roles; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }
}

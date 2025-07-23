package br.com.maxzdosreis.libraryapi.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id")
    private String clientId;

    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "redirect_uri")
    private String redirectURI;

    @Column(name = "scope")
    private String scope;

    public Client() {}

    public Client(Long id, String clientId, String clientSecret, String redirectURI, String scope) {
        this.id = id;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectURI = redirectURI;
        this.scope = scope;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getClientId() { return clientId; }

    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getClientSecret() { return clientSecret; }

    public void setClientSecret(String clientSecret) { this.clientSecret = clientSecret; }

    public String getScope() { return scope; }

    public void setScope(String scope) { this.scope = scope; }

    public String getRedirectURI() { return redirectURI; }

    public void setRedirectURI(String redirectURI) { this.redirectURI = redirectURI; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(clientId, client.clientId) && Objects.equals(clientSecret, client.clientSecret) && Objects.equals(redirectURI, client.redirectURI) && Objects.equals(scope, client.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, clientSecret, redirectURI, scope);
    }
}

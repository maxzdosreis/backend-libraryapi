package br.com.maxzdosreis.libraryapi.dto;

import jakarta.validation.constraints.NotBlank;

public class ClientDTO {

    private Long id;

    @NotBlank(message = "Client ID é obrigatório")
    private String clientId;

    @NotBlank(message = "Redirect URI é obrigatória")
    private String redirectURI;

    @NotBlank(message = "Scope é obrigatório")
    private String scope;

    public ClientDTO() {}

    public ClientDTO(Long id, String clientId, String redirectURI, String scope) {
        this.id = id;
        this.clientId = clientId;
        this.redirectURI = redirectURI;
        this.scope = scope;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getClientId() { return clientId; }

    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getRedirectURI() { return redirectURI; }

    public void setRedirectURI(String redirectURI) { this.redirectURI = redirectURI; }

    public String getScope() { return scope; }

    public void setScope(String scope) { this.scope = scope; }
}

package br.com.maxzdosreis.libraryapi.dto;

import jakarta.validation.constraints.NotBlank;

public class ClientAuthDTO {

    @NotBlank(message = "Client ID é obrigatório")
    private String clientId;

    @NotBlank(message = "Client Secret é obrigatório")
    private String clientSecret;

    public ClientAuthDTO() {}

    public ClientAuthDTO(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientId() { return clientId; }

    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getClientSecret() { return clientSecret; }

    public void setClientSecret(String clientSecret) { this.clientSecret = clientSecret; }
}

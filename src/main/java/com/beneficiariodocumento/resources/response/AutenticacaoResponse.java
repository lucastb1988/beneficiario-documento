package com.beneficiariodocumento.resources.response;

public class AutenticacaoResponse {

    private String accessToken;

    public AutenticacaoResponse() {
    }

    public AutenticacaoResponse(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
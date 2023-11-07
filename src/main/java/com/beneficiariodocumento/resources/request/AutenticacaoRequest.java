package com.beneficiariodocumento.resources.request;

import javax.validation.constraints.NotNull;

public class AutenticacaoRequest {

    @NotNull
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
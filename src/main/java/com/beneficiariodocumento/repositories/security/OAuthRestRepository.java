package com.beneficiariodocumento.repositories.security;

import com.beneficiariodocumento.resources.response.AutenticacaoResponse;
import org.springframework.stereotype.Repository;

import static java.util.UUID.randomUUID;

@Repository
public class OAuthRestRepository {

    public AutenticacaoResponse gerarAccessToken() {
        return new AutenticacaoResponse(randomUUID().toString());
    }
}
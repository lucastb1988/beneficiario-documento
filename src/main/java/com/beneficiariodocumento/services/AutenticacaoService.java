package com.beneficiariodocumento.services;

import com.beneficiariodocumento.resources.response.AutenticacaoResponse;

public interface AutenticacaoService {

    AutenticacaoResponse login(String username);
}
package com.beneficiariodocumento.services.impl;

import com.beneficiariodocumento.domain.security.SessaoInfo;
import com.beneficiariodocumento.domain.security.Usuario;
import com.beneficiariodocumento.exception.NotFoundException;
import com.beneficiariodocumento.exception.UnauthorizedException;
import com.beneficiariodocumento.repositories.security.OAuthRestRepository;
import com.beneficiariodocumento.repositories.security.SessaoInfoRepository;
import com.beneficiariodocumento.repositories.security.UsuarioRepository;
import com.beneficiariodocumento.resources.response.AutenticacaoResponse;
import com.beneficiariodocumento.services.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {

    @Autowired
    private SessaoInfoRepository sessionInfoRepository;

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private OAuthRestRepository oauthProvider;

    public AutenticacaoResponse login(String username) {
        return autenticar(username);
    }

    private AutenticacaoResponse autenticar(final String username) throws UnauthorizedException {
        AutenticacaoResponse autenticacaoResponse;
        SessaoInfo sessaoInfo;
        Usuario usuario = null;

        if (!username.isEmpty()) {
            try {
                usuario = userRepository.findByEmail(username);
            } catch (NotFoundException e) {
                throw new UnauthorizedException("Credenciais inválidas");
            }
        }

        autenticacaoResponse = gerarAccessToken();
        sessaoInfo = new SessaoInfo(autenticacaoResponse.getAccessToken());
        sessaoInfo.setUserId(usuario.getId());
        sessionInfoRepository.save(sessaoInfo);

        return autenticacaoResponse;
    }

    private AutenticacaoResponse gerarAccessToken() {
        return oauthProvider.gerarAccessToken();
    }

}
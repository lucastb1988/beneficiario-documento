package com.beneficiariodocumento.services.impl;

import com.beneficiariodocumento.domain.security.ProfileEnum;
import com.beneficiariodocumento.domain.security.SessaoInfo;
import com.beneficiariodocumento.domain.security.Usuario;
import com.beneficiariodocumento.exception.UnauthorizedException;
import com.beneficiariodocumento.repositories.security.SessaoInfoRepository;
import com.beneficiariodocumento.repositories.security.UsuarioRepository;
import com.beneficiariodocumento.services.AutorizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Lazy
public class AutorizacaoServiceImpl implements AutorizacaoService {

    @Autowired
    private UsuarioRepository userRepository;

    @Autowired
    private UsuarioServiceImpl userService;

    @Autowired
    private SessaoInfoRepository sessionInfoRepository;

    public Usuario autorizar(final String accessToken, ProfileEnum... profiles) {
        SessaoInfo sessionInfo = sessionInfoRepository.findByAccessToken(accessToken);

        if (sessionInfo == null) {
            throw new UnauthorizedException("Token informado incorreto!");
        }

        Optional<Usuario> user = userRepository.findById(sessionInfo.getUserId());
        if (!user.isPresent()) {
            throw new UnauthorizedException("Usuário inexistente!");
        }

        for (ProfileEnum p : profiles) {
            if (user.get().getProfiles().contains(p.getDescription())) {
                return user.get();
            } else {
                throw new UnauthorizedException("Profile do usuário autenticado sem permissão para realizar a operação!");
            }
        }

        return null;
    }
}
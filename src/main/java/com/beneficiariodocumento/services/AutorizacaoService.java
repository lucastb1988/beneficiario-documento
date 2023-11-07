package com.beneficiariodocumento.services;

import com.beneficiariodocumento.domain.security.ProfileEnum;
import com.beneficiariodocumento.domain.security.Usuario;

public interface AutorizacaoService {

    Usuario autorizar(final String accessToken, ProfileEnum... profile);
}
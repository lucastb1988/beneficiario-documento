package com.beneficiariodocumento.services.impl;

import com.beneficiariodocumento.domain.security.ProfileEnum;
import com.beneficiariodocumento.domain.security.Usuario;
import com.beneficiariodocumento.exception.UnprocessableEntityAPIException;
import com.beneficiariodocumento.repositories.security.UsuarioRepository;
import com.beneficiariodocumento.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public void criar(Usuario user) {
        Usuario userDb = findByEmailExists(user.getEmail());

        if (userDb != null) {
            throw new UnprocessableEntityAPIException("Usuario já existente!");
        }

        user.getProfiles().forEach(p -> ProfileEnum.fromDescription(p));
        userRepository.save(user);
    }

    private Usuario findByEmailExists(String email) {
        return userRepository.findByEmail(email);
    }

}

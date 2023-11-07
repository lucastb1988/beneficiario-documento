package com.beneficiariodocumento.resources;

import com.beneficiariodocumento.domain.security.Usuario;
import com.beneficiariodocumento.dto.UsuarioDTO;
import com.beneficiariodocumento.services.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Api(tags = {"API dedicada a criar usuários."})
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService userService;

    @ApiOperation("Criação de usuário.")
    @PostMapping
    public ResponseEntity<UsuarioDTO> criar(@Valid @RequestBody UsuarioDTO userDto) {
        Usuario user = new Usuario();
        BeanUtils.copyProperties(userDto, user);
        userService.criar(user);

        return ResponseEntity.status(201).build();
    }
}

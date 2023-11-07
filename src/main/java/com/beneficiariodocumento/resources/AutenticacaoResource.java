package com.beneficiariodocumento.resources;

import com.beneficiariodocumento.resources.request.AutenticacaoRequest;
import com.beneficiariodocumento.resources.response.AutenticacaoResponse;
import com.beneficiariodocumento.services.AutenticacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"API dedicada a autenticação do login."})
@RestController
public class AutenticacaoResource {

    @Autowired
    private AutenticacaoService authenticationService;

    @ApiOperation("Autenticação de usuário")
    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    public AutenticacaoResponse login(
            @RequestBody AutenticacaoRequest authenticationRequest) {

        return authenticationService.login(authenticationRequest.getUser());
    }
}
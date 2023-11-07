/*
 * Copyright 2018 iguatemi
 *************************************************************
 *Nome     : UnprocessableEntityAPIException.java
 *Autor    : Builders
 *Data     : Mon May 28 2018 13:06:17 GMT-0300 (BRT)
 *Empresa  : Platform Builders
 *************************************************************
 */
package com.beneficiariodocumento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityAPIException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UnprocessableEntityAPIException(String errorCode) {
        super(errorCode);
    }


}

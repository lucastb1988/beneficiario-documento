/*
 * Copyright 2018 iguatemi
 *************************************************************
 *Nome     : NotFoundException.java
 *Autor    : Builders
 *Data     : Mon May 28 2018 13:06:17 GMT-0300 (BRT)
 *Empresa  : Platform Builders
 *************************************************************
 */
package com.beneficiariodocumento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(final Throwable cause) {
        super(cause);
    }

    public NotFoundException(final String msg) {
        super(new Throwable(msg));
    }
}


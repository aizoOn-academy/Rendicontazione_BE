package com.aizoon.rendicontazione.error.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DuplicateResourceException extends ResponseStatusException {

    private static final long serialVersionUID = 1L;

    public DuplicateResourceException(String reason) {
        super(HttpStatus.CONFLICT, reason);
    }
}
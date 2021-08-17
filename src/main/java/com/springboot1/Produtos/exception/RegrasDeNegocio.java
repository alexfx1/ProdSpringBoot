package com.springboot1.Produtos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@SuppressWarnings("supress")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RegrasDeNegocio extends RuntimeException {
    public RegrasDeNegocio(String msg) {
        super(msg);
    }
}
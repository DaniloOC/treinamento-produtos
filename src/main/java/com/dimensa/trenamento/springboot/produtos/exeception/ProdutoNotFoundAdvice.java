package com.dimensa.trenamento.springboot.produtos.exeception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProdutoNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ProdutoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String produtoNotFoundException(ProdutoNotFoundException exception) {
        return exception.getMessage();
    }
    
}

package com.dimensa.trenamento.springboot.produtos.exeception;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Map<String, List<String>>> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).toList();
        return new ResponseEntity<>(errorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> errorsMap(List<String> errors) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        errorResponse.put("erros", errors);
        return errorResponse;
    }

}

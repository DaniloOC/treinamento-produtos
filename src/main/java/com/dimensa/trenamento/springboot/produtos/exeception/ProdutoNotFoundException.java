package com.dimensa.trenamento.springboot.produtos.exeception;

public class ProdutoNotFoundException extends RuntimeException {

    public ProdutoNotFoundException(Long id) {
        super("Não foi encontrado um produto com id: " + id);
    }

}

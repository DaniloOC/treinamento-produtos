package com.dimensa.trenamento.springboot.produtos.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProdutoAtualizaDTO {

    @NotBlank
    @Size(min = 5, max = 255, message = "Tamanho invalido para o nome")
    private String nome;

    private String descricao;

    @NotNull
    @Min(value = 0, message = "Valor do produto tem que ser maior que zero.")
    private BigDecimal valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}

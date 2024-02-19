package com.dimensa.trenamento.springboot.produtos.model;

import java.math.BigDecimal;

import com.dimensa.trenamento.springboot.produtos.dto.ProdutoAtualizaDTO;
import com.dimensa.trenamento.springboot.produtos.dto.ProdutoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    private String descricao;

    private BigDecimal valor;

    public Produto() {
    }

    public Produto(ProdutoDTO dto) {
        id = dto.getId();
        nome = dto.getNome();
        descricao = dto.getDescricao();
        valor = dto.getValor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public void atualiza(ProdutoAtualizaDTO dto) {
        if (dto.getNome() != null) {
            this.nome = dto.getNome();
        }

        if (dto.getDescricao() != null) {
            this.descricao = dto.getDescricao();
        }

        if (dto.getValor() != null) {
            this.valor = dto.getValor();
        }
    }

}

package com.dimensa.trenamento.springboot.produtos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dimensa.trenamento.springboot.produtos.model.Produto;
import com.dimensa.trenamento.springboot.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listaTodos() {
        return repository.findAll();
    }

    public Produto incluir(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> obter(Long id) {
        return repository.findById(id);
    }

}

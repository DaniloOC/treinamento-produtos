package com.dimensa.trenamento.springboot.produtos.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dimensa.trenamento.springboot.produtos.dto.ProdutoAtualizaDTO;
import com.dimensa.trenamento.springboot.produtos.exeception.ProdutoNotFoundException;
import com.dimensa.trenamento.springboot.produtos.model.Produto;
import com.dimensa.trenamento.springboot.produtos.repository.ProdutoRepository;


@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public Page<Produto> listaTodos(Pageable paginacao) {
        return repository.findAll(paginacao);
    }

    public Produto incluir(Produto produto) {
        return repository.save(produto);
    }

    public Optional<Produto> obter(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Produto atualizar(Long id, ProdutoAtualizaDTO dto) {
        Optional<Produto> produtoOpt = repository.findById(id);
        if (!produtoOpt.isPresent()) {
            throw new ProdutoNotFoundException(id);
        }
        Produto produto = produtoOpt.get();
        produto.atualiza(dto);
        return repository.save(produto);
    }

    @Transactional
    public void excluir(Long id) {
        repository.deleteById(id);
    }

}

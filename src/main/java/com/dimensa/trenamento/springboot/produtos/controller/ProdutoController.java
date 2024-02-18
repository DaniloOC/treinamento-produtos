package com.dimensa.trenamento.springboot.produtos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dimensa.trenamento.springboot.produtos.exeception.ProdutoNotFoundException;
import com.dimensa.trenamento.springboot.produtos.model.Produto;
import com.dimensa.trenamento.springboot.produtos.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() {
        return service.listaTodos();
    }

    @PostMapping
    public Produto incluir(@RequestBody Produto produto) {
        return service.incluir(produto);
    }

    @GetMapping("/{id}")
    public Produto obter(@PathVariable Long id) {
        return service.obter(id)
            .orElseThrow(() -> new ProdutoNotFoundException(id));
    }
}

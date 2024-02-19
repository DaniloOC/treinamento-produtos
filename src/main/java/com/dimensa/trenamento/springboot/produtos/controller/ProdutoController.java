package com.dimensa.trenamento.springboot.produtos.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dimensa.trenamento.springboot.produtos.dto.ProdutoAtualizaDTO;
import com.dimensa.trenamento.springboot.produtos.dto.ProdutoDTO;
import com.dimensa.trenamento.springboot.produtos.exeception.ProdutoNotFoundException;
import com.dimensa.trenamento.springboot.produtos.model.Produto;
import com.dimensa.trenamento.springboot.produtos.service.ProdutoService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public Page<ProdutoDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return service.listaTodos(paginacao).map(ProdutoDTO::new);
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> incluir(@Valid @RequestBody ProdutoDTO dto, UriComponentsBuilder uriBuilder) {
        Produto produto = new Produto(dto);
        produto = service.incluir(produto);
        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        ProdutoDTO produtoDTO = new ProdutoDTO(produto);
        return ResponseEntity.created(uri).body(produtoDTO);
    }

    @GetMapping("/{id}")
    public ProdutoDTO obter(@PathVariable Long id) {
        Optional<Produto> produtoOpt = service.obter(id);
        if (!produtoOpt.isPresent()) {
            throw new ProdutoNotFoundException(id);
        } 
        return new ProdutoDTO(produtoOpt.get());
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizar(@PathVariable Long id, @RequestBody ProdutoAtualizaDTO dto) {
        Produto produto = service.atualizar(id, dto);
        return new ProdutoDTO(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }

}

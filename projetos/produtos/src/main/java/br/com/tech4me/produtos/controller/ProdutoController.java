package br.com.tech4me.produtos.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.produtos.model.Produto;
import br.com.tech4me.produtos.service.ProdutoService;
import br.com.tech4me.produtos.shared.ProdutoDto;

@RestController()
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> obterProdutos(){
        return new ResponseEntity<>(service.obterProdutos(), HttpStatus.OK);
    }

    @GetMapping(value = "/{codigo}")
    public ResponseEntity<ProdutoDto> produtoPorCodigo(@PathVariable String codigo){
        Optional<ProdutoDto> produto = service.produtoPorCodigo(codigo);
        
        if(produto.isPresent()){
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<ProdutoDto> criarProduto(@RequestBody ProdutoDto produto){
        service.criarProduto(produto);

        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{codigo}")
    public ResponseEntity<ProdutoDto> atualizarProduto(@PathVariable String codigo, @RequestBody ProdutoDto produto){
        ProdutoDto produtoNovo = service.atualizarProduto(codigo, produto);
        if(produtoNovo != null){
            return new ResponseEntity<>(produtoNovo, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping(value = "/{codigo}")
    public ResponseEntity<Produto> deletarProduto(@PathVariable String codigo){
        
        service.removerProduto(codigo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    
}

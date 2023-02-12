package br.com.tech4me.produtos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.produtos.model.Produto;
import br.com.tech4me.produtos.repository.ProdutoRepository;
import br.com.tech4me.produtos.shared.ProdutoDto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository repository;

    @Override
    public ProdutoDto criarProduto(ProdutoDto produto) {
        ModelMapper mapper = new ModelMapper();
        Produto produtoEntidade = mapper.map(produto, Produto.class);
        produtoEntidade = repository.save(produtoEntidade);

        return mapper.map(produtoEntidade, ProdutoDto.class);
    }

    @Override
    public List<ProdutoDto> obterProdutos() {
        List<Produto> produtos = repository.findAll();

        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto, ProdutoDto.class))
        .collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutoDto> produtoPorCodigo(String codigo) {
        Optional<Produto> produto = repository.findByCodigo(codigo);

        if(produto.isPresent()){
            return Optional.of(new ModelMapper().map(produto.get(), ProdutoDto.class));
        }

        return Optional.empty();
    }

    @Override
    public void removerProduto(String codigo){
        Optional<Produto> produto = repository.findByCodigo(codigo);

        if(produto.isPresent()){
            repository.deleteById(produto.get().getId());
        }
        return;
    }

    @Override
    public ProdutoDto atualizarProduto(String codigo, ProdutoDto produto) {
        Optional<Produto> produtoAntigo = repository.findByCodigo(codigo);
        
        ModelMapper mapper = new ModelMapper();
        if(produtoAntigo != null){
            produtoAntigo.get().setCodigo(produto.getCodigo());
            produtoAntigo.get().setNome(produto.getNome());
            produtoAntigo.get().setQuantidade(produto.getQuantidade());
            produtoAntigo.get().setValor(produto.getValor());
            repository.save(produtoAntigo.get());
        }

        return mapper.map(produtoAntigo, ProdutoDto.class);
    }
    
}

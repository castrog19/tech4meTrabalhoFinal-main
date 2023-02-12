package br.com.tech4me.produtos.service;
import java.util.List;
import java.util.Optional;

import br.com.tech4me.produtos.shared.ProdutoDto;

public interface ProdutoService {

    ProdutoDto criarProduto(ProdutoDto produto);
    List<ProdutoDto> obterProdutos();
    Optional<ProdutoDto> produtoPorCodigo(String codigo);
    void removerProduto(String codigo);
    ProdutoDto atualizarProduto(String codigo, ProdutoDto produto);
    
}

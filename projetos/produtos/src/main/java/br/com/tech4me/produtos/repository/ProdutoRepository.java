package br.com.tech4me.produtos.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.produtos.model.Produto;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {

    Optional<Produto> findByCodigo(String codigo);
    
}

package br.com.tech4me.vendas.repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.vendas.model.Venda;

@Repository
public interface VendaRepository extends MongoRepository<Venda, String>{

    ArrayList<Venda> findByDataVenda(Date data);
    
}

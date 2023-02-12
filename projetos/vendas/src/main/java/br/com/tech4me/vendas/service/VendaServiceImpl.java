package br.com.tech4me.vendas.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.vendas.model.Venda;
import br.com.tech4me.vendas.repository.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository repository;

    @Override
    public ArrayList<Venda> obterVendasPeriodo(Date data) {
        
        return repository.findByDataVenda(data);
    }

    @Override
    public ArrayList<Venda> obterVendas() {
        return (ArrayList<Venda>) repository.findAll();
    }

    @Override
    public Venda realizarVenda(Venda venda) {
        repository.save(venda);
        return venda;
    }
    
}

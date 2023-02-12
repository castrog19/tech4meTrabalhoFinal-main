package br.com.tech4me.vendas.service;

import java.util.ArrayList;
import java.util.Date;

import br.com.tech4me.vendas.model.Venda;

public interface VendaService {
    
    Venda realizarVenda(Venda venda);
    ArrayList<Venda> obterVendasPeriodo(Date data);
    ArrayList<Venda> obterVendas();
}

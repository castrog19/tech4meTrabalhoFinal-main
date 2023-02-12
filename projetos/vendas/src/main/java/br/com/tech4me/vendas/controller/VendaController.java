package br.com.tech4me.vendas.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.vendas.model.Venda;
import br.com.tech4me.vendas.service.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {
    
    @Autowired
    private VendaService servico;

    @GetMapping(value = "date")
    public ResponseEntity<ArrayList<Venda>> obterVendasPeriodo(@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date){
        System.out.println(date.toString());
        return new ResponseEntity<>(servico.obterVendasPeriodo(date), HttpStatus.OK);
    } 

    @GetMapping
    public ResponseEntity<ArrayList<Venda>> obterVendas(){
        return new ResponseEntity<>(servico.obterVendas(), HttpStatus.OK);
    } 

    @PostMapping
    public ResponseEntity<Venda> realizarVenda(@RequestBody Venda venda){
        return new ResponseEntity<>(servico.realizarVenda(venda), HttpStatus.OK);
    }

}

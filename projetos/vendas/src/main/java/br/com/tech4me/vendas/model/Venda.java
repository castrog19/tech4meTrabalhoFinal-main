package br.com.tech4me.vendas.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Venda {
    
    @Id
    private String id;
    private String codigoProduto;
    private Date dataVenda = new Date();
    private int qtVendida;
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getCodigoProduto() {
        return this.codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public Date getDataVenda() {
        return this.dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getQtVendida() {
        return this.qtVendida;
    }

    public void setQtVendida(int qtVendida) {
        this.qtVendida = qtVendida;
    }

}

package br.com.tech4me.produtos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produto")
public class Produto {

    @Id
    private String id;
    private String codigo;
    private String nome;
    private double valor;
    private int quantidade;
    
    public Produto(String id, String codigo, String nome, double valor, int quantidade){
        super();
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }
    
    public Produto(){}

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


}
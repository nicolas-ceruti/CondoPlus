package com.mycompany.zcondo;

public class Fornecedor {
    
    public int id;
    public String nome;
    public String categoria;
    public String cpf;
    public String rg;
    public double preco;
    public String telefone;
    public String email;
    
    public Fornecedor (String nome, String categoria, String cpf, String rg, double preco, String telefone, String email){
        
        this.nome = nome;
        this.categoria = categoria;
        this.cpf = cpf;
        this.rg = rg;
        this.preco = preco;
        this.telefone = telefone;
        this.email = email;
        
    }
    
    public Fornecedor (int id, String nome, String categoria, //
                            String cpf, String rg, double preco, String telefone, String email){
        
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.cpf = cpf;
        this.rg = rg;
        this.preco = preco;
        this.telefone = telefone;
        this.email = email;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int codigo) {
        this.id = codigo;
    }

    
    public String getNome() {
        
        return nome;
        
    }

    public void setNome(String nome) {
        
        this.nome = nome;
        
    }

    public String getCategoria() {
        
        return categoria;
        
    }

    public void setCategoria (String categoria) {
        
        this.categoria = categoria;
        
    }

    public String getCpf() {
        
        return cpf;
        
    }

    public void setCpf(String cpf) {
       
        this.cpf = cpf;
        
    }

    public String getRg() {
        
        return rg;
        
    }

    public void setRg(String rg) {
        
        this.rg = rg;
        
    }

    public double getPreco() {
        
        return preco;
        
    }

    public void setPreco(double preco) {
        
        this.preco = preco;
        
    }

    public String getTelefone() {
        
        return telefone;
        
    }

    public void setTelefone(String telefone) {
        
        this.telefone = telefone;
        
    }

    public String getEmail() {
        
        return email;
        
    }

    public void setEmail(String email) {
        
        this.email = email;
        
    }     
}
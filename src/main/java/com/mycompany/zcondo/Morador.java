package com.mycompany.zcondo;

public class Morador {
    
    public int id;
    public String senha;
    public String nome;
    public String dataDeNascimento;
    public String cpf;
    public String rg;
    public int apartamento;
    public String telefone;
    public String email;
    public int nivel;
    
    public Morador ( String nome, String dataDeNascimento, String cpf, 
            String rg, int apartamento, String telefone, String email, int nivel){ 

        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.apartamento = apartamento;
        this.telefone = telefone;
        this.email = email;
        this.nivel = nivel;
        
    }
    
    public Morador (int id, String nome, String dataDeNascimento, String cpf, 
            String rg, int apartamento, String telefone, String email, int nivel){ 
        this.id = id;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
        this.rg = rg;
        this.apartamento = apartamento;
        this.telefone = telefone;
        this.email = email;
        this.nivel = nivel;
        
    }

    
    
    
    public Morador (String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public String getNome() {
        
        return nome;
        
    }

    public void setNome(String nome) {
         
        this.nome = nome;
        
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    public String getDataDeNascimento() {
        
        return dataDeNascimento;
        
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        
        this.dataDeNascimento = dataDeNascimento;
        
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

    public int getApartamento() {
        
        return apartamento;
        
    }

    public void setApartamento(int apartamento) {
        
        this.apartamento = apartamento;
        
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    
    
}
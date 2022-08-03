package com.mycompany.zcondo;

import java.util.Calendar;

public class Notificacao {
    
    public int id;
    
    public String data;
    
    public String descricao;
    
    public String emissor;
    
    public int classificacao;
    
    

    public Notificacao(String descricao, String emissor, String data) {

        this.data = data; //data
        
        this.descricao = descricao;   //Mensagem

        this.emissor = emissor;   //EMissor

        
    }
    
    public Notificacao(int id, String emissor, String descricao, String data ) {

        this.id = id;
        
        this.emissor = emissor;   //EMissor
        
        this.descricao = descricao;   //Mensagem
        
        this.data = data; //data

 

        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    
    public String getDescricao() {
        
        return descricao;
        
    }

    public String getEmissor() {
        
        return emissor;
        
    }

    public void setDescricao(String descricao) {
        
        this.descricao = descricao;
        
    }

    public void setEmissor(String emissor) {
        
        this.emissor = emissor;
        
    }

    public void setData(String data) {
        
        this.data = data;
        
    }

    public String getData() {
        
        return data;
        
    }      
}
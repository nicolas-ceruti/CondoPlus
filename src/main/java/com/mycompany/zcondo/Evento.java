
package com.mycompany.zcondo;

public class Evento {
    
    public int id;
    public String nomeEvento;
    public String localEvento;
    public String dataEvento;
    public String horaEvento;
    public String duracaoEvento;

    public Evento(String nomeEvento,String localEvento, String dataEvento, String horaEvento, String duracaoEvento) {
        this.nomeEvento = nomeEvento;
        this.localEvento = localEvento;
        this.dataEvento = dataEvento;
        this.horaEvento = horaEvento;
        this.duracaoEvento = duracaoEvento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(String horaEvento) {
        this.horaEvento = horaEvento;
    }

    public String getDuracaoEvento() {
        return duracaoEvento;
    }

    public void setDuracaoEvento(String duracaoEvento) {
        this.duracaoEvento = duracaoEvento;
    }
    
    
    
}

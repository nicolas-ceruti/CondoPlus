package com.mycompany.zcondo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EventoDAO {
    
    public List<Evento> getAll() {
           
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultEvento = connection. //
                        createStatement(). //
                        executeQuery("SELECT * FROM evento");

               List<Evento> listaDeEventos = new ArrayList<>();

               while (!resultEvento.isLast()) {
                   
                   resultEvento.next();
                   
                   
                   String nomeEvento = resultEvento.getString("nomeEvento");
                   String localEvento = resultEvento.getString("localEvento");
                   String dataEvento = resultEvento.getString("dataEvento");
                   String horaEvento = resultEvento.getString("horaEvento");
                   String duracaoEvento = resultEvento.getString("duracaoEvento");

                   Evento eventoResultadoDaBusca = new Evento(nomeEvento, localEvento, 
                           dataEvento, horaEvento, horaEvento);
               }

               return listaDeEventos;
               
            } catch (Exception e) {
               
                throw new RuntimeException(e);
                
           }
        }


    public void save(Evento novoEvento) {

        try {

            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO evento (nomeEvento, localEvento, dataEvento, horaEvento,"
                            + " duracaoEvento) values (" //
                            + " '" + novoEvento.nomeEvento + "'" //
                            + ", '" + novoEvento.localEvento + "'" //
                            + ", '" + novoEvento.dataEvento + "'" //
                            + ", '" + novoEvento.horaEvento + "'" //
                            + ", '" + novoEvento.duracaoEvento + "'" + ")");

        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }

    public void update(Evento novoEvento) {

        try {

            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("UPDATE evento SET " //
                            + "nomeEvento = '" + novoEvento.nomeEvento + "'" //
                            + ",localEvento = '" + novoEvento.localEvento + "' " //
                            + ", dataEvento = " + novoEvento.dataEvento //
                            + ", horaEvento = " + novoEvento.horaEvento // 
                            + ", duracaoEvento = '" + novoEvento.duracaoEvento + "' "//
                            + " WHERE idEvento = " + novoEvento.id //
                    );

        } catch (Exception e) {

            throw new RuntimeException(e);

        }
    }

}

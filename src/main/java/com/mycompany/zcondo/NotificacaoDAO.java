package com.mycompany.zcondo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class NotificacaoDAO {
    

    public List<Notificacao> getAll() {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoNotificacao = connection.createStatement().executeQuery("SELECT * FROM notificacao");

            List<Notificacao> listaDeNotificacoes = new ArrayList<>();

            while (!resultadoNotificacao.isLast() && resultadoNotificacao != null) {

                resultadoNotificacao.next();
                
                int idNotificacao = resultadoNotificacao.getInt("idnotificacao");
                String moradorNotificacao = resultadoNotificacao.getString("emissorNotificacao");
                String mensagemNotificacao = resultadoNotificacao.getString("mensagemNotificacao");
                String dataNotificacao = resultadoNotificacao.getString("dataNotificacao");


                Notificacao notificacaoResultadoDaBusca = new Notificacao(idNotificacao, moradorNotificacao, mensagemNotificacao, dataNotificacao);
                listaDeNotificacoes.add(notificacaoResultadoDaBusca);
            }

            return listaDeNotificacoes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }     
    
    public void save(Notificacao novaNotificacao) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO notificacao (dataNotificacao, emissorNotificacao, mensagemNotificacao, classificacaoNotificacao) values (" //
                            + "'" + novaNotificacao.data + "'" //
                                         + ", '" + novaNotificacao.emissor + "'" //
                                                 + ", '" + novaNotificacao.descricao + "'" //
                                                       + ", '" + "1" + "')" //
                                 );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void update(Notificacao notificacaoEdited) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                   executeUpdate("UPDATE notificacao SET " //
                           + "dataNotificacao = '" + notificacaoEdited.data + "'" //
                                + ", emissorNotificacao = '" + notificacaoEdited.emissor  + "'"  //
                                    + ", mensagemNotificacao = '" + notificacaoEdited.descricao+ "'"  //
                                                          + " WHERE idNotificacao =  " + notificacaoEdited.id 
                                                              
                   );  
           

       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }

    
    public void delete(Notificacao notificacaoToRemove) {
       try {
           Connection connection = ConnectionSingleton.getConnection();
           connection.createStatement(). //
                   executeUpdate("DELETE FROM notificacao WHERE idnotificacao = " +  notificacaoToRemove.id); 
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
    }
           
           
    
}

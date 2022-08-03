package com.mycompany.zcondo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoradorDAO {


    public Morador getById (int id) throws SQLException{
        
        try {
            
            Connection connection = ConnectionSingleton.getConnection();       

            ResultSet resultMoradores = connection. //
                    createStatement().//
                    executeQuery("SELECT * FROM usuario WHERE codigo = " + id + ";");

            
            int idUser = resultMoradores.getInt("idUser");
            String nomeUser = resultMoradores.getString("nomeUser");
            String nascUser = resultMoradores.getString("nascUser");
            String cpfUser = resultMoradores.getString("cpfUser");
            String rgUser = resultMoradores.getString("rgUser");
            int numero_aptoUser = resultMoradores.getInt("numero_aptoUser");
            String telefoneUser = resultMoradores.getString("telefoneUser");
            String emailUser = resultMoradores.getString("emailUser");

            return new Morador (nomeUser, nascUser, cpfUser, rgUser, numero_aptoUser, telefoneUser, emailUser, 2 );

        } catch (Exception e){
            
            throw new RuntimeException (e);
            
        }   
    }


    public List<Morador> getAll() {
           
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoMoradores = connection. //
                        createStatement(). //
                        executeQuery("SELECT * FROM usuario");

               List<Morador> listaDeMoradores = new ArrayList<>();

               while (!resultadoMoradores.isLast()) {
                   
                   resultadoMoradores.next();
                   
                   int idUser = resultadoMoradores.getInt("idUser");
                   String nomeUser = resultadoMoradores.getString("nomeUser");
                   String nascUser = resultadoMoradores.getString("nascUser");
                   String cpfUser = resultadoMoradores.getString("cpfUser");
                   String rgUser = resultadoMoradores.getString("rgUser");
                   int numero_aptoUser = resultadoMoradores.getInt("numero_aptoUser");
                   String telefoneUser = resultadoMoradores.getString("telefoneUser");
                   String emailUser = resultadoMoradores.getString("emailUser");
                   int nivelUser = resultadoMoradores.getInt("nivelUser");

                   Morador moradorResultadoDaBusca = new Morador(idUser, nomeUser, nascUser, 
                           cpfUser, rgUser, numero_aptoUser, telefoneUser, emailUser, nivelUser );
                   listaDeMoradores.add(moradorResultadoDaBusca);
               }

               return listaDeMoradores;
               
            } catch (Exception e) {
               
                throw new RuntimeException(e);
                
           }
        }

    public void save(Morador novoMorador) {
       
        try {
           
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                   executeUpdate("INSERT INTO usuario (senhaUser, nomeUser, nascUser, cpfUser, rgUser, numero_aptoUser, telefoneUser, emailUser, nivelUser ) values (" //
                            + "SHA2('1234',256), "//Senha padrão
                             + "'" + novoMorador.nome  //
                                    + "' , '" + novoMorador.dataDeNascimento + "'" //
                                          + ", '" + novoMorador.cpf+ "'" //
                                                    + ", '" + novoMorador.rg+ "'" //
                                                          + ", '" + novoMorador.apartamento + "'" //
                                                                    + ", '" + novoMorador.telefone + "'" //
                                                                       + ", '" + novoMorador.email + "'" //
                                                                          + ", " + 2 + " )"
                           
                   );
           
       } catch (Exception e) {
           
            throw new RuntimeException(e);
            
       }
    }

    public void update(Morador moradoresEdited) {
        
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("UPDATE usuario SET " //
                    + "idUser = " + moradoresEdited.id + " "  //
                        + ", nomeUser = '" + moradoresEdited.nome + "' " //
                            + ", nascUser = '" + moradoresEdited.dataDeNascimento  + "' "  //
                                + ", cpfUser = '" + moradoresEdited.cpf + "' "  //
                                    +  ", rgUser = '" + moradoresEdited.rg + "' "  //
                                        + ", numero_aptoUser = '" + moradoresEdited.apartamento + "' "  //
                                            + ", telefoneUser = '" + moradoresEdited.telefone + "' "  //
                                                + ", emailUser = '" + moradoresEdited.email + "' "  // 
                                                    +", nivelUser = " + 2//
                                                         + " WHERE idUser = " + moradoresEdited.id//
                    );  
            System.out.println(moradoresEdited.id);
           

        } catch (Exception e) {
           
            throw new RuntimeException(e);
            
       }
    }
    
    public void delete(Morador moradoresToRemove) {
       
        try {
           
           Connection connection = ConnectionSingleton.getConnection();
           connection.createStatement(). //
                   
                   executeUpdate("DELETE FROM usuario WHERE rgUser = '" + moradoresToRemove.rg + "'");
        
        } catch (Exception e) {
           
            throw new RuntimeException(e);
            
       }
    }
    
    public boolean exists(Morador usuario) {
        
        try {  
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoUsuarioExiste = connection. //
                    createStatement(). //
                    executeQuery("select count(*) from usuario " //
                            + " where nomeUser = '" + usuario.getNome() + "'"//
                            + " and senhaUser = SHA2('" + usuario.senha + "', 256) ;");

            resultadoUsuarioExiste.next();
            int quantidadeDeUsuariosComEsseUsuarioESenha = resultadoUsuarioExiste.getInt(1);

            return quantidadeDeUsuariosComEsseUsuarioESenha > 0;

        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
        }
    }
    
    public boolean firstAcess(Morador usuario) {
        
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoUsuarioExiste = connection. //
                    createStatement(). //
                    executeQuery("select count(*) from usuario " //
                            + " where nomeUser = '" + usuario.getNome() + "'"//
                            + " and senhaUser = SHA2('1234',256) ;");

            resultadoUsuarioExiste.next();
            int quantidadeDeUsuario = resultadoUsuarioExiste.getInt(1);

            return quantidadeDeUsuario > 0;

        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
        }
    }
    
    public void switchPassword(Morador morador, String passwordOfTextField) {
       
        try {
           
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                   executeUpdate("UPDATE usuario SET " //
                           + "senhaUser = SHA2('" + passwordOfTextField + "',256)" //
                                   + " WHERE nomeUser = '" + morador.nome + "'" //
                   );  
           

        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
       }
    }
    
    public int retornarNivel(String textFromTextField, String textFromPasswordField ) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoUsuarioExiste = connection. //
                    createStatement(). //
                    executeQuery("select (nivelUser) from usuario " //
                            + " where nomeUser = '" + textFromTextField + "'"//
                            + " and senhaUser = SHA2('" + textFromPasswordField + "',256) ;");

            
            resultadoUsuarioExiste.next();
            int nivel = resultadoUsuarioExiste.getInt(1);

            return nivel;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
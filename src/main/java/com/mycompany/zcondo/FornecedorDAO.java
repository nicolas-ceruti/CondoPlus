
package com.mycompany.zcondo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    
    public List<Fornecedor> getAll() {
        
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            ResultSet resultadoFornecedores = connection. //
                    createStatement(). //
                    executeQuery("SELECT * FROM fornecedor");
            
            List<Fornecedor> resultadoComTodosFornecedores = new ArrayList<>();

            while (!resultadoFornecedores.isLast()) {
                resultadoFornecedores.next();
                
                int idFornecedor = resultadoFornecedores.getInt("idFornecedor");
                String nomeFornecedor = resultadoFornecedores.getString("nomeFornecedor");
                String categoriaFornecedor = resultadoFornecedores.getString("categoriaFornecedor");
                String cpfFornecedor = resultadoFornecedores.getString("cpfFornecedor");
                String rgFornecedor = resultadoFornecedores.getString("rgFornecedor");
                double precoFornecedor = resultadoFornecedores.getDouble("precoFornecedor");
                String telefoneFornecedor = resultadoFornecedores.getString("telefoneFornecedor");
                String emailFornecedor = resultadoFornecedores.getString("emailFornecedor");
                
                
                Fornecedor fornecedorQuePegueiDoBanco = new Fornecedor(idFornecedor, nomeFornecedor, categoriaFornecedor , cpfFornecedor , rgFornecedor , precoFornecedor , telefoneFornecedor , emailFornecedor);
                resultadoComTodosFornecedores.add(fornecedorQuePegueiDoBanco);
            }
            
            return resultadoComTodosFornecedores;
            
        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
        }
    }

    public void save(Fornecedor novoFornecedor) {
        
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("INSERT INTO fornecedor (nomeFornecedor, categoriaFornecedor, cpfFornecedor, rgFornecedor,"
                            + " precoFornecedor, telefoneFornecedor, emailFornecedor)values (" //
                            + " '" + novoFornecedor.nome + "'" //
                                + ", '" + novoFornecedor.categoria + "'" //
                                    + ", '" + novoFornecedor.cpf + "'" //
                                        + ", '" + novoFornecedor.rg + "'" //
                                            + ", " + novoFornecedor.preco //   
                                                + ", '" + novoFornecedor.telefone + "'" //
                                                    + ", '" + novoFornecedor.email + "'" + ")");
        
        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
        }
    }
    
    public void update(Fornecedor fornecedorEditado) {
        
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("UPDATE fornecedor SET " //
                            + "idFornecedor = '" + fornecedorEditado.id + "'" //
                            + ", nomeFornecedor = '" + fornecedorEditado.nome + "'" //
                                + ",categoriaFornecedor = '" + fornecedorEditado.categoria + "' " //
                                    + ", cpfFornecedor = " + fornecedorEditado.cpf //
                                        + ", precoFornecedor = " + fornecedorEditado.preco // 
                                            + ", telefoneFornecedor = '" + fornecedorEditado.telefone + "' "//
                                                + ", emailFornecedor = '" + fornecedorEditado.email + "' " //
                                                    + " WHERE idFornecedor = " + fornecedorEditado.id //
                    ); 
            
        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
        }
    }
    
    public void delete(Fornecedor fornecedorParaRemover) {
       
        try {
            
            Connection connection = ConnectionSingleton.getConnection();
            connection.createStatement(). //
                    executeUpdate("DELETE FROM fornecedor WHERE rgFornecedor = '" + fornecedorParaRemover.rg + "'");
        
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }    
    }
}
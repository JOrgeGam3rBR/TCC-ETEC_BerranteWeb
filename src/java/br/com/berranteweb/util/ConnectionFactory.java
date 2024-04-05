
package br.com.berranteweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionFactory {
    
    public static Connection conectar() throws Exception {
            try {

            Class.forName("org.postgresql.Driver");

            System.out.println("Conectou!");

            return DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/BerranteWeb", "postgres", "postdba");

        } catch (Exception e) {

            throw new Exception("Erro ao conectar ao banco de dados: " + e.getMessage());

        }
    }
    
    

    public static void fecharConexao(Connection conn, Statement stmt, ResultSet rs) 
            throws Exception {
        
        try{
            
            if(conn != null){
                conn.close();
            }
            
            if(stmt != null){
                stmt.close();
            }
            
            if(rs != null){
                rs.close();
            }
            
        }catch(Exception e){
            
            throw  new Exception("Erro ao fechar conexão: " + e.getMessage());
             
        }
        
        
    }
    
}

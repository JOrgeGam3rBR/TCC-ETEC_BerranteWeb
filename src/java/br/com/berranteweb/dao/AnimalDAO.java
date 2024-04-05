package br.com.berranteweb.dao;

import br.com.berranteweb.modelo.Animal;
import br.com.berranteweb.modelo.Fazenda;
import br.com.berranteweb.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class AnimalDAO implements GenericDAO{

     private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    public AnimalDAO() {
        
        try{
            this.conn = ConnectionFactory.conectar();
        }catch(Exception e){
            System.out.println("Erro ao conectar ao BD " + e.getMessage());
        }
        
        
    }
    
    public java.util.Date converterData(String data) throws ParseException {
        if (data != null || !data.trim().equals("")) {
            SimpleDateFormat fmt = new SimpleDateFormat("dd/mm/yyyy");
            java.util.Date date = fmt.parse(data);
            return date;
        } else {
            return null;
        }
    }
    @Override
    public Boolean cadastrar(Object object) throws Exception {
         Boolean retorno = true;
 try{
        
            Animal animal = (Animal) object;
            String sql = "insert into animal(brinco,idFazenda,raca,sexo,dataNasc,tipo,status) values (?,?,?,?,?,?,?)";
            stmt = this.conn.prepareStatement(sql);
            
            
            stmt.setInt(1, animal.getBrinco());
            stmt.setInt(2, animal.getFazenda().getIdFazenda());
            stmt.setString(3, animal.getRaca());
            stmt.setString(4, animal.getSexo());
            stmt.setDate(5, new java.sql.Date(animal.getDataNasc().getDate()));
            stmt.setString(6, animal.getTipo());
            stmt.setString(7, animal.getStatus());
            
            stmt.execute();
            
            
        }catch(Exception e){
            retorno = false;
            Animal animal = (Animal) object;
            System.out.println(animal.getBrinco());
            System.out.println(animal.getFazenda());
            System.out.println(animal.getSexo());
            System.out.println(new java.sql.Date(animal.getDataNasc().getDate()));
            System.out.println(animal.getTipo());
            System.out.println(animal.getStatus());
            System.out.println("Erro ao cadastrar AnimalDAO" + e.getMessage());
                
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
            
        }

        return retorno;    }
    
    
    
    public List<Object> listarPorFazenda(Integer id) throws Exception {
        List<Object> lista = new ArrayList < > ();
    try {
            String sql = "Select * from animal where idFazenda=?";
            

            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Animal animal = new Animal();
                animal.setIdAnimal(this.rs.getInt("idAnimal"));
                Fazenda fazenda = new Fazenda();
                fazenda.setIdFazenda(this.rs.getInt("idFazenda"));
                animal.setFazenda(fazenda);
                        
                animal.setBrinco(this.rs.getInt("brinco"));
                animal.setRaca(this.rs.getString("raca"));
                animal.setSexo(this.rs.getString("sexo"));
                animal.setDataNasc(this.rs.getDate("DataNasc"));
                animal.setTipo(this.rs.getString("tipo"));
                animal.setStatus(this.rs.getString("status"));

                
                lista.add(animal);

            }
                } catch(Exception e){
                System.out.println("Erro ao listar animalDAO " + e.getMessage());
        }finally{
                ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return lista;    
    }
    @Override
    public List<Object> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean excluir(Integer id) throws Exception {
Boolean retorno = true;
try{
            String sql = "delete from animal where idAnimal = ?";
            
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            
        }catch(Exception e){
            retorno = false;
            System.out.println("Erro ao excluir animalDAO" + e.getMessage());
        }finally{
        ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return retorno;    }

    @Override
    public Object carregar(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

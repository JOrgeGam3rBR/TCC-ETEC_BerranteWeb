
package br.com.berranteweb.dao;

import br.com.berranteweb.modelo.Fazenda;
import br.com.berranteweb.modelo.Pecuarista;
import br.com.berranteweb.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FazendaDAO implements GenericDAO {

    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    public FazendaDAO() {
        
        try{
            this.conn = ConnectionFactory.conectar();
        }catch(Exception e){
            System.out.println("Erro ao conectar ao BD " + e.getMessage());
        }
    }
    @Override
    public Boolean cadastrar(Object object) throws Exception {
        Boolean retorno = true;
        
        try{
        
            Fazenda fazenda = (Fazenda) object;
            String sql = "insert into fazenda(nomeFazenda,endereco,cidade,estado,idPes) values (?,?,?,?,?)";
            stmt = this.conn.prepareStatement(sql);
            
            
            stmt.setString(1, fazenda.getNomeFazenda());
            stmt.setString(2, fazenda.getEndereco());
            stmt.setString(3, fazenda.getCidade());
            stmt.setString(4, fazenda.getEstado());
            stmt.setInt(5, fazenda.getPecuarista().getId());
            stmt.execute();
            
        }catch(Exception e){
            retorno = false;
            System.out.println("Erro ao cadastrar FazendaDAO" + e.getMessage());
                
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
            
        }

        return retorno;
    }
    @Override
    public List<Object> listar() throws Exception {
List<Object> lista = new ArrayList < > ();

        try {
            String sql = "Select * from fazenda c, pessoa p where c.idPes=p.idPessoa order by p.nome";
            

            stmt = this.conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Fazenda fazenda = new Fazenda();
                fazenda.setIdFazenda(this.rs.getInt("idFazenda"));
                
                Pecuarista pecuarista = new Pecuarista();
                pecuarista.setId(this.rs.getInt("idPes"));
                fazenda.setPecuarista(pecuarista);
                
                fazenda.setNomeFazenda(this.rs.getString("nomeFazenda"));
                fazenda.setEndereco(this.rs.getString("endereco"));
                fazenda.setCidade(this.rs.getString("cidade"));
                fazenda.setEstado(this.rs.getString("estado"));

                
                lista.add(fazenda);

            }
                } catch(Exception e){
                System.out.println("Erro ao listar fazendaDAO " + e.getMessage());
        }finally{
                ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return lista;           }

    @Override
    public Boolean excluir(Integer id) throws Exception {
Boolean retorno = true;
try{
            String sql = "delete from fazenda where idFazenda = ?";
            
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            
        }catch(Exception e){
            retorno = false;
            System.out.println("Erro ao excluir fazendaDAO" + e.getMessage());
        }finally{
        ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return retorno;        }

    @Override
    public Object carregar(Integer id) throws Exception {
try{
            String sql = "Select * from fazenda u, pecuarista p where u.idPes = p.idPessoa and u.idFazenda=?";
            
            this.stmt = this.conn.prepareStatement(sql);
            this.stmt.setInt(1, id);
            
            this.rs = stmt.executeQuery();
            
            this.rs.next();
            
                Fazenda fazenda = new Fazenda();
                fazenda.setIdFazenda(this.rs.getInt("idFazenda"));
                
                Pecuarista pecuarista = new Pecuarista();
                pecuarista.setId(this.rs.getInt("idPes"));
                fazenda.setPecuarista(pecuarista);
                
                fazenda.setNomeFazenda(this.rs.getString("nomeFazenda"));
                fazenda.setEndereco(this.rs.getString("endereco"));
                fazenda.setCidade(this.rs.getString("cidade"));

                
                
                return fazenda;
            
        }catch(Exception e){
            
            System.out.println("Erro ao carregar fazendaDAO" + e.getMessage());
            return null;
        }finally{
        ConnectionFactory.fecharConexao(conn, stmt, rs);
        }         }

    @Override
    public Boolean alterar(Object object) throws Exception {
try{
            Fazenda fazenda = (Fazenda) object;
            String sql="update fazenda set idFazenda = ?";
            this.stmt = this.conn.prepareStatement(sql);
            
            this.stmt.setString(1, fazenda.getNomeFazenda());

            
            this.stmt.execute();
            
            return true;
            
        }catch(Exception e){
            System.out.println("Erro ao alterar pecuaristaDAO" + e.getMessage());
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
    }
    
    
     public List<Object> listarPorPecuarista(Integer id) throws Exception {
List<Object> lista = new ArrayList < > ();

        try {
            String sql = "Select * from fazenda c, pessoa p where c.idPes=p.idPessoa and c.idPes=? order by p.nome";
            

            stmt = this.conn.prepareStatement(sql);
            
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Fazenda fazenda = new Fazenda();
                fazenda.setIdFazenda(this.rs.getInt("idFazenda"));
                
                Pecuarista pecuarista = new Pecuarista();
                pecuarista.setId(this.rs.getInt("idPes"));
                fazenda.setPecuarista(pecuarista);
                
                fazenda.setNomeFazenda(this.rs.getString("nomeFazenda"));
                fazenda.setEndereco(this.rs.getString("endereco"));
                fazenda.setCidade(this.rs.getString("cidade"));
                fazenda.setEstado(this.rs.getString("estado"));

                
                lista.add(fazenda);

            }
                } catch(Exception e){
                System.out.println("Erro ao listar fazendaDAO " + e.getMessage());
        }finally{
                ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return lista;           }
}

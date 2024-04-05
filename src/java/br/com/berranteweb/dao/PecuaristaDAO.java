 package br.com.berranteweb.dao;

import br.com.berranteweb.modelo.Pecuarista;
import br.com.berranteweb.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PecuaristaDAO  implements GenericDAO{
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    
    public PecuaristaDAO() {
        
        try{
            this.conn = ConnectionFactory.conectar();
        }catch(Exception e){
            System.out.println("Erro ao conectar ao BD " + e.getMessage());
        }
    }

    @Override
    public Boolean cadastrar(Object object) throws Exception {
 try{
        
            Pecuarista pecuarista = (Pecuarista) object;
            String sql = "insert into pecuarista (idPes) values (?) returning idPecuarista";
            this.stmt = this.conn.prepareStatement(sql);
            
            PessoaDAO daoPessoa = new PessoaDAO();
            this.stmt.setInt(1, daoPessoa.cadastrar(pecuarista));
            
            this.stmt.execute();
            
            return true;
            
        }catch(Exception e){
            
            System.out.println("Erro ao cadastrar PecuaristaDAO" + e.getMessage());
                return false;
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
            
        }


    }

    @Override
    public List<Object> listar() throws Exception {
List<Object> lista = new ArrayList < > ();

        try {
            String sql = "Select * from pecuarista c, pessoa p where c.idPes=p.idPessoa order by p.nome";
            

            stmt = this.conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Pecuarista pecuarista = new Pecuarista();
                pecuarista.setIdPecuarista(this.rs.getInt("idPecuarista"));
                pecuarista.setId(this.rs.getInt("idPessoa"));
                pecuarista.setNome(this.rs.getString("nome"));
                pecuarista.setCpf(this.rs.getString("cpf"));
                pecuarista.setEmail(this.rs.getString("email"));
                pecuarista.setCidade(this.rs.getString("cidade"));
                pecuarista.setEstado(this.rs.getString("estado"));
                pecuarista.setCep(this.rs.getString("cep"));

                
                lista.add(pecuarista);

            }
                } catch(Exception e){
                System.out.println("Erro ao listar pecuaristaDAO " + e.getMessage());
        }finally{
                ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return lista;       }

    @Override
    public Boolean excluir(Integer id) throws Exception {
Boolean retorno = true;
try{
            String sql = "delete from pecuarista where idPes = ?";
            
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            
        }catch(Exception e){
            retorno = false;
            System.out.println("Erro ao excluir pecuaristaDAO" + e.getMessage());
        }finally{
        ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return retorno;    }

    @Override
    public Object carregar(Integer id) throws Exception {
try{
            String sql = "Select * from pessoa where idPessoa = ?";
            
            this.stmt = this.conn.prepareStatement(sql);
            this.stmt.setInt(1, id);
            
            this.rs = stmt.executeQuery();
            
            this.rs.next();
            
                Pecuarista pecuarista = new Pecuarista();
                
                pecuarista.setNome(this.rs.getString("nome"));
                pecuarista.setCpf(this.rs.getString("cpf"));
                pecuarista.setEmail(this.rs.getString("email"));
                pecuarista.setCidade(this.rs.getString("cidade"));
                pecuarista.setEstado(this.rs.getString("estado"));
                pecuarista.setCep(this.rs.getString("cep"));
                pecuarista.setSenha(this.rs.getString("senha"));
                
                
                return pecuarista;
            
        }catch(Exception e){
            
            System.out.println("Erro ao carregar pecuaristaDAO" + e.getMessage());
            return null;
        }finally{
        ConnectionFactory.fecharConexao(conn, stmt, rs);
        }     }

    @Override
    public Boolean alterar(Object object) throws Exception {
try{
            Pecuarista pecuarista = (Pecuarista) object;
            String sql="update pecuarista set idPes = ?";
            this.stmt = this.conn.prepareStatement(sql);
            
            this.stmt.setString(1, pecuarista.getNome());

            
            this.stmt.execute();
            
            return true;
            
        }catch(Exception e){
            System.out.println("Erro ao alterar pecuaristaDAO" + e.getMessage());
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
       }
    
}

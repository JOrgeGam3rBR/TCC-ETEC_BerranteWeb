
package br.com.berranteweb.dao;

import br.com.berranteweb.modelo.Pessoa;
import br.com.berranteweb.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PessoaDAO {
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public PessoaDAO() {
        
        try{
            this.conn = ConnectionFactory.conectar();
        }catch(Exception e){
            System.out.println("Erro ao conectar ao BD " + e.getMessage());
        }
    }
    
 
    public Integer cadastrar(Object object) throws Exception {

          try{  
            
            Pessoa pessoa = (Pessoa) object;
            String sql = "insert into pessoa(nome,cpf,cidade,estado,cep,email,senha) values (?,?,?,?,?,?,?) returning idPessoa";
            this.stmt = this.conn.prepareStatement(sql);
            

            this.stmt.setString(1, pessoa.getNome());
            this.stmt.setString(2, pessoa.getCpf());
            this.stmt.setString(3, pessoa.getCidade());
            this.stmt.setString(4, pessoa.getEstado());
            this.stmt.setString(5, pessoa.getCep());
            this.stmt.setString(6, pessoa.getEmail());
            this.stmt.setString(7, pessoa.getSenha());

            this.rs = this.stmt.executeQuery();
            
            this.rs.next();
            
            return this.rs.getInt("idPessoa");
            
        }catch (Exception e){
            
            System.out.println("Erro ao cadastrar PessoaDAO" + e.getMessage());
                return 0;
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);

    }

    }
    public List<Object> listar() throws Exception {
List<Object> lista = new ArrayList < > ();

        try {
            String sql = "Select * from pessoa";
            

            stmt = this.conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Pessoa pessoa = new Pessoa();
                pessoa.setId(this.rs.getInt("idPessoa"));
                pessoa.setNome(this.rs.getString("nome"));
                pessoa.setCpf(this.rs.getString("cpf"));
                pessoa.setEmail(this.rs.getString("email"));
                pessoa.setCidade(this.rs.getString("cidade"));
                pessoa.setEstado(this.rs.getString("estado"));
                pessoa.setCep(this.rs.getString("cep"));

                
                lista.add(pessoa);

            }
                } catch(Exception e){
                System.out.println("Erro ao listar pessoaDAO " + e.getMessage());
        }finally{
                ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return lista;          }


    public Boolean excluir(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public Object carregar(Integer id) throws Exception {
try{
            String sql = "Select * from pessoa idPessoa=?";
            
            this.stmt = this.conn.prepareStatement(sql);
            this.stmt.setInt(1, id);
            
            this.rs = stmt.executeQuery();
            
            this.rs.next();
            
                Pessoa pessoa = new Pessoa();
                
                
                pessoa.setNome(this.rs.getString("nome"));
                pessoa.setCpf(this.rs.getString("cpf"));
                pessoa.setEmail(this.rs.getString("email"));
                pessoa.setCidade(this.rs.getString("cidade"));
                pessoa.setEstado(this.rs.getString("estado"));
                pessoa.setCep(this.rs.getString("cep"));
                pessoa.setSenha(this.rs.getString("senha"));
                
                
                return pessoa;
            
        }catch(Exception e){
            
            System.out.println("Erro ao carregar pessoaDAO" + e.getMessage());
            return null;
        }finally{
        ConnectionFactory.fecharConexao(conn, stmt, rs);
        }         }


    public Boolean alterar(Object object) throws Exception {
try{
            Pessoa pessoa = (Pessoa) object;
            String sql="update pessoa set nome = ?, cpf = ?, cidade = ?, estado=?, cep=?, email=?, senha=? where id = ?";
            this.stmt = this.conn.prepareStatement(sql);
            
            this.stmt.setString(1, pessoa.getNome());
            this.stmt.setString(2, pessoa.getCpf());
            this.stmt.setString(3, pessoa.getCidade());
            this.stmt.setString(4, pessoa.getEstado());
            this.stmt.setString(5, pessoa.getCep());
            this.stmt.setString(6, pessoa.getEmail());
            this.stmt.setString(7, pessoa.getSenha());
             this.stmt.setInt(8, pessoa.getId());
            
            this.stmt.execute();
            
            return true;
            
        }catch(Exception e){
            System.out.println("Erro ao alterar funcionarioDAO" + e.getMessage());
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }    }    


    
    
    public Pessoa logar(String email, String senha) throws Exception{
    
        Pessoa pessoa = new Pessoa();
     try{
             String sql = "select*from pessoa where email like  ? and senha like ?";
             
             this.stmt = this.conn.prepareStatement(sql);
             
             this.stmt.setString(1, email);
             this.stmt.setString(2, senha);
         
             this.rs= this.stmt.executeQuery();
            
             if(this.rs.next()){
             
            pessoa.setId(rs.getInt("idPessoa"));
            pessoa.setNome(rs.getString("nome"));
            
             }

        }catch(Exception e){
            System.out.println("Erro ao logar PessoaDAO " + e.getMessage());
         
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
     }
     return pessoa;
    }
    
}

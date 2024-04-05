/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.berranteweb.dao;

import br.com.berranteweb.modelo.Funcionario;
import br.com.berranteweb.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class FuncionarioDAO implements GenericDAO {

    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    public FuncionarioDAO() {
        
        try{
            this.conn = ConnectionFactory.conectar();
        }catch(Exception e){
            System.out.println("Erro ao conectar ao BD " + e.getMessage());
        }
    }
    
    @Override
    public Boolean cadastrar(Object object) throws Exception {

 try{
        
            Funcionario funcionario = (Funcionario) object;
            String sql = "insert into funcionario(trabalho, salario, idPes, idFazenda) values (?,?,?,?)";
            stmt = this.conn.prepareStatement(sql);
            
            this.stmt.setString(1, funcionario.getTrabalho()); 
            this.stmt.setDouble(2, funcionario.getSalario());
            
            
            PessoaDAO daoPessoa = new PessoaDAO();
            stmt.setInt(3, daoPessoa.cadastrar(funcionario));
            
            this.stmt.setInt(4, funcionario.getFazenda().getIdFazenda());
            stmt.execute();
            
            return true;
            
        }catch(Exception e){
            
            System.out.println("Erro ao cadastrar FuncionarioDAO" + e.getMessage());
                return false;
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
            
        }


    }

    @Override
    public List<Object> listar() throws Exception {

        List<Object> lista = new ArrayList < > ();

        try {
            String sql = "Select * from funcionario c, pessoa p where c.idPes=p.idPessoa order by p.nome";
            

            stmt = this.conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(this.rs.getInt("idFuncionario"));
                funcionario.setId(this.rs.getInt("idPessoa"));
                funcionario.setNome(this.rs.getString("nome"));
                funcionario.setCpf(this.rs.getString("cpf"));
                funcionario.setEmail(this.rs.getString("email"));
                funcionario.setCidade(this.rs.getString("cidade"));
                funcionario.setEstado(this.rs.getString("estado"));
                funcionario.setCep(this.rs.getString("cep"));
                funcionario.setTrabalho(this.rs.getString("trabalho"));
                funcionario.setSalario (this.rs.getDouble("salario"));
                
                lista.add(funcionario);

            }
                } catch(Exception e){
                System.out.println("Erro ao listar funcionarioDAO " + e.getMessage());
        }finally{
                ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return lista;    }

    @Override
    public Boolean excluir(Integer id) throws Exception {
        Boolean retorno = true;
try{
            String sql = "delete from funcionario where idPes = ?";
            
            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            
        }catch(Exception e){
            retorno = false;
            System.out.println("Erro ao excluir funcionarioDAO" + e.getMessage());
        }finally{
        ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return retorno;
    }

    @Override
    public Object carregar(Integer id) throws Exception {
try{
            String sql = "Select * from funcionario u, pessoa p where u.idPes = p.idpessoa and u.idPes=?";
            
            this.stmt = this.conn.prepareStatement(sql);
            this.stmt.setInt(1, id);
            
            this.rs = stmt.executeQuery();
            
            this.rs.next();
            
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(this.rs.getInt("idFuncionario"));
                funcionario.setId(this.rs.getInt("idPes"));
                funcionario.setNome(this.rs.getString("nome"));
                funcionario.setCpf(this.rs.getString("cpf"));
                funcionario.setEmail(this.rs.getString("email"));
                funcionario.setCidade(this.rs.getString("cidade"));
                funcionario.setEstado(this.rs.getString("estado"));
                funcionario.setCep(this.rs.getString("cep"));
                funcionario.setSenha(this.rs.getString("senha"));
                funcionario.setTrabalho(this.rs.getString("trabalho"));
                funcionario.setSalario (this.rs.getDouble("salario"));
                
                
                return funcionario;
            
        }catch(Exception e){
            
            System.out.println("Erro ao carregar funcionarioDAO" + e.getMessage());
            return null;
        }finally{
        ConnectionFactory.fecharConexao(conn, stmt, rs);
        }    }

    @Override
    public Boolean alterar(Object object) throws Exception {
 try{
            Funcionario funcionario = (Funcionario) object;
            String sql="update pessoa set nome = ?, cpf = ?, email = ?, cidade = ?, estado=?, cep=?, trabalho=?, salario=?, email=?, senha=?,  where id = ?";
            this.stmt = this.conn.prepareStatement(sql);
            
            this.stmt.setString(1, funcionario.getNome()); 
            this.stmt.setString(2, funcionario.getCpf());
            this.stmt.setString(3, funcionario.getEmail());
            this.stmt.setString(4, funcionario.getCidade());
            this.stmt.setString(5, funcionario.getEstado());
            this.stmt.setString(6, funcionario.getCep());
            this.stmt.setString(7, funcionario.getTrabalho()); 
            this.stmt.setDouble(8, funcionario.getSalario());
            this.stmt.setString(9, funcionario.getSenha());
            this.stmt.setInt(10, funcionario.getId());
            
            
            
            this.stmt.execute();
            
            return true;
            
        }catch(Exception e){
            System.out.println("Erro ao alterar funcionarioDAO" + e.getMessage());
            return false;
        }finally{
            ConnectionFactory.fecharConexao(conn, stmt, rs);
        }    }
    
    public List<Object> listarPorFazenda(Integer id) throws Exception {

        List<Object> lista = new ArrayList < > ();

        try {
            String sql = "Select * from funcionario c, pessoa p where c.idPes=p.idPessoa and c.idFazenda=? order by p.nome";
            

            stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(this.rs.getInt("idFuncionario"));
                funcionario.setId(this.rs.getInt("idFazenda"));
                funcionario.setNome(this.rs.getString("nome"));
                funcionario.setCpf(this.rs.getString("cpf"));
                funcionario.setEmail(this.rs.getString("email"));
                funcionario.setCidade(this.rs.getString("cidade"));
                funcionario.setEstado(this.rs.getString("estado"));
                funcionario.setCep(this.rs.getString("cep"));
                funcionario.setTrabalho(this.rs.getString("trabalho"));
                funcionario.setSalario (this.rs.getDouble("salario"));
                
                lista.add(funcionario);

            }
                } catch(Exception e){
                System.out.println("Erro ao listar funcionarioDAO " + e.getMessage());
        }finally{
                ConnectionFactory.fecharConexao(conn, stmt, rs);
        }
        
        return lista;    }
    
}

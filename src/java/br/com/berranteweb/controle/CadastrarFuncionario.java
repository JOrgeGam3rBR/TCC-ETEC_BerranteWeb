/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.berranteweb.controle;

import br.com.berranteweb.dao.FuncionarioDAO;
import br.com.berranteweb.dao.GenericDAO;
import br.com.berranteweb.modelo.Fazenda;
import br.com.berranteweb.modelo.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge
 */
@WebServlet(name = "CadastrarFuncionario", urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
                   
            String idFuncionario = request.getParameter("idFuncionario");
            Integer idFazenda = Integer.parseInt(request.getParameter("fazenda"));
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String cpf = request.getParameter("cpf");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String cep = request.getParameter("cep");
            String trabalho = request.getParameter("trabalho");
            Double salario = Double.parseDouble(request.getParameter("salario"));
            
            
            Funcionario funcionario = new Funcionario();
            
            Fazenda fazenda = new Fazenda();
            fazenda.setIdFazenda(idFazenda);
            
            funcionario.setFazenda(fazenda);
            funcionario.setNome(nome);
            funcionario.setEmail(email);
            funcionario.setSenha(senha);
            funcionario.setCpf(cpf);
            funcionario.setCidade(cidade);
            funcionario.setEstado(estado);
            funcionario.setCep(cep);
            funcionario.setTrabalho(trabalho);
            funcionario.setSalario(salario);

            GenericDAO dao = new FuncionarioDAO();
            
            String mensagem = "";
            
            
        if(idFuncionario.equals("")){
            if(dao.cadastrar(funcionario)){
                mensagem = "Cadastrado com sucesso!";
            }else{
                mensagem = "Erro ao cadastrar!";
            }
        }else{
            
        
            funcionario.setIdFuncionario(Integer.parseInt(idFuncionario));
            
            
            if(dao.alterar(funcionario)){
            mensagem="Dados alterado com sucesso!";
            }else{
            mensagem="Erro ao alterar dados"; 
            }
        
        }
            
            request.setAttribute("mensagem", mensagem);
            
            request.getRequestDispatcher(
              "cadastrar-funcionario.jsp").forward(request, response);
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar/alterar funcionarioCTR " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

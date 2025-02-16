/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.berranteweb.controle;

import br.com.berranteweb.dao.GenericDAO;
import br.com.berranteweb.dao.PecuaristaDAO;
import br.com.berranteweb.modelo.Pecuarista;
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
@WebServlet(name = "CadastrarPecuarista", urlPatterns = {"/CadastrarPecuarista"})
public class CadastrarPecuarista extends HttpServlet {

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
                   
            
            String idPecuarista = request.getParameter("idPecuarista");
            String nome = request.getParameter("nome");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String cpf = request.getParameter("cpf");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String cep = request.getParameter("cep");
            
            Pecuarista Pecuarista = new Pecuarista();
            Pecuarista.setNome(nome);
            Pecuarista.setEmail(email);
            Pecuarista.setSenha(senha);
            Pecuarista.setCpf(cpf);
            Pecuarista.setCidade(cidade);
            Pecuarista.setEstado(estado);
            Pecuarista.setCep(cep);


            GenericDAO dao = new PecuaristaDAO();
            
            String mensagem = "";
            
            
        if(idPecuarista.equals("")){
            if(dao.cadastrar(Pecuarista)){
                mensagem = "Cadastrado com sucesso!";
            }else{
                mensagem = "Erro ao cadastrar!";
            }
        }else{
            
            Pecuarista.setIdPecuarista(Integer.parseInt(idPecuarista));
            
            if(dao.alterar(Pecuarista)){
            mensagem="Dados alterado com sucesso!";
            }else{
            mensagem="Erro ao alterar dados"; 
            }
        
        }

            request.setAttribute("mensagem", mensagem);
            
            request.getRequestDispatcher(
              "Login.jsp").forward(request, response);
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar/alterar perfilCTR " + e.getMessage());
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.berranteweb.controle;

import br.com.berranteweb.dao.FazendaDAO;
import br.com.berranteweb.dao.GenericDAO;
import br.com.berranteweb.modelo.Fazenda;
import br.com.berranteweb.modelo.Pecuarista;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jorge
 */
@WebServlet(name = "CadastrarFazenda", urlPatterns = {"/CadastrarFazenda"})
public class CadastrarFazenda extends HttpServlet {

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
                   
            String idFazenda = request.getParameter("idFazenda");
            String nomeFazenda = request.getParameter("nomeFazenda");
            String endereco = request.getParameter("endereco");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            
            
            HttpSession sessao = request.getSession(true);
            Integer idPessoa= (Integer)sessao.getAttribute("idPessoa");
            
            Fazenda fazenda = new Fazenda();
            
            
            
            fazenda.setNomeFazenda(nomeFazenda);
            fazenda.setEndereco(endereco);
            fazenda.setCidade(cidade);
            fazenda.setEstado(estado);
            
            Pecuarista pecuarista = new Pecuarista();
            pecuarista.setId(idPessoa);
            
            fazenda.setPecuarista(pecuarista);
                   
            GenericDAO dao = new FazendaDAO();
            
            String mensagem = "";
            
            
        if(idFazenda.equals("")){
            if(dao.cadastrar(fazenda)){
                mensagem = "Cadastrado com sucesso!";
            }else{
                mensagem = "Erro ao cadastrar!";
            }
        }else{
            
        
            fazenda.setIdFazenda(Integer.parseInt(idFazenda));
            
            
            if(dao.alterar(fazenda)){
            mensagem="Dados alterado com sucesso!";
            }else{
            mensagem="Erro ao alterar dados"; 
            }
        
        }
            
            request.setAttribute("mensagem", mensagem);
            
            request.getRequestDispatcher(
              "ListarFazendaPorPecuarista").forward(request, response);
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar/alterar fazendaCTR " + e.getMessage());
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

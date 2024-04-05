/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.berranteweb.controle;

import br.com.berranteweb.dao.AnimalDAO;
import br.com.berranteweb.dao.GenericDAO;
import br.com.berranteweb.modelo.Animal;
import br.com.berranteweb.modelo.Fazenda;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "CadastrarAnimal", urlPatterns = {"/CadastrarAnimal"})
public class CadastrarAnimal extends HttpServlet {

    
   public Date converterData(String data) throws ParseException {
        if (data != null || !data.trim().equals("")) {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
            Date date = fmt.parse(data);
            return date;
        } else {
            return null;
        }
    }
    
    public static String data2String(Date data) throws ParseException {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");    
        String dataFormatada = fmt.format(data);
        
        return dataFormatada;
        }
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
                   
            
            String idAnimal = request.getParameter("idAnimal");
            Integer brinco = Integer.parseInt (request.getParameter("brinco"));
            String raca = request.getParameter("raca");
            String sexo = request.getParameter("sexo");
            Date dataNasc = converterData(request.getParameter("dataNasc").replace("-", "/"));
            String tipo = request.getParameter("tipo");
            String status = request.getParameter("status");
            
            
            
            HttpSession sessao = request.getSession(true);
            Integer idFazenda= (Integer)sessao.getAttribute("idFazenda");
            
            Animal animal = new Animal();
            
            Fazenda fazenda = new Fazenda();
            fazenda.setIdFazenda(idFazenda);
                    
            animal.setFazenda(fazenda);
            animal.setBrinco(brinco);
            animal.setRaca(raca);
            animal.setSexo(sexo);
            animal.setDataNasc(dataNasc);
            animal.setTipo(tipo);
            animal.setStatus(status);


            GenericDAO dao = new AnimalDAO();
            
            String mensagem = "";
            
            
       if(idAnimal.equals("")){
            if(dao.cadastrar(animal)){
                mensagem = "Cadastrado com sucesso!";
            }else{
                mensagem = "Erro ao cadastrar!";
            }
        }else{
            
        
            animal.setIdAnimal(Integer.parseInt(idAnimal));
            
            
            if(dao.alterar(animal)){
            mensagem="Dados alterado com sucesso!";
            }else{
            mensagem="Erro ao alterar dados"; 
            }
        
        }
            
            request.setAttribute("mensagem", mensagem);
            
            request.getRequestDispatcher(
              "ListarAnimalPorFazenda").forward(request, response);
            
        }catch(Exception e){
            System.out.println("Erro ao cadastrar/alterar animalCTR " + e.getMessage());
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

<%-- 
    Document   : cadastrar-funcionario
    Created on : May 19, 2021, 4:53:48 PM
    Author     : jorge
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="br.com.berranteweb.dao.FazendaDAO"%>
<%@page import="br.com.berranteweb.dao.GenericDAO"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/login-registro.css" rel="stylesheet" type="text/css"/>
        <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        
        <title>Berrante Web-Cadastro</title>

    </head>
    <body>
       
        <div class="row">
    <div class="col-md-6 mx-auto p-0">
        <div class="card">
            <div class="login-box">
                
                <div class="login-snip"> <label for="tab-2" class="tab">Cadastrar Funcionário</label>
                    <div class="login-space">
                        <a href="index-login.jsp">Voltar</a><br><br>
                        
                         <%
                                        
                                        FazendaDAO fazendaDAO = new FazendaDAO();
                                        
                                        HttpSession sessao = request.getSession(true);
                                        
                                        Integer id = (Integer) sessao.getAttribute("idPessoa");
                                        List<Object>  lista = fazendaDAO.listarPorPecuarista(id);
                                        
                                        %>
                                       
                        <form method="post" action="CadastrarFuncionario">
                       
                            ${mensagem}
                            <input type="hidden" name="idFuncionario" value="${funcionario.idFuncionario}"/>
                            <div class="group"> <label for="user" class="label">Nome</label> <input id="user" name="nome" type="text" class="input" placeholder="Insira o nome"  required value="${funcionario.nome}"> </div>
                            <div class="group"> <label for="user" class="label">CPF</label> <input id="user" name="cpf" type="text" class="input" placeholder="Insira o CPF" required value="${funcionario.cpf}"> </div>
                            <div class="group"> <label for="user" class="label">Cidade</label> <input id="user" name="cidade" type="text" class="input" placeholder="Insira a cidade" required value="${funcionario.cidade}"> </div>
                            <div class="group"> <label for="user" class="label">Estado</label> <input id="user" name="estado" type="text" class="input" placeholder="Insira o estado" required value="${funcionario.estado}"> </div>
                            <div class="group"> <label for="user" class="label">CEP</label> <input id="user" name="cep" type="text" class="input" placeholder="Insira o CEP" required value="${funcionario.cep}"> </div>
                            <div class="group"> <label for="pass" class="label">Email</label> <input id="pass" name="email" type="email" class="input" placeholder="Insira o Email" required value="${funcionario.email}"> </div>
                            <div class="group"> <label for="pass" class="label">Password</label> <input id="pass" name="senha" type="password" class="input" data-type="password" placeholder="Crie uma senha" required value="${funcionario.senha}"> </div>
                            <div class="group"> <label for="user" class="label">Trabalho</label> <input id="user" name="trabalho" type="text" class="input" placeholder="Insira o trabalho" required value="${funcionario.trabalho}"> </div>
                            <div class="group"> <label for="user" class="label">Salario</label> <input id="user" name="salario" type="text" class="input" placeholder="Insira o Salário" required value="${funcionario.salario}"> </div>
                            
                            <div class="group"> <label for="user" class="label">Fazenda</label> 
                            <select class="label input" name="fazenda">
                                <c:forEach items="<%=lista%>" var="fazenda">
                                    <option value="${fazenda.idFazenda}">${fazenda.nomeFazenda}</option>
                                                    
                                </c:forEach>
                                            </select>
                            </div>
                            
                            <div class="group"> <input type="submit" class="button" value="Cadastrar"> </div>
                            
                            
                        </div>
                        </form>
                        
                        
                  
                </div>
            </div>
        </div>
    </div>
</div>
        
        
        
        
        
        
        
        
        
        
        
        

 
    </body>
</html>

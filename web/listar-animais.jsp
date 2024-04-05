<%-- 
    Document   : listar-animais
    Created on : 07/06/2021, 10:39:26
    Author     : jorge
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@page import="br.com.berranteweb.dao.FuncionarioDAO"%>
<%@page import="br.com.berranteweb.dao.GenericDAO"%>



<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Berrante Web</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/icons/gordim_preto.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
  <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">
        
        <!--===============================================================================================-->	
	
        
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/bootstrap/css/bootstrap1.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
        <link href="assets/vendor/animate/animatetable.css" rel="stylesheet" type="text/css"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="assets/vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
        <link href="assets/css/main.css" rel="stylesheet" type="text/css"/>
        <link href="assets/css/util.css" rel="stylesheet" type="text/css"/>

<!--===============================================================================================-->
        
    </head>
    <body>
           <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo mr-auto"> <img src="assets/img/gordim_preto.png" alt=""/><a href="index-login.jsp">BERRANTE<span>WEB</span></a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <%
        HttpSession sessao = request.getSession(true);
        Integer id = (Integer) sessao.getAttribute("idPessoa");
        Integer idFazenda = Integer.parseInt(request.getParameter("idFazenda"));
%>
      
      <nav class="nav-menu d-none d-lg-block" >
        <ul>
          <li><a href="index-login.jsp">Home</a></li>
          <li><a href="precos-login.jsp">Preços</a></li>
          <li><a href="contato-login.jsp">Contato</a></li>
          <li class="drop-down"><a href="">Usuario</a>
            <ul>
              <li><a href="CarregarPecuarista?id=<%=id%>">Perfil </a></li>
              <li><a href="ListarFazendaPorPecuarista">Fazendas</a></li>
              <li><a href="cadastrar-funcionario.jsp">Cadastrar Funcionário</a></li>
              <li><a href="index.jsp">Logout</a></li>
            </ul>
      </nav><!-- .nav-menu -->

      <div class="header-social-links">
        <a href="#" class="twitter"><i class="icofont-twitter"></i></a>
        <a href="#" class="facebook"><i class="icofont-facebook"></i></a>
        <a href="https://www.instagram.com/berrante_web/" class="instagram"><i class="icofont-instagram"></i></a>
        
      </div>
     
    </div>
  </header><!-- End Header -->
        <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Animais</h2>
        
          <ol>
            <li><a href="index-login.jsp">Home</a></li>
            <li><a href="ListarFazendaPorPecuarista">Fazendas</a></li>
            <li>Animais</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs -->
        <div class="limiter">
         
       
		<div class="container-table100">
                   
                    
			<div class="wrap-table100">
                            
         <div class="table100 ver2 m-b-110">
             
					<table data-vertable="ver2">
						<thead>
							<tr class="row100 head">
								<th class="column100 column1" data-column="column1">Brinco</th>
								<th class="column100 column2" data-column="column2">Raça</th>
								<th class="column100 column3" data-column="column3">Sexo</th>
								
                                                                <th class="column100 column5" data-column="column5">DataNascimento</th>
                                                                <th class="column100 column6" data-column="column6">Tipo</th>
                                                                <th class="column100 column7" data-column="column7">Status</th>
                                                                <th class="column100 column8" data-column="column8"></th>
                                                                
							</tr>
						</thead>
                                                
						<tbody>
                                                    
                                                    
                                                    <c:forEach items="${animais}" var="animal">
                                                       
							<tr class="row100">
								<td class="column100 column1" data-column="column1">${animal.brinco}</td>
								<td class="column100 column2" data-column="column2">${animal.raca}</td>
								<td class="column100 column3" data-column="column3">${animal.sexo}</td>
                                                                <td class="column100 column5" data-column="column5"> <fmt:formatDate value="${animal.dataNasc}" type="date" pattern="dd/MM/yyyy" dateStyle="full" /> </td>
                                                                <td class="column100 column6" data-column="column6">${animal.tipo}</td>
                                                                <td class="column100 column7" data-column="column7">${animal.status}</td>
                                                                <td class="column100 column9" data-column="column9"> 
                                                                  <div class="container">
                                                                  <nav class="nav-menu d-none d-lg-block align-items-center">
                                                                <ul>
                                                                      <li class="nav-menu drop-down li"><a href="">Opções</a>
                                                                <ul>
                                                                    <li><a href="CarregarAnimal?idAnimal=${animal.idAnimal}"> Alterar </a></li>
                                                                    <li><a href="ExcluirAnimal?idAnimal=${animal.idAnimal}"> Excluir</a></li>
                                                                </ul>
                                                                </ul>
                                                                    </nav>
                                                                </div>
                                                                </td>
                                                                
							</tr>
                                                        
							 </c:forEach> 
                                                       <form method="post" action="CadastrarAnimal?idFazenda=<%=idFazenda%>">
                                                            <input type="hidden" name="idAnimal" value="${animal.idAnimal}"/>
                                                           
                                                            
                                                            <tr class="row100 col-md-6 form-group">
                                                             
                                                                
                                                                
								<td class="column100 column1" data-column="column1"><input id="user" name="brinco" type="text" class="form-control" placeholder="Brinco"  required value="${animal.brinco}"></td>
								<td class="column100 column2" data-column="column2"><input id="user" name="raca" type="text" class="form-control" placeholder="Raça" required value="${animal.raca}"></td>
                                                                <td class="column100 column2" data-column="column2"><select name="sexo" class="form-control"/>
                                                                                            <option ${animal.sexo == "Macho" ? "selected" : ""} value="Macho"> Macho</option>
                                                                                            <option ${animal.sexo == "Fêmea" ? "selected" : ""} value="Fêmea"> Fêmea</option>
                                                                </select></td>
								<td class="column100 column5" data-column="column5"><input id="user" name="dataNasc" type="date" class="form-control" placeholder="Data de nascimento" required value="${animal.dataNasc}"></td>
                                                                <td class="column100 column6" data-column="column6"><input id="user" name="tipo" type="text" class="form-control" placeholder="Tipo" required value="${animal.tipo}"></td>
                                                                <td class="column100 column7" data-column="column7">
                                                                <select name="status" class="form-control"/>
                                                                                                        <option ${animal.status == "Ativo" ? "selected" : ""} value="Ativo"> Ativo</option>
                                                                                                        <option ${animal.status == "Inativo" ? "selected" : ""} value="Inativo"> Inativo</option>
                                                                </select></td>
<td class="column100 column7" data-column="column7"><button type="submit" value="Cadastrar" > Cadastrar</button></td>
                                                             
							</tr>
                                                        </form> 
                                                         
						</tbody> 
                                               
					</table>
                                            
                                                        
                                                        
				</div>
                         
                         <h3>${mensagem}</h3>
                        </div>
                                    
                    </div>
           
        </div>
         
                         <!-- ======= Footer ======= -->
  <footer id="footer">

    
      <div class="container">
        <div class="row">
    <div class="container d-md-flex py-4">

      <div class="mr-md-auto text-center text-md-left">
        <div class="copyright">
          &copy; BerranteWEB <strong><span>Company</span></strong>. Todos os direitos reservados
        </div>
        <div class="credits">
          <!-- All the links in the footer should remain intact. -->
          <!-- You can delete the links only if you purchased the pro version. -->
          <!-- Licensing information: https://bootstrapmade.com/license/ -->
          <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/company-free-html-bootstrap-template/ -->
          Desenvolvido por <a href="https://bootstrapmade.com/">Alunos da ETEC de Fernandópolis</a>

        </div>
      </div>
      <div class="social-links text-center text-md-right pt-3 pt-md-0">
        <a href="#" class="twitter"><i class="bx bxl-twitter"></i></a>
        <a href="#" class="facebook"><i class="bx bxl-facebook"></i></a>
        <a href="https://www.instagram.com/berrante_web/" class="instagram"><i class="bx bxl-instagram"></i></a>
        
      </div>
    </div>
  </footer><!-- End Footer -->

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

  <!-- Vendor JS Files -->
  <script src="assets/vendor/jquery/jquery.min.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/jquery-sticky/jquery.sticky.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/venobox/venobox.min.js"></script>
  <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
  <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
  <script src="assets/vendor/aos/aos.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

                       
    </body>
</html>

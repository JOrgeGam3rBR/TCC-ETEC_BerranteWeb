<%-- 
    Document   : perfil
    Created on : 22/05/2021, 15:24:16
    Author     : jorge
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.berranteweb.dao.FazendaDAO"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    
    
   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<head>
    
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
        
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Berrante-Web Perfil</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
            
                                        
                                        %>

      

      <nav class="nav-menu d-none d-lg-block">
        <ul>
          <li><a href="index-login.jsp">Home</a></li>
          <li><a href="precos-login.jsp">Preços</a></li>
          <li><a href="contato-login.jsp">Contato</a></li>
          <li class="drop-down"><a href="">Usuario</a>
            <ul>
              <li class="active"><a href="CarregarPecuarista?id=<%=id%>">Perfil </a></li>
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
          <h2>Perfil</h2>
          <ol>
            <li><a href="index-login.jsp">Home</a></li>
            <li>Perfil</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs -->
    <br>
<div class="container bootstrap snippet">
    
    <div class="row">
  		<div class="col-sm-3"><!--left col-->
              

      <div class="text-center">
        <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar">
        <h6>Trocar foto de perfil...</h6>
        <input type="file" class="text-center center-block file-upload">
      </div></hr><br>

        </div><!--/col-3-->
    	<div class="col-sm-9">
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#home">Perfil</a></li>
                
              </ul>

              
          <div class="tab-content">
            <div class="tab-pane active" id="home">
                <hr>
                  <form class="form" action="CadastrarPecuarista" method="post" id="registrationForm">
                      <div class="form-group">
                          <input type="hidden" name="id"/>
                          <div class="col-xs-6">
                              <label for="nome"><h4>Nome</h4></label>
                              <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome" title="Seu nome" value="${pecuarista.nome}" >
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                            <label for="cpf"><h4>CPF</h4></label>
                              <input type="text" class="form-control" name="cpf" id="cpf" placeholder="CPF" title="Seu CPF" value="${pecuarista.cpf}">
                          </div>
                      </div>
          
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="cidade"><h4>Cidade</h4></label>
                              <input type="text" class="form-control" name="cidade" id="cidade" placeholder="Fernandópolis" title="Sua cidade" value="${pecuarista.cidade}">
                          </div>
                      </div>
          
                      <div class="form-group">
                          <div class="col-xs-6">
                             <label for="estado"><h4>Estado</h4></label>
                              <input type="text" class="form-control" name="estado" id="estado" placeholder="São Paulo" title="seu estado" value="${pecuarista.estado}">
                          </div>
                      </div>
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="email"><h4>Email</h4></label>
                              <input type="email" class="form-control" name="email" id="email" placeholder="you@email.com" title="Seu email." value="${pecuarista.email}">
                          </div>
                      </div>
                      
                      <div class="form-group">
                          
                          <div class="col-xs-6">
                              <label for="senha"><h4>Senha</h4></label>
                              <input type="password" class="form-control" name="senha" id="senha" placeholder="senha" title="Sua senha" value="${pecuarista.senha}">
                          </div>
                      </div>
                     
                      <div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Salvar</button>
                               	<button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Resetar</button>
                            </div>
                      </div>
              	</form>
              
              <hr>
              
             </div><!--/tab-pane-->
             
          </div><!--/tab-content-->

        </div><!--/col-9-->
    </div><!--/row-->
</div>
                          
                           
                          <br>
                          <br>
                          <br>
                          <br>
                          <br>
                        
        
                          
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

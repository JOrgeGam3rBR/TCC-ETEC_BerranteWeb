<%-- 
    Document   : precos-login
    Created on : 15/06/2021, 19:51:07
    Author     : jorge
--%>


<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Preços - BerranteWeb</title>
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

  <!-- =======================================================
  * Template Name: Company - v2.2.1
  * Template URL: https://bootstrapmade.com/company-free-html-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

<!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex align-items-center">

      <h1 class="logo mr-auto">   <img src="assets/img/gordim_preto.png" alt=""/>   <a href="index-login.jsp">BERRANTE<span>WEB</span></a></h1>
      
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

     <%
          HttpSession sessao = request.getSession(true);
          Integer id = (Integer) sessao.getAttribute("idPessoa");
  
%>
      
      <nav class="nav-menu d-none d-lg-block" >
        <ul>
          <li><a href="index-login.jsp">Home</a></li>
          <li class="active"><a href="precos-login.jsp">Preços</a></li>
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
  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <div class="d-flex justify-content-between align-items-center">
          <h2>Preços</h2>
          <ol>
            <li><a href="index.jsp">Home</a></li>
            <li>Preços</li>
          </ol>
        </div>

      </div>
    </section><!-- End Breadcrumbs -->

    <!-- ======= Pricing Section ======= -->
    <section id="pricing" class="pricing">
      <div class="container" data-aos="fade-up">

        <div class="row">

          <div class="col-lg-3 col-md-6">
            <div class="box">
              <h3>Inicial</h3>
              <h4><sup>R$</sup>29<span> / Mês</span></h4>
              <ul>
                <li>1 Fazenda</li>
                <li>Funcionários</li>
                <li>1000 Animais</li>
                <li>Tabela de Transações</li>
                <li class="na">Tabela de Medicações</li>
                <li class="na">Tabela de Pesagem</li>
                <li class="na">Tabela de Perdas </li>
                
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Assinar</a>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mt-4 mt-md-0">
            <div class="box featured">
              <h3>Intermediário</h3>
              <h4><sup>R$</sup>59<span> / Mês</span></h4>
              <ul>
                <li>3 Fazenda</li>
                <li>Funcionários</li>
                <li>5000 Animais</li>
                <li>Tabela de Transações</li>
                <li>Tabela de Medicações</li>
                <li class="na">Tabela de Pesagem</li>
                <li class="na">Tabela de Perdas </li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Assinar</a>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mt-4 mt-lg-0">
            <div class="box">
              <h3>Avançado</h3>
              <h4><sup>R$</sup>79<span> / Mês</span></h4>
              <ul>
                <li>4 Fazenda</li>
                <li>Funcionários</li>
                <li>10000 Animais</li>
                <li>Tabela de Transações</li>
                <li>Tabela de Medicações</li>
                <li>Tabela de Pesagem</li>
                <li class="na">Tabela de Perdas </li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Assinar</a>
              </div>
            </div>
          </div>

          <div class="col-lg-3 col-md-6 mt-4 mt-lg-0">
            <div class="box">
              <span class="advanced">Avançado</span>
              <h3>Rei do Gado</h3>
              <h4><sup>R$</sup>99<span> / Mês</span></h4>
              <ul>
                <li>5 Fazenda</li>
                <li>Funcionários</li>
                <li>100000 Animais</li>
               <li>Tabela de Transações</li>
                <li>Tabela de Medicações</li>
                <li>Tabela de Pesagem</li>
                <li>Tabela de Perdas </li>
              </ul>
              <div class="btn-wrap">
                <a href="#" class="btn-buy">Assinar</a>
              </div>
            </div>
          </div>

        </div>

      </div>
    </section><!-- End Pricing Section -->

    <!-- ======= Frequently Asked Questions Section ======= -->
    <section id="faq" class="faq section-bg">
      <div class="container" data-aos="fade-up">

        <div class="section-title">
          <h2>Perguntas Frequentes</h2>
        </div>

        <div class="faq-list">
          <ul>
            <li data-aos="fade-up">
              <i class="bx bx-help-circle icon-help"></i> <a data-toggle="collapse" class="collapse" href="#faq-list-1">Eu posso cancelar o meu plano a qualquer hora?<i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i></a>
              <div id="faq-list-1" class="collapse show" data-parent=".faq-list">
                <p>
Sim, você pode cancelar seu plano a qualquer hora.                </p>
              </div>
            </li>

            <li data-aos="fade-up" data-aos-delay="100">
              <i class="bx bx-help-circle icon-help"></i> <a data-toggle="collapse" href="#faq-list-2" class="collapsed">Como posso entrar em contato com a equipe? <i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i></a>
              <div id="faq-list-2" class="collapse" data-parent=".faq-list">
                <p>
Você pode entrar em contato a partir da aba CONTATO, onde disponibilizamos nosso telefone e e-mail, além de possuir um campo que oferece contato direto.</p>
                </p>
              </div>
            </li>

            <li data-aos="fade-up" data-aos-delay="200">
              <i class="bx bx-help-circle icon-help"></i> <a data-toggle="collapse" href="#faq-list-3" class="collapsed">Eu posso trocar de plano a qualquer momento? <i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i></a>
              <div id="faq-list-3" class="collapse" data-parent=".faq-list">
                <p>
Sim, você pode trocar seu plano, mas ele só será alterado a partir do próximo mês, junto com a cobrança do mesmo.              </div>
            </li>

            <li data-aos="fade-up" data-aos-delay="300">
              <i class="bx bx-help-circle icon-help"></i> <a data-toggle="collapse" href="#faq-list-4" class="collapsed">Como posso atualizar minha assinatura ou alterar algum dado? <i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i></a>
              <div id="faq-list-4" class="collapse" data-parent=".faq-list">
                <p>
Você pode ir na área de cadastro, logar sua conta e depois alterar os dados que deseja modificar e em seguida, salve suas modificações.                </p>
              </div>
            </li>

            <li data-aos="fade-up" data-aos-delay="400">
              <i class="bx bx-help-circle icon-help"></i> <a data-toggle="collapse" href="#faq-list-5" class="collapsed">Onde posso encontrar informações novas em relação ao mercado comercial de bovinos? <i class="bx bx-chevron-down icon-show"></i><i class="bx bx-chevron-up icon-close"></i></a>
              <div id="faq-list-5" class="collapse" data-parent=".faq-list">
                <p>
Você pode encontrar essas informações atualizadas na página home, onde todos os dados e notas serão atualizados conforme as mudanças do mercado.                </p>
              </div>
            </li>

          </ul>
        </div>

      </div>
    </section><!-- End Frequently Asked Questions Section -->

  </main><!-- End #main -->

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
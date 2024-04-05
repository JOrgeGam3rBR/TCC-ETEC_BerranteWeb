<%-- 
    Document   : Login
    Created on : 22/05/2021, 12:08:56
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%><!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="assets/css/login-registro.css" rel="stylesheet" type="text/css"/>
        <link href='https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css'>
        <script src='https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        
        
          
  <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        
        
        <title>Berrante Web-Login</title>
    </head>
    <body>
        
 <div class="row">
    <div class="col-md-6 mx-auto p-0">
        <div class="card">
            <div class="login-box">
                <div class="login-snip"> <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Cadastrar-se</label>
                    <div class="login-space">
                        <form method="post" action="Login">
                        <div class="login">
                            <div class="group"> <label for="user" class="label">Email</label> <input id="user" name="email" type="text" class="input" placeholder="Digite seu nome"> </div>
                            <div class="group"> <label for="pass" class="label">Senha</label> <input id="pass" name="senha" type="password" class="input" data-type="password" placeholder="Digite sua senha"> </div>
                            <div class="group"> <input id="check" type="checkbox" class="check" checked> <label for="check"><span class="icon"></span> Permanecer logado</label> </div>
                            <div class="group"> <input type="submit" class="button" value="Logar"> </div>
                            ${mensagem}
                            <div class="hr"></div>
                            <div class="foot"> <a href="#">Esqueceu a senha?</a> </div>
                        </div>
                        </form>
                        <form method="post" action="CadastrarPecuarista">
                        <div class="sign-up-form">
                            <input type="hidden" name="idPecuarista"/>
                            <div class="group"> <label for="user" class="label">Nome</label> <input id="user" name="nome" type="text" class="input" placeholder="Insira seu nome"  required> </div>
                            <div class="group"> <label for="user" class="label">CPF</label> <input id="user" name="cpf" type="text" class="input" placeholder="Insira seu CPF" required> </div>
                            <div class="group"> <label for="user" class="label">Cidade</label> <input id="user" name="cidade" type="text" class="input" placeholder="Insira sua cidade" required> </div>
                            <div class="group"> <label for="user" class="label">Estado</label> <input id="user" name="estado" type="text" class="input" placeholder="Insira seu estado" required> </div>
                            <div class="group"> <label for="user" class="label">CEP</label> <input id="user" name="cep" type="text" class="input" placeholder="Insira seu CEP" required> </div>
                            <div class="group"> <label for="pass" class="label">Email</label> <input id="pass" name="email" type="email" class="input" placeholder="Insira seu Email" required> </div>
                            <div class="group"> <label for="pass" class="label">Password</label> <input id="pass" name="senha" type="password" class="input" data-type="password" placeholder="Crie uma senha" required> </div>
                            
                            <div class="group"> <input type="submit" class="button" value="Cadastrar-se"> </div>
                            
                            <div class="hr"></div>
                           
                        </div>
                        </form>
                        
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
        ${mensagem}
    </body>
</html>

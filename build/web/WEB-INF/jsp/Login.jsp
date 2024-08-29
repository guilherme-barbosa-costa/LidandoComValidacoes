<%-- 
    Document   : Login
    Created on : 26/08/2024, 13:54:45
    Author     : Senai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <style>
            h1{
                text-align: center;
            }
            button{
                align-items: center;
            }
            
        </style>
        
         <form action="./Login" class="form-container" method="post">
        <div class="form-floating mb-3">
                <input type="text" class="form-control" id="floatingInput" name="email" placeholder="Email">
                <label for="floatingInput">Email</label>
            </div>
            <div class="form-floating mb-3">
                <input type="password" class="form-control" id="floatingInput" name="senha" placeholder="Senha">
                <label for="floatingInput">Senha</label>
            </div>
            <div class="form-floating mb-3 btn1">
                <button class="btn btn-secondary" type="submit">Logar</button>
            </div>
        </form>
        
    <a href="./Cadastro">Cadastrar-se</a>    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>

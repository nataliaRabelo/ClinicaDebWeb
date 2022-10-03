<%-- 
    Document   : Login
    Created on : 01/10/2022, 17:19:02
    Author     : natyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Login</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <h3>Login</h3>
                <form action="Login" method="POST">
                    <div class="mb-3">
                        <label for="email" class="form-label">email</label>
                        <input type="text" name="email" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="senha" class="form-label">senha</label>
                        <input type="text" name="senha" class="form-control">
                    </div>
                    <div>
                        <input type="submit" value="Enviar" class="btn btn-primary">
                        <%--<a href="/ClinicaDaNatalia/AreaDoMedico"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;"></button></a>--%>
                    </div>
                </form>
            </div>
        </div>
        <script src="bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>
<%-- 
    Document   : RegistroEspecialidade
    Created on : 09/10/2022, 21:15:22
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
        <title>Registro de Especialidade</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <h3>Registro de Especialidade</h3>
                <form target="_blank" method="POST" action="ListaDeEspecialidades.jsp" >
                    <div class="mb-3">
                        <label for="nome" class="form-label">id</label>
                        <input type="text" name="nome" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="crm" class="form-label">descricao</label>
                        <input type="text" name="crm" class="form-control">
                    </div>
                    <div>
                        <%--<input onclick="window.location.href = 'http://locallhost:8080/ClinicaDaNatalia/AreaDoMedico';" type="submit" value="Submit request" />--%>
                        <input type="submit" value="Submit" name="submit">
                        <%--<a href="/ClinicaDaNatalia/AreaDoMedico"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;"></button></a>--%>
                    </div>
                </form>
            </div>
        </div>
        <script src="bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>

<%-- 
    Document   : RegistroMedico
    Created on : 01/10/2022, 17:20:22
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
        <title>Registro de Médico</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <h3>Registro de Médico</h3>
                <form target="_blank" method="POST" action="AreaDoMedico" >
                    <div class="mb-3">
                        <label for="nome" class="form-label">nome</label>
                        <input type="text" name="nome" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="crm" class="form-label">crm</label>
                        <input type="text" name="crm" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="estadocrm" class="form-label">estadocrm</label>
                        <input type="text" name="estado crm" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="cpf" class="form-label">cpf</label>
                        <input type="text" name="cpf" class="form-control">
                    </div>
                        <label for="senha;" class="form-label">senha</label>
                        <input type="text" name="cpf" class="form-control">
                    </div>
                    </div>
                        <label for="autorizado" class="form-label">autorizado</label>
                        <input type="text" name="autorizado" class="form-control">
                    </div>
                    </div>
                        <label for="especialidade" class="form-label">especialidade</label>
                        <input type="text" name="especialidade" class="form-control">
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

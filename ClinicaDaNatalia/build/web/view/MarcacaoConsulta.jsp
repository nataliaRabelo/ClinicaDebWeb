<%-- 
    Document   : MarcacaoConsulta
    Created on : 01/10/2022, 17:19:29
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
        <title>Marcacao Consulta</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <h3>Marcar consulta</h3>
                <form action="MarcacaoConsulta" method="POST">
                    <div class="mb-3">
                        <label for="data" class="form-label">data</label>
                        <input type="text" name="data" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="descricao" class="form-label">descricao</label>
                        <input type="text" name="descricao" class="form-control">
                    </div>
                        <label for="realizada;" class="form-label">senha</label>
                        <input type="text" name="realizaca" class="form-control">
                    </div>
                    </div>
                        <label for="idmedico" class="form-label">idmedico</label>
                        <input type="text" name="idmedico" class="form-control">
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

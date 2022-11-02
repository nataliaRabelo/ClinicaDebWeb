<%-- 
    Document   : RegistroPaciente
    Created on : 01/10/2022, 17:20:48
    Author     : natyn
--%>

<%@page import="model.TipoPlano"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Registro de Paciente</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #fff; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Registro de paciente</h1></font></div>
                <form action="RegistroPaciente" method="POST">
                    <div class="mb-3">
                        <label for="nome" class="form-label" color="#FFFAFA">nome</label>
                        <input type="text" name="nome" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="cpf" class="form-label" color="#FFFAFA">cpf</label>
                        <input type="text" name="cpf" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="senha;" class="form-label" color="#FFFAFA">senha</label>
                        <input type="text" name="senha" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="idtipoplano" class="form-label" color="#FFFAFA">convênio</label>
                        <select class="form-select d-block w-100 form-control" id="idtipoplano" name="idtipoplano"required>
                        <option value="">Escolha o plano.</option>
                        <%
                        ArrayList<TipoPlano> listaDePlanos = (ArrayList<TipoPlano>) request.getAttribute("listaDePlanos");

                        for (TipoPlano tipoPlano : listaDePlanos) {
                            out.println("<option value= '"+tipoPlano.getId()+"'>");
                            out.println(tipoPlano.getDescricao());
                            out.println("</option>");
                        }
%>
                    </select>
                    </div>
                    <div>
                        <input type="submit" value="Enviar" class="btn-primary">
                    </div>
                </form>
            </div>
        </div>
        <style>
                body {
            background-color: #008AAF;
        }     
        </style>
        <script src="bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>

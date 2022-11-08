<%-- 
    Document   : RealizarConsulta
    Created on : 05/11/2022, 08:02:07
    Author     : natyn
--%>

<%@page import="model.Consulta"%>
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
        <ul class="nav-bar">
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/AreaDoPaciente">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/">Logout</a></li>
        </ul>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
        <link rel="stylesheet" href="view/index.css">
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Realizar consulta</h1></font></div>
                <form action="RealizarConsulta" method="POST">
                    <div class="mb-3">
                        <label for="descricao" class="form-label" color="#FFFAFA">descricao</label>
                        <input type="text" name="descricao" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="id" class="form-label" color="#FFFAFA">consulta</label>
                        <select class="form-select d-block w-100 form-control" id="id" name="id"required>
                        <option value="">Escolha a consulta a ser alterada.</option>
                        <%
                        ArrayList<Consulta> listaDeConsultas = (ArrayList<Consulta>) request.getAttribute("listaDeConsultas");

                        for (Consulta consulta : listaDeConsultas) {
                            out.println("<option value= '"+consulta.getId()+"'>");
                            out.println(consulta.getData());
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
        <script src="bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>

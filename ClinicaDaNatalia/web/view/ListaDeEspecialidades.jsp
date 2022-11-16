<%-- 
    Document   : ListaDeMedicos
    Created on : 02/10/2022, 17:01:19
    Author     : natyn
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Especialidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Lista de Especialidades</title>
        <ul class="nav-bar">
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/RegistroPaciente">Registro</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/Login">Login</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeConvenios">Convenios</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeEspecialidades">Especialidades</a></li>
        </ul>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
        <link rel="stylesheet" href="css/style4.css">
        <link rel="stylesheet" href="view/index.css">
    </head>
    <body>
        <div class="container">
            <div class="mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Lista de Especialidades</h1></font></div>
                <%
                    ArrayList<Especialidade> listaDeEspecialidades = (ArrayList<Especialidade>) request.getAttribute("listaDeEspecialidades");

                    for (Especialidade especialidade : listaDeEspecialidades) {
                        String id = especialidade.getId();
                        String descricao = especialidade.getDescricao();

                %>
                <div class="card mb-3">
                    <div class="card-body">
                        <p class="card-text"><%=especialidade.getDescricao()%></p>
                    </div>
                </div>
                <%     }%>

            </div>
        </div>
    </body>
</html>


<%@page import="java.util.ArrayList"%>
<%@page import="model.TipoPlano"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Lista de Convenios</title>
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
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Lista de Convênios</h1></font></div>
                <%
                    ArrayList<TipoPlano> listaDePlanos = (ArrayList<TipoPlano>) request.getAttribute("listaDePlanos");

                    for (TipoPlano tipoPlano : listaDePlanos) {
                        String id = tipoPlano.getId();
                        String descricao = tipoPlano.getDescricao();

                %>
                <div class="card mb-3">
                    <div class="card-body">
                        <p class="card-text"><%=tipoPlano.getDescricao()%></p>
                    </div>
                </div>
                <%     }%>

            </div>
        </div>
    </body>
</html>

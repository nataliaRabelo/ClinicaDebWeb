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
        <a href="/ClinicaDaNatalia/"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="mt-5">
                <h2>Lista de Especialidades</h2>
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


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
        <title>Lista de Comentários - Login com DAO</title>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="mt-5">

                <h1>Área Pública</h1>
                <h2>Lista de Convênios</h2>
                <%
                    ArrayList<TipoPlano> listaDePlanos = (ArrayList<TipoPlano>) request.getAttribute("listaDePlanos");

                    for (TipoPlano tipoPlano : listaDePlanos) {
                        String id = tipoPlano.getId();
                        String data = tipoPlano.getDescricao();

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

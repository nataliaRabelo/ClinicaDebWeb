<%@page import="model.Especialidade"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Lista de Administradores</title>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
        <link rel="stylesheet" href="css/style4.css">
        <link rel="stylesheet" href="view/index.css">
        <link rel="stylesheet" href="view/table.css">
        <ul class="nav-bar">
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/AreaDoAdministrador">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/Logout">Logout</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeConveniosPublica">Convenios</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeEspecialidadesPublica">Especialidades</a></li>
    </ul>
    </head>
    <body>
        <div class="container">
            <div class="mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h2>Lista de Especialidades</h2></div>
<div class="table table-hover">
        <table class="table">
            <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Descricao
                    </th>
                </tr>
            </thead>
            <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/RegistroEspecialidade"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Nova especialidade</button></a>
            </div>
                <%
                    ArrayList<Especialidade> especialidades = (ArrayList<Especialidade>) request.getAttribute("especialidades");
                    if(especialidades.isEmpty()){
                        out.print("<h1>A lista de especialidades está vazia! D:</h1>");
                    }
                    for (Especialidade especialidade : especialidades) {
                        String id = especialidade.getId();
                        String nome = especialidade.getDescricao();

                %>
            <tbody>
                    <tr>
                        <td>
                            <%= id%>
                        </td>
                        <td>
                            <%= nome%>                         
                        </td>
                        <%
                        out.print("<td>");
                        out.print("<form action=\"EditarEspecialidade\"\"\" method=\"get\">");
                        out.print("<button name=\"id\" value=\""+ especialidade.getId()+"\">Editar</button>");
                        out.print("</form>");
                        out.print("<form action=\"ExcluirEspecialidade\"\"\" method=\"post\">");
                        out.print("<button name=\"id\" value=\""+ especialidade.getId()+"\">Excluir</button>");
                        out.print("</form>");
                        out.print("</td>");
                        %>
                    </tr>
            </tbody>
            <%     }%>
        </table>
    </div>
    </body>
</html>

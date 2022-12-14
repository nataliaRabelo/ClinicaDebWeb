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
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h2>Lista de Administradores</h2></div>
<div class="table table-hover">
        <table class="table">
            <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Nome
                    </th>
                    <th>
                        Cpf
                    </th>
                    <th>
                        Senha
                    </th>
                </tr>
            </thead>
            <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/RegistroAdministrador"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Novo administrador</button></a>
            </div>
                <%
                    ArrayList<Usuario> listaDeAdministradores = (ArrayList<Usuario>) request.getAttribute("administradores");
                    if(listaDeAdministradores.isEmpty()){
                        out.print("<h1>A lista de administradores est?? vazia! D:</h1>");
                    }
                    for (Usuario administrador : listaDeAdministradores) {
                        String id = administrador.getId();
                        String nome = administrador.getNome();
                        String cpf = administrador.getCpf();
                        String senha = administrador.getSenha();

                %>
            <tbody>
                    <tr>
                        <td>
                            <%= id%>
                        </td>
                        <td>
                            <%= nome%>                         
                        </td>
                        <td>
                            <%= cpf%>
                        </td>
                        <td>
                            <%= senha%>
                        </td>
                        <%
                        out.print("<td>");
                        out.print("<form action=\"EditarAdministrador\"\"\" method=\"get\">");
                        out.print("<button name=\"id\" value=\""+ administrador.getId()+"\">Editar</button>");
                        out.print("</form>");
                        out.print("<form action=\"ExcluirAdministrador\"\"\" method=\"post\">");
                        out.print("<button name=\"id\" value=\""+ administrador.getId()+"\">Excluir</button>");
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

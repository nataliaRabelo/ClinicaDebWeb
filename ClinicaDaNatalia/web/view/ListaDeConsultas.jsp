<%@page import="model.Paciente"%>
<%@page import="model.Administrador"%>
<%@page import="model.Usuario"%>
<%@page import="model.Medico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Consulta"%>
<%Usuario usuario = (Usuario) request.getAttribute("usuariologado");%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Lista de Consultas</title>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
        <link rel="stylesheet" href="css/style4.css">
        <link rel="stylesheet" href="view/index.css">
        <link rel="stylesheet" href="view/table.css">
        <ul class="nav-bar">
            <%
            if(usuario.getClass() == Paciente.class){
                out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"/ClinicaDaNatalia/AreaDoPaciente\">Home</a></li>");
            }else if(usuario.getClass() == Medico.class){
                out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"/ClinicaDaNatalia/AreaDoMedico\">Home</a></li>"); 
            }else{
                out.print("<li class=\"nav-item\"><a class=\"nav-link\" href=\"/ClinicaDaNatalia/AreaDoAdministrador\">Home</a></li>");
            }%>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/Logout">Logout</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeConveniosPublica">Convenios</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeEspecialidadesPublica">Especialidades</a></li>
    </ul>
    </head>
    <body>
        <div class="container">
            <div class="mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h2>Lista de Consultas</h2></div>
<div class="table table-hover">
        <table class="table">
            <thead>
                <tr>
                    <th>
                        Id
                    </th>
                    <th>
                        Data
                    </th>
                    <th>
                        Descricao
                    </th>
                    <th>
                        Realizada?
                    </th>
                    <th>
                        Medico
                    </th>
                </tr>
            </thead>
                <%
                    ArrayList<Consulta> listaDeConsultas = (ArrayList<Consulta>) request.getAttribute("listaDeConsultas");
                    if(listaDeConsultas.isEmpty()){
                        out.print("<h1>Sua lista de consultas está vazia! D:</h1>");
                    }
                    for (Consulta consulta : listaDeConsultas) {
                        String id = consulta.getId();
                        String data = consulta.getData();
                        String descricao = consulta.getDescricao();
                        String realizada = consulta.getRealizada();
                        String idmedico = consulta.getMedico();
                        
                %>
            <tbody>
                    <tr>
                       <td>
                            <%= id%>
                        </td>
                        <td>
                            <%= data%>
                        </td>
                        <td>
                            <%= descricao%>                         
                        </td>
                        <td>
                            <%= realizada%>
                        </td>
                        <td>
                            <%= idmedico%>
                        </td>
                        <%
                            if(usuario != null && usuario.getClass() == Medico.class){
                                out.print("<td>");
                                if(consulta.getRealizada().equals("S")){
                                    out.print("<form action=\"EditarConsulta\"\"\" method=\"get\">");
                                    out.print("<button name=\"id\" value=\""+ consulta.getId()+"\">Editar</button>");
                                }
                                out.print("</td>");
                            }
                        %>
                    </tr>
            </tbody>
            <%     }%>
        </table>
    </div>
    </body>
</html>

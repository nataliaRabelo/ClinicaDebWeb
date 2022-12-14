<%@page import="model.Paciente"%>
<%@page import="model.Usuario"%>
<%@page import="model.Exame"%>
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
        <title>Lista de Exames</title>
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
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h2>Lista de Exames</h2></div>
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
                    <th>
                        Id consulta
                    </th>
                    <th>
                        Data da consulta
                    </th>
                    <th>
                        Id Medico
                    </th>
                    <th>
                        Medico
                    </th>
                     <th>
                        Id Paciente
                    </th>
                    <th>
                        Paciente
                    </th>
                </tr>
            </thead>
                <%
                    ArrayList<Exame> listaDeExames = (ArrayList<Exame>) request.getAttribute("listaDeExames");
                    if(listaDeExames.isEmpty()){
                        out.print("<h1>Sua lista de exames est?? vazia! D:</h1>");
                    }
                    for (Exame exame : listaDeExames) {
                        String id = exame.getId();
                        String descricao = exame.getDescricaoTipoExame();
                        String idconsulta = exame.getIdConsulta();
                        String data = exame.getDataConsulta();
                        String idmedico = exame.getIdMedico();
                        String medico = exame.getMedico();
                        String idpaciente = exame.getIdPaciente();
                        String paciente = exame.getPaciente();

                %>
            <tbody>
                    <tr>
                        <td>
                            <%= id%>
                        </td>
                        <td>
                            <%= descricao%>
                        </td>
                        <td>
                            <%= idconsulta%>                         
                        </td>
                        <td>
                            <%= data%>
                        </td>
                        <td>
                            <%= idmedico%>
                        </td>
                        <td>
                            <%= medico%>
                        </td>
                        <td>
                            <%= idpaciente%>
                        </td>
                        <td>
                            <%= paciente%>
                        </td>
                    </tr>
            </tbody>
            <%     }%>
        </table>
    </div>
    </body>
</html>
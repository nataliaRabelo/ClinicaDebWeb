<%@page import="model.Paciente"%>
<%@page import="model.Medico"%>
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
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/">Logout</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeConvenios">Convenios</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeEspecialidades">Especialidades</a></li>
    </ul>
    </head>
    <body>
        <div class="container">
            <div class="mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h2>Lista de Pacientes</h2></div>
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
                    <th>
                        Autorizado
                    </th>
                    <th>
                        Id Plano
                    </th>
                </tr>
            </thead>
            <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/RegistroPaciente"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Novo paciente</button></a>
            </div>
                <%
                    ArrayList<Paciente> listaDePacientes = (ArrayList<Paciente>) request.getAttribute("pacientes");
                    if(listaDePacientes.isEmpty()){
                        out.print("<h1>A lista de administradores está vazia! D:</h1>");
                    }
                    for (Paciente paciente : listaDePacientes) {
                        String id = paciente.getId();
                        String nome = paciente.getNome();
                        String cpf = paciente.getCpf();
                        String senha = paciente.getSenha();
                        String autorizado = paciente.getAutorizado();
                        String idTipoPlano = paciente.getIdtipoPlano();

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
                        <td>
                            <%= autorizado%>
                        </td>
                        <td>
                            <%= idTipoPlano%>
                        </td>
                        <%
                        out.print("<td>");
                        out.print("<form action=\"EditarPaciente\"\"\" method=\"get\">");
                        out.print("<button name=\"id\" value=\""+ paciente.getId()+"\">Editar</button>");
                        out.print("</form>");
                        out.print("<form action=\"ExcluirPaciente\"\"\" method=\"post\">");
                        out.print("<button name=\"id\" value=\""+ paciente.getId()+"\">Excluir</button>");
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

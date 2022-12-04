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
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeConveniosPublica">Convenios</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeEspecialidadesPublica">Especialidades</a></li>
    </ul>
    </head>
    <body>
        <div class="container">
            <div class="mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h2>Lista de Medicos</h2></div>
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
                        Crm
                    </th>
                    <th>
                        estado CRM
                    </th>
                    <th>
                        Id especialidade
                    </th>
                    <th>
                        Especialidade
                    </th>
                </tr>
            </thead>
            <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/RegistroMedico"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Novo medico</button></a>
            </div>
                <%
                    ArrayList<Medico> listaDeMedicos = (ArrayList<Medico>) request.getAttribute("medicos");
                    if(listaDeMedicos.isEmpty()){
                        out.print("<h1>A lista de administradores está vazia! D:</h1>");
                    }
                    for (Medico medico : listaDeMedicos) {
                        String id = medico.getId();
                        String nome = medico.getNome();
                        String cpf = medico.getCpf();
                        String senha = medico.getSenha();
                        String crm = medico.getCrm();
                        String estadoCrm = medico.getEstadoCrm();
                        String idEspecialidade = medico.getIdEspecialidade();
                        String especialidade = medico.getNomeEspecialidade(idEspecialidade);

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
                            <%= crm%>
                        </td>
                        <td>
                            <%= estadoCrm%>
                        </td>
                        <td>
                            <%= idEspecialidade%>
                        </td>
                        <td>
                            <%= especialidade%>
                        </td>
                        <%
                        out.print("<td>");
                        out.print("<form action=\"EditarMedico\"\"\" method=\"get\">");
                        out.print("<button name=\"id\" value=\""+ medico.getId()+"\">Editar</button>");
                        out.print("</form>");
                        out.print("<form action=\"ExcluirMedico\"\"\" method=\"post\">");
                        out.print("<button name=\"id\" value=\""+ medico.getId()+"\">Excluir</button>");
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

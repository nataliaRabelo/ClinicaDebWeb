<%-- 
    Document   : AreaDoPaciente
    Created on : 01/10/2022, 17:18:32
    Author     : natyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Paciente" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Área do Paciente</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    <div align="center"><font face="Trebuchet MS" color="#00000"><h1 class="display-1">Bem-vindo, paciente. O que deseja fazer?</h1></font></div>
        <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/MarcacaoConsulta"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;">Marcar consulta</button></a>
         </div>
    </head>
    <body>
        <%--
        <div class="container">
            <jsp:include page="AreaDoMedico.jsp" />
            <div class="mt-5">
                <%
                    Paciente paciente = (Paciente) request.getAttribute("paciente");
                %>
                
                <h1>Dados recebidos do Paciente</h1>
                <h3>Nome: <%= paciente.getNome() %></h1>
                <h3>CPF: <%= paciente.getCpf()%> </h1>
                <h3>Senha: <%= paciente.getSenha()%> </h1>
                <h3>Autorizado: <%= paciente.getAutorizado()%> </h1>
                <h3>Especialidade: <%= paciente.getIdtipoPlano()%> </h1>
            </div>
        </div>
        --%>
    </body>
</html>
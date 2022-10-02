<%-- 
    Document   : AreaDoMedico
    Created on : 01/10/2022, 17:18:00
    Author     : natyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Medico" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Área do médico</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    <div align="center"><font face="Trebuchet MS" color="#00000"><h1 class="display-1">Bem-vindo, médico. O que deseja fazer?</h1></font></div>
        <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/MarcacaoConsulta"><button style="background: #069cc2; border-radius: 6px; padding: 15px; cursor: pointer; color: #fff; border: none; font-size: 16px;">Marcar consulta</button></a>
         </div>
    </head>
    <body>
        <div class="container">
            <jsp:include page="AreaDoMedico.jsp" />
            <div class="mt-5">
                <%
                    Medico medico = (Medico) request.getAttribute("medico");
                %>
                
                <h1>Dados recebidos do Medico</h1>
                <h3>Nome: <%= medico.getNome() %></h1>
                <h3>CRM: <%= medico.getCrm()%> </h1>
                <h3>Estado do CRM: <%= medico.getEstadoCrm()%> </h1>
                <h3>CPF: <%= medico.getCpf()%> </h1>
                <h3>Senha: <%= medico.getSenha()%> </h1>
                <h3>Autorizado: <%= medico.getAutorizado()%> </h1>
                <h3>Especialidade: <%= medico.getIdEspecialidade()%> </h1>
            </div>
        </div>
    </body>
</html>


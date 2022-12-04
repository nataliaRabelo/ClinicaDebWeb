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
        <link rel="stylesheet" href="css/style4.css">
        <link rel="stylesheet" href="view/index.css">
        <ul class="nav-bar">
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/AreaDoPaciente">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/">Logout</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeConveniosPublica">Convenios</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeEspecialidadesPublica">Especialidades</a></li>
    </ul>
    <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1 class="display-1">Bem-vindo, paciente. O que deseja fazer?</h1></font></div>
        <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/MarcacaoConsulta"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Marcar consulta</button></a>
              <a href="/ClinicaDaNatalia/ListaDeConsultas"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Lista de consultas</button></a>
              <a href="/ClinicaDaNatalia/ListaDeExames"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Lista de exames</button></a>
         </div>
    </head>
    <body>
    </body>
</html>

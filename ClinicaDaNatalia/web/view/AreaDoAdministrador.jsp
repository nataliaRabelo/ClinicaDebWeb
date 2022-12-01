<%-- 
    Document   : AreaDoMedico
    Created on : 01/10/2022, 17:18:00
    Author     : natyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Medico" %>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Área do Administrador</title>
        <link rel="stylesheet" href="css/style4.css">
        <link rel="stylesheet" href="view/index.css">
        <ul class="nav-bar">
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/AreaDoAdministrador">Home</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/">Logout</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeConvenios">Convenios</a></li>
            <li class="nav-item"><a class="nav-link" href="/ClinicaDaNatalia/ListaDeEspecialidades">Especialidades</a></li>
    </ul>
    </head>
    <body>
        <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1 class="display-1">Bem-vindo, administrador. Gerencie algum dos objetos abaixo.</h1></font></div>
        <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h3 class="display-1">Usuarios</h3></font></div>
        <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/ListaDeMedicos"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Medicos</button></a>
              <a href="/ClinicaDaNatalia/ListaDePacientes"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Pacientes</button></a>
              <a href="/ClinicaDaNatalia/ListaDeAdministradores"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Administradores</button></a>
         </div>
        <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h3 class="display-1">Serviços</h3></font></div>
         <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/ListaDeEspecialidades"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Especialidades</button></a>
              <a href="/ClinicaDaNatalia/ListaDeConsultas"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Consultas</button></a>
              <a href="/ClinicaDaNatalia/ListaDeExames"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Exames</button></a>
         </div>
        <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h3 class="display-1">Parcerias</h3></font></div>
         <div align="center" class="span3">
              <a href="/ClinicaDaNatalia/ListaDeConvenios"><button style="background: #FFFAFA; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Convenios</button></a>
         </div>
    </body>
</html>

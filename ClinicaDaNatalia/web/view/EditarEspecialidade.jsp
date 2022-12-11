<%-- 
    Document   : EditarConsulta
    Created on : 08/11/2022, 07:54:54
    Author     : natyn
--%>
<%@page import="model.Especialidade"%>
<%@page import="model.Administrador"%>
<%@page import="model.TipoPlano"%>
<%Especialidade especialidade = (Especialidade) request.getAttribute("especialidade");%>
<%@page import="model.UsuarioLogado"%>
<%@page import="model.Paciente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Registrar Especialidade</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #fff; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Editar especialidade</h1></font></div>
                    <form action="EditarEspecialidade" method="POST">
                     <input type="hidden" name="id" value="<%=request.getAttribute("id")%>"/>
                     <div class="mb-3">
                        <label for="descricao" class="form-label" color="#FFFAFA" value="<%=especialidade.getDescricao()%>">descricao</label>
                        <input type="text" name="descricao" class="form-control">
                    </div>
                    <div>
                        <input type="submit" value="Enviar" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
        <style>
                body {
            background-color: #008AAF;
        }     
        </style>
        <script src="bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>
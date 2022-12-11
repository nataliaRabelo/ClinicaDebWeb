<%-- 
    Document   : EditarConsulta
    Created on : 08/11/2022, 07:54:54
    Author     : natyn
--%>
<%@page import="model.TipoPlano"%>
<%Paciente paciente = (Paciente) request.getAttribute("paciente");%>
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
        <title>Editar Paciente</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #fff; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Editar paciente</h1></font></div>
                <form action="EditarPaciente" method="POST">
                    <input type="hidden" name="id" value="<%=request.getAttribute("id")%>"/>
                     <div class="mb-3">
                        <label for="nome" class="form-label" color="#FFFAFA">nome</label>
                        <input type="text" name="nome" class="form-control" value="<%=paciente.getNome()%>">
                    </div>
                    <div class="mb-3">
                        <label for="cpf" class="form-label" color="#FFFAFA">cpf</label>
                        <input type="text" name="cpf" class="form-control" value="<%=paciente.getCpf()%>">
                    </div>
                    <div class="mb-3">
                        <label for="senha" class="form-label" color="#FFFAFA">senha</label>
                        <input type="text" name="senha" class="form-control" value="<%=paciente.getSenha()%>">
                    </div>
                    <div class="mb-3">
                        <label for="autorizado" class="form-label" color="#FFFAFA">autorizado</label>
                        <input type="text" name="autorizado" class="form-control" value="<%=paciente.getAutorizado()%>">
                    </div>
                    <div class="mb-3">
                        <label for="idtipoplano" class="form-label" color="#FFFAFA">convênio</label>
                        <select class="form-select d-block w-100 form-control" id="idtipoplano" name="idtipoplano"required>
                        <option value="">Escolha seu plano</option>
                        <%
                        ArrayList<TipoPlano> listaDePlanos = (ArrayList<TipoPlano>) request.getAttribute("listaDePlanos");

                        for (TipoPlano tipoPlano : listaDePlanos) {
                            out.println("<option value= '"+tipoPlano.getId()+"'>");
                            out.println(tipoPlano.getDescricao());
                            out.println("</option>");
                        }
%>
                    </select>
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

<%-- 
    Document   : EditarConsulta
    Created on : 08/11/2022, 07:54:54
    Author     : natyn
--%>
<%@page import="model.Especialidade"%>
<%@page import="model.TipoPlano"%>
<%Medico medico = (Medico) request.getAttribute("medico");%>
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
        <title>Editar Paciente</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #fff; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Editar médico</h1></font></div>
                <form action="EditarMedico" method="POST">
                    <input type="hidden" name="id" value="<%=request.getAttribute("id")%>"/>
                     <div class="mb-3">
                        <label for="nome" class="form-label" color="#FFFAFA">nome</label>
                        <input type="text" name="nome" class="form-control" value="<%=medico.getNome()%>">
                    </div>
                    <div class="mb-3">
                        <label for="cpf" class="form-label" color="#FFFAFA">cpf</label>
                        <input type="text" name="cpf" class="form-control" value="<%=medico.getCpf()%>">
                    </div>
                    <div class="mb-3">
                        <label for="senha" class="form-label" color="#FFFAFA">senha</label>
                        <input type="text" name="senha" class="form-control" value="<%=medico.getSenha()%>">
                    </div>
                    <div class="mb-3">
                        <label for="crm" class="form-label" color="#FFFAFA">crm</label>
                        <input type="text" name="crm" class="form-control" value="<%=medico.getCrm()%>">
                    </div>
                    <div class="mb-3">
                        <label for="estadocrm" class="form-label" color="#FFFAFA">estado crm</label>
                        <input type="text" name="estadocrm" class="form-control" value="<%=medico.getEstadoCrm()%>">
                    </div>
                    <div class="mb-3">
                        <label for="autorizado" class="form-label" color="#FFFAFA">autorizado</label>
                        <input type="text" name="autorizado" class="form-control" value="<%=medico.getAutorizado()%>">
                    </div>
                    <div class="mb-3">
                        <label for="idespecialidade" class="form-label" color="#FFFAFA">especialidade</label>
                        <select class="form-select d-block w-100 form-control" id="idespecialidade" name="idespecialidade"required>
                        <option value="">Escolha a especialidade</option>
                        <%
                        ArrayList<Especialidade> listaDeEspecialidades = (ArrayList<Especialidade>) request.getAttribute("listaDeEspecialidades");

                        for (Especialidade especialidade : listaDeEspecialidades) {
                            out.println("<option value= '"+especialidade.getId()+"'>");
                            out.println(especialidade.getDescricao());
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

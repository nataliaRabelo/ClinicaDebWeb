<%-- 
    Document   : EditarConsulta
    Created on : 08/11/2022, 07:54:54
    Author     : natyn
--%>
<%@page import="model.Consulta"%>
<%Consulta consulta = (Consulta) request.getAttribute("consulta");%>
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
        <title>Marcação de consulta</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #fff; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Editar consulta</h1></font></div>
                <form action="EditarConsulta" method="POST">
                    <input type="hidden" name="id" value="<%=request.getAttribute("id")%>"/>
                    <div class="mb-3">
                        <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label" for="data">data</label>
                        <input name="data" type="datetime-local" class="form-control" id="dataConsulta" placeholder="" value="<%=consulta.getData()%>" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label" for="hora">hora</label>
                        <input name="hora" type="time" class="form-control" id="horaConsulta" placeholder="" value="<%=consulta.getHora()%>" required>
                    </div>
                </div>
                    </div>
                     <div class="mb-3">
                        <label for="descricao" class="form-label" color="#FFFAFA">descricao</label>
                        <input type="text" name="descricao" class="form-control" value="<%=consulta.getDescricao()%>">
                    </div>
                    <div class="mb-3">
                        <label for="idtipomedico" class="form-label" color="#FFFAFA">medico</label>
                        <select class="form-select d-block w-100 form-control" id="idmedico" name="idmedico"required>
                        <option value="">Escolha o medico.</option>
                        <%
                        ArrayList<Medico> listaDeMedicos = (ArrayList<Medico>) request.getAttribute("listaDeMedicos");

                        for (Medico medico : listaDeMedicos) {
                            out.println("<option value= '"+medico.getId()+"'>");
                            out.println(medico.getNome() + " - " + medico.getNomeEspecialidade(medico.getId()));
                            out.println("</option>");
                        }
%>
                    </select>
                    </div>
                    <div class="mb-3">
                        <label for="idpaciente" class="form-label" color="#FFFAFA">paciente</label>
                        <select class="form-select d-block w-100 form-control" id="idpaciente" name="idpaciente"required>
                        <option value="">Escolha o paciente.</option>
                        <%
                        ArrayList<Paciente> listaDePacientes = (ArrayList<Paciente>) request.getAttribute("listaDePacientes");

                        for (Paciente paciente : listaDePacientes) {
                            out.println("<option value= '"+paciente.getId()+"'>");
                            out.println(paciente.getNome());
                            out.println("</option>");
                        }
%>
                    </select>
                    </div>
                    <div>
                        <input type="submit" value="Enviar" class="btn-primary">
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

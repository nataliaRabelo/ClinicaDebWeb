<%-- 
    Document   : SolicitacaoExame
    Created on : 01/10/2022, 17:21:07
    Author     : natyn
--%>

<%@page import="model.Consulta"%>
<%@page import="model.TipoExame"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>SolicitacaoExame</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #fff; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="col-sm-6 offset-3 mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Registro de paciente</h1></font></div>
                <form action="RegistroPaciente" method="POST">
                    <div class="mb-3">
                        <label for="nome" class="form-label" color="#FFFAFA">tipo do exame</label>
                        <select class="form-select d-block w-100 form-control" id="idtipoexame" name="idtipoexame"required>
                        <option value="">Escolha o plano.</option>
                        <%
                        ArrayList<TipoExame> listaDeTipoExames = (ArrayList<TipoExame>) request.getAttribute("listaDeTipoExames");

                        for (TipoExame tipoExame : listaDeTipoExames) {
                            out.println("<option value= '"+tipoExame.getId()+"'>");
                            out.println(tipoExame.getDescricao());
                            out.println("</option>");
                        }
%>
                    </select>
                    </div>
                    <div class="mb-3">
                        <label for="cpf" class="form-label" color="#FFFAFA">id</label>
                        <input type="text" name="cpf" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="senha;" class="form-label" color="#FFFAFA">descricao</label>
                        <input type="text" name="senha" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="senha;" class="form-label" color="#FFFAFA">consulta</label>
                        <select class="form-select d-block w-100 form-control" id="idconsulta" name="idconsulta"required>
                        <option value="">Escolha o plano.</option>
                        <%
                        ArrayList<Consulta> listaDeConsultas = (ArrayList<Consulta>) request.getAttribute("listaDeConsultas");
                        for (Consulta consulta : listaDeConsultas) {
                            out.println("<option value= '"+consulta.getId()+"'>");
                            out.println(consulta.getDescricao());
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
        <script src="bootstrap/bootstrap.bundle.min.js"></script>
    </body>
</html>

<%-- 
    Document   : MarcacaoConsulta
    Created on : 01/10/2022, 17:19:29
    Author     : natyn
--%>
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
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h1>Marcação de consulta</h1></font></div>
                <form action="MarcacaoConsulta" method="POST">
                    <div class="mb-3">
                        <div class="row">
                    <div class="col-md-6 mb-3">
                        <label class="form-label" for="data">data</label>
                        <input name="data" type="date" class="form-control" id="dataConsulta" placeholder="" value="" required>
                    </div>
                    <div class="col-md-6 mb-3">
                        <label class="form-label" for="hora">hora</label>
                        <input name="datahora" type="time" class="form-control" id="horaConsulta" placeholder="" value="" required>
                    </div>
                </div>
                    </div>
                    <div class="mb-3">
                        <label for="cpf" class="form-label" color="#FFFAFA">descricao</label>
                        <input type="text" name="cpf" class="form-control">
                    </div>
                    <div class="mb-3">
                        <label for="idtipoplano" class="form-label" color="#FFFAFA">medico</label>
                        <select class="form-select d-block w-100 form-control" id="idtipoplano" name="idtipoplano"required>
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
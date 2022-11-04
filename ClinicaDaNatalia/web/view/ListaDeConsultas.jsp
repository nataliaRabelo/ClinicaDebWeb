<%@page import="java.util.ArrayList"%>
<%@page import="model.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="#">
        <title>Lista de Consultas</title>
        <a href="/ClinicaDaNatalia/"><button style="background: #fff; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Voltar</button></a>
        <link href="bootstrap/bootstrap.min.css"  rel="stylesheet"> 
    </head>
    <body>
        <div class="container">
            <div class="mt-5">
                <div align="center"><font face="Trebuchet MS" color="#FFFAFA"><h2>Lista de Consultas</h2></div>
<div class="table table-hover">
        <table class="table">
            <thead>
                <tr>
                    <th>
                        Data
                    </th>
                    <th>
                        Descricao
                    </th>
                    <th>
                        Realizada?
                    </th>
                    <th>
                        Medico
                    </th>
                </tr>
            </thead>
                <%
                    ArrayList<Consulta> listaDeConsultas = (ArrayList<Consulta>) request.getAttribute("listaDeConsultas");
                    if(listaDeConsultas.isEmpty()){
                        out.print("<h1>Sua lista de consultas está vazia! D:</h1>");
                    }
                    for (Consulta consulta : listaDeConsultas) {
                        String id = consulta.getId();
                        String data = consulta.getData();
                        String descricao = consulta.getDescricao();
                        String realizada = consulta.getRealizada();
                        String idmedico = consulta.getIdMedico();
                        String idpaciente = consulta.getIdPaciente();

                %>
            <tbody>
                    <tr>
                        <td>
                            <%= data%>
                        </td>
                        <td>
                            <%= descricao%>                         
                        </td>
                        <td>
                            <%= realizada%>
                        </td>
                        <td>
                            <%= idmedico%>
                        </td>
                        <td>
                            <a href="/ClinicaDaNatalia/"><button style="background: #fff; border-radius: 6px; padding: 15px; cursor: pointer; color: #008AAF; border: none; font-size: 16px;">Editar</button></a>
                        </td>
                    </tr>
            </tbody>
            <%     }%>
        </table>
    </div>
                        <style>
    * {
        box-sizing: border-box;
    }

    body {
        background: #008AAF;
        font-family: "Open Sans", arial;
    }

    table {
        width: 100%;
        max-width: 800px;
        height: 100px;
        border-collapse: collapse;
        border: 1px solid #38678f;
        margin: 50px auto;
        background: white;
    }

    th {
        background: #008AAF;
        height: 54px;
        width: 25%;
        font-weight: lighter;
        text-shadow: 0 1px 0 #38678f;
        color: #008AAF;
        border: 1px solid #38678f;
        box-shadow: inset 0px 1px 2px #568ebd;
        transition: all 0.2s;
    }

    tr {
        border-bottom: 1px solid #cccccc;
    }

        tr:last-child {
            border-bottom: 0px;
        }

    td {
        border-right: 1px solid #cccccc;
        padding: 10px;
        transition: all 0.2s;
    }

        td:last-child {
            border-right: 0px;
        }

        td.selected {
            background: #d7e4ef;
        }

        td input {
            font-size: 14px;
            background: none;
            outline: none;
            border: 0;
            display: table-cell;
            height: 100%;
            width: 100%;
        }

            td input:focus {
                box-shadow: 0 1px 0 steelblue;
                color: steelblue;
            }

    ::-moz-selection {
        background: steelblue;
        color: white;
    }

    ::selection {
        background: steelblue;
        color: white;
    }

    .heavyTable {
        box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
        animation: float 5s infinite;
    }

    .main {
        max-width: 600px;
        padding: 10px;
        margin: auto;
    }

    .content {
        color: #008AAF;
        text-align: center;
    }

        .content p,
        .content pre,
        .content h2 {
            text-align: left;
        }

        .content pre {
            padding: 1.2em 0 0.5em;
            background: white;
            background: rgba(255, 255, 255, 0.7);
            border: 1px solid rgba(255, 255, 255, 0.9);
            color: #38678f;
        }

        .content .download {
            margin: auto;
            background: rgba(255, 255, 255, 0.1);
            display: inline-block;
            padding: 1em 1em;
            border-radius: 12em;
            margin-bottom: 2em;
        }

        .content .button {
            display: inline-block;
            text-decoration: none;
            color: white;
            height: 48px;
            line-height: 48px;
            padding: 0 20px;
            border-radius: 24px;
            border: 1px solid #38678f;
            background: steelblue;
            box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 1px 3px rgba(255, 255, 255, 0.2);
            transition: all 0.1s;
        }

            .content .button:hover {
                background: #4f8aba;
                box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 0 10px rgba(255, 255, 255, 0.1);
            }

            .content .button:active {
                color: #294d6b;
                background: #427aa9;
                box-shadow: 0 1px 0 rgba(255, 255, 255, 0.1), inset 0 0 5px rgba(0, 0, 0, 0.2);
            }

            .content .button:focus {
                outline: none;
            }

    h1 {
        text-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    Resources{

    }
</style>
</div>
                

            </div>
        </div>
    </body>
</html>

<%-- 
    Document   : AreaDoMedico
    Created on : 01/10/2022, 17:18:00
    Author     : natyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Medico" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Area do Medico</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">


                <%
                    // testar se está logado
                    HttpSession sessao = request.getSession(false);
                    if (sessao != null) {
                        Medico usuarioLogado = (Medico) session.getAttribute("medico");
                        if (usuarioLogado != null) { %>
                            <a class="nav-link" href="SolicitacaoExame">Gerenciar Usuários</a>
                            <a class="nav-link" href="logOut">Logout</a>
                <%  } else { %>
                            <a class="nav-link" href="Login.jsp">Login</a>
                <%    }
                    }%>



            </div>
        </div>
    </div>
</nav>

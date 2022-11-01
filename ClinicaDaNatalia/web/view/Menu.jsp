<%-- 
    Document   : Menu.jsp
    Created on : 01/11/2022, 02:54:14
    Author     : natyn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="model.Usuario, model.Administrador, model.Medico, model.Paciente" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">

                <%
                    // testar se está logado
                    HttpSession sessao = request.getSession(false);
                    if (sessao != null) {
                        Usuario usuarioLogado = (Usuario) session.getAttribute("usuario");
                        if (usuarioLogado != null) { 
                            if(usuarioLogado.getClass() == Administrador.class){%>
                              <a class="nav-link" href="gerenciarUsuarios">Gerenciar Usuários (ADMIN)</a>
                              <a class="nav-link" href="logOut">Logout</a>  
                            <%}else if(usuarioLogado.getClass() == Medico.class){%>
                            <a class="nav-link" href="gerenciarUsuarios">Gerenciar Usuários (MEDICO)</a>
                            <a class="nav-link" href="logOut">Logout</a>
                            <%  } else if(usuarioLogado.getClass() == Paciente.class)  { %>
                            <a class="nav-link" href="mostrarComentarios">Coment&aacute;rios (PACIENTE)</a>
                            <a class="nav-link" href="formLogin.jsp">Login</a>
                            <%  } else { %>
                            <a class="nav-link" href="mostrarComentarios">Coment&aacute;rios (PUBLICO)</a>
                            <a class="nav-link" href="formLogin.jsp">Login</a>
                            <%    }%>
            </div>
        </div>
    </div>
</nav>
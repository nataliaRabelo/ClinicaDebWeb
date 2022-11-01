/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author natyn
 */
@WebFilter(filterName = "filtro", urlPatterns = {"/*"})
public class Filtro implements Filter{
    
        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        String uri = ((HttpServletRequest) request).getRequestURI();
        // aqui os servlets da parte pública que não precisa de login
        // e os CSS e JS necessários
        if ((uri.equals("/loginDAO/"))
                || (uri.contains("/bootstrap"))
                || (uri.contains("/efetuarLogin"))
                || (uri.contains("/comentarios"))
                || (uri.contains("/mostrarComentarios"))
                || (uri.contains("/formLogin"))
                || (uri.contains("/menu"))
                || (uri.contains("/index"))) {
            chain.doFilter((HttpServletRequest) request, (HttpServletResponse) response);
        } else {
            // se a área necessita de login verifica se o usuário está na sessão - está logado
            Usuario usuario = (Usuario) ((HttpServletRequest) request).getSession().getAttribute("usuario");
            if ((usuario != null) && (!((String) usuario.getNome()).isEmpty())) {
                chain.doFilter((HttpServletRequest) request, (HttpServletResponse) response);
            } else {
                ((HttpServletRequest) request).setAttribute("msgError", "É necessário fazer login");
                ((HttpServletRequest) request).getRequestDispatcher("/formLogin.jsp").forward(request, response);
            }
        }
    }
   @Override 
   public void init(FilterConfig arg0) throws ServletException { }

    public void destroy() {
    }

    
}

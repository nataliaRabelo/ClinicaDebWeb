/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdministradorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;
import model.Usuario;

/**
 *
 * @author natyn
 */
@WebServlet(name = "RegistroAdministrador", urlPatterns = {"/RegistroAdministrador"})
public class RegistroAdministrador extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroAdministrador.jsp");
        rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        Usuario usuario = new Usuario(nome, cpf, senha);
        AdministradorDAO usuarioDAO = new AdministradorDAO();
        try {
            usuarioDAO.Inserir(usuario);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);

        } else {
            request.setAttribute("msgError", "Algo não foi registrado corretamente.");
            RequestDispatcher rd = request.getRequestDispatcher("/RegistroAdministrador.jsp");
            rd.forward(request, response);
        }

    }

}

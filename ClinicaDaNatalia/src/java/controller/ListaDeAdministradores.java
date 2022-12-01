/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdministradorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;
import model.Usuario;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ListaDeAdministradores", urlPatterns = {"/ListaDeAdministradores"})
public class ListaDeAdministradores extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            AdministradorDAO administradorDao = new AdministradorDAO();
            ArrayList<Usuario> administradores = administradorDao.ListaDeUsuarios();
            request.setAttribute("administradores", administradores);
            RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDeAdministradores.jsp");
            rd.forward(request, response);
    }

}

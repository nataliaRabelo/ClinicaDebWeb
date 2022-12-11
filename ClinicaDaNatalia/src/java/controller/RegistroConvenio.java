package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.TipoPlanoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipoPlano;

/**
 *
 * @author natyn
 */
@WebServlet(urlPatterns = {"/RegistroConvenio"})
public class RegistroConvenio extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroConvenio.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        TipoPlano tipoplano = new TipoPlano(descricao);
        TipoPlanoDAO tipoplanoDAO = new TipoPlanoDAO();
        try {
            tipoplanoDAO.Inserir(tipoplano);
        } catch (Exception ex) {
            request.setAttribute("msgError", "Algo não foi registrado corretamente: " + ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
        rd.forward(request, response);
    }

}

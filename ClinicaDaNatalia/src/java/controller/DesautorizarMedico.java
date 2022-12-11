/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.MedicoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author natyn
 */
@WebServlet(name = "DesautorizarMedico", urlPatterns = {"/DesautorizarMedico"})
public class DesautorizarMedico extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            MedicoDAO medicoDAO = new MedicoDAO();
            String id =  request.getParameter("id");
            medicoDAO.Desautorizar(id);
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            throw new RuntimeException("Falha no post");
        }
    }

}

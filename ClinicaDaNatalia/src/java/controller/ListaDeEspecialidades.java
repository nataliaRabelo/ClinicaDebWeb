/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EspecialidadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Especialidade;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ListaDeEspecialidades", urlPatterns = {"/ListaDeEspecialidades"})
public class ListaDeEspecialidades extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            try {
                ArrayList<Especialidade> especialidades = especialidadeDAO.ListaDeEspecialidades();
                request.setAttribute("especialidades", especialidades);
                RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDeEspecialidades.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException(ex.getMessage());
            }
    }

}

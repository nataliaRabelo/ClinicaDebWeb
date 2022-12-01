/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ListaDePacientes", urlPatterns = {"/ListaDePacientes"})
public class ListaDePacientes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PacienteDAO pacienteDAO = new PacienteDAO();
            ArrayList<Paciente> pacientes = pacienteDAO.ListaDePacientes();
            request.setAttribute("pacientes", pacientes);
            RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDePacientes.jsp");
            rd.forward(request, response);
    }

}

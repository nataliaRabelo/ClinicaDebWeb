/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.MedicoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Medico;

/**
 *
 * @author natyn
 */
@WebServlet(name = "SelecionarMedico", urlPatterns = {"/SelecionarMedico"})
public class SelecionarMedico extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                MedicoDAO medicoDAO = new MedicoDAO();
                ArrayList<Medico> listaDeMedicos = medicoDAO.ListaDeMedicos();
                request.setAttribute("listaDeMedicos", listaDeMedicos);
                RequestDispatcher rd = request.getRequestDispatcher("/view/SelecionarMedico.jsp");
                rd.forward(request, response);            
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException(ex.getMessage());
            }
    }

}

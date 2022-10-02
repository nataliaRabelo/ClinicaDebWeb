package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/RegistroMedico"})
public class RegistroMedico extends HttpServlet {

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
            RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroMedico.jsp");
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
        String nome = request.getParameter("nome");
        String crm = request.getParameter("crm");
        String estadocrm = request.getParameter("estadocrm");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("cpf");
        String autorizado = request.getParameter("autorizado");
        String especialidade = request.getParameter("especialidade");
        if(nome.isEmpty() || crm.isEmpty() || estadocrm.isEmpty() || cpf.isEmpty() || senha.isEmpty() || autorizado.isEmpty() || especialidade.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("RegistroMedico.jsp");
            rd.forward(request, response);
        } else {
            Medico medico = new Medico(nome, Integer.valueOf(crm), estadocrm, cpf, senha, autorizado, especialidade);
            request.setAttribute("medico", medico);
            RequestDispatcher rd = request.getRequestDispatcher("AreaDoMedico.jsp");
            
        }

    }
}

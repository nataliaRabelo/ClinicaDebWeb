/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.TipoPlanoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ListaDeConveniosPublica", urlPatterns = {"/ListaDeConveniosPublica"})
public class ListaDeConveniosPublica extends HttpServlet {

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
            TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
            try {
                ArrayList<TipoPlano> listaDePlanos = tipoPlanoDAO.ListaDePlanos();
                request.setAttribute("listaDePlanos", listaDePlanos);
                RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDeConveniosPublica.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException("Falha na query ao listar convenios.");
            }
    }


}

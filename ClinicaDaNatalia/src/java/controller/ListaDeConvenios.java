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
@WebServlet(name = "ListaDeConvenios", urlPatterns = {"/ListaDeConvenios"})
public class ListaDeConvenios extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
            try {
                ArrayList<TipoPlano> convenios = tipoPlanoDAO.ListaDePlanos();
                request.setAttribute("convenios", convenios);
                RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDeConvenios.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException(ex.getMessage());
            }
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.EspecialidadeDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Consulta;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ListaDeConsultas", urlPatterns = {"/ListaDeConsultas"})
public class ListaDeConsultas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                    ConsultaDAO consultaDAO = new ConsultaDAO();
            try {
                ArrayList<Consulta> listaDeConsultas = consultaDAO.ListaDeConsultas();
                request.setAttribute("listaDeConsultas", listaDeConsultas);
                RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDeConsultas.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException("Falha na query ao listar convenios.");
            }
    }

}

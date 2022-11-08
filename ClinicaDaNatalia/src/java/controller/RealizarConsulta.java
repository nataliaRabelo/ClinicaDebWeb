/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdministradorDAO;
import DAO.ConsultaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consulta;
import model.Usuario;

/**
 *
 * @author natyn
 */
@WebServlet(name = "RealizarConsulta", urlPatterns = {"/RealizarConsulta"})
public class RealizarConsulta extends HttpServlet {


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
            ConsultaDAO consultaDAO = new ConsultaDAO();
            ArrayList<Consulta> listaDeConsultasTotal = consultaDAO.ListaDeConsultas();
            ArrayList<Consulta> listaDeConsultas = new ArrayList<>();
            for(Consulta consulta : listaDeConsultasTotal){
                if(consulta.getRealizada().equals("N")){
                    listaDeConsultas.add(consulta);
                }
            }
            request.setAttribute("listaDeConsultas", listaDeConsultas);
            RequestDispatcher rd = request.getRequestDispatcher("/view/RealizarConsulta.jsp");
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
        String descricao = request.getParameter("descricao");
        String id = request.getParameter("id");
        System.out.println(id);
        ConsultaDAO consultaDAO = new ConsultaDAO();
        try {
            HttpSession session = request.getSession();
            ArrayList<Consulta> consultas = consultaDAO.ListaDeConsultas();
            for(Consulta consulta : consultas){
                if(consulta.getId().equals(id)){
                    consulta.setDescricao(descricao);
                    consulta.setRealizada("S");
                    consultaDAO.Alterar(consulta);
                    session.setAttribute("consulta", consulta);
                    RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoMedico.jsp");
                    rd.forward(request, response);
                }
            }
            
        } catch (Exception ex) {
            throw new RuntimeException("Falha na query para alterar consulta:" + ex.getMessage());
        }

        if (descricao == null || id == null) {
            request.setAttribute("msgError", "Algo não foi registrado corretamente.");
            RequestDispatcher rd = request.getRequestDispatcher("/view/RealizarConsulta.jsp");
            rd.forward(request, response);
            
        } 

    }

}

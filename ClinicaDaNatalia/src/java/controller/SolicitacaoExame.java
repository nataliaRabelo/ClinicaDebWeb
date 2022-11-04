package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.ConsultaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Consulta;
import model.UsuarioLogado;

/**
 *
 * @author natyn
 */
@WebServlet(urlPatterns = {"/SolicitacaoExame"})
public class SolicitacaoExame extends HttpServlet {

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
            // pegando os parâmetros do request
            //String idtipoplano = request.getParameter("idtipoplano");
            try {
                ArrayList<Consulta> todasAsConsultas = consultaDAO.ListaDeConsultas();
                ArrayList<Consulta> listaDeConsultas = new ArrayList();
                for(Consulta consulta : todasAsConsultas){
                    if(UsuarioLogado.getInstancia().getIdTipoPlano() != null && consulta.getIdPaciente().equals(UsuarioLogado.getInstancia().getId())){
                        listaDeConsultas.add(consulta);
                    }if(UsuarioLogado.getInstancia().getCrm() != null && consulta.getIdMedico().equals(UsuarioLogado.getInstancia().getId())){
                        listaDeConsultas.add(consulta);
                    }
                    
                }
                request.setAttribute("listaDeConsultas", listaDeConsultas);
                RequestDispatcher rd = request.getRequestDispatcher("/view/SolicitacaoExame.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException("Falha na query ao listar consultas.");
            }
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
    }

}

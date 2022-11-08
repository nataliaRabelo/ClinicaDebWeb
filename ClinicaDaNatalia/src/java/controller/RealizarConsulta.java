/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdministradorDAO;
import DAO.ConsultaDAO;
import DAO.ExameDAO;
import DAO.TipoExameDAO;
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
import model.Exame;
import model.TipoExame;
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
            TipoExameDAO tipoExameDAO = new TipoExameDAO();
            ArrayList<Consulta> listaDeConsultasTotal = consultaDAO.ListaDeConsultas();
            ArrayList<Consulta> listaDeConsultas = new ArrayList<>();
            ArrayList<TipoExame> tiposExames = tipoExameDAO.ListaDeTipoExames();
            for(Consulta consulta : listaDeConsultasTotal){
                if(consulta.getRealizada().equals("N")){
                    listaDeConsultas.add(consulta);
                }
            }
            request.setAttribute("listaDeConsultas", listaDeConsultas);
            request.setAttribute("tiposExames", tiposExames);
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
        String idtipoexame = request.getParameter("idtipoexame");
        ConsultaDAO consultaDAO = new ConsultaDAO();
        TipoExameDAO tipoExameDAO = new TipoExameDAO();
        ExameDAO exameDAO = new ExameDAO();
        Consulta consulta = null;
        Exame exame = null;
        try {
            ArrayList<Consulta> consultas = consultaDAO.ListaDeConsultas();
            for(Consulta consultaDaLista : consultas){
                if(consultaDaLista.getId().equals(id)){
                    consultaDaLista.setDescricao(descricao);
                    consultaDaLista.setRealizada("S");
                    consulta = consultaDaLista;
                    consultaDAO.Alterar(consultaDaLista);
                }
            } if(!(idtipoexame.equals("-1"))){
                exame = new Exame(idtipoexame,id);
                exameDAO.Inserir(exame);
                
            }if (consulta == null) {
            request.setAttribute("msgError", "Algo não foi registrado corretamente.");
            RequestDispatcher rd = request.getRequestDispatcher("/view/RealizarConsulta.jsp");
            rd.forward(request, response);            
        } else{
            HttpSession session = request.getSession();
            session.setAttribute("consulta", consulta);
            session.setAttribute("exame", exame);
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoMedico.jsp");
            rd.forward(request, response);
        }
        } catch (Exception ex) {
            throw new RuntimeException("Falha na query para alterar consulta:" + ex.getMessage());
        }
    }

}

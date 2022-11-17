package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.AdministradorDAO;
import DAO.ConsultaDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.TipoPlanoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Medico;
import model.Paciente;
import model.TipoPlano;
import model.Usuario;
import java.text.SimpleDateFormat;
import model.Consulta;
import model.UsuarioLogado;

/**
 *
 * @author natyn
 */
@WebServlet(urlPatterns = {"/MarcacaoConsulta"})
public class MarcacaoConsulta extends HttpServlet {


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
        MedicoDAO medicoDAO = new MedicoDAO();
        ArrayList<Usuario> listaDeMedicos = medicoDAO.ListaDeMedicos();
        request.setAttribute("listaDeMedicos", listaDeMedicos);
        RequestDispatcher rd = request.getRequestDispatcher("/view/MarcacaoConsulta.jsp");
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
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");
        String idmedico = request.getParameter("idmedico");
        String dataInteira = data + " " + hora;
        Consulta consulta = new Consulta(dataInteira, "", idmedico, UsuarioLogado.getInstancia().getId());
        ConsultaDAO consultaDAO = new ConsultaDAO();
        try {
            consultaDAO.Inserir(consulta);
        } catch (Exception ex) {
            throw new RuntimeException("Falha na query para marcar consulta");
        }
        if (consulta != null) {
            HttpSession session = request.getSession();
            session.setAttribute("consulta", consulta);
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoPaciente.jsp");
            rd.forward(request, response);

        } else {
            request.setAttribute("msgError", "Algo não foi registrado corretamente.");
            RequestDispatcher rd = request.getRequestDispatcher("/view/MarcacaoConsulta.jsp");
            rd.forward(request, response);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.TipoPlanoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consulta;
import model.Medico;
import model.Paciente;
import model.TipoPlano;
import model.Usuario;
import model.UsuarioLogado;

/**
 *
 * @author natyn
 */
@WebServlet(name = "EditarPaciente", urlPatterns = {"/EditarPaciente/*"})
public class EditarPaciente extends HttpServlet {

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
        String id = (String) request.getParameter("id");
        TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();
        ArrayList<TipoPlano> listaDePlanos = tipoPlanoDAO.ListaDePlanos();
        request.setAttribute("listaDePlanos", listaDePlanos);
        request.setAttribute("id", id);
        try {
            Paciente paciente = pacienteDAO.get(id);
            request.setAttribute("paciente", paciente);
        } catch (Exception ex) {
            throw new RuntimeException( ex.getCause() + " " + ex.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/EditarPaciente.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paciente paciente = null;
        String id = (String) request.getParameter("id");
        String nome = (String) request.getParameter("nome");
        String cpf = (String) request.getParameter("cpf");
        String senha = (String) request.getParameter("senha");
        String autorizado = (String) request.getParameter("autorizado");
        String idtipoplano = (String) request.getParameter("idtipoplano");
        if(id != null && nome != null && cpf != null && autorizado != null && idtipoplano != null){
                paciente = new Paciente(id, nome, cpf, senha, autorizado, idtipoplano);
                PacienteDAO pacienteDAO = new PacienteDAO();
            try {
                pacienteDAO.Alterar(paciente);
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
            if (paciente != null) {
                HttpSession session = request.getSession();
                session.setAttribute("paciente", paciente);
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("msgError", "Algo não foi registrado corretamente.");
                RequestDispatcher rd = request.getRequestDispatcher("/view/EditarPaciente.jsp");
                rd.forward(request, response);
            }
        }

    }
    
        

}

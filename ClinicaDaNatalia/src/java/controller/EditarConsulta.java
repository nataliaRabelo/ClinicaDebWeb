/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consulta;
import model.Paciente;
import model.Usuario;
import model.UsuarioLogado;

/**
 *
 * @author natyn
 */
@WebServlet(name = "EditarConsulta", urlPatterns = {"/EditarConsulta/*"})
public class EditarConsulta extends HttpServlet {

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
        PacienteDAO pacienteDAO = new PacienteDAO();
        ArrayList<Usuario> listaDeMedicos = medicoDAO.ListaDeMedicos();
        ArrayList<Paciente> listaDePacientes = pacienteDAO.ListaDePacientes();
        request.setAttribute("listaDeMedicos", listaDeMedicos);
        request.setAttribute("listaDePacientes", listaDePacientes);
        request.setAttribute("id", UsuarioLogado.getInstancia().getBotao());
        RequestDispatcher rd = request.getRequestDispatcher("/view/EditarConsulta.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Consulta consulta = null;
        String id = UsuarioLogado.getInstancia().getBotao();
        System.out.println("id: " + id);
        String data = (String) request.getParameter("data");
        System.out.println("data: " + data);
        String hora = (String) request.getParameter("hora");
        System.out.println("hora: " + hora);
        String descricao = (String) request.getParameter("descricao");
        System.out.println("descricao: " + descricao);
        String idpaciente = (String) request.getParameter("idpaciente");
        System.out.println("idpaciente: " + idpaciente);
        String idmedico = (String) request.getParameter("idmedico");
        System.out.println("idmedico: " + idmedico);
        String dataInteira = data + " " + hora;
        if(data != null && hora != null && descricao != null && idpaciente != null && idmedico != null){
                consulta = new Consulta(id, dataInteira, descricao, "S", idmedico, idpaciente);
                ConsultaDAO consultaDAO = new ConsultaDAO();
            try {
                consultaDAO.Alterar(consulta);
            } catch (Exception ex) {
                throw new RuntimeException("Falha na query para editar consulta");
            }
            if (consulta != null) {
                HttpSession session = request.getSession();
                session.setAttribute("consulta", consulta);
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoMedico.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("msgError", "Algo não foi registrado corretamente.");
                RequestDispatcher rd = request.getRequestDispatcher("/view/EditarConsulta.jsp");
                rd.forward(request, response);
            }
        }

    }
    
        

}

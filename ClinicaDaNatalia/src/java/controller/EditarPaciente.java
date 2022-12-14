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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;
import model.TipoPlano;

/**
 *
 * @author natyn
 */
@WebServlet(name = "EditarPaciente", urlPatterns = {"/EditarPaciente/*"})
public class EditarPaciente extends HttpServlet {

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
                request.setAttribute("msgError", "Algo n??o foi registrado corretamente.");
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp\n" + ex.getMessage());
                rd.forward(request, response);
            }
            if (paciente != null) {
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("msgError", "Algo n??o foi registrado corretamente.");
                RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroPaciente.jsp");
                rd.forward(request, response);
            }
        }

    }
    
        

}

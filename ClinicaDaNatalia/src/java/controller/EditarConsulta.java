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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Consulta;
import model.Medico;
import model.Paciente;

/**
 *
 * @author natyn
 */
@WebServlet(name = "EditarConsulta", urlPatterns = {"/EditarConsulta/*"})
public class EditarConsulta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        MedicoDAO medicoDAO = new MedicoDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();
        ConsultaDAO consultaDAO = new ConsultaDAO();
        ArrayList<Medico> listaDeMedicos = medicoDAO.ListaDeMedicos();
        ArrayList<Paciente> listaDePacientes = pacienteDAO.ListaDePacientes();
        request.setAttribute("listaDeMedicos", listaDeMedicos);
        request.setAttribute("listaDePacientes", listaDePacientes);
        request.setAttribute("id", id);
        try {
            Consulta consulta = consultaDAO.get(id);
            request.setAttribute("consulta", consulta);
        } catch (Exception ex) {
            Logger.getLogger(EditarConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/EditarConsulta.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Consulta consulta = null;
        String id = (String) request.getParameter("id");
        System.out.println("id: " + id);
        String data = (String) request.getParameter("data");
        System.out.println("data: " + data);
        String descricao = (String) request.getParameter("descricao");
        System.out.println("descricao: " + descricao);
        String idpaciente = (String) request.getParameter("idpaciente");
        System.out.println("idpaciente: " + idpaciente);
        String idmedico = (String) request.getParameter("idmedico");
        System.out.println("idmedico: " + idmedico);
        data = data.replace("T", " ");
        if(data != null && descricao != null && idpaciente != null && idmedico != null){
                consulta = new Consulta(id, data, descricao, "S", idmedico, idpaciente);
                ConsultaDAO consultaDAO = new ConsultaDAO();
            try {
                consultaDAO.Alterar(consulta);
            } catch (Exception ex) {
                throw new RuntimeException("Falha na query para editar consulta");
            }
            if (consulta != null) {
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoMedico.jsp");
                rd.forward(request, response); 
            } else {
                request.setAttribute("msgError", "Algo n??o foi registrado corretamente.");
                RequestDispatcher rd = request.getRequestDispatcher("/view/EditarConsulta.jsp");
                rd.forward(request, response);
            }
        }

    }
    
        

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;
import model.Consulta;
import model.Medico;
import model.Paciente;

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
            String idmedico = request.getParameter("idmedico");
            HttpSession session = request.getSession();
            Administrador administrador = (Administrador) session.getAttribute("administrador");
            Medico medico = (Medico) session.getAttribute("medico");
            Paciente paciente = (Paciente) session.getAttribute("paciente");
            try {
                ArrayList<Consulta> todasAsConsultas = consultaDAO.ListaDeConsultas();
                ArrayList<Consulta> listaDeConsultas = new ArrayList();
                for(Consulta consulta : todasAsConsultas){
                    if(paciente != null && consulta.getIdPaciente().equals(paciente.getId())){
                        listaDeConsultas.add(consulta);
                    }if(medico != null && consulta.getIdMedico().equals(medico.getId())){
                        listaDeConsultas.add(consulta);
                    }if(idmedico != null && consulta.getIdMedico().equals(idmedico)){
                        listaDeConsultas.add(consulta);
                    }
                    
                }
                request.setAttribute("listaDeConsultas", listaDeConsultas);
                if(paciente != null){
                    request.setAttribute("usuariologado", paciente);
                }else if(medico != null){
                    request.setAttribute("usuariologado", medico);
                }else if(paciente != null){
                    request.setAttribute("usuariologado", administrador);
                }
                RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDeConsultas.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException(ex.getMessage());
            }
    }

}

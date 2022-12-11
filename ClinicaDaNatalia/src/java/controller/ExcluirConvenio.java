/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.ExameDAO;
import DAO.PacienteDAO;
import DAO.TipoPlanoDAO;
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
import model.Exame;
import model.Paciente;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ExcluirConvenio", urlPatterns = {"/ExcluirConvenio"})
public class ExcluirConvenio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            ConsultaDAO consultaDAO = new ConsultaDAO();
            PacienteDAO pacienteDAO = new PacienteDAO();
            ExameDAO exameDAO = new ExameDAO();
            TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
            String id =  request.getParameter("id");
            ArrayList<Consulta> consultas = consultaDAO.ListaDeConsultas();
            ArrayList<Exame> exames = exameDAO.ListaDeExames();
            ArrayList<Paciente> pacientes = pacienteDAO.ListaDePacientes();
            ArrayList<Paciente> pacientesDoConvenio = new ArrayList();
            for(int i= 0; i < pacientes.size(); i++){
                if(pacientes.get(i).getIdtipoPlano().equals(id)){
                    pacientesDoConvenio.add(pacientes.get(i));
                }
            }
            if(!(pacientesDoConvenio.isEmpty())){
                for(int j=0; j < pacientesDoConvenio.size(); j++){
                    for(int x = 0; x < consultas.size(); x++){
                       for(int z = 0; z < exames.size(); z++){
                           if(exames.get(z).getIdConsulta().equals(consultas.get(x).getId()) && consultas.get(x).getIdPaciente().equals(pacientesDoConvenio.get(j).getId())){
                               exameDAO.Excluir(exames.get(z).getId());
                           }
                       }
                        if(consultas.get(x).getIdPaciente().equals(pacientesDoConvenio.get(j).getId())){
                            consultaDAO.Excluir(consultas.get(x).getId());
                        }
                    }
                    pacienteDAO.Excluir(pacientesDoConvenio.get(j).getId());
                }
                tipoPlanoDAO.Excluir(id);
            }else{
               tipoPlanoDAO.Excluir(id);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.ExameDAO;
import DAO.PacienteDAO;
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
@WebServlet(name = "ExcluirPaciente", urlPatterns = {"/ExcluirPaciente"})
public class ExcluirPaciente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try {
            ConsultaDAO consultaDAO = new ConsultaDAO();
            PacienteDAO pacienteDAO = new PacienteDAO();
            ExameDAO exameDAO = new ExameDAO();
            String id =  request.getParameter("id");;
            ArrayList<Consulta> consultas = consultaDAO.ListaDeConsultas();
            ArrayList<Exame> exames = exameDAO.ListaDeExames();
            ArrayList<Consulta> consultasDoPaciente = new ArrayList();
            for(int i= 0; i < consultas.size(); i++){
                if(consultas.get(i).getIdPaciente().equals(id)){
                    consultasDoPaciente.add(consultas.get(i));
                }
            }
            if(!(consultasDoPaciente.isEmpty())){
                for(int j=0; j < consultasDoPaciente.size(); j++){
                    for(int x = 0; x < exames.size(); x++){
                        if(exames.get(x).getIdConsulta().equals(consultasDoPaciente.get(j).getId())){
                            exameDAO.Excluir(exames.get(x).getId());
                        }
                    }
                    consultaDAO.Excluir(consultasDoPaciente.get(j).getId());
                }
            }else{
               pacienteDAO.Excluir(id);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}

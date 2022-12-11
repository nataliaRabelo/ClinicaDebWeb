/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.EspecialidadeDAO;
import DAO.ExameDAO;
import DAO.MedicoDAO;
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
import model.Medico;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ExcluirEspecialidade", urlPatterns = {"/ExcluirEspecialidade"})
public class ExcluirEspecialidade extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ConsultaDAO consultaDAO = new ConsultaDAO();
            MedicoDAO medicoDAO = new MedicoDAO();
            ExameDAO exameDAO = new ExameDAO();
            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            String id =  request.getParameter("id");
            ArrayList<Consulta> consultas = consultaDAO.ListaDeConsultas();
            ArrayList<Exame> exames = exameDAO.ListaDeExames();
            ArrayList<Medico> medicos = medicoDAO.ListaDeMedicos();
            ArrayList<Medico> medicosDaEspecialidade = new ArrayList();
            for(int i= 0; i < medicos.size(); i++){
                if(medicos.get(i).getIdEspecialidade().equals(id)){
                    medicosDaEspecialidade.add(medicos.get(i));
                }
            }
            if(!(medicosDaEspecialidade.isEmpty())){
                for(int j=0; j < medicosDaEspecialidade.size(); j++){
                    for(int x = 0; x < consultas.size(); x++){
                       for(int z = 0; z < exames.size(); z++){
                           if(exames.get(z).getIdConsulta().equals(consultas.get(x).getId()) && consultas.get(x).getIdMedico().equals(medicosDaEspecialidade.get(j).getId())){
                               exameDAO.Excluir(exames.get(z).getId());
                           }
                       }
                        if(consultas.get(x).getIdMedico().equals(medicosDaEspecialidade.get(j).getId())){
                            consultaDAO.Excluir(consultas.get(x).getId());
                        }
                    }
                    medicoDAO.Excluir(medicosDaEspecialidade.get(j).getId());
                }
                especialidadeDAO.Excluir(id);
            }else{
               especialidadeDAO.Excluir(id);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

}

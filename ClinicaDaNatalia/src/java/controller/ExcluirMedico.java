/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
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

/**
 *
 * @author natyn
 */
@WebServlet(name = "ExcluirMedico", urlPatterns = {"/ExcluirMedico"})
public class ExcluirMedico extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                        try {
            ConsultaDAO consultaDAO = new ConsultaDAO();
            MedicoDAO medicoDAO = new MedicoDAO();
            ExameDAO exameDAO = new ExameDAO();
            String id =  request.getParameter("id");;
            ArrayList<Consulta> consultas = consultaDAO.ListaDeConsultas();
            ArrayList<Exame> exames = exameDAO.ListaDeExames();
            ArrayList<Consulta> consultasDoMedico = new ArrayList();
            for(int i= 0; i < consultas.size(); i++){
                if(consultas.get(i).getIdMedico().equals(id)){
                    consultasDoMedico.add(consultas.get(i));
                }
            }
            if(!(consultasDoMedico.isEmpty())){
                for(int j=0; j < consultasDoMedico.size(); j++){
                    for(int x = 0; x < exames.size(); x++){
                        if(exames.get(x).getIdConsulta().equals(consultasDoMedico.get(j).getId())){
                            exameDAO.Excluir(exames.get(x).getId());
                        }
                    }
                    consultaDAO.Excluir(consultasDoMedico.get(j).getId());
                }
                medicoDAO.Excluir(id);
            }else{
               medicoDAO.Excluir(id);
            }
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);

        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }


}

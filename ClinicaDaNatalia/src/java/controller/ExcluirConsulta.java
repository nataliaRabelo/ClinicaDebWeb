/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.ExameDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
import model.Exame;
import model.UsuarioLogado;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ExcluirConsulta", urlPatterns = {"/ExcluirConsulta"})
public class ExcluirConsulta extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ConsultaDAO consultaDAO = new ConsultaDAO();
            ExameDAO exameDAO = new ExameDAO();
            String id =  request.getParameter("id");
            ArrayList<Exame> examesDaConsulta = new ArrayList();
            ArrayList<Exame> exames = exameDAO.ListaDeExames();
            for(int i = 0; i< exames.size(); i++){
                if(exames.get(i).getIdConsulta().equals(id)){
                    examesDaConsulta.add(exames.get(i));
                }
            }
            if(!(examesDaConsulta.isEmpty())){
                for(Exame exame: examesDaConsulta){
                    exameDAO.Excluir(exame.getId());
                }
                consultaDAO.Excluir(id);
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                rd.forward(request, response);
            }else{
                consultaDAO.Excluir(id);
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                rd.forward(request, response);
            }

        } catch (Exception ex) {
            throw new RuntimeException("Falha no post");
        }
    }

}

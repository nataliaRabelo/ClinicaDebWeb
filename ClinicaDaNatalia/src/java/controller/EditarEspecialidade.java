/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EspecialidadeDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Especialidade;

/**
 *
 * @author natyn
 */
@WebServlet(name = "EditarEspecialidade", urlPatterns = {"/EditarEspecialidade"})
public class EditarEspecialidade extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        Especialidade especialidade = null;
        try {
            especialidade = especialidadeDAO.get(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        request.setAttribute("id", id);
        request.setAttribute("especialidade", especialidade);
        RequestDispatcher rd = request.getRequestDispatcher("/view/EditarEspecialidade.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        String descricao = (String) request.getParameter("descricao");
        Especialidade especialidade = null;
        if(id != null && descricao != null){
                especialidade = new Especialidade(id, descricao);
                EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            try {
                especialidadeDAO.Alterar(especialidade);
                if (especialidade != null) {
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                rd.forward(request, response);

                } else {
                    request.setAttribute("msgError", "Algo não foi registrado corretamente.");
                    RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                    rd.forward(request, response);
                }
            } catch (Exception ex) {
                request.setAttribute("msgError", "Algo não foi registrado corretamente: " + ex.getMessage());
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                rd.forward(request, response);
            }
        }
    }

}

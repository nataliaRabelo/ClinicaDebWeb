package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.EspecialidadeDAO;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/RegistroEspecialidade"})
public class RegistroEspecialidade extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroEspecialidade.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        Especialidade especialidade = new Especialidade(descricao);
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        try {
            especialidadeDAO.Inserir(especialidade);
        } catch (Exception ex) {
            request.setAttribute("msgError", "Algo não foi registrado corretamente: " + ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
        rd.forward(request, response);
    }


}

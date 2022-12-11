/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.TipoPlanoDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipoPlano;

/**
 *
 * @author natyn
 */
@WebServlet(name = "EditarConvenio", urlPatterns = {"/EditarConvenio"})
public class EditarConvenio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
        TipoPlano tipoPlano = null;
        try {
            tipoPlano = tipoPlanoDAO.get(id);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        request.setAttribute("id", id);
        request.setAttribute("tipoPlano", tipoPlano);
        RequestDispatcher rd = request.getRequestDispatcher("/view/EditarConvenio.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        String descricao = (String) request.getParameter("descricao");
        TipoPlano tipoPlano = null;
        if(id != null && descricao != null){
                tipoPlano = new TipoPlano(id, descricao);
                TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
            try {
                tipoPlanoDAO.Alterar(tipoPlano);
                if (tipoPlano != null) {
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

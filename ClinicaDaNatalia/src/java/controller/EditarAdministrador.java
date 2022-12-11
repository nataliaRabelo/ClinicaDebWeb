/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AdministradorDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;

/**
 *
 * @author natyn
 */
@WebServlet(name = "EditarAdministrador", urlPatterns = {"/EditarAdministrador"})
public class EditarAdministrador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        AdministradorDAO admDAO = new AdministradorDAO();
        request.setAttribute("id", id);
        try {
            Administrador adm = admDAO.get(id);
            request.setAttribute("adm", adm);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/EditarAdministrador.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Administrador adm = null;
            String id = (String) request.getParameter("id");
            String nome = (String) request.getParameter("nome");
            String cpf = (String) request.getParameter("cpf");
            String senha = (String) request.getParameter("senha");
            if(id != null && nome != null && cpf != null && senha != null){
                adm = new Administrador(id, nome, cpf, senha);
                AdministradorDAO admDAO = new AdministradorDAO();
            try {
                admDAO.Alterar(adm);
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
            if (adm != null) {
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("msgError", "Algo não foi registrado corretamente.");
                RequestDispatcher rd = request.getRequestDispatcher("/view/EditarAdministrador.jsp");
                rd.forward(request, response);
            }
        }
    }

}

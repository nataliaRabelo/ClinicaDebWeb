package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.AdministradorDAO;
import DAO.PacienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Paciente;
import model.Usuario;

/**
 *
 * @author natyn
 */
@WebServlet(urlPatterns = {"/RegistroPaciente"})
public class RegistroPaciente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroPaciente.jsp");
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // pegando os parâmetros do request
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String autorizado = request.getParameter("autorizado");
        String idtipoplano = request.getParameter("idtipoplano");
        Paciente usuario = new Paciente(nome, cpf, senha, autorizado, idtipoplano);
        PacienteDAO usuarioDAO = new PacienteDAO();
        try {
            usuarioDAO.Inserir(usuario);
        } catch (Exception ex) {
            throw new RuntimeException("Falha na query para Logar");
        }

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            RequestDispatcher rd = request.getRequestDispatcher("/AreaDoAdministrador.jsp");
            rd.forward(request, response);

        } else {
            request.setAttribute("msgError", "Algo não foi registrado corretamente.");
            RequestDispatcher rd = request.getRequestDispatcher("/RegistroAdministrador.jsp");
            rd.forward(request, response);
        }
    }

}

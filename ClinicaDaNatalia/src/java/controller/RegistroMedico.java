package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.AdministradorDAO;
import DAO.EspecialidadeDAO;
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
import javax.servlet.http.HttpSession;
import model.Especialidade;
import model.Medico;
import model.Usuario;

/**
 *
 * @author natyn
 */
@WebServlet(urlPatterns = {"/RegistroMedico"})
public class RegistroMedico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
            ArrayList<Especialidade> listaDeEspecialidades = especialidadeDAO.ListaDeEspecialidades();
            request.setAttribute("listaDeEspecialidades", listaDeEspecialidades);
            RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroMedico.jsp");
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String crm = request.getParameter("crm");
        String estadocrm = request.getParameter("estadocrm");
        String idespecialidade = request.getParameter("idespecialidade");
        Medico usuario = new Medico(nome, cpf, senha, crm, estadocrm, "N", idespecialidade);
        MedicoDAO medicoDAO = new MedicoDAO();
        try {
            medicoDAO.Inserir(usuario);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        if (usuario != null) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);

        } else {
            request.setAttribute("msgError", "Algo não foi registrado corretamente.");
            RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroMedico.jsp");
            rd.forward(request, response);
        }
    }
}

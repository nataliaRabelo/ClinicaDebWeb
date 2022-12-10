package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.AdministradorDAO;
import DAO.PacienteDAO;
import DAO.TipoPlanoDAO;
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
import model.Administrador;
import model.Paciente;
import model.TipoPlano;
import model.Usuario;
import model.UsuarioLogado;

/**
 *
 * @author natyn
 */
@WebServlet(urlPatterns = {"/RegistroPaciente"})
public class RegistroPaciente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            TipoPlanoDAO tipoPlanoDAO = new TipoPlanoDAO();
            ArrayList<TipoPlano> listaDePlanos = tipoPlanoDAO.ListaDePlanos();
            request.setAttribute("listaDePlanos", listaDePlanos);
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
        String idtipoplano = request.getParameter("idtipoplano");
        Paciente usuario = new Paciente(nome, cpf, senha, idtipoplano);
        PacienteDAO pacienteDAO = new PacienteDAO();
        try {
            pacienteDAO.Inserir(usuario);
        } catch (Exception ex) {
            request.setAttribute("msgError", "Algo não foi registrado corretamente: " + ex.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
            rd.forward(request, response);
        }

        if (usuario != null) {
            HttpSession session = request.getSession();
            Administrador administrador = (Administrador) session.getAttribute("administrador");
            if(administrador == null){
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoPaciente.jsp");
                rd.forward(request, response);
            }else{
                session.setAttribute("usuario", usuario);
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                rd.forward(request, response);
            }
        } else {
            request.setAttribute("msgError", "Algo não foi registrado corretamente.");
            RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroPaciente.jsp");
            rd.forward(request, response);
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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

/**
 *
 * @author natyn
 */
@WebServlet(name = "EditarMedico", urlPatterns = {"/EditarMedico"})
public class EditarMedico extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        EspecialidadeDAO especialidadeDAO = new EspecialidadeDAO();
        MedicoDAO medicoDAO = new MedicoDAO();
        ArrayList<Especialidade> listaDeEspecialidades = especialidadeDAO.ListaDeEspecialidades();
        request.setAttribute("listaDeEspecialidades", listaDeEspecialidades);
        request.setAttribute("id", id);
        try {
            Medico medico = medicoDAO.get(id);
            request.setAttribute("medico", medico);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("/view/EditarMedico.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Medico medico = null;
        String id = (String) request.getParameter("id");
        String nome = (String) request.getParameter("nome");
        String cpf = (String) request.getParameter("cpf");
        String senha = (String) request.getParameter("senha");
        String crm = (String) request.getParameter("crm");
        String estadocrm = (String) request.getParameter("estadocrm");
        String autorizado = (String) request.getParameter("autorizado");
        String especialidade = (String) request.getParameter("idespecialidade");
        if(id != null && nome != null && cpf != null && autorizado != null && crm != null && estadocrm != null && especialidade != null){
                medico = new Medico(id, nome, cpf, senha, crm, estadocrm, autorizado, especialidade);
                MedicoDAO medicoDAO = new MedicoDAO();
            try {
                medicoDAO.Alterar(medico);
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
            if (medico != null) {
                HttpSession session = request.getSession();
                session.setAttribute("medico", medico);
                RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("msgError", "Algo não foi registrado corretamente.");
                RequestDispatcher rd = request.getRequestDispatcher("/view/EditarMedico.jsp");
                rd.forward(request, response);
            }
        }
    }



}

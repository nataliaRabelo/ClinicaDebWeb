package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.AdministradorDAO;
import DAO.MedicoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Medico;
import model.Usuario;

/**
 *
 * @author natyn
 */
@WebServlet(urlPatterns = {"/RegistroMedico"})
public class RegistroMedico extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroMedico.jsp");
            rd.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String crm = request.getParameter("crm");
        String estadocrm = request.getParameter("estadocrm");
        String autorizado = request.getParameter("autorizado");
        String idespecialidade = request.getParameter("idespecialidade");
        if (nome.isEmpty() || cpf.isEmpty() || senha.isEmpty()) {
            // dados não foram preenchidos retorna ao formulário
            request.setAttribute("msgError", "Usuário e/ou senha incorreto");
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        } else {

            Medico usuario = new Medico(nome, cpf, senha, crm, estadocrm, autorizado, idespecialidade);
            MedicoDAO medicoDAO = new MedicoDAO();
            try {
                medicoDAO.Inserir(usuario);
            } catch (Exception ex) {
                throw new RuntimeException("Falha na query para Logar");
            }

            if (usuario != null) {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                RequestDispatcher rd = request.getRequestDispatcher("/AreaDoMedico.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("msgError", "Usuário e/ou senha incorreto");
                RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                rd.forward(request, response);
            }

        }
    }
}

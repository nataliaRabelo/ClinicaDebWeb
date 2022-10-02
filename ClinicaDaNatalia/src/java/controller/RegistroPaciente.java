package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;

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
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String autorizado = request.getParameter("autorizado");
        String idtipoplano = request.getParameter("idtipoplano");
        if(nome.isEmpty() || cpf.isEmpty() || senha.isEmpty() || autorizado.isEmpty() || idtipoplano.isEmpty()){
            RequestDispatcher rd = request.getRequestDispatcher("/view/RegistroPaciente.jsp");
            rd.forward(request, response);
        } else {
            Paciente paciente = new Paciente(nome, cpf, senha, autorizado, idtipoplano);
            request.setAttribute("paciente", paciente);
            RequestDispatcher rd = request.getRequestDispatcher("/ClinicaDaNatalia/AreaDoPaciente");
            
        }
    }

}

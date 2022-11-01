package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Administrador;
import model.Medico;
import model.Paciente;
import model.Usuario;

/**
 *
 * @author natyn
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {


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
        RequestDispatcher rd = request.getRequestDispatcher("/view/Login.jsp");
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
                    // pegando os parâmetros do request
        String cpf_user = request.getParameter("cpf");
        String senha_user = request.getParameter("senha");
        if (cpf_user.isEmpty() || senha_user.isEmpty()) {
            // dados não foram preenchidos retorna ao formulário
            request.setAttribute("msgError", "Usuário e/ou senha incorreto");
            RequestDispatcher rd = request.getRequestDispatcher("/formLogin.jsp");
            rd.forward(request, response);
        } else {
            Connection conexao = null;
            try {
                //Carrega o Driver JDBC na memória
                Class.forName("com.mysql.jdbc.Driver"); //load driver                       
                //Abre a conexão com o banco de dados via JDBC
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjava", "root", "");
 
                String sqlString = "select * from usuarios where cpf = ? and senha =? limit 1";
                PreparedStatement sql = conexao.prepareStatement(sqlString);
                sql.setString(1, cpf_user);
                sql.setString(2, senha_user);
                ResultSet resultado = sql.executeQuery();
                resultado.last();
                if (resultado.getRow() > 0) {
                    if(!resultado.getString("idtipoplano").equals(null)){
                        Usuario paciente = new Paciente(resultado.getString("id"),resultado.getString("nome"),
                        resultado.getString("cpf"),resultado.getString("senha"),resultado.getString("autorizado"),resultado.getString("idtipoplano") );
                        HttpSession session = request.getSession();
                        session.setAttribute("paciente", paciente);
                        RequestDispatcher rd = request.getRequestDispatcher("/areaDoPaciente.jsp");
                        rd.forward(request, response);
                    }
                    else if(!resultado.getString("crm").equals(null)){
                        Usuario medico = new Medico(resultado.getString("id"),resultado.getString("nome"),resultado.getString("crm"), resultado.getString("estadocrm"),
                        resultado.getString("cpf"),resultado.getString("senha"),resultado.getString("autorizado"),resultado.getString("idtipoplano"));
                        HttpSession session = request.getSession();
                        session.setAttribute("medico", medico);
                        RequestDispatcher rd = request.getRequestDispatcher("/areaDoMedico.jsp");
                        rd.forward(request, response);
                    }else{
                        Usuario administrador = new Administrador(resultado.getString("id"),resultado.getString("nome"),
                        resultado.getString("cpf"),resultado.getString("senha") );
                        HttpSession session = request.getSession();
                        session.setAttribute("administrador", administrador);
                        RequestDispatcher rd = request.getRequestDispatcher("/areaDoAdministrador.jsp");
                        rd.forward(request, response);
                    }

                } else {
                    request.setAttribute("msgError", "Usuário e/ou senha incorreto");
                    RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
                    rd.forward(request, response);
                }

            } catch (ClassNotFoundException ex) {
                System.out.println("Não foi possível encontrar o Driver!");
            } catch (SQLException ex) {
                System.out.println("Não foi possível conectar ao banco!");
            } finally {
                try {
                    conexao.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

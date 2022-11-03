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
import model.UsuarioLogado;

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
            RequestDispatcher rd = request.getRequestDispatcher("/Login.jsp");
            rd.forward(request, response);
        } else {
            Connection conexao = null;
            try {
                //Carrega o Driver JDBC na memória
                Class.forName("com.mysql.jdbc.Driver"); //load driver                       
                //Abre a conexão com o banco de dados via JDBC
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica", "root", "");
 
                String sqlString = "SELECT * FROM (SELECT a.nome AS nome, a.id AS id, a.cpf AS cpf, a.senha AS senha, NULL AS idtipoplano, NULL AS autorizado, NULL AS idespecialidade, NULL AS estadocrm, NULL AS crm FROM administrador a UNION ALL SELECT p.nome AS nome, p.id AS id, p.cpf AS cpf, p.senha AS senha, p.idtipoplano AS idtipoplano, p.autorizado AS autorizado, NULL AS idespecialidade, NULL AS estadocrm, NULL AS crm FROM paciente p UNION ALL SELECT m.nome AS nome, m.id AS id, m.cpf AS cpf, m.senha AS senha, NULL AS idtipoplano, m.autorizado AS autorizado, m.idespecialidade AS idespecialidade, m.estadocrm AS estadocrm, m.crm AS crm FROM medico m) g WHERE cpf=? and senha =? LIMIT 1";
                PreparedStatement sql = conexao.prepareStatement(sqlString);
                sql.setString(1, cpf_user);
                sql.setString(2, senha_user);
                ResultSet resultado = sql.executeQuery();
                resultado.last();
                if (resultado.getRow() > 0) {
                    if(!(resultado.getString("idtipoplano") == null)){
                        Paciente paciente = new Paciente(resultado.getString("id"),resultado.getString("nome"),
                        resultado.getString("cpf"),resultado.getString("senha"),resultado.getString("autorizado"),resultado.getString("idtipoplano") );
                        UsuarioLogado.getInstancia().setPaciente(paciente);
                        HttpSession session = request.getSession();
                        session.setAttribute("paciente", paciente);
                        RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoPaciente.jsp");
                        rd.forward(request, response);
                    }
                    else if(!(resultado.getString("crm") == null)){
                        Medico medico = new Medico(resultado.getString("id"),resultado.getString("nome"),resultado.getString("crm"), resultado.getString("estadocrm"),
                        resultado.getString("cpf"),resultado.getString("senha"),resultado.getString("autorizado"),resultado.getString("idtipoplano"));
                        UsuarioLogado.getInstancia().setMedico(medico);
                        HttpSession session = request.getSession();
                        session.setAttribute("medico", medico);
                        RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoMedico.jsp");
                        rd.forward(request, response);
                    }else{
                        Administrador administrador = new Administrador(resultado.getString("id"),resultado.getString("nome"),
                        resultado.getString("cpf"),resultado.getString("senha"));
                        UsuarioLogado.getInstancia().setAdmin(administrador);
                        HttpSession session = request.getSession();
                        session.setAttribute("administrador", administrador);
                        RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoAdministrador.jsp");
                        rd.forward(request, response);
                    }

                } else {
                    request.setAttribute("msgError", "Usuário e/ou senha incorreto");
                    RequestDispatcher rd = request.getRequestDispatcher("/Login");
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

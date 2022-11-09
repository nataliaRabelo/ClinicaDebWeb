/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.EspecialidadeDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consulta;
import model.UsuarioLogado;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ListaDeConsultas", urlPatterns = {"/ListaDeConsultas"})
public class ListaDeConsultas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ConsultaDAO consultaDAO = new ConsultaDAO();
            // pegando os parâmetros do request
            //String idtipoplano = request.getParameter("idtipoplano");
            try {
                ArrayList<Consulta> todasAsConsultas = consultaDAO.ListaDeConsultas();
                ArrayList<Consulta> listaDeConsultas = new ArrayList();
                for(Consulta consulta : todasAsConsultas){
                    if(UsuarioLogado.getInstancia().getIdTipoPlano() != null && consulta.getIdPaciente().equals(UsuarioLogado.getInstancia().getId())){
                        listaDeConsultas.add(consulta);
                    }if(UsuarioLogado.getInstancia().getCrm() != null && consulta.getIdMedico().equals(UsuarioLogado.getInstancia().getId())){
                        listaDeConsultas.add(consulta);
                    }
                    
                }
                request.setAttribute("listaDeConsultas", listaDeConsultas);
                request.setAttribute("usuariologado", UsuarioLogado.getInstancia());
                RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDeConsultas.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException("Falha na query ao listar consultas.");
            }
    }

}

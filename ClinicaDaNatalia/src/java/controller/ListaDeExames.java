/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.ExameDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Consulta;
import model.Exame;
import model.UsuarioLogado;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ListaDeExames", urlPatterns = {"/ListaDeExames"})
public class ListaDeExames extends HttpServlet {


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
            ExameDAO exameDAO = new ExameDAO();
            // pegando os parâmetros do request
            //String idtipoplano = request.getParameter("idtipoplano");
            try {
                ArrayList<Exame> todosOsExames = exameDAO.ListaDeExames();
                ArrayList<Exame> listaDeExames = new ArrayList();
                for(Exame exame : todosOsExames){
                    if(UsuarioLogado.getInstancia().getIdTipoPlano() != null && exame.getIdPaciente().equals(UsuarioLogado.getInstancia().getId())){
                        listaDeExames.add(exame);
                    }if(UsuarioLogado.getInstancia().getCrm() != null && exame.getIdMedico().equals(UsuarioLogado.getInstancia().getId())){
                        listaDeExames.add(exame);
                    }
                    
                }
                request.setAttribute("listaDeExames", listaDeExames);
                request.setAttribute("usuariologado", UsuarioLogado.getInstancia());
                RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDeExames.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException("Falha na query ao listar consultas.");
            }
        
    }


}

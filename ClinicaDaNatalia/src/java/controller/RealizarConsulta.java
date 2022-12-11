/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ConsultaDAO;
import DAO.ExameDAO;
import DAO.TipoExameDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Consulta;
import model.Exame;
import model.Medico;
import model.TipoExame;

/**
 *
 * @author natyn
 */
@WebServlet(name = "RealizarConsulta", urlPatterns = {"/RealizarConsulta"})
public class RealizarConsulta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ConsultaDAO consultaDAO = new ConsultaDAO();
            TipoExameDAO tipoExameDAO = new TipoExameDAO();
            ArrayList<Consulta> listaDeConsultasTotal = consultaDAO.ListaDeConsultas();
            ArrayList<Consulta> listaDeConsultas = new ArrayList<>();
            ArrayList<TipoExame> tiposExames = tipoExameDAO.ListaDeTipoExames();
            HttpSession session = request.getSession();
            Medico medico = (Medico) session.getAttribute("medico");
            for(Consulta consulta : listaDeConsultasTotal){
                if(consulta.getIdMedico().equals(medico.getId()) && consulta.getRealizada().equals("N")){
                    listaDeConsultas.add(consulta);
                }
            }
            request.setAttribute("listaDeConsultas", listaDeConsultas);
            request.setAttribute("tiposExames", tiposExames);
            RequestDispatcher rd = request.getRequestDispatcher("/view/RealizarConsulta.jsp");
            rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String descricao = request.getParameter("descricao");
        String id = request.getParameter("id");
        String[] idtipoexame = request.getParameterValues("idtipoexame");
        ConsultaDAO consultaDAO = new ConsultaDAO();
        ExameDAO exameDAO = new ExameDAO();
        Consulta consulta = null;
        Exame exame = null;
        try {
            ArrayList<Consulta> consultas = consultaDAO.ListaDeConsultas();
            for(Consulta consultaDaLista : consultas){
                if(consultaDaLista.getId().equals(id)){
                    consultaDaLista.setDescricao(descricao);
                    consultaDaLista.setRealizada("S");
                    consulta = consultaDaLista;
                    consultaDAO.Alterar(consultaDaLista);
                }
            }
            boolean semExame = false;
            for(int i = 0; i < idtipoexame.length; i++){
                if(idtipoexame[i].equals("-1")){
                semExame = true;  
                }else if(semExame){
                    break;
                }else{
                    exame = new Exame(idtipoexame[i],id);
                    exameDAO.Inserir(exame);
                }
            }
        if (consulta == null) {
            request.setAttribute("msgError", "Algo não foi registrado corretamente.");
            RequestDispatcher rd = request.getRequestDispatcher("/view/RealizarConsulta.jsp");
            rd.forward(request, response);            
        } else{
            HttpSession session = request.getSession();
            session.setAttribute("consulta", consulta);
            session.setAttribute("exame", exame);
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoMedico.jsp");
            rd.forward(request, response);
        }
        } catch (Exception ex) {
            throw new RuntimeException("Falha na query para alterar consulta:" + ex.getMessage());
        }
    }

}

package controller;

import DAO.ConsultaDAO;
import DAO.MedicoDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Medico;
import model.Consulta;
import model.Paciente;

/**
 *
 * @author natyn
 */
@WebServlet(urlPatterns = {"/MarcacaoConsulta"})
public class MarcacaoConsulta extends HttpServlet {


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
        MedicoDAO medicoDAO = new MedicoDAO();
        ArrayList<Medico> listaDeMedicos = medicoDAO.ListaDeMedicos();
        String msgError = request.getParameter("msgError");
        request.setAttribute("msgError", msgError);
        request.setAttribute("listaDeMedicos", listaDeMedicos);
        RequestDispatcher rd = request.getRequestDispatcher("/view/MarcacaoConsulta.jsp");
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
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");
        String idmedico = request.getParameter("idmedico");
        String dataInteira = data + " " + hora;
        HttpSession session = request.getSession();
        Paciente paciente = (Paciente) session.getAttribute("paciente");
        ConsultaDAO consultaDAO = new ConsultaDAO();
        ArrayList<Consulta> consultas = consultaDAO.ListaDeConsultas();
         Consulta consulta = null;
        int count = 0;
        for(Consulta consulta2 : consultas){
            String[] dataSplitada = consulta2.getData().split(" "); 
            if(consulta2.getIdMedico().equals(idmedico) && data.equals(dataSplitada[0])){
               count++;
            }
        }
        if(count < 2){
            consulta = new Consulta(dataInteira, "", idmedico, paciente.getId());
        }
        if (consulta != null) {
            try {
                consultaDAO.Inserir(consulta);
            } catch (Exception ex) {
                throw new RuntimeException(ex.getMessage());
            }
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoPaciente.jsp");
            rd.forward(request, response);
        }else {
            String msgError = "Este m??dico j?? possui o m??ximo de consultas para este dia. Tente outro dia ou outro m??dico.";
            request.setAttribute("msgError", msgError);
            RequestDispatcher rd = request.getRequestDispatcher("/view/AreaDoPaciente.jsp");
            rd.forward(request, response);
        }
    }

}

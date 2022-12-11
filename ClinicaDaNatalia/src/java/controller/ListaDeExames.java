
package controller;

import DAO.ExameDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Exame;
import model.Medico;
import model.Paciente;

/**
 *
 * @author natyn
 */
@WebServlet(name = "ListaDeExames", urlPatterns = {"/ListaDeExames"})
public class ListaDeExames extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            ExameDAO exameDAO = new ExameDAO();
            HttpSession session = request.getSession();
            Medico medico = (Medico) session.getAttribute("medico");
            Paciente paciente = (Paciente) session.getAttribute("paciente");
            try {
                ArrayList<Exame> todosOsExames = exameDAO.ListaDeExames();
                ArrayList<Exame> listaDeExames = new ArrayList();
                for(Exame exame : todosOsExames){
                    if(paciente != null && exame.getIdPaciente().equals(paciente.getId())){
                        listaDeExames.add(exame);
                    }if(medico != null && exame.getIdMedico().equals(medico.getId())){
                        listaDeExames.add(exame);
                    }
                    
                }
                request.setAttribute("listaDeExames", listaDeExames);
                RequestDispatcher rd = request.getRequestDispatcher("/view/ListaDeExames.jsp");
                rd.forward(request, response);
                
                
            } catch (IOException | ServletException ex) {
                throw new RuntimeException("Falha na query ao listar consultas.");
            }
        
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.ConsultaDAO;
import DAO.ExameDAO;
import DAO.MedicoDAO;
import DAO.PacienteDAO;
import DAO.TipoExameDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author natyn
 */
public class Exame {
    
    private String id;
    private String idtipoexame;
    private String idconsulta;

    public Exame(String idtipoexame, String idconsulta) {
        this.idtipoexame = idtipoexame;
        this.idconsulta = idconsulta;
    }
    
    public Exame(String id, String idtipoexame, String idconsulta) {
        this.id = id;
        this.idtipoexame = idtipoexame;
        this.idconsulta = idconsulta;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getIdTipoExame(){
        return this.idtipoexame;
    }
        
    public String getIdConsulta(){
        return this.idconsulta;
    }
    
    public String getDescricaoTipoExame(){
        TipoExameDAO tipoExameDAO = new TipoExameDAO();
        List<TipoExame> tiposExames = tipoExameDAO.ListaDeTipoExames();
        for(TipoExame tipoExame : tiposExames){
            if(tipoExame.getId().equals(this.idtipoexame)){
                return tipoExame.getDescricao();
            }
        }
        return null;
    }
    
    public String getIdMedico(){
        ConsultaDAO consultaDAO = new ConsultaDAO();
        List<Consulta> consultas = consultaDAO.ListaDeConsultas();
        for(Consulta consulta : consultas){
            if(consulta.getId().equals(this.idconsulta)){
                return consulta.getIdMedico();
            }
        }
        return null;
    }
    
    public String getDataConsulta(){
        ConsultaDAO consultaDAO = new ConsultaDAO();
        List<Consulta> consultas = consultaDAO.ListaDeConsultas();
        for(Consulta consulta : consultas){
            if(consulta.getId().equals(this.idconsulta)){
                return consulta.getData();
            }
        }
        return null;
    }
    
    public String getMedico(){
        MedicoDAO medicoDAO = new MedicoDAO();
        ArrayList<Usuario> medicos = medicoDAO.ListaDeMedicos();
            for(Usuario usuario : medicos){
            if(usuario.getId().equals(this.getIdMedico())){
                return usuario.getNome();
            }
        }
        return null;
    }
    
    public String getPaciente(){
        PacienteDAO pacienteDAO = new PacienteDAO();
        ArrayList<Paciente> pacientes = pacienteDAO.ListaDePacientes();
            for(Usuario usuario : pacientes){
            if(usuario.getId().equals(this.getIdPaciente())){
                return usuario.getNome();
            }
        }
        return null;
    }
    
    public String getIdPaciente(){
        ConsultaDAO consultaDAO = new ConsultaDAO();
        List<Consulta> consultas = consultaDAO.ListaDeConsultas();
        for(Consulta consulta : consultas){
            if(consulta.getId().equals(this.idconsulta)){
                return consulta.getIdPaciente();
            }
        }
        return null;
    }

    public void setId(String id) {
        this.id=id;
    }

    public void setIdTipoExame(String idtipoexame) {
        this.idtipoexame=idtipoexame;
    }

    public void setIdConsulta(String idconsulta) {
        this.idconsulta=idconsulta;
    }
}

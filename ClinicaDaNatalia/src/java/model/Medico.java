/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.EspecialidadeDAO;
import java.util.ArrayList;

/**
 *
 * @author natyn
 */
public class Medico extends Usuario{
    
    private String crm;
    private String estadocrm;
    private String autorizado;
    private String idespecialidade;
    
    public Medico(String id, String nome, String cpf, String senha, String crm, String estadocrm, String autorizado, String especialidade){
        super(id, nome, cpf, senha);
        this.crm = crm;
        this.estadocrm = estadocrm;
        this.autorizado = autorizado;
        this.idespecialidade = especialidade;
    }
    
    public Medico(String nome, String cpf, String senha, String crm, String estadocrm, String autorizado, String especialidade){
        super(nome, cpf, senha);
        this.crm = crm;
        this.estadocrm = estadocrm;
        this.autorizado = autorizado;
        this.idespecialidade = especialidade;
    }

    public Medico() {
        
    }
    
    public String getCrm(){
        return this.crm;
    }
    public String getEstadoCrm(){
        return this.estadocrm;
    }
    
    public String getAutorizado(){
        return this.autorizado;
    }
    
    public String getIdEspecialidade(){
        return this.idespecialidade;
    }
    
    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setEstadoCrm(String estadocrm) {
        this.estadocrm = estadocrm;
    }

    public void setAutorizado(String autorizado) {
        this.autorizado = autorizado;
    }

    public void setIdEspecialidade(String idespecialidade) {
        this.idespecialidade = idespecialidade;
    }
    
    public String getNomeEspecialidade(String idespecialidade){
        EspecialidadeDAO especialidadeDao = new EspecialidadeDAO(); 
        ArrayList<Especialidade> especialidades = especialidadeDao.ListaDeEspecialidades();
        for(Especialidade especialidade : especialidades){
            if(especialidade.getId().equals(idespecialidade)){
                return especialidade.getDescricao();
            }
        }
        return null;
    }
    
}

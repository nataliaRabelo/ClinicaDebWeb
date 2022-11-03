/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author natyn
 */
public class Consulta {
    
    private String id;
    private String data;
    private String descricao;
    private String realizada;
    private String idmedico;
    private String idpaciente;
    
    public Consulta(String id, String data, String descricao, String realizada, String idmedico, String idpaciente){
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.descricao = realizada;
        this.idmedico = idmedico;
        this.idpaciente = idpaciente;
    }
    
    public Consulta(String data, String descricao, String idmedico, String idpaciente){
        this.data = data;
        this.descricao = descricao;
        this.descricao = "N";
        this.idmedico = idmedico;
        this.idpaciente = idpaciente;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getData(){
        return this.data;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public String getRealizada(){
        return this.realizada;
    }
    
    public String getIdMedico(){
        return this.idmedico;
    }
        
    public String getIdPaciente(){
        return this.idmedico;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void setRealizada(String realizada){
        this.realizada = realizada;
    }
    
    public void setIdMedico(String idmedico){
        this.idmedico = idmedico;
    }
        
    public void setIdPaciente(String idpaciente){
        this.idpaciente = idpaciente;
    }
}

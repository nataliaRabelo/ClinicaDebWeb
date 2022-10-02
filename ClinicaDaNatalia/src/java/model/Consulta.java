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
    
    private int id;
    private LocalDateTime data;
    private String descricao;
    private String realizada;
    private int idmedico;
    private int idpaciente;
    
    public int getId(){
        return this.id;
    }
    
    public LocalDateTime getData(){
        return this.data;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    
    public String getRealizada(){
        return this.realizada;
    }
    
    public int getIdMedico(){
        return this.idmedico;
    }
        
    public int getIdPaciente(){
        return this.idmedico;
    }
}

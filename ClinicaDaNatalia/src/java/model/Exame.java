/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author natyn
 */
public class Exame {
    
    private int id;
    private int idtipoexame;
    private int idconsulta;
    
    public int getId(){
        return this.id;
    }
    
    public int getIdTipoExame(){
        return this.idtipoexame;
    }
        
    public int getIdConsulta(){
        return this.idconsulta;
    }
}

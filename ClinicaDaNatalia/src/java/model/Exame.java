/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DAO.TipoExameDAO;

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
    
    public String getDescricaoTipoExame(){
        TipoExameDAO timoExameDAO = new TipoExameDAO();
        /*Arraylist<TipoExame> tiposDeExames = timoExameDAO.listaDeTipoExames();
        for(TipoExame tipoExame : tiposDeExames){
            if(tipoExame.getId() == this.idtipoexame){
                return tipoExame.getDescricao();
            }
        }
        */
        return "";
    }
}

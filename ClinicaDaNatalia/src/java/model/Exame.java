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
    
    private String id;
    private String idtipoexame;
    private String idconsulta;

    public Exame(String idtipoexame, String idconsulta) {
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

    public void setId(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdTipoExame(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdConsulta(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

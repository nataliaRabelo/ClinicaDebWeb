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
public class Paciente extends Usuario{
    
    private String autorizado;
    private String idtipoplano;
    
    public Paciente(){
        
    }
    
    public Paciente(String id, String nome, String cpf, String senha, String autorizado, String tipoplano){
        super(id, nome, cpf, senha);
        this.autorizado = autorizado;
        this.idtipoplano = tipoplano;
    }
    
    public Paciente(String nome, String cpf, String senha, String tipoplano){
        super(nome, cpf, senha);
        this.autorizado = "N";
        this.idtipoplano = tipoplano;
    }

    public String getAutorizado(){
        return this.autorizado;
    }
    
    public String getIdtipoPlano(){
        return this.idtipoplano;
    }
    
    public void setAutorizado(String autorizado){
        this.autorizado = autorizado;
    }
    
    public void setIdTipoPlano(String idtipoplano){
        this.idtipoplano = idtipoplano;
    }

}

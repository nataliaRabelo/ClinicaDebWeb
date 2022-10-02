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
public class Paciente {
    
    private int id = 0;
    private String nome;
    private String cpf;
    private String senha;
    private String autorizado;
    private int idtipoplano;
    
    public Paciente(String nome, String cpf, String senha, String autorizado, String tipoplano){
        this.id++;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.autorizado = autorizado;
        if(tipoplano.equals("UNIMED")){
            this.idtipoplano = 1;
        }else if(tipoplano.equals("AMIL")){
            this.idtipoplano = 2;
        }else if(tipoplano.equals("SulAmérica")){
            this.idtipoplano = 3;
        }else if(tipoplano.equals("Particular")){
            this.idtipoplano = 4;
        }
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    public String getSenha(){
        return this.senha;
    }
    
    public String getAutorizado(){
        return this.autorizado;
    }
    
    public int getIdtipoPlano(){
        return this.idtipoplano;
    }

}

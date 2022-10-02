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
public class Medico {
    
    private int id = 0;
    private String nome;
    private int crm;
    private String estadocrm;
    private String cpf;
    private String senha;
    private String autorizado;
    private int idespecialidade;
    
    public Medico(String nome, int crm, String estadocrm, String cpf, String senha, String autorizado, String especialidade){
        this.id++;
        this.nome = nome;
        this.crm = crm;
        this.estadocrm = estadocrm;
        this.cpf = cpf;
        this.senha = senha;
        this.autorizado = autorizado;
        if(especialidade.equals("CARDIOLOGIA")){
            this.idespecialidade = 1;
        }else if(especialidade.equals("NEUROLOGIA")){
            this.idespecialidade = 2;
        }else if(especialidade.equals("GASTROLOGISTA")){
            this.idespecialidade = 3;
        }else if(especialidade.equals("PNEUMOLOGIA")){
            this.idespecialidade = 4;
        }else{
            this.idespecialidade = 0;
        }
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getCrm(){
        return this.crm;
    }
    public String getEstadoCrm(){
        return this.estadocrm;
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
    
    public int getIdEspecialidade(){
        return this.idespecialidade;
    }
    
}

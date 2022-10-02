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
public class Administrador {
    
    private int id = 0;
    private String nome;
    private String cpf;
    private String senha;
    
    public Administrador(String nome, String cpf, String senha){
        this.id++;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
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
    
}

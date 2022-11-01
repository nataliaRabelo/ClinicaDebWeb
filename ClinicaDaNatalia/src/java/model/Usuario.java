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
public class Usuario {
    
    private String id;
    private String nome;
    private String cpf;
    private String senha;
    
    public Usuario(String id, String nome, String cpf, String senha){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    
        public Usuario(String nome, String cpf, String senha){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public String getId(){
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

    public void setId(int id) {
        this.id = String.valueOf(id);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}

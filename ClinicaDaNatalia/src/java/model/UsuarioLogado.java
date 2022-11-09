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
public class UsuarioLogado{
    
    private String id;
    private String nome;
    private String cpf;
    private String senha;
    private String autorizado;
    private String idtipoplano;
    private String crm;
    private String estadocrm;
    private String idespecialidade;
    private String botao; 
    private static UsuarioLogado instancia;
    
    public void setMedico(Medico usuario){
        this.id = usuario.getId();
        this.nome = usuario.getId();
        this.cpf = usuario.getId();
        this.senha = usuario.getSenha();
        this.autorizado = usuario.getAutorizado();
        this.idtipoplano = null;
        this.crm = usuario.getCrm();
        this.estadocrm = usuario.getEstadoCrm();
        this.idespecialidade = usuario.getIdEspecialidade();    
    }
            
    public void setPaciente(Paciente usuario){
        this.id = usuario.getId();
        this.nome = usuario.getId();
        this.cpf = usuario.getId();
        this.senha = usuario.getSenha();
        this.autorizado = usuario.getAutorizado();
        this.idtipoplano = usuario.getIdtipoPlano();
        this.crm = null;
        this.estadocrm = null;
        this.idespecialidade = null;    
    }
    
    public void setAdmin(Administrador usuario){
        this.id = usuario.getId();
        this.nome = usuario.getId();
        this.cpf = usuario.getId();
        this.senha = usuario.getSenha();
        this.autorizado = null;
        this.idtipoplano = null;
        this.crm = null;
        this.estadocrm = null;
        this.idespecialidade = null;    
    }
        
    public static UsuarioLogado getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioLogado();
        }
        return instancia;
    }
    
    public String getId(){
        return this.id;
    }
    
    public String getIdTipoPlano(){
        return this.idtipoplano;
    }
    
    public String getCrm(){
        return this.crm;
    }
    
    public String getBotao(){
        return this.botao;
    }
    
    public void setBotao(String botao){
        this.botao=botao;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Administrador;
import model.Usuario;

/**
 *
 * @author natyn
 */
public class AdministradorDAO {
    
        public void Inserir(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO administrador (nome, cpf, senha)"
                    + " VALUES (?,?,?)");
            sql.setString(1, usuario.getNome());
            sql.setString(2, usuario.getCpf());
            sql.setString(3, usuario.getSenha());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }

    public Administrador get(String id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM administrador WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(id));
            ResultSet resultado = sql.executeQuery();
            Administrador adm = new Administrador();
            if (resultado != null) {
                while (resultado.next()) {
                    adm.setId(Integer.parseInt(resultado.getString("ID")));
                    adm.setNome(resultado.getString("NOME"));
                    adm.setCpf(resultado.getString("CPF"));
                    adm.setSenha(resultado.getString("SENHA"));
                }
            }
            return adm;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Usuario Usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE administrador SET id = ?, nome = ?, cpf = ?, senha = ?  WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(Usuario.getId()));
            sql.setString(2, Usuario.getNome());
            sql.setString(3, Usuario.getCpf());
            sql.setString(4, Usuario.getSenha());
            sql.setString(5, Usuario.getId());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(String id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM administrador WHERE ID = ? ");
            sql.setInt(1, Integer.parseInt(id));
            sql.executeUpdate();
            System.out.println(sql);

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir consulta) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Usuario> ListaDeUsuarios() {
        ArrayList<Usuario> meusUsuarios = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM administrador order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Usuario usuario = new Usuario(resultado.getString("NOME"),
                    resultado.getString("CPF"),
                    resultado.getString("SENHA"));
                    usuario.setId(Integer.parseInt(resultado.getString("id")));
                    meusUsuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeAdministradores) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusUsuarios;
    }

    public Usuario Logar(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM administrador WHERE cpf=? and senha =? LIMIT 1");
            sql.setString(1, usuario.getCpf());
            sql.setString(2, usuario.getSenha());
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    usuario.setId(Integer.parseInt(resultado.getString("ID")));
                    usuario.setNome(resultado.getString("NOME"));
                    usuario.setCpf(resultado.getString("CPF"));
                    usuario.setSenha(resultado.getString("SENHA"));
                }
            }
            return usuario;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }
    
}

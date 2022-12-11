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
import model.Paciente;
import model.Usuario;

/**
 *
 * @author natyn
 */
public class PacienteDAO {
    
        public void Inserir(Paciente usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO paciente (nome, cpf, senha, idtipoplano)"
                    + " VALUES (?,?,?,?)");
            sql.setString(1, usuario.getNome());
            sql.setString(2, usuario.getCpf());
            sql.setString(3, usuario.getSenha());
            sql.setInt(4, Integer.valueOf(usuario.getIdtipoPlano()));
            System.out.println(sql);
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Paciente get(String id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM paciente WHERE ID = " + Integer.valueOf(id));
            ResultSet resultado = sql.executeQuery();
            Paciente usuario = new Paciente();
            System.out.println(sql);
            if (resultado != null) {
                while (resultado.next()) {
                    usuario.setId(resultado.getString("ID"));
                    usuario.setNome(resultado.getString("NOME"));
                    usuario.setCpf(resultado.getString("CPF"));
                    usuario.setSenha(resultado.getString("SENHA"));
                    usuario.setAutorizado(resultado.getString("AUTORIZADO"));
                    usuario.setIdTipoPlano(resultado.getString("IDTIPOPLANO"));
                }
            }
            return usuario;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Paciente usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE paciente SET id = ?, nome = ?, cpf = ?, senha = ?, autorizado = ?, idtipoplano = ? WHERE id = ? ");
            sql.setInt(1, Integer.valueOf(usuario.getId()));
            sql.setString(2, usuario.getNome());
            sql.setString(3, usuario.getCpf());
            sql.setString(4, usuario.getSenha());
            sql.setString(5, usuario.getAutorizado());
            sql.setInt(6, Integer.parseInt(usuario.getIdtipoPlano()));
            sql.setInt(7, Integer.valueOf(usuario.getId()));
            sql.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Autorizar(String id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE paciente SET autorizado = ? WHERE id = ? ");
            sql.setString(1, "S");
            sql.setString(2, id);
            sql.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }
    
    public void Desautorizar(String id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE paciente SET autorizado = ? WHERE id = ? ");
            sql.setString(1, "N");
            sql.setString(2, id);
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
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM paciente WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(id));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Paciente> ListaDePacientes() {
        ArrayList<Paciente> meusUsuarios = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM paciente order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Paciente usuario = new Paciente(resultado.getString("NOME"), resultado.getString("NOME"),
                            resultado.getString("CPF"),
                            resultado.getString("SENHA"), resultado.getString("AUTORIZADO"), resultado.getString("IDTIPOPLANO"));
                    usuario.setId(Integer.parseInt(resultado.getString("id")));
                    meusUsuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDePacientes) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusUsuarios;
    }

    public Usuario Logar(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM paciente WHERE cpf=? and senha =? LIMIT 1");
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

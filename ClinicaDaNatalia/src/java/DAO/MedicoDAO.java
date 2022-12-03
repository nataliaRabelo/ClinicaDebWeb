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
import model.Medico;
import model.Usuario;

/**
 *
 * @author natyn
 */
public class MedicoDAO {
    
            public void Inserir(Medico usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO medico (nome, cpf, senha, crm, estadocrm, autorizado, idespecialidade)"
                    + " VALUES (?,?,?,?,?,?,?,?)");
            sql.setString(1, usuario.getNome());
            sql.setString(2, usuario.getCpf());
            sql.setString(3, usuario.getSenha());
            sql.setString(4, usuario.getCrm());
            sql.setString(5, usuario.getEstadoCrm());
            sql.setString(6, usuario.getAutorizado());
            sql.setString(7, usuario.getIdEspecialidade());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            conexao.closeConexao();
        }
    }

    public Medico get(String id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM medico WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(id));
            ResultSet resultado = sql.executeQuery();
            Medico medico = new Medico();
            if (resultado != null) {
                while (resultado.next()) {
                    medico.setId(Integer.parseInt(resultado.getString("ID")));
                    medico.setNome(resultado.getString("NOME"));
                    medico.setCpf(resultado.getString("CPF"));
                    medico.setSenha(resultado.getString("SENHA"));
                    medico.setCrm(resultado.getString("CRM"));
                    medico.setEstadoCrm(resultado.getString("ESTADOCRM"));
                    medico.setAutorizado(resultado.getString("AUTORIZADO"));
                    medico.setIdEspecialidade(resultado.getString("IDESPECIALIDADE"));
                }
            }
            return medico;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Medico usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE medico SET id = ?, nome = ?, cpf = ?, senha = ?, crm = ?, estadocrm = ?, autorizado = ?, idespecialidade = ?  WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(usuario.getId()));
            sql.setString(2, usuario.getNome());
            sql.setString(3, usuario.getCpf());
            sql.setString(4, usuario.getSenha());
            sql.setString(5, usuario.getCrm());
            sql.setString(6, usuario.getEstadoCrm());
            sql.setString(7, usuario.getAutorizado());
            sql.setInt(8, Integer.valueOf(usuario.getIdEspecialidade()));
            sql.setInt(9, Integer.valueOf(usuario.getId()));

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
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM medico WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(id));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Medico> ListaDeMedicos() {
        ArrayList<Medico> meusUsuarios = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM medico order by nome";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Medico usuario = new Medico(resultado.getString("ID"), resultado.getString("NOME"),
                            resultado.getString("CPF"),
                            resultado.getString("SENHA"), 
                            resultado.getString("CRM"),
                            resultado.getString("ESTADOCRM"),
                            resultado.getString("AUTORIZADO"),
                            resultado.getString("IDESPECIALIDADE"));
                    meusUsuarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeMedicos) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return meusUsuarios;
    }

    public Usuario Logar(Usuario usuario) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM medico WHERE cpf=? and senha =? LIMIT 1");
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

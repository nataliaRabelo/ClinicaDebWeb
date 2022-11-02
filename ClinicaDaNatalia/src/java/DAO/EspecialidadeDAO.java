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
import model.Especialidade;
import model.TipoPlano;

/**
 *
 * @author natyn
 */
public class EspecialidadeDAO {
    
    public void Inserir(Especialidade especialidade) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO especialidade (id, descricao) VALUES (?,?)");
            sql.setString(1, especialidade.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (especialidade) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public Especialidade get(Especialidade especialidade) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM especialidade WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(especialidade.getId()));
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    especialidade.setId(resultado.getString("ID"));
                    especialidade.setDescricao(resultado.getString("DESCRICAO"));

                }
            }
            return especialidade;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get especialidade) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Especialidade especialidade) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE especialidade SET descricao = ? WHERE ID = ? ");
            sql.setString(1, especialidade.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar especialidade) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Especialidade especialidade) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM especialidade WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(especialidade.getId()));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir especialidade) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Especialidade> ListaDeEspecialidades() {
        ArrayList<Especialidade> especialidades = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM especialidade";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Especialidade especialidade = new Especialidade(resultado.getString("ID"), resultado.getString("DESCRICAO"));
                    especialidades.add(especialidade);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeEspecialidades) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return especialidades;
    }
    
}

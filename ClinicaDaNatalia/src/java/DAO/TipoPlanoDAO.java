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
import model.TipoPlano;

/**
 *
 * @author natyn
 */
public class TipoPlanoDAO {
    
    public void Inserir(TipoPlano tipoPlano) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO tipoplano (descricao) VALUES (?)");
            sql.setString(1, tipoPlano.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }

    public TipoPlano get(String id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM tipoplano WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(id));
            ResultSet resultado = sql.executeQuery();
            TipoPlano tipoPlano = new TipoPlano();
            if (resultado != null) {
                while (resultado.next()) {
                    tipoPlano.setId(resultado.getString("ID"));
                    tipoPlano.setDescricao(resultado.getString("DESCRICAO"));

                }
            }
            return tipoPlano;

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(TipoPlano tipoPlano) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE tipoplano SET descricao = ? WHERE id = ?");
            sql.setString(1, tipoPlano.getDescricao());
            sql.setString(2, tipoPlano.getId());
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
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM tipoplano WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(id));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<TipoPlano> ListaDePlanos() {
        ArrayList<TipoPlano> planos = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM tipoplano";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    TipoPlano tipoPlano = new TipoPlano(resultado.getString("ID"), resultado.getString("DESCRICAO"));
                    planos.add(tipoPlano);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeComentarios) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return planos;
    }

    
}

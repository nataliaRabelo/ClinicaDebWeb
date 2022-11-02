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
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO Comentarios (cometario, data, idusuario) VALUES (?,?,?)");
            sql.setString(1, tipoPlano.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public TipoPlano get(TipoPlano tipoPlano) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Comentarios WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(tipoPlano.getId()));
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    tipoPlano.setId(resultado.getString("ID"));
                    tipoPlano.setDescricao(resultado.getString("DESCRICAO"));

                }
            }
            return tipoPlano;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(TipoPlano tipoPlano) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Comentarios SET cometario = ?, data = ?, idusuario = ?, senha = ?  WHERE ID = ? ");
            sql.setString(1, tipoPlano.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(TipoPlano tipoPlano) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Comentarios WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(tipoPlano.getId()));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir comentario) incorreta");
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

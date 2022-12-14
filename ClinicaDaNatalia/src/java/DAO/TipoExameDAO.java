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
import model.TipoExame;

/**
 *
 * @author natyn
 */
public class TipoExameDAO {
    
        public void Inserir(TipoExame tipoExame) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO tipoexame (descricao) VALUES (?)");
            sql.setString(1, tipoExame.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (tipoexame) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public TipoExame get(TipoExame tipoExame) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Comentarios WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(tipoExame.getId()));
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    tipoExame.setId(resultado.getString("ID"));
                    tipoExame.setDescricao(resultado.getString("DESCRICAO"));

                }
            }
            return tipoExame;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(TipoExame tipoExame) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Comentarios SET cometario = ?, data = ?, idusuario = ?, senha = ?  WHERE ID = ? ");
            sql.setString(1, tipoExame.getDescricao());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(TipoExame tipoExame) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM Comentarios WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(tipoExame.getId()));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<TipoExame> ListaDeTipoExames() {
        ArrayList<TipoExame> tipoExames = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM tipoexame";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    TipoExame tipoExame = new TipoExame(resultado.getString("ID"), resultado.getString("DESCRICAO"));
                    tipoExames.add(tipoExame);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeTipoExames) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return tipoExames;
    }
    
}

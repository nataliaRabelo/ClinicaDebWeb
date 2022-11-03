/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Consulta;
import model.Especialidade;

/**
 *
 * @author natyn
 */
public class ConsultaDAO {
    
        public void Inserir(Consulta consulta) throws Exception {
        Conexao conexao = new Conexao();
        try {
                    
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        java.util.Date dataFormatada = formatoData.parse(consulta.getData());
        long dataFormatada2 = dataFormatada.getTime();
        Timestamp dataFormatada3 = new java.sql.Timestamp(dataFormatada2);
        PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO consulta (data, descricao, realizada, idmedico, idpaciente) VALUES (?,?,?,?,?,?)");
        sql.setTimestamp(1, dataFormatada3);
        sql.setString(2, consulta.getDescricao());
        sql.setString(3, consulta.getRealizada());
        sql.setInt(4, Integer.valueOf(consulta.getIdMedico()));
        sql.setInt(5, Integer.valueOf(consulta.getIdPaciente()));
        sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (consulta) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public Consulta get(Consulta consulta) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM consulta WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(consulta.getId()));
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    consulta.setId(resultado.getString("ID"));
                    consulta.setDescricao(resultado.getString("DATA"));
                    consulta.setDescricao(resultado.getString("DESCRICAO"));
                    consulta.setDescricao(resultado.getString("REALIZADA"));
                    consulta.setDescricao(resultado.getString("IDMEDICO"));
                    consulta.setDescricao(resultado.getString("IDPACIENTE"));

                }
            }
            return consulta;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get consulta) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Consulta consulta) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE consulta SET id = ? data = ? descricao = ? realizada = ? idmedico = ? idpaciente = ? WHERE ID = ? ");
            sql.setString(1, consulta.getId());
            sql.setTimestamp(2, Timestamp.valueOf(consulta.getData()));
            sql.setString(3, consulta.getDescricao());
            sql.setString(4, consulta.getRealizada());
            sql.setInt(5, Integer.valueOf(consulta.getIdMedico()));
            sql.setInt(6, Integer.valueOf(consulta.getIdPaciente()));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar consulta) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(Consulta consulta) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM consulta WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(consulta.getId()));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir consulta) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Consulta> ListaDeConsultas() {
        ArrayList<Consulta> consultas = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM consulta";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Consulta consulta = new Consulta(resultado.getString("ID"), resultado.getString("DATA"), resultado.getString("DESCRICAO"), resultado.getString("REALIZADA"), resultado.getString("IDMEDICO"), resultado.getString("IDPACIENTE"));
                    consultas.add(consulta);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeConsultas) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return consultas;
    }
}

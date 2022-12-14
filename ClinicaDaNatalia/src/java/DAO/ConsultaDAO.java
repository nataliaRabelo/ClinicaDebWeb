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
import java.time.LocalDateTime;
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
        
        String dataConsulta = consulta.getData() + ":00";
        Timestamp dataTimeStamp = Timestamp.valueOf(dataConsulta);
        PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO consulta (data, descricao, idmedico, idpaciente) VALUES (?,'-',?,?)");
        sql.setTimestamp(1, dataTimeStamp);
        sql.setInt(2, Integer.parseInt(consulta.getIdMedico()));
        sql.setInt(3, Integer.parseInt(consulta.getIdPaciente()));
        sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (consulta) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public Consulta get(String id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM consulta WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(id));
            ResultSet resultado = sql.executeQuery();
            Consulta consulta = new Consulta();
            if (resultado != null) {
                while (resultado.next()) {
                    consulta.setId(resultado.getString("ID"));
                    consulta.setData(resultado.getString("DATA"));
                    consulta.setDescricao(resultado.getString("DESCRICAO"));
                    consulta.setRealizada(resultado.getString("REALIZADA"));
                    consulta.setIdMedico(resultado.getString("IDMEDICO"));
                    consulta.setIdPaciente(resultado.getString("IDPACIENTE"));

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
            String dataConsulta = consulta.getData();
            Timestamp dataTimeStamp = null;
            try{
                dataTimeStamp = Timestamp.valueOf(dataConsulta);
            }catch(Exception e){
                dataTimeStamp = Timestamp.valueOf(dataConsulta + ":00");
            }
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE consulta SET id = ?, data = ?, descricao = ?, realizada = ?, idmedico = ?, idpaciente = ? WHERE id = ? ");
            sql.setInt(1, Integer.valueOf(consulta.getId()));
            sql.setTimestamp(2, dataTimeStamp);
            sql.setString(3, consulta.getDescricao());
            sql.setString(4, consulta.getRealizada());
            sql.setInt(5, Integer.parseInt(consulta.getIdMedico()));
            sql.setInt(6, Integer.parseInt(consulta.getIdPaciente()));
            sql.setInt(7, Integer.valueOf(consulta.getId()));
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
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM consulta WHERE ID = ? ");
            sql.setInt(1, Integer.parseInt(id));
            sql.executeUpdate();
            System.out.println(sql);

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
            throw new RuntimeException(e.getMessage());
        } finally {
            conexao.closeConexao();
        }
        return consultas;
    }
}

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
import static java.util.Collections.list;
import model.Exame;

/**
 *
 * @author natyn
 */
public class ExameDAO {
    
       public void Inserir(Exame exame) throws Exception {
        Conexao conexao = new Conexao();
        PreparedStatement sql = conexao.getConexao().prepareStatement("INSERT INTO exames (idtipoexame, idconsulta) VALUES (?, ?)");
        try {
            sql.setInt(1, Integer.valueOf(exame.getIdTipoExame()));
            sql.setInt(2, Integer.valueOf(exame.getIdConsulta()));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de insert (exame) incorreta");
        } finally {
			try {
                            sql.close();
			} catch (SQLException e2) {
                            System.out.println(e2.getMessage());
			}

			try {
                            conexao.closeConexao();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
    }

    public Exame get(Exame exame) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("SELECT * FROM Comentarios WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(exame.getId()));
            ResultSet resultado = sql.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    exame.setId(resultado.getString("ID"));
                    exame.setIdTipoExame(resultado.getString("IDTIPOEXAME"));
                    exame.setIdConsulta(resultado.getString("IDCONSULTA"));

                }
            }
            return exame;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }
    
    public ArrayList<Exame> getExamesFromIdConsulta(String id){
                Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM exames WHERE IDCONSULTA = " + Integer.valueOf(id);
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            ArrayList<Exame> exames = new ArrayList();
            if (resultado != null) {
                while (resultado.next()) {
                    Exame exame = new Exame(resultado.getString("ID"), resultado.getString("IDTIPOEXAME"), resultado.getString("IDCONSULTA"));
                    exames.add(exame);
                }
            }
            return exames;

        } catch (SQLException e) {
            throw new RuntimeException("Query de select (get comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Alterar(Exame exame) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("UPDATE Comentarios SET cometario = ?, data = ?, idusuario = ?, senha = ?  WHERE ID = ? ");
            sql.setString(1, exame.getIdConsulta());
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de update (alterar comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public void Excluir(String id) throws Exception {
        Conexao conexao = new Conexao();
        try {
            PreparedStatement sql = conexao.getConexao().prepareStatement("DELETE FROM exames WHERE ID = ? ");
            sql.setInt(1, Integer.valueOf(id));
            sql.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Query de delete (excluir comentario) incorreta");
        } finally {
            conexao.closeConexao();
        }
    }

    public ArrayList<Exame> ListaDeTipoExames() {
        ArrayList<Exame> exames = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM exames";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Exame tipoExame = new Exame(resultado.getString("ID"), resultado.getString("DESCRICAO"));
                    exames.add(tipoExame);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeExames) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return exames;
    }
    
        public ArrayList<Exame> ListaDeExames() {
        ArrayList<Exame> exames = new ArrayList();
        Conexao conexao = new Conexao();
        try {
            String selectSQL = "SELECT * FROM exames";
            PreparedStatement preparedStatement;
            preparedStatement = conexao.getConexao().prepareStatement(selectSQL);
            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado != null) {
                while (resultado.next()) {
                    Exame tipoExame = new Exame(resultado.getString("ID"), resultado.getString("IDTIPOEXAME"), resultado.getString("IDCONSULTA"));
                    exames.add(tipoExame);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Query de select (ListaDeExames) incorreta");
        } finally {
            conexao.closeConexao();
        }
        return exames;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author natyn
 */
public class Conexao {
    private Connection conexao;

    public Conexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //load driver  
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbjava", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException("Nao foi possivel efetuar uma conexao com o BD!");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Nao foi possivel encontrar a classe referente! Verifique o driver!");
        }
    }

    public Connection getConexao() {
        return this.conexao;
    }

    public void closeConexao() {
        try {
            this.conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

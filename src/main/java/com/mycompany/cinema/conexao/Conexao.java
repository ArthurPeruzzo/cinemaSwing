/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.conexao;

import com.mycompany.cinema.util.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Arthur
 */
public class Conexao {
    
     private Connection connection;
    private final String URL = "jdbc:postgresql://localhost:5432/cinema";
    private final String USUARIO = "postgres";
    private final String SENHA = "postgres";
    private static Conexao instancia;

    private Conexao() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("conectou");
        } catch (SQLException ex) {
            Util.gravarErro(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao conectar... " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Util.gravarErro(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Problemas com driver... " + ex.getMessage());
        }
    }

    public static Conexao getConexao() {
        if(instancia == null){
            instancia = new Conexao();
        }
        return instancia;
    }


    public Connection getConnection() {
        return connection;
    }
}

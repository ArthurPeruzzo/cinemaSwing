/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.dao;

import com.mycompany.cinema.conexao.Conexao;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Arthur
 */
public abstract class AbstractDao<T> {
    
        protected Connection connection;

    public abstract T insert(T object);

    public abstract List<T> findAll();

    public abstract boolean delete(int id);

    public abstract T findById(int id);

    public abstract boolean update(T object);

    public Connection getConexao()  {
        Conexao conexao = Conexao.getConexao();
        connection = conexao.getConnection();
        return connection;
    }
    
}

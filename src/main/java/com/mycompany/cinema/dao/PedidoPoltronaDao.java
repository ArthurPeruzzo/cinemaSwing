/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.dao;

import com.mycompany.cinema.entidade.*;
import com.mycompany.cinema.util.Util;

import javax.swing.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class PedidoPoltronaDao extends AbstractDao<PedidoPoltrona>{

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public PedidoPoltronaDao() {
        super.getConexao();
    }

    @Override
    public PedidoPoltrona insert(PedidoPoltrona pedido) {
        PedidoPoltrona pedidoSalvo = new PedidoPoltrona();
        try {
            if (pedido != null) {
                preparedStatement = super.connection.prepareStatement("insert into pedido_poltrona (poltronaid, pedidoid) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, pedido.getPoltrona().getId());
                preparedStatement.setLong(2, pedido.getPedido().getId());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    pedidoSalvo.setId(resultSet.getLong("id"));
                    pedidoSalvo.setPoltrona(new Poltrona(resultSet.getLong("poltronaid")));
                    pedidoSalvo.setPedido(new Pedido(resultSet.getLong("pedidoid")));
                }
            }
        } catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return pedidoSalvo;
    }

    @Override
    public List<PedidoPoltrona> findAll() {
        return null;
    }

    @Override
    public boolean delete(Long id) {
       return false;
    }

    @Override
    public PedidoPoltrona findById(Long id) {
        return null;
    }

    @Override
    public boolean update(PedidoPoltrona object) {
        return false;
    }



}

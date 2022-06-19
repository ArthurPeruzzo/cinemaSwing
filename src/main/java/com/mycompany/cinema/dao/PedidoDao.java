/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.dao;

import com.mycompany.cinema.entidade.*;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class PedidoDao extends AbstractDao<Pedido>{

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public PedidoDao() {
        super.getConexao();
    }

    @Override
    public Pedido insert(Pedido pedido) {
        Pedido pedidoSalvo = new Pedido();
        try {
            if (pedido != null) {
                preparedStatement = super.connection.prepareStatement("insert into pedido (salaid, filmeid, pessoaid, datahora, status, poltronaid) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, pedido.getSala().getId());
                preparedStatement.setLong(2, pedido.getFilme().getId());
                preparedStatement.setLong(3, pedido.getPessoa().getId());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(dateTimeFormatter.format(pedido.getDataHora())));
                preparedStatement.setString(5, String.valueOf(pedido.getStatus()));
                preparedStatement.setLong(6, pedido.getPoltrona().getId());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    pedidoSalvo.setId(resultSet.getLong("id"));
                    pedidoSalvo.setSala(new Sala(resultSet.getLong("salaid")));
                    pedidoSalvo.setFilme(new Filme(resultSet.getLong("filmeid")));
                    pedidoSalvo.setPessoa(new Pessoa(resultSet.getLong("pessoaid")));
                    pedidoSalvo.setDataHora(resultSet.getTimestamp("datahora").toLocalDateTime());
                    pedidoSalvo.setStatus(StatusPedido.valueOf(resultSet.getString("status")));
                    pedidoSalvo.setPoltrona(new Poltrona(resultSet.getLong("poltronaid")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidoSalvo;
    }

    @Override
    public List<Pedido> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Pedido findById(int id) {
        return null;
    }

    @Override
    public boolean update(Pedido object) {
        return false;
    }



}

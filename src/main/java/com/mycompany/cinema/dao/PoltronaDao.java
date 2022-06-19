/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.dao;

import com.mycompany.cinema.entidade.*;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class PoltronaDao extends AbstractDao<Poltrona>{

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public PoltronaDao() {
        super.getConexao();
    }

    @Override
    public Poltrona insert(Poltrona pedido) {
        Poltrona pedidoSalvo = new Poltrona();
        if (pedido != null) {
//                preparedStatement = super.connection.prepareStatement("insert into pedido (salaid, filmeid, pessoaid, datahora, status, poltronaid) values (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//                preparedStatement.setLong(1, pedido.getSala().getId());
//                preparedStatement.setLong(2, pedido.getFilme().getId());
//                preparedStatement.setLong(3, pedido.getPessoa().getId());
//                preparedStatement.setTimestamp(4, Timestamp.valueOf(dateTimeFormatter.format(pedido.getDataHora())));
//                preparedStatement.setString(5, String.valueOf(pedido.getStatus()));
//                preparedStatement.setLong(6, pedido.getPoltrona().getId());
//                preparedStatement.executeUpdate();
//                resultSet = preparedStatement.getGeneratedKeys();
//                while (resultSet.next()) {
//                    pedidoSalvo.setId(resultSet.getLong("id"));
//                    pedidoSalvo.setSala(new Sala(resultSet.getLong("salaid")));
//                    pedidoSalvo.setFilme(new Filme(resultSet.getLong("filmeid")));
//                    pedidoSalvo.setPessoa(new Pessoa(resultSet.getLong("pessoaid")));
//                    pedidoSalvo.setDataHora(resultSet.getTimestamp("datahora").toLocalDateTime());
//                    pedidoSalvo.setStatus(StatusPoltrona.valueOf(resultSet.getString("status")));
//                    pedidoSalvo.setPoltrona(new Poltrona(resultSet.getLong("poltronaid")));
//                }
        }
        return pedidoSalvo;
    }

    @Override
    public List<Poltrona> findAll() {
        List<Poltrona> poltronas = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from poltrona p");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Poltrona poltrona = new Poltrona();
                poltrona.setId(resultSet.getLong(1));
                poltrona.setCodigo(resultSet.getString(2));
                poltronas.add(poltrona);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return poltronas;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Poltrona findById(int id) {
        return null;
    }

    @Override
    public boolean update(Poltrona object) {
        return false;
    }

    public List<Poltrona> buscaPoltronasIndisponiveis(){
        List<Poltrona> poltronas = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select distinct p2.* from pedido p \n" +
                    "inner join horario_sessao hs on p.filmeid = hs.filmeid and hs.salaid = p.salaid \n" +
                    "inner join sala s on s.id = p.salaid\n" +
                    "inner join pedido_poltrona pp on pp.pedidoid = p.id\n" +
                    "inner join poltrona p2 on p2.id = pp.poltronaid\n" +
                    "where p.status = 'PAGO' and\n" +
                    "p.filmeid = 5 and\n" +
                    "hs.data = '2022-05-06'");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Poltrona poltrona = new Poltrona();
                poltrona.setId(resultSet.getLong(1));
                poltrona.setCodigo(resultSet.getString(2));
                poltronas.add(poltrona);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poltronas;
    }

}

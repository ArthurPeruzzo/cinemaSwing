/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinema.dao;

import com.mycompany.cinema.entidade.*;

import javax.swing.*;
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

    public PoltronaDao() {
        super.getConexao();
    }

    @Override
    public Poltrona insert(Poltrona poltrona) {
        Poltrona poltronaSalva = new Poltrona();
        try {
            if (poltrona != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO poltrona (codigo) values (?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, poltrona.getCodigo());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    poltronaSalva.setId(resultSet.getLong("id"));
                    poltronaSalva.setCodigo(resultSet.getString("codigo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poltronaSalva;
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
    public boolean delete(Long id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM poltrona WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não é possível excluir a poltrona pois já existe um pedido vinculada a ela.");
            return false;
        }
    }

    @Override
    public Poltrona findById(Long id) {
        Poltrona poltrona = new Poltrona();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM poltrona WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                poltrona.setId(resultSet.getLong("id"));
                poltrona.setCodigo(resultSet.getString("codigo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return poltrona;
    }

    @Override
    public boolean update(Poltrona poltrona) {
        try {
            if (poltrona != null) {
                preparedStatement = super.connection.prepareStatement("update poltrona set codigo = ? where id = ?;", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, poltrona.getCodigo());
                preparedStatement.setLong(2, poltrona.getId());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Poltrona> buscaPoltronasIndisponiveis(Long filmeId, Long salaId){
        List<Poltrona> poltronas = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select distinct p2.* from pedido p \n" +
                    "inner join horario_sessao hs on p.filmeid = hs.filmeid and p.salaid = hs.salaid " +
                    "inner join pedido_poltrona pp on pp.pedidoid = p.id\n" +
                    "inner join poltrona p2 on p2.id = pp.poltronaid\n" +
                    "where p.filmeid = ? and\n" +
                    "p.salaid = ? and\n" +
                    "hs.\"data\" > CURRENT_DATE");
            preparedStatement.setLong(1, filmeId);
            preparedStatement.setLong(2, salaId);
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

package com.mycompany.cinema.dao;

import com.mycompany.cinema.entidade.Sala;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDao extends AbstractDao<Sala> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public SalaDao() {
        super.getConexao();
    }

    @Override
    public Sala insert(Sala sala) {
        Sala salaSalva = new Sala();
        try {
            if (sala != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO sala (codigo) values (?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, sala.getCodigo());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                while (resultSet.next()) {
                    salaSalva.setId(resultSet.getLong("id"));
                    salaSalva.setCodigo(resultSet.getString("codigo"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return salaSalva;
    }

    @Override
    public List<Sala> findAll() {
        List<Sala> salas = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from sala f");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Sala sala = new Sala();
                sala.setId(resultSet.getLong("id"));
                sala.setCodigo(resultSet.getString("codigo"));
                salas.add(sala);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return salas;
    }

    @Override
    public boolean delete(Long id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM sala WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir. A sala possui vínculos com horários ou pedidos.");
            return false;
        }
    }

    @Override
    public Sala findById(Long id) {
        Sala sala = new Sala();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM sala WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sala.setId(resultSet.getLong("id"));
                sala.setCodigo(resultSet.getString("codigo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sala;
    }

    @Override
    public boolean update(Sala sala) {
        try {
            if (sala != null) {
                preparedStatement = super.connection.prepareStatement("update sala set codigo = ? where id = ?;", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, sala.getCodigo());
                preparedStatement.setLong(2, sala.getId());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

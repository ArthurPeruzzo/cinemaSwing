package com.mycompany.cinema.dao;

import com.mycompany.cinema.entidade.Filme;
import com.mycompany.cinema.util.Util;

import javax.swing.*;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FilmeDao extends AbstractDao<Filme> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    public FilmeDao() {
        super.getConexao();
    }

    @Override
    public Filme insert(Filme filme) {
        Filme filmeSalvo = new Filme();
        try {
            if (filme != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO filme (nome, estreia) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, filme.getNome());
                preparedStatement.setTimestamp(2, Timestamp.valueOf(dateTimeFormatter.format(filme.getDataHoraEstreia())));
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();

                while (resultSet.next()) {
                    filmeSalvo.setId(resultSet.getLong("id"));
                    filmeSalvo.setNome(resultSet.getString("nome"));
                    filmeSalvo.setDataHoraEstreia(resultSet.getTimestamp("estreia").toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return filmeSalvo;
    }

    @Override
    public List<Filme> findAll() {
        List<Filme> filmes = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select * from filme f");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Filme filme = new Filme();
                filme.setId(resultSet.getLong("id"));
                filme.setNome(resultSet.getString("nome"));
                filme.setDataHoraEstreia(resultSet.getTimestamp("estreia").toLocalDateTime());
                filmes.add(filme);
            }
        }catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return filmes;
    }

    @Override
    public boolean delete(Long id) {
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM filme WHERE id = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Util.gravarErro(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao excluir. O filme possui v??nculos com hor??rios ou pedidos.");
            return false;
        }
    }

    @Override
    public Filme findById(Long id) {
        Filme filme = new Filme();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM filme WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                filme.setId(resultSet.getLong("id"));
                filme.setNome(resultSet.getString("nome"));
                filme.setDataHoraEstreia(resultSet.getTimestamp("estreia").toLocalDateTime());
            }
        } catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return filme;
    }

    @Override
    public boolean update(Filme filme) {
        try {
            if (filme != null) {
                preparedStatement = super.connection.prepareStatement("update filme set nome = ?, estreia = ? where id = ?;", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, filme.getNome());
                preparedStatement.setTimestamp(2, Timestamp.valueOf(dateTimeFormatter.format(filme.getDataHoraEstreia())));
                preparedStatement.setLong(3, filme.getId());
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();
                return true;
            }
        } catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return false;
    }
}

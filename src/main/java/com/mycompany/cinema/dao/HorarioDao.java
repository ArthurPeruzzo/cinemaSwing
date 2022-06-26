package com.mycompany.cinema.dao;

import com.mycompany.cinema.entidade.Filme;
import com.mycompany.cinema.entidade.HorarioSessao;
import com.mycompany.cinema.entidade.Sala;
import com.mycompany.cinema.util.Util;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HorarioDao extends AbstractDao<HorarioSessao> {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public HorarioDao() {
        super.getConexao();
    }

    @Override
    public HorarioSessao insert(HorarioSessao horarioSessao) {
        HorarioSessao horarioSessaoSalvo = new HorarioSessao();
        try {
            if (horarioSessao != null) {
                preparedStatement = super.connection.prepareStatement("INSERT INTO horario_sessao (salaid, filmeid, data, hora) values (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setLong(1, horarioSessao.getSala().getId());
                preparedStatement.setLong(2, horarioSessao.getFilme().getId());
                preparedStatement.setDate(3, Date.valueOf(horarioSessao.getData()));
                preparedStatement.setTime(4, Time.valueOf(timeFormatter.format(horarioSessao.getHora())));
                preparedStatement.executeUpdate();
                resultSet = preparedStatement.getGeneratedKeys();

                while (resultSet.next()) {
                    horarioSessao.setSala(new Sala(resultSet.getLong("salaid")));
                    horarioSessao.setFilme(new Filme(resultSet.getLong("filmeid")));
                    horarioSessao.setData(resultSet.getDate("data").toLocalDate());
                    horarioSessao.setHora(resultSet.getTime("hora").toLocalTime());
                }
            }
        } catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return horarioSessaoSalvo;
    }

    @Override
    public List<HorarioSessao> findAll() {
        List<HorarioSessao> horarioSessaos = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select f.*, s.codigo, fi.nome from horario_sessao f " +
                    "inner join sala s on s.id = f.salaid " +
                    "inner join filme fi on fi.id = f.filmeid");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HorarioSessao horarioSessao = new HorarioSessao();
                horarioSessao.setSala(new Sala(resultSet.getLong("salaid")));
                horarioSessao.setFilme(new Filme(resultSet.getLong("filmeid")));
                horarioSessao.setData(resultSet.getDate("data").toLocalDate());
                horarioSessao.setHora(resultSet.getTime("hora").toLocalTime());
                horarioSessao.getSala().setCodigo(resultSet.getString("codigo"));
                horarioSessao.getFilme().setNome(resultSet.getString("nome"));

                horarioSessaos.add(horarioSessao);
            }
        }catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return horarioSessaos;
    }

    @Override
    public boolean delete(Long id) {
       return false;
    }

    public boolean deleteHorarioSessao(HorarioSessao horarioSessao){
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM horario_sessao WHERE salaid = ? and filmeid = ? and data = ? and hora = ?");
            preparedStatement.setLong(1, horarioSessao.getSala().getId());
            preparedStatement.setLong(2, horarioSessao.getFilme().getId());
            preparedStatement.setDate(3, Date.valueOf(horarioSessao.getData()));
            preparedStatement.setTime(4, Time.valueOf(timeFormatter.format(horarioSessao.getHora())));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Util.gravarErro(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao excluir.");
            return false;
        }
    }

    @Override
    public HorarioSessao findById(Long id) {
        HorarioSessao horarioSessao = new HorarioSessao();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM horario_sessao WHERE id = ?");
            preparedStatement.setLong(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                horarioSessao.setSala(new Sala(resultSet.getLong("salaid")));
                horarioSessao.setFilme(new Filme(resultSet.getLong("filmeid")));
                horarioSessao.setData(resultSet.getDate("data").toLocalDate());
                horarioSessao.setHora(resultSet.getTime("hora").toLocalTime());
            }
        } catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return horarioSessao;
    }

    public HorarioSessao findBySalaAndFilme(Long salaId, Long filmeId) {
        HorarioSessao horarioSessao = new HorarioSessao();
        try {
            preparedStatement = super.connection.prepareStatement("select f.*, s.codigo, fi.nome from horario_sessao f " +
                    "inner join sala s on s.id = f.salaid " +
                    "inner join filme fi on fi.id = f.filmeid " +
                    "where f.salaid = ? " +
                    "and f.filmeid = ?;");
            preparedStatement.setLong(1, salaId);
            preparedStatement.setLong(2, filmeId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                horarioSessao.setSala(new Sala(resultSet.getLong("salaid")));
                horarioSessao.setFilme(new Filme(resultSet.getLong("filmeid")));
                horarioSessao.setData(resultSet.getDate("data").toLocalDate());
                horarioSessao.setHora(resultSet.getTime("hora").toLocalTime());
                horarioSessao.getSala().setCodigo(resultSet.getString("codigo"));
                horarioSessao.getFilme().setNome(resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return horarioSessao;
    }

    @Override
    public boolean update(HorarioSessao object) {
        return false;
    }

    public List<HorarioSessao> buscaHorariosPeloFilmeEDataMaiorQueAtual(Filme filme){
        List<HorarioSessao> horarioSessaos = new ArrayList<>();
        try {
            preparedStatement = super.connection.prepareStatement("select f.*, s.codigo, fi.nome from horario_sessao f " +
                    "inner join sala s on s.id = f.salaid " +
                    "inner join filme fi on fi.id = f.filmeid "+
                    "where fi.id = ? " +
                    "and f.\"data\" > CURRENT_DATE");
            preparedStatement.setLong(1, filme.getId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HorarioSessao horarioSessao = new HorarioSessao();
                horarioSessao.setSala(new Sala(resultSet.getLong("salaid")));
                horarioSessao.setFilme(new Filme(resultSet.getLong("filmeid")));
                horarioSessao.setData(resultSet.getDate("data").toLocalDate());
                horarioSessao.setHora(resultSet.getTime("hora").toLocalTime());
                horarioSessao.getSala().setCodigo(resultSet.getString("codigo"));
                horarioSessao.getFilme().setNome(resultSet.getString("nome"));

                horarioSessaos.add(horarioSessao);
            }
        }catch (SQLException e) {
            Util.gravarErro(e.getMessage());
        }
        return horarioSessaos;
    }

}

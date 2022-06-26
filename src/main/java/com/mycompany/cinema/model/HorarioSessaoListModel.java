package com.mycompany.cinema.model;

import com.mycompany.cinema.entidade.HorarioSessao;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class HorarioSessaoListModel extends AbstractTableModel {

    private List<HorarioSessao> horariosSessao;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final String[] colunas = new String[]{"Sala", "Filme", "Data", "Hora"};

    public HorarioSessaoListModel(List<HorarioSessao> horariosSessao) {
        this.horariosSessao = horariosSessao;
    }

    @Override
    public int getRowCount() {
        return horariosSessao.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HorarioSessao horarioSessao = horariosSessao.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return horarioSessao.getSala().getCodigo();
            case 1:
                return horarioSessao.getFilme().getNome();
            case 2:
                return dateFormatter.format(horarioSessao.getData());
            case 3:
                return timeFormatter.format(horarioSessao.getHora());
            default:
                break;
        }
        return horarioSessao;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public HorarioSessao getHorarioSessaoPorLinha(int linha){
        return horariosSessao.get(linha);
    }

}

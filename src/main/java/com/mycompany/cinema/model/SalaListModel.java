package com.mycompany.cinema.model;

import com.mycompany.cinema.entidade.Sala;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SalaListModel extends AbstractTableModel {

    private List<Sala> salas;

    private final String[] colunas = new String[]{"Id", "Código"};

    public SalaListModel(List<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public int getRowCount() {
        return salas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sala sala = salas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sala.getId();
            case 1:
                return sala.getCodigo();
            default:
                break;
        }
        return sala;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}

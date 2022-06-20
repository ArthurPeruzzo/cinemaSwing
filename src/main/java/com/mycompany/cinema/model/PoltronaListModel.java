package com.mycompany.cinema.model;

import com.mycompany.cinema.entidade.Poltrona;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PoltronaListModel extends AbstractTableModel {

    private List<Poltrona> poltronas;

    private final String[] colunas = new String[]{"Id", "Código"};

    public PoltronaListModel(List<Poltrona> poltronas) {
        this.poltronas = poltronas;
    }

    @Override
    public int getRowCount() {
        return poltronas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Poltrona poltrona = poltronas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return poltrona.getId();
            case 1:
                return poltrona.getCodigo();
            default:
                break;
        }
        return poltrona;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

}

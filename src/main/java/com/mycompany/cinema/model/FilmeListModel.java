package com.mycompany.cinema.model;

import com.mycompany.cinema.entidade.Filme;

import javax.swing.table.AbstractTableModel;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FilmeListModel extends AbstractTableModel {

    private List<Filme> filmes;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final String[] colunas = new String[]{"Código", "Nome", "Data da estreia", "Data da pré-estreia" };

    public FilmeListModel(List<Filme> filmes) {
        this.filmes = filmes;
    }

    @Override
    public int getRowCount() {
        return filmes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filme filme = filmes.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return filme.getId();
            case 1:
                return filme.getNome();
            case 2:
                return dateTimeFormatter.format(filme.getDataHoraEstreia());
            case 3:
                return dateTimeFormatter.format(filme.getDataHoraPreEstreia());
            default:
                break;
        }
        return filme;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(Filme filme) {
        filmes.add(filme);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        filmes.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, Filme filme) {
        filmes.set(indiceLinha, filme);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}

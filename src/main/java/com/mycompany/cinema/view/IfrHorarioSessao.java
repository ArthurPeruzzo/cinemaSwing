
package com.mycompany.cinema.view;

import com.mycompany.cinema.dao.FilmeDao;
import com.mycompany.cinema.dao.HorarioDao;
import com.mycompany.cinema.dao.SalaDao;
import com.mycompany.cinema.entidade.Filme;
import com.mycompany.cinema.entidade.HorarioSessao;
import com.mycompany.cinema.entidade.Sala;
import com.mycompany.cinema.model.HorarioSessaoListModel;
import com.mycompany.cinema.util.Util;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

public class IfrHorarioSessao extends JInternalFrame {
    private final HorarioDao horarioDao = new HorarioDao();
    private final SalaDao salaDao = new SalaDao();
    private final FilmeDao filmeDao = new FilmeDao();
    private final DateTimeFormatter dateTimeFormatterData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DateTimeFormatter dateTimeFormatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    private HorarioSessaoListModel horarioSessaoListModel = null;


    public IfrHorarioSessao() {
        initComponents();
        super.setTitle("Cadastro de Horário de sessão");
        buscaSalas();
        buscaFilmes();
        atualizaListaDeHorarioSessaos();

    }

    private void buscaSalas() {
        List<Sala> salas = salaDao.findAll();
        if(!Util.listNuloOuVazio(salas)){
            salas.forEach(s -> sala.addItem(s));
        }
    }

    private void buscaFilmes() {
        List<Filme> filmes = filmeDao.findAll();
        if(!Util.listNuloOuVazio(filmes)){
            filmes.forEach(f -> filme.addItem(f));
        }
    }

    public void atualizaListaDeHorarioSessaos(){
        List<HorarioSessao> horariosSessao = horarioDao.findAll();
        horarioSessaoListModel = new HorarioSessaoListModel(horariosSessao);
        limpaForm();
        jTable1.setModel(horarioSessaoListModel);
    }

    private void limpaForm() {
        data.setText(null);
        hora.setText(null);
        filme.setSelectedIndex(-1);
        sala.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        sala = new javax.swing.JComboBox<>();
        filme = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        limparForm = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        fechar = new javax.swing.JButton();
        data = new javax.swing.JFormattedTextField();
        hora = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel8.setText("Sala");

        sala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaActionPerformed(evt);
            }
        });

        filme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filmeActionPerformed(evt);
            }
        });

        jLabel1.setText("Filme");

        jLabel2.setText("Data");

        jLabel3.setText("Hora");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sala, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filme, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("Lista de horários");

        jButton4.setText("Remover");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        limparForm.setText("Limpar");
        limparForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(limparForm)
                        .addGap(8, 8, 8))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(limparForm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(61, 61, 61))
        );

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        fechar.setText("Fechar");
        fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharActionPerformed(evt);
            }
        });
        jPanel4.add(fechar);

        data.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm:ss"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        save();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void salaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaActionPerformed
    }//GEN-LAST:event_salaActionPerformed

    private void filmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filmeActionPerformed
    }//GEN-LAST:event_filmeActionPerformed

    private void fecharActionPerformed(java.awt.event.ActionEvent evt) {                                       
        limpaForm();
        this.dispose();
    }

    private void limparFormActionPerformed(java.awt.event.ActionEvent evt) {                                           
        limpaForm();
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        int linhaSelecionada = jTable1.getSelectedRow();
        if (linhaSelecionada >= 0) {
            int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir a sala selecionada?",
                    "Exclusão",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcao == JOptionPane.YES_OPTION) {
                HorarioSessao horarioSessao = horarioSessaoListModel.getHorarioSessaoPorLinha(linhaSelecionada);
                if(horarioDao.deleteHorarioSessao(horarioSessao)){
                    JOptionPane.showMessageDialog(null, "HorarioSessao excluída com sucesso!");
                }

                atualizaListaDeHorarioSessaos();
                }
            }
        else {
            JOptionPane.showMessageDialog(null, "SELECIONE UM REGISTRO!");
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField data;
    private javax.swing.JButton fechar;
    private javax.swing.JComboBox<Filme> filme;
    private javax.swing.JFormattedTextField hora;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton limparForm;
    private javax.swing.JComboBox<Sala> sala;
    // End of variables declaration//GEN-END:variables

    private HorarioSessao getHorarioSessao() {
        HorarioSessao horarioSessao = null;
        if(!Objects.isNull(sala.getSelectedItem()) && !Objects.isNull(filme.getSelectedItem()) &&
            !data.getText().equals("") && !hora.getText().equals("")){
            horarioSessao = new HorarioSessao();
                horarioSessao.setSala(new Sala(sala.getSelectedItem()));
                horarioSessao.setFilme(new Filme(filme.getSelectedItem()));
                horarioSessao.setHora(LocalTime.parse(hora.getText(), dateTimeFormatterHora));
                horarioSessao.setData(LocalDate.parse(data.getText(), dateTimeFormatterData));
        }
        return horarioSessao;
    }

    private void save() {
        HorarioSessao horarioSessao = getHorarioSessao();
        if (horarioSessao != null) {
            horarioDao.insert(horarioSessao);
        }
        atualizaListaDeHorarioSessaos();
    }
}

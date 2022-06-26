package com.mycompany.cinema.util;

import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public  class Util {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    
       public static void centralizarFrame(JInternalFrame jInternalFrame) {
        jInternalFrame.setLocation(
                (jInternalFrame.getDesktopPane().getSize().width - jInternalFrame.getSize().width) / 2,
                (jInternalFrame.getDesktopPane().getSize().height - jInternalFrame.getSize().height) / 2);
    }

    public static boolean listNuloOuVazio(Collection<?> collection){
           return collection == null || collection.isEmpty();
    }

    public static void gravarErro( String erro) {
        File file = new File(System.getProperty("user.dir") + "/src/erros.txt");

        try (OutputStream output = new FileOutputStream(file); DataOutputStream data = new DataOutputStream(output)) {
            data.writeUTF(dtf.format(LocalDateTime.now()) + " - (ERROR) - " + erro);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
    }
}

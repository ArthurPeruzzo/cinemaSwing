/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cinema.util;

import javax.swing.*;
import java.util.Collection;

/**
 *
 * @author Andreia
 */
public  class Util {
    
       public static void centralizarFrame(JInternalFrame jInternalFrame) {
        jInternalFrame.setLocation(
                (jInternalFrame.getDesktopPane().getSize().width - jInternalFrame.getSize().width) / 2,
                (jInternalFrame.getDesktopPane().getSize().height - jInternalFrame.getSize().height) / 2);
    }

    public static boolean nuloOuVazio(Collection<?> collection){
           return collection == null || collection.isEmpty();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import Ventanas.IniciarSesion;
import Ventanas.SistemaB;
import javax.swing.JOptionPane;

/**
 *
 * @author HP 245 G4
 */
public class BibliotecaUBI {

    public static void main(String args[]) {
    
        SistemaB s = new SistemaB();
        IniciarSesion ini = new IniciarSesion();
        s.setVisible(true);
        try {
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(100);
                s.jProgressBar1.setValue(i);
                s.progreso.setText(i + "%");

                if (i == 100) {
                    s.setVisible(false);
                    ini.setVisible(true);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

}

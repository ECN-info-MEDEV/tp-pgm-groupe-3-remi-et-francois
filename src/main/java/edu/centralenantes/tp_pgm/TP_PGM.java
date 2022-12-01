/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.centralenantes.tp_pgm;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author inky19
 */
public class TP_PGM {

    public static void main(String[] args) {
        JFileChooser fileExplorer = new JFileChooser();
        int res = fileExplorer.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION){
            File file = fileExplorer.getSelectedFile();
            try {
                ImagePGM img = new ImagePGM(file);
            } catch (Exception ex) {
                Logger.getLogger(TP_PGM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}

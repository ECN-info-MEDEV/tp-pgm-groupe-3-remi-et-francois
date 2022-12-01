/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package edu.centralenantes.tp_pgm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author inky19
 */
public class Image {

    private int[][] bitmap;
    private final int width;
    private final int height;
    private final int maxLevel;
    private static final String SEP = " ";
    
    public Image(File file) throws FileNotFoundException, IOException, Exception{
        BufferedReader reader = new BufferedReader(new FileReader(file)); 
        String line = reader.readLine(); // Ligne P2
        line = reader.readLine();        // Ligne de commentaire
        line = reader.readLine();        // Ligne de dimensions
        String[] dataLine = line.split(SEP);
        width = Integer.parseInt(dataLine[0]);
        height = Integer.parseInt(dataLine[1]);
        bitmap = new int[width][height];
        line = reader.readLine();
        maxLevel = Integer.parseInt(line);
        line = reader.readLine();
        dataLine = line.split(SEP);
        int ind = 0;
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                if (ind>=dataLine.length){
                    ind = 0;
                    line = reader.readLine();
                    if (line.isEmpty()){
                        throw new Exception("La taille déclarée ("+width+"x"+height+") ne correspond pas. Le fichier est peut être corrompu");
                    }
                    dataLine = line.split(SEP);
                    System.out.println("DATA SIZE = " + dataLine.length);
                }
                while(ind < dataLine.length && dataLine[ind].isEmpty()){
                    ind++;
                }
                if (!dataLine[ind].isEmpty()){
                    System.out.println(line);
                    System.out.println(dataLine[ind]);
                    bitmap[i][j]=Integer.parseInt(dataLine[ind]);
                }

                ind++;
            }
        }
    }       

    public int[][] getBitmap() {
        return bitmap;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getMaxLevel() {
        return maxLevel;
    }
    
}

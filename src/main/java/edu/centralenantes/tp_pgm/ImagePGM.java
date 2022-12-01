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
public class ImagePGM {

    private int[][] bitmap;                // Matrice des pixels
    private final int width;               // Largeur de l'image
    private final int height;              // Hauteur de l'image
    private final int maxLevel;            // Niveau maximum de gris
    private static final String SEP = " "; // Délimiteur dans le format de fichier .pgm
    
    /**
     *
     * @param file Fichier à charger
     * @throws FileNotFoundException
     * @throws IOException
     * @throws Exception
     */
    public ImagePGM(File file) throws FileNotFoundException, IOException, Exception{
        BufferedReader reader = new BufferedReader(new FileReader(file)); 
        String line = reader.readLine(); // Ligne P2
        line = reader.readLine();        // Ligne de commentaire
        line = reader.readLine();        // Ligne de dimensions
        String[] dataLine = line.split(SEP);
        int ind = 0; // Indice pour parcourir une ligne de données du fichier
        // Les boucles while ont pour but de gérer les espaces inutiles sur la ligne de dimensions
        while(dataLine[ind].isEmpty()){
            ind++;
        }
        width = Integer.parseInt(dataLine[ind]);
        ind++;
        while(dataLine[ind].isEmpty()){
            ind++;
        }
        height = Integer.parseInt(dataLine[ind]);
        bitmap = new int[width][height];
        line = reader.readLine();
        maxLevel = Integer.parseInt(line);
        line = reader.readLine();
        dataLine = line.split(SEP);
        ind = 0;
        for (int i=0; i<width; i++){
            for (int j=0; j<height; j++){
                if (ind>=dataLine.length){ // Passe à la ligne suivante dans le fichier
                    ind = 0;
                    line = reader.readLine();
                    if (line.isEmpty()){
                        throw new Exception("La taille déclarée ("+width+"x"+height+") ne correspond pas. Le fichier est peut être corrompu");
                    }
                    dataLine = line.split(SEP);
                }
                while(ind < dataLine.length && dataLine[ind].isEmpty()){ // Permet de gérer les doubles espaces ou les espaces en début de ligne
                    ind++;
                }
                if (!dataLine[ind].isEmpty()){ // Condition pour gérer les espaces en fin de ligne
                    bitmap[i][j]=Integer.parseInt(dataLine[ind]);
                }
                ind++;
            }
        }
    }       

    /**
     *
     * @return Matrice de pixels
     */
    public int[][] getBitmap() {
        return bitmap;
    }

    /**
     *
     * @return Largeur de l'image
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return Hauteur de l'image
     */
    public int getHeight() {
        return height;
    }

    /**
     *
     * @return Niveau maximum de gris
     */
    public int getMaxLevel() {
        return maxLevel;
    }
    
}

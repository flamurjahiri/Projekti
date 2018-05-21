package Projekti;

import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Flamur
 */
public class Receta2 {
    public File f2;

    public FileReader fr2;
    public BufferedReader br2;

    public FileWriter fw2;
    public BufferedWriter bw2;

    public Receta2() throws FileNotFoundException, IOException {
        f2 = new File(System.getProperty("user.dir") + "\\Receta2.txt");
        if(!f2.exists()){
            f2.createNewFile();
        }
        fr2 = new FileReader(f2);
        br2 = new BufferedReader(fr2);
        fw2 = new FileWriter(f2, true);
        bw2 = new BufferedWriter(fw2);
    }

    public void shkruajeReceten2() throws IOException {
        RecetMapper rm = new RecetMapper();
        String line;
        while ((line = rm.br.readLine()) != null) {
            bw2.write(line);
            bw2.newLine();
            bw2.flush();
        }
        bw2.close();
    }

    public void ClearReceten2() throws IOException {
        File f4 = new File(System.getProperty("user.dir") + "\\Receta2.txt");
        if(!f4.exists()){
            f4.createNewFile();
        }
        FileWriter fw4 = new FileWriter(f4);
        FileReader fr4 = new FileReader(f4);
        BufferedReader br4 = new BufferedReader(fr4);
        BufferedWriter bw4 = new BufferedWriter(fw4);
        bw4.write("");
        bw4.flush();
        bw4.close();
    }
}

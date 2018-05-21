package Projekti;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Flamur
 */

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author flamurjahiri
 */
public class RecetMapper {
    public BufferedReader br;
    public FileReader fr;
    public FileWriter fw;
    public BufferedWriter bw;
    public File f;
    public ArrayList<String> Recetat;
    public String kohezgjatja;
    public String perberja;

    public RecetMapper() throws FileNotFoundException, IOException {
        f = new File(System.getProperty("user.dir") + "\\Receta.txt");
        if(!f.exists()){
            f.createNewFile();
        }

        fr = new FileReader(f);
        br = new BufferedReader(fr);

        fw = new FileWriter(f, true);
        bw = new BufferedWriter(fw);
        Recetat = new ArrayList<>();
    }

    public boolean checkReceta(String username) throws IOException {
        String line;
        String[] array;
        while ((line = br.readLine()) != null) {
            array = line.split(";");
            if (array[0].equals(username)) {
                return true;
            }
        }
        return false;
    }

    public Receta getReceta(String emriRecetes) throws IOException, RecetaException {
        String asd;
        String[] dsa;
        while ((asd = br.readLine()) != null) {
            dsa = asd.split(";");
            if (dsa[0].equals(emriRecetes)) {
                perberja = dsa[1];
                kohezgjatja = dsa[2];
                return new Receta(emriRecetes, dsa[1], dsa[2]);
            }
        }
        return null;
    }

    public String getPerberja(String username) throws IOException, RecetaException {
        getReceta(username);
        return perberja;
    }

    public String getKohezgjatja(String username) throws IOException, RecetaException {
        getReceta(username);
        return kohezgjatja;
    }

    public void shtoReceten(String emri, String pergaditja, String kohezgjatja) throws RecetMapperException, IOException {
        if (pergaditja == null || kohezgjatja == null) {
            throw new RecetMapperException("Receta eshte null");
        }
        if (checkReceta(emri)) {
            throw new RecetMapperException("Receta egziston");
        } else {
            bw.write(emri);
            bw.write(";");
            bw.write(pergaditja);
            bw.write(";");
            bw.write(kohezgjatja);
            bw.newLine();
            bw.flush();
            bw.close();
        }
    }

    public void fshijeReceten(String emri) throws RecetMapperException, IOException {
        if (emri == null) {
            throw new RecetMapperException("Receta eshte null");
        }
        if (!checkReceta(emri)) {
            throw new RecetMapperException("Receta nuk egziston");
        } else {
            Receta2 r2 = new Receta2();
            r2.shkruajeReceten2();
            File f3 = new File(System.getProperty("user.dir") + "\\Receta.txt");
            FileWriter fw3 = new FileWriter(f3);
            FileReader fr3 = new FileReader(f3);
            BufferedReader br3 = new BufferedReader(fr3);
            BufferedWriter bw3 = new BufferedWriter(fw3);
            bw3.write("");
            bw3.flush();
            bw3.close();
            RecetMapper rm = new RecetMapper();
            String[] asd;
            String line;
            while ((line = r2.br2.readLine()) != null) {
                asd = line.split(";");
                if (asd[0].equals(emri)) {
                } else {
                    rm.bw.write(line);
                    rm.bw.newLine();
                    rm.bw.flush();
                }
            }
            r2.ClearReceten2();
        }
    }

    public Receta ktheReceten(String emriRecetes) throws IOException, RecetaException {
        String asd;
        String[] dsa;
        while ((asd = br.readLine()) != null) {
            dsa = asd.split(";");
            if (dsa[0].equals(emriRecetes)) {
                return new Receta(emriRecetes, dsa[1], dsa[2]);
            }
        }
        return null;
    }

    public int getnrRecetav() throws IOException {
        String line;
        int count = 0;
        String[] split;
        while ((line = br.readLine()) != null) {
            count++;
            split = line.split(";");
            Recetat.add(split[0]);
        }
        return count;
    }

    public ArrayList<String> getRecetat() throws IOException {
        getnrRecetav();
        return Recetat;
    }
}
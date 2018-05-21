package Projekti;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Flamur
 */

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class UserMapper {

    public BufferedReader br;
    public FileReader fr;

    public FileWriter fw;
    public BufferedWriter bw;
    public File f;
    public ArrayList<String> Useret;

    public UserMapper() throws FileNotFoundException, IOException {
        f = new File(System.getProperty("user.dir") + "\\Userat.txt");
        if(!f.exists()){
            f.createNewFile();
        }
        fr = new FileReader(f);
        br = new BufferedReader(fr);

        fw = new FileWriter(f, true);
        bw = new BufferedWriter(fw);
        Useret = new ArrayList<>();
    }

    // public User Get specific user(String username)...
    //void Delete specific user(String username)
    //Add user(Username,password)
    //public String[] Get all users()
    //public void Remove all users();

    public int getnrUsereve() throws IOException {
        String line;
        int count = 0;
        String[] split;
        while ((line = br.readLine()) != null) {
            count++;
            split = line.split(";");
            Useret.add(split[0]);
        }
        return count;
    }

    public ArrayList<String> getUsers() throws IOException {
        getnrUsereve();
        return Useret;
    }

    public User getUser(String username) throws IOException, UserException {
        String asd;
        String[] dsa;
        while ((asd = br.readLine()) != null) {
            dsa = asd.split(";");
            if (dsa[0].toLowerCase().equals(username)) {
                return new User(username, dsa[1]);
            }
        }
        return null;
    }

    public boolean checkUser(String username, String password) throws IOException, UserException {
        String line;
        String array[];
        User a = getUser(username);
        if (a == null) {
            JOptionPane.showMessageDialog(null, "Username eshte gabim", "Error : Login", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (!a.getPassword().equals(password)) {
            JOptionPane.showMessageDialog(null, "Passwordi eshte gabim", "Error : Login", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;
        }

    }

    public void shtoUser(String username, String password) throws IOException {
        bw.write(username);
        bw.write(";");
        bw.write(password);
        bw.newLine();
        bw.flush();
        bw.close();
        JOptionPane.showMessageDialog(null, "Urime jeni regjistruar me sukses !", "REGJISTRIMI I SUKSESSHEM!", JOptionPane.INFORMATION_MESSAGE);

    }

    public boolean eshteMenagjer(String username, String password) {
        return username.toLowerCase().equals("admin") && password.equals("admin");
    }

    public void fshijeUserin(String emri) throws UserException, IOException {
        User2 u2 = new User2();
        u2.shkruajUserat2();
        File f3 = new File(System.getProperty("user.dir") + "\\Userat.txt");
        if(!f3.exists()){
            f3.createNewFile();
        }
        FileWriter fw3 = new FileWriter(f3);
        FileReader fr3 = new FileReader(f3);
        BufferedReader br3 = new BufferedReader(fr3);
        BufferedWriter bw3 = new BufferedWriter(fw3);
        bw3.write("");
        bw3.flush();
        bw3.close();
        UserMapper um = new UserMapper();
        String[] asd;
        String line;
        while ((line = u2.br2.readLine()) != null) {
            asd = line.split(";");
            if (asd[0].equals(emri)) {
            } else {
                um.bw.write(line);
                um.bw.newLine();
                um.bw.flush();
            }
        }
        u2.ClearUserat2();
    }
}

package Projekti;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Flamur
 */
public class User {

    private String username;
    private String password;
    private boolean isMenager;

    public User(String username, String password, boolean isMenager) throws UserException {
        if (username == null || username.trim().isEmpty()) throw new UserException("Username eshte null");
        if (password == null || password.trim().isEmpty()) throw new UserException("Passwordi eshte null");
        else {
            this.username = username;
            this.password = password;
            this.isMenager = isMenager;
        }
    }

    public User(String username, String password) throws UserException {
        this(username, password, false);
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isIsMenager() {
        return isMenager;
    }

    public boolean equals(Object o) {
        return ((User) o).getUsername().equals(username);
    }
}


package Projekti;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Flamur
 */
public class Receta {
    public String emriRecetes;
    public String perberesit;
    public String koheZgjatja;

    public Receta(String emriRecetes, String perberesit, String koheZgjatja) throws RecetaException {
        if (emriRecetes == null || emriRecetes.trim().isEmpty()) throw new RecetaException("Emri Recetes eshte null");
        if (perberesit == null || perberesit.trim().isEmpty())
            throw new RecetaException("Perberja e receetes eshte null");
        if (koheZgjatja == null || koheZgjatja.trim().isEmpty())
            throw new RecetaException("Koha e pergaditjes eshte null");
        else {
            this.emriRecetes = emriRecetes;
            this.perberesit = perberesit;
            this.koheZgjatja = koheZgjatja;
        }
    }

    public String getEmriRecetes() {
        return emriRecetes;
    }

    public String getPerberesit() {
        return perberesit;
    }

    public String getKoheZgjatja() {
        return koheZgjatja;
    }

    public boolean equals(Object o) {
        if (o instanceof Receta) {
            Receta r = (Receta) o;
            return r.getEmriRecetes().equals(emriRecetes);
        }
        return false;
    }

}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author nabem
 */
public class Spectacle {
    private int codeSpectacle;
    private String jourSpectacle;
    private int heureDebut;
    private int heureFin;
    private double prixSpectacle;
    private int artistePresentateur;
    private int codeFestival;
    private Theme theme;
    private Collection<Numero> programme;
    
    
    public Spectacle(int code, String jour, int debut, int fin, double prix, int codeArtistePresentateur, Theme theme, int codeFest) {
        this.codeSpectacle = code;
        this.jourSpectacle = jour;
        this.heureDebut = debut;
        this.heureFin = fin;
        this.prixSpectacle = prix;
        this.theme = theme;
        this.codeFestival = codeFest;
        //this.programme = Factory.getDAO().getProgrammeSpectacle(this.codeSpectacle);
        this.artistePresentateur = codeArtistePresentateur;
    }
    
    public int getCodeFestival(){
        return this.codeFestival;
    }
    
    public Theme getTheme(){
        return this.theme;
    }
    
    public int getID() {
        return this.codeSpectacle;
    }
    public int getDebut(){
        return this.heureDebut;
    }
    
    public int getFin(){
        return this.heureFin;
    }
    
    public String getJour(){
        return this.jourSpectacle;
    }
    
    public double getPrix(){
        return this.prixSpectacle;
    }
    
    public int getPresentateur(){
        return this.artistePresentateur;
    }
    
    
    @Override
    public String toString() {
        String affiche = "";
        int duree = heureFin - heureDebut;
        System.out.println("Code du spectacle : " + codeSpectacle + " " + "Jour : " + jourSpectacle + " " + "Dure : " + " " + duree + " " + "Coute : " + prixSpectacle) ;
        
        for(Numero numero : this.programme) {
            affiche += numero.toString();
        }
        return affiche;
    }
}

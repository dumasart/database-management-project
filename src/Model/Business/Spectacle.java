/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Business;

import java.util.ArrayList;

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
    
    private ArrayList<Numero> listeNumeros; //un spectacle contient un ou plusieurs numéros
    
    public Spectacle(int code, String jour, int debut, int fin, double prix, ArrayList<Numero> listeNumero) {
        this.codeSpectacle = code;
        this.jourSpectacle = jour;
        this.heureDebut = debut;
        this.heureFin = fin;
        this.prixSpectacle = prix;
        
        this.listeNumeros = listeNumero;
    }
    
    public int getCode() {
        return this.codeSpectacle;
    }
    public int getDebut(){
        return this.heureDebut;
    }
    
    public int getFin(){
        return this.heureFin;
    }
    
    public ArrayList<Numero> getListeNumeros() {
        return this.listeNumeros;
    }
    @Override
    public String toString() {
        String affiche = "";
        int duree = heureFin - heureDebut;
        System.out.println("Code du spectacle : " + codeSpectacle + " " + "Jour : " + jourSpectacle + " " + "Dure : " + " " + duree + " " + "Coute : " + prixSpectacle) ;
        
        for(Numero numero : getListeNumeros()) {
            affiche += numero.toString();
        }
        return affiche;
    }
}

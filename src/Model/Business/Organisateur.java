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
public class Organisateur {
    private ArrayList<Expert> listeExpert;
    private ArrayList<Spectacle> listeSpectacle;
    private ArrayList<Numero> listeNumero;
    public ArrayList<Artiste> listeArtiste;
    
    public Organisateur(ArrayList<Expert> listeExpert, ArrayList<Spectacle> listeSpectacle, ArrayList<Numero> listeNumero, ArrayList<Artiste> listeArtiste) {
        this.listeExpert = listeExpert;
        this.listeSpectacle = listeSpectacle;
        this.listeNumero = listeNumero;
        this.listeArtiste = listeArtiste;
    }
   
    public ArrayList<Expert> getListeExpert() {
        return this.listeExpert;
    }
    
    public ArrayList<Spectacle> getListeSpectacle() {
        return this.listeSpectacle;
    }
    public ArrayList<Artiste> getListeArtiste() {
        return this.listeArtiste;
    }
    public ArrayList<Numero> getListeNumero() {
        return this.listeNumero;
    }
}

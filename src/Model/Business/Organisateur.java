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
    private ArrayList<Artiste> listeExpert;
    private ArrayList<Spectacle> listeSpectacle;
    
    public Organisateur(ArrayList<Artiste> listeExpert, ArrayList<Spectacle> listeSpectacle) {
        this.listeExpert = listeExpert;
        this.listeSpectacle = listeSpectacle;
    }
    
    public void ajouteExpert(Expert exp) {
        if(! listeExpert.contains(exp) && listeExpert.size() < 5) {
            listeExpert.add(exp);
        }
    }
    
    public void ajouteSpectacle(Spectacle spectacle) {
        if(! listeSpectacle.contains(spectacle)) {
            listeSpectacle.add(spectacle);
        }
    }
    
    public ArrayList<Artiste> getListeExpert() {
        return this.listeExpert;
    }
    
    public ArrayList<Spectacle> getListeSpectacle() {
        return this.listeSpectacle;
    }
}

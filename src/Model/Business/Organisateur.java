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
    
    public Organisateur(ArrayList<Artiste> listeExpert) {
        this.listeExpert = listeExpert;
    }
    
    public void ajouteExpert(Expert exp) {
        if(! listeExpert.contains(exp)) {
            listeExpert.add(exp);
        }
    }
    
    public void ajouteSpectacle(Spectacle spectacle) {
        
    }
}

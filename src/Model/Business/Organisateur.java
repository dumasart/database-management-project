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
    
    public void ajouteExpert(Expert exp) {
        if(! listeExpert.contains(exp) && listeExpert.size() < 30) {
            listeExpert.add(exp);
        }
    }
    
    public void ajouteSpectacle(Spectacle spectacle) {
        if(! listeSpectacle.contains(spectacle)) {
            listeSpectacle.add(spectacle);
        }
    }
    
    public void ajouteArtiste(Artiste artiste) {
        if(! listeArtiste.contains(artiste)) {
            listeArtiste.add(artiste);
        }
    }
    
    public void ajouteNumero(Numero numero) {
        if(! listeNumero.contains(numero)) {
            listeNumero.add(numero);
            //on l'assigne à un expert pour l'évaluer
            for(Expert exp : getListeExpert()) {
                if(numero.nbrEvaluateur < 5) {
                    exp.ajouteNumero(numero);
                    numero.nbrEvaluateur ++;
                }
            }
        }
    }
    
    public ArrayList<Expert> getListeExpert() {
        return this.listeExpert;
    }
    
    public ArrayList<Spectacle> getListeSpectacle() {
        return this.listeSpectacle;
    }
}

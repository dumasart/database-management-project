/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Business;

import java.util.Collection;

/**
 *
 * @author nabem
 */
public class Organisateur {
    private Collection<Expert> listeExpert;
    private Collection<Spectacle> listeSpectacle;
    private Collection<Numero> listeNumero;
    private Collection<Artiste> listeArtiste;
    
    public Organisateur(Collection<Expert> listeExpert, Collection<Spectacle> listeSpectacle, Collection<Numero> listeNumero, Collection<Artiste> listeArtiste) {
        this.listeExpert = listeExpert;
        this.listeSpectacle = listeSpectacle;
        this.listeNumero = listeNumero;
        this.listeArtiste = listeArtiste;
    }
   
    public Collection<Expert> getListeExpert() {
        return this.listeExpert;
    }
    
    public Collection<Spectacle> getListeSpectacle() {
        return this.listeSpectacle;
    }
    public Collection<Artiste> getListeArtiste() {
        return this.listeArtiste;
    }
    public Collection<Numero> getListeNumero() {
        return this.listeNumero;
    }
}

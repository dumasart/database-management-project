/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Theme;
import Model.Numero;
import Model.Spectacle;
import java.util.Collection;
import java.util.Map;

/**
 * Ce contrôleur va vérifier et ajouter les numéros dans le Spectacle
 * @author luud
 */
public class JuryViewController {
    private Collection<Numero> listeMeilleursNumeros;
    private Collection<Spectacle> listeSpectacles;
    
    public JuryViewController() {
        updateData(Theme.Acrobatie);
    }
    
    public void updateData(Theme theme) {
        /*
        this.listeMeilleursNumeros = dao.getMeilleursNumerosParTheme(theme);
        this.listeSpectacles = dao.getSpectacles();
        */
    }
    
    public void ajouteNumeroASpectacle(Numero num, Spectacle spec) {
        
    }
}

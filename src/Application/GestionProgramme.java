/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Model.Business.Spectacle;
import java.util.ArrayList;
import java.util.Collection;

/**
 *La classe pour gérer les programmes de façon globale :
 *          -Afficher le programme global du festival
 *          -Afficher le programme pour chaque spectacle
 * @author nabem
 */
public class GestionProgramme {
    private static Collection<Spectacle> listeSpectacle;
    
    //il faut lui fournir une liste de spectacles dans la base de données
    public GestionProgramme() {
        GestionProgramme.listeSpectacle = Factory.getDAO().getSpectacles();
    }
    
    public Collection<Spectacle> getListeSpectacle() {
        return GestionProgramme.listeSpectacle;
    }
    /**
     * Fonction pour calculer la durée totale du festival
     * @return la duree totale du festival 
     */
    public static int dureeFestival() {
        int duree = 0;
        for(Spectacle s : listeSpectacle) {
            duree += s.getFin() - s.getDebut();
        }
        return duree;
    }
    
    public  static void main(String args[]) {
        
        System.out.print("Durée du festival :  " + dureeFestival());
        for(Spectacle s : listeSpectacle) {
            System.out.println(s.toString());
        }
    }
}

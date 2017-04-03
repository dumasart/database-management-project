/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Business;

import java.util.*;

/**
 *
 * @author nabem
 */
public class Expert extends Artiste{
    private ArrayList<Artiste> listeArtiste;
    Enum_theme theme;
    
    public Expert(int code, String nom, String prenom, String dateNaissance, String  adresse, ArrayList<Numero> listeNumero, ArrayList<Artiste> listeArtiste, Enum_theme theme) {
        super(code,nom,prenom,dateNaissance,adresse,listeNumero);
        this.listeArtiste = listeArtiste;
        this.theme = theme;
    }
    
    public void ajouteNumero(Numero numero) {
        if(! getListeNumeros().contains(numero)) {
            getListeNumeros().add(numero);
        }
    }
    
    public void retireNumero(Numero numero) {
        getListeNumeros().remove(numero);
    }
}

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
    //private ArrayList<Numero> listeNumero;
    Enum_theme theme;
    
    public Expert(int code, String nom, String prenom, String dateNaissance, String  adresse, ArrayList<Numero> listeNumero, Enum_theme theme) {
        super(code,nom,prenom,dateNaissance,adresse,listeNumero);
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
    
    public Enum_theme getTheme() {
        return this.theme;
    }
    
    public void afficheNumeros() {
        System.out.println("Liste des numéros associés : ");
        for(Numero num : getListeNumeros()) {
            System.out.println(num.toString());
        }
    }
    
    public int getId(){
        return super.getID();
    }
    
    @Override
    public String toString() {
        return "" + "Monsieur " + this.getNom() + " " + this.getPrenom() + "est expert en : " + this.getTheme();
    }
}

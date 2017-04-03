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
public class Artiste {
    private int code;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String adresse;
    private ArrayList<Numero> listeNumeros;
    
    /**
     * Constructeur
     */
    public Artiste(int code, String nom,String prenom,String dateNaissance, String adresse, ArrayList<Numero> listeNumero) {
        this.code = code;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.listeNumeros = listeNumero;
    }
    
}

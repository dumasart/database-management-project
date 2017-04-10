    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author nabem
 */
public class Expert extends Artiste{
    private ArrayList<Numero> listeNumeros;
    private ArrayList<Theme> themes;
    private String numeroTel;
    private int nbrNumeroEvaluer; //pour dire s'il peut tjrs évaluer un numéro (nbr < 15)
    
    public Expert(int code, int codeCirque, String nom, String prenom, String dateNaissance, 
            String  adresse, ArrayList<Numero> listeNumero, ArrayList<Theme> themes, String numTel, 
            ArrayList<String> pseudos) {
        super(code,codeCirque,nom,prenom,dateNaissance,adresse, pseudos);
        this.themes = themes;
        this.numeroTel = numTel;
        this.nbrNumeroEvaluer = 0;
        this.listeNumeros = listeNumero;
    }
    
    public ArrayList<Numero> getListeNumeros() {
        return this.listeNumeros;
    }
     
    public void retireNumero(Numero numero) {
        this.listeNumeros.remove(numero);
        this.nbrNumeroEvaluer--;
    }
    
    public void ajouteNumero(Numero numero) {
        this.listeNumeros.add(numero);
        this.nbrNumeroEvaluer++;
    }
    
    public String getNumeroTel(){
        return this.numeroTel;
    }
    
    public void setNumeroTel(String tel){
        this.numeroTel = tel;
    }
    
    public ArrayList<Theme> getThemes() {
        return this.themes;
    }
    
    public int getNbrNumeros() {
        return this.nbrNumeroEvaluer;
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
        return "" + "Monsieur " + this.getNom() + " " + this.getPrenom() + "est expert en : " + this.getThemes().toString();
    }
}

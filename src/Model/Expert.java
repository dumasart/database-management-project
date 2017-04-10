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
    /**
     * List of all the acts that the Expert has to evaluate
     */
    private ArrayList<Numero> listeNumeros;
    /**
     * List of all the theme in which the expert is known as being good
     */
    private ArrayList<Theme> themes;
    /**
     * telephone number of the expert 
     */
    private String numeroTel;
    /**
     * total number of acts that the expert has to evaluate 
     * in order to verify that the number of acts evaluated are less than 15 
     */
    private int nbrNumeroEvaluer;
    /**
     * Constructor of the Expert 
     * @param code : Expert artist's code. Must be unique
     * @param codeCirque : circus's code 
     * @param nom : artist's name 
     * @param prenom : artist's first name 
     * @param dateNaissance : artist's born date
     * @param adresse : artist's address
     * @param listeNumero : list of the acts to evaluate 
     * @param themes : list of all the theme 
     * @param numTel : telephone number of the Expert 
     * @param pseudos : list of all the nick name of the expert
     */
    public Expert(int code, int codeCirque, String nom, String prenom, String dateNaissance, 
            String  adresse, ArrayList<Numero> listeNumero, ArrayList<Theme> themes, String numTel, 
            ArrayList<String> pseudos) {
        super(code,codeCirque,nom,prenom,dateNaissance,adresse, pseudos);
        this.themes = themes;
        this.numeroTel = numTel;
        this.nbrNumeroEvaluer = 0;
        this.listeNumeros = listeNumero;
    }
    /**
     * 
     * @return the list of the acts that the expert has to evaluate  
     */
    public ArrayList<Numero> getListeNumeros() {
        return this.listeNumeros;
    }
     /**
      * 
      * @param numero : act to remove from the list of ones to evaluate
      */
    public void retireNumero(Numero numero) {
        this.listeNumeros.remove(numero);
        this.nbrNumeroEvaluer--;
    }
    /**
     * 
     * @param numero : act to add from the list of ones to evaluate
     */
    public void ajouteNumero(Numero numero) {
        this.listeNumeros.add(numero);
        this.nbrNumeroEvaluer++;
    }
    /**
     * 
     * @return return the phone number of the expert
     */
    public String getNumeroTel(){
        return this.numeroTel;
    }
    /**
     * 
     * @param tel : set the phone number of the expert 
     */
    public void setNumeroTel(String tel){
        this.numeroTel = tel;
    }
    /**
     * 
     * @return all theme in which the expert is considered as quite well good wow such 
     */
    public ArrayList<Theme> getThemes() {
        return this.themes;
    }
    /**
     * 
     * @return return the total number of acts evaluated by the expert 
     */
    public int getNbrNumeros() {
        return this.nbrNumeroEvaluer;
    }
    /**
     * print the list of all the acts evaluated by the expert 
     */
    public void afficheNumeros() {
        System.out.println("Liste des numéros associés : ");
        for(Numero num : getListeNumeros()) {
            System.out.println(num.toString());
        }
    }
    /**
     * 
     * @return the code artist of the expert 
     */
    public int getId(){
        return super.getID();
    }
    /** 
     * 
     * @return sexy little introduction sentence 
     */
    @Override
    public String toString() {
        return "" + "Monsieur " + this.getNom() + " " + this.getPrenom() + "est expert en : " + this.getThemes().toString();
    }
}

    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.*;

/**
 *
 * @author kouvtang
 */
public class Artiste {
	private int codeArtiste;
	private int codeCirque;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String adresse;
	private ArrayList<String> pseudos;
    
	/**
         * Constructor 
         * @param codeArtiste : code of the artist : require to be unique 
         * @param codeCirque : code of the artist's circus 
         * @param nom : name of the artist 
         * @param prenom : first name of the artist 
         * @param dateNaissance : born date of the artist 
         * @param adresse : address of the artist 
         * @param pseudos : list of the artist's nick name 
         */
	public Artiste(int codeArtiste, int codeCirque, String nom, String prenom, String dateNaissance, String adresse, ArrayList<String> pseudos) {
		this.codeArtiste = codeArtiste;
		this.codeCirque = codeCirque;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.pseudos = pseudos;
	}
        /**
         * 
         * @return ID de of the artist 
         */
	public int getID() {
		return this.codeArtiste;
	}
        /**
         * 
         * @return Circus code 
         */
	public int getCodeCirque() {
		return this.codeCirque;
	}
        /**
         * 
         * @return Name of the artist 
         */
	public String getNom() {
		return this.nom;
	}
        /**
         * 
         * @return first name of the artist 
         */
	public String getPrenom() {
		return this.prenom;
	}
	/**
         * 
         * @return return born date of the artist
         */
	public String getDate() {
		return this.dateNaissance;
	}
        /**
         * 
         * @return address of the artist
         */
	public String getAdresse() {
		return this.adresse;
	}
        /**
         * 
         * @return all the nickname of the artist
         */
	public ArrayList<String> getPseudos() {
		return this.pseudos;
	}
        /**
         * 
         * @param pseudo nickname to add to the list of nickname of the artist
         */
	public void addPseudo(String pseudo) {
		this.pseudos.add(pseudo);
	}
        /**
         * 
         * @return artist introduction in String
         */
	@Override
	public String toString() {
		return "" + "Salut, je m'appelle " + this.getNom() + " " + this.getPrenom() + ", je suis né le " + this.getDate() + " et j'habite au " + this.getAdresse() + ". Je travaille au cirque numéro " + this.getCodeCirque() + " et mon code est " + this.getID();
	}
}

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
	private int codeCirque;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String adresse;
    
	/**
	 * Constructeur
	 */
	public Artiste(int code, int codeCirque, String nom, String prenom, String dateNaissance, String adresse) {
		this.code = codeArtiste;
		this.codeCirque = codeCirque;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
	}
    
	public int getID() {
		return this.codeArtiste;
	}

	public int getCodeCirque() {
		return this.codeCirque;
	}
    
	public String getNom() {
		return this.nom;
	}
    
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getDate() {
		return this.dateNaissance;
	}

	public String getAdresse() {
		return this.adresse;
	}

	@Override
	public String toString() {
		return "" + "Salut, je m'appelle " + this.getNom() + " " + this.getPrenom() + ", je suis né le " + this.getDate() + " et j'habite au " + this.getAdresse() + ". Je travaille au cirque numéro " + this.codeCirque() + " et mon code est " + this.getID();
	}
}

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
	 * Constructeur prenant en compte une liste de pseudos
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

	public ArrayList<String> getPseudos() {
		return this.pseudos;
	}

	public void addPseudo(String pseudo) {
		this.pseudos.add(pseudo);
	}

	@Override
	public String toString() {
		return "" + "Salut, je m'appelle " + this.getNom() + " " + this.getPrenom() + ", je suis né le " + this.getDate() + " et j'habite au " + this.getAdresse() + ". Je travaille au cirque numéro " + this.getCodeCirque() + " et mon code est " + this.getID();
	}
}

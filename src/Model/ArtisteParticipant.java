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
public class ArtisteParticipant extends Artiste {
	private ArrayList<Integer> listeNumero;

	/**
	 * Constructeur avec liste de pseudos
	 */
	public ArtisteParticipant(int code, int codeCirque, String nom, String prenom, String dateNaissance, String  adresse, ArrayList<String> pseudos) {
		super(code, codeCirque, nom, prenom, dateNaissance, adresse, pseudos);
	        this.listeNumero = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getListeNumero() {
		return this.listeNumero;    
	}

	public void addNumero(int codeNumero) {
		this.listeNumero.add(codeNumero);
	}

	@Override
	public String toString() {
		String content = "Voici l'ensemble des numéros que je vais présenter : \n";
		for(Integer codeNumero : this.getListeNumero()) {
			content = content + codeNumero + " \n";
		}
		content = super.toString() + "\n\n" + content;
		return content;
	}
}

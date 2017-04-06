/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Business;

import java.util.*;

/**
 *
 * @author kouvtang
 */
public class ArtisteParticipant extends Artist {
	private ArrayList<Integer> listeNumero;
	
	public ArtisteParticipant(int code, int codeCirque, String nom, String prenom, String dateNaissance, String  adresse) {
		super(code, codeCirque, nom, prenom, dateNaissance, adresse);
		private ArrayList<Integer> listeNumero = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getListeNumero() {
		return this.listeNumero;
	}

	public void addNumero(int codeNumero) {
		this.listeNumero.add(codeNumero);
	}

	@Override
	public String toString() {
		String content = new String("Voici l'ensemble des numéros que je vais présenter : \n");
		for(Integer codeNumero : this.getListeNumero()) {
			content = content + codeNumero + " \n";
		}
		content = super.toString() + "\n\n" + content;
		return content;
	}
}

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
public class Festival {

	private int codeFestival;
	private ArrayList<Integer> listeSpectacle;

	public Festival(int codeFestival) {
		this.codeFestival = codeFestival;
		this.listeSpectacle = new ArrayList<Integer>();
	}

	public int getCodeFestival() {
		return this.codeFestival;
	}

	public ArrayList<Integer> getListeSpectacle() {
		return this.listeSpectacle;
	}

	public void addSpectacle(int codeSpectacle) {
		this.listeSpectacle.add(codeSpectacle);
	}

	@Override
	public String toString() {
		String content = new String("Voici le contenu du festival numéro ");
		content = content + this.getCodeFestival() + "\n";
		for(Integer codeSpectacle : this.getListeSpectacle()) {
			content = content + codeSpectacle + " \n";
		}

		return content;
	}

	

}

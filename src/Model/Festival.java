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
        /**
         * code of the festival. Must be unique 
         */
	private int codeFestival;
        /**
         * list of all the shows in the festival
         */
	private ArrayList<Integer> listeSpectacle;
        /**
         * Constructor 
         * @param codeFestival code of the festival. Must be unique 
         */
	public Festival(int codeFestival) {
		this.codeFestival = codeFestival;
		this.listeSpectacle = new ArrayList<Integer>();
	}
        /**
         * 
         * @return code of the festival 
         */
	public int getCodeFestival() {
		return this.codeFestival;
	}
        /**
         * 
         * @return list of the shows in the festival 
         */
	public ArrayList<Integer> getListeSpectacle() {
		return this.listeSpectacle;
	}
        /**
         * 
         * @param codeSpectacle. Show's code of th show to add to the festival 
         */
	public void addSpectacle(int codeSpectacle) {
		this.listeSpectacle.add(codeSpectacle);
	}
        /**
         * 
         * @return introduction of the festival 
         */
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

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
public class Cirque {
        /**
         * code of the circus
         * is private 
         */
	private int codeCirque;
        /**
         * name of the circus
         * is private 
         */
	private String nomCirque;
        /**
         * Constructor of the circus 
         * @param codeCirque : code of the circus require to be unique
         * @param nomCirque : name of the circus
         */
	public Cirque(int codeCirque, String nomCirque) {
		this.codeCirque = codeCirque;
		this.nomCirque = nomCirque;
	}
        /**
         * 
         * @return the code of the circus 
         */
	public int getCodeCirque() {
		return this.codeCirque;
	}
        /**
         * 
         * @return name of the circus 
         */
	public String getNomCirque() {
		return this.nomCirque;
	}
        /**
         * 
         * @return information of the circus in a little sentence 
         */
	@Override
	public String toString() {
		return "" + "Le cirque " + this.getNomCirque() + " a été attribué au code " + this.getCodeCirque();
	}

}

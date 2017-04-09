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

	private int codeCirque;
	private String nomCirque;

	public Cirque(int codeCirque, String nomCirque) {
		this.codeCirque = codeCirque;
		this.nomCirque = nomCirque;
	}

	public int getCodeCirque() {
		return this.codeCirque;
	}

	public String getNomCirque() {
		return this.nomCirque;
	}

	@Override
	public String toString() {
		return "" + "Le cirque " + this.getNomCirque() + " a été attribué au code " + this.getCodeCirque();
	}

}

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
public class ArtistePrincipal extends ArtisteParticipant {
	private String numTelPrincipal;

	public ArtistePrincipal(int code, int codeCirque, String nom, String prenom, String dateNaissance, String  adresse, String numTelPrincipal) {
		super(code, codeCirque, nom, prenom, dateNaissance, adresse);
		this.numTelPrincipal = numTelPrincipal;
	}

	public String getNumTel() {
		return this.numTelPrincipal;
	}

	@Override
	public String toString() {
		return super.toString() + " Vous pouvez m'appeler au " + this.numTelPrincipal;
	}
}

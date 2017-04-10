/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;


/**
 *
 * @author kouvtang B2O
 */
public class ArtistePrincipal extends ArtisteParticipant {

    /**
     * telephone number of the artist
     */
    private String numTelPrincipal;
    /**
     * Constructor of the artist 
     * @param code : artist code  (require to be unique)
     * @param codeCirque : circus code 
     * @param nom : name
     * @param prenom : first name
     * @param dateNaissance : born date
     * @param adresse : address
     * @param numTelPrincipal : : telephone number of the artist 
     * @param pseudos : list of all the nick name of the artist 
     */
    public ArtistePrincipal(int code, int codeCirque, String nom, String prenom, String dateNaissance, String adresse, String numTelPrincipal, ArrayList<String> pseudos) {
        super(code, codeCirque, nom, prenom, dateNaissance, adresse, pseudos);
        this.numTelPrincipal = numTelPrincipal;
    }
    /**
     * 
     * @return return the telephone  number of the artist  
     */
    public String getNumTel() {
        return this.numTelPrincipal;
    }
    /**
     * 
     * @return return the telephone number with a little sexy sentence 
     */
    @Override
    public String toString() {
        return super.toString() + " Vous pouvez m'appeler au " + this.numTelPrincipal;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Business;

/**
 *
 * @author nabem
 */
public class Numero {
    private int codeNumero;
    private String titreNumero;
    private String resumeNumero;
    private int dureeNumero;
    private int nbrArtisteNumero;
    static int nbrEvaluateur; //le nombre d'expert qui évalue le numéro
    private boolean valide;
    
    public Numero(int code, String titre, String resume, int duree, int nbrArtiste) {
        this.codeNumero = code;
        this.titreNumero = titre;
        this.resumeNumero = resume;
        this.dureeNumero = duree;
        this.nbrArtisteNumero = nbrArtiste;
        this.valide = true;
        this.nbrEvaluateur = 0;
    }
    
    public int getNbrEvaluateur() {
        return this.nbrEvaluateur;
    }
    public int getNumero() {
        return this.codeNumero;
    }
    public boolean getValid() {
        return this.valide;
    }
    
    @Override
    public String toString() {
        return "Code : " + codeNumero + " Titre : " + titreNumero + " resume : " + resumeNumero + " Duree : " + dureeNumero + " Nombre d'artistes : " + nbrArtisteNumero + "\n";
    }
}

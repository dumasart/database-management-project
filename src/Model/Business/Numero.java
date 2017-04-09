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
    private int codeArtistePrincipal;
    private String titreNumero;
    private String resumeNumero;
    private int dureeNumero;
    private int nbrArtisteNumero;
    static int nbrEvaluateur; //le nombre d'expert qui évalue le numéro
    private boolean valide;
    private boolean isCreation;
    private Theme themeNumero;
    
    public Numero(int code, String titre, String resume, int duree, int nbrArtiste, boolean creation, int artistePrincipal, String theme) {
        this.codeNumero = code;
        this.titreNumero = titre;
        this.resumeNumero = resume;
        this.dureeNumero = duree;
        this.nbrArtisteNumero = nbrArtiste;
        this.themeNumero = Theme.valueOf(theme);
        this.valide = true;
        this.nbrEvaluateur = 0;
        this.codeArtistePrincipal = artistePrincipal;
        this.isCreation = creation;
    }
    
    public int getArtistePrincipal() {
        return this.codeArtistePrincipal;
    }
    public int getID(){
        return this.codeNumero;
    }
    public String getTitre() {
        return this.titreNumero;
    }
    public String getResume() {
        return this.resumeNumero;
    }
    public int getDuree() {
        return this.getDuree();
    }
    public int getNbArtiste() {
        return this.nbrArtisteNumero;
    }
    public boolean getCreation() {
        return this.isCreation;
    }
    public Theme getTheme() {
        return this.themeNumero;
    }
    public boolean getValid() {
        return this.valide;
    }
    public int getNbrEvaluateur() {
        return this.nbrEvaluateur;
    }
    @Override
    public String toString() {
        return "Code : " + codeNumero + " Titre : " + titreNumero + " resume : " + resumeNumero + " Duree : " + dureeNumero + " Nombre d'artistes : " + nbrArtisteNumero + "\n";
    }
}

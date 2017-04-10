/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author nabem
 */
public class Numero {
    /**
     * code of the act. Must be unique 
     */
    private int codeNumero;
    /**
     * code of the artist in charge of this act.
     */
    private int codeArtistePrincipal;
    /**
     * title of the act 
     */
    private String titreNumero;
    /**
     * summary of the act
     */
    private String resumeNumero;
    /**
     * length of the act in minute
     */
    private int dureeNumero;
    /**
     * number of artists playing in the act 
     */
    private int nbrArtisteNumero;
    /**
     * number of expert that evaluate this act
     */
    static int nbrEvaluateur; 
    /**
     * true if the act is chosen else false 
     */
    private boolean valide;
    /**
     * true if the act is a creation 
     */
    private boolean isCreation;
    /**
     * theme of the act 
     */
    private Theme themeNumero;
    
    /**
     * Constructor of the act 
     * @param code
     * @param titre
     * @param resume
     * @param duree
     * @param nbrArtiste
     * @param creation
     * @param artistePrincipal
     * @param theme 
     */
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
    /**
     * 
     * @return the code of the main artist of this act 
     */
    public int getArtistePrincipal() {
        return this.codeArtistePrincipal;
    }
    /**
     * 
     * @return the code of this act 
     */
    public int getID(){
        return this.codeNumero;
    }
    /**
     * 
     * @return the title of this act 
     */
    public String getTitre() {
        return this.titreNumero;
    }
    /**
     * 
     * @return the summary of this act
     */
    public String getResume() {
        return this.resumeNumero;
    }
    /**
     * 
     * @return the length of this act 
     */
    public int getDuree() {
        return this.getDuree();
    }
    /**
     * 
     * @return the number of artist on the act
     */
    public int getNbArtiste() {
        return this.nbrArtisteNumero;
    }
    /**
     * 
     * @return if the act is a creation 
     */
    public boolean getCreation() {
        return this.isCreation;
    }
    /**
     * 
     * @return theme of the act 
     */
    public Theme getTheme() {
        return this.themeNumero;
    }
    /**
     * 
     * @return if the act is valid 
     */
    public boolean getValid() {
        return this.valide;
    }
    /**
     * 
     * @return return the number of expert that evaluate this act  
     */
    public int getNbrEvaluateur() {
        return this.nbrEvaluateur;
    }
    /**
     * 
     * @param nbrEval : set the number of expert that should evaluate this act 
     */
    public void setNbrEvaluateur(int nbrEval) {
        this.nbrEvaluateur = nbrEval;
    }
    /**
     * 
     * @return little presentation of this act 
     */
    @Override
    public String toString() {
        return "Code : " + codeNumero + " Titre : " + titreNumero + " resume : " + resumeNumero + " Duree : " + dureeNumero + " Nombre d'artistes : " + nbrArtisteNumero + "\n";
    }
}

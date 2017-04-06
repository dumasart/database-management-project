
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Model.Business.Enum_theme;
import Model.Business.Evaluation;
import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Spectacle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author milang
 */
public class RequeteOrganisateur extends Requete {

    public static ResultatsSpectacles getSpectacles() {
        ResultSet rs = Getter.request("SELECT * FROM Spectacle");
        ResultatsSpectacles spectacles = new ResultatsSpectacles();
        try {
            while(rs.next()) {
                Spectacle spec=new Spectacle(
                        rs.getInt("codeSpectacle"),
                        rs.getDate("jourSpectacle").toString(),
                        rs.getInt("heureDebut"),
                        rs.getInt("heureFin"),
                        rs.getDouble("prixSpectacle"),
                        rs.getInt("codeArtiste"),
                        Enum_theme.valueOf(rs.getString("theme")),
                        rs.getInt("codeFestival")
                );
            }
        }
        catch (SQLException e) {
            System.out.println("Euh!\n");
        }
        return null;
    }
    public static ResultatsNumeros getNumeros() {
        //USELESS
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    
    
    /**
     * Prendre tous les numéros de thème
     * @param theme
     * @return 
     */
    public static ResultatsNumeros getNumerosByTheme(Enum_theme theme) {
        String s = "SELECT * FROM Numero WHERE theme = " + theme;
        ResultatsNumeros eval = new ResultatsNumeros();

        try {
            ResultSet b = Getter.request(s);
            while(b.next()) {
                Numero num = new Numero(
                        b.getInt("codeNumero"),
                        b.getString("titreNumero"),
                        b.getString("resumeNumero"),
                        b.getInt("dureeNumero"),
                        b.getInt("nbArtisteNumero"),
                        b.getString("themeNumero")                        
                );
                eval.add(num);
            }
        }
        catch(SQLException e) {
            System.out.println("Wololo");

        }
        return eval;

    }
    
    public static ResultatsNumeros getNumerosInSpectacle(int codeSpec) {
        String s = "SELECT * FROM NumeroAccepte WHERE codeSpectacle = " + codeSpec;
        ResultSet rs = Getter.request(s);
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResultatsEvaluations getNumeroEvaluations(Numero numero) {
        String cmd = "SELECT * FROM Evaluation WHERE codeNumero = " + numero.getID();
        ResultSet rs = Getter.request(cmd);
        System.out.println("Not yet Implemented!\n");
        return null;
    }
     
    public static int getMoyenneNumero(Numero numero){
        // Je sais pas comment on remplit ResultatsInformation
        String cmd = "SELECT AVG(Note) FROM (evaluation INNER JOIN Numero WHERE evaluation.codeNumero = Numero.codeNumero) WHERE evaluation.codeNumero = " + numero.getID();
        // COMMENT ON STOCKE DES DATA QUI NE SONT PAS UN TYPE DONNÉ ?
        try {
            ResultSet b = Getter.request(cmd);
            if (b.next()) {
                return b.getInt("Average");
            }
        }
        catch(SQLException e) {
            System.out.println("Wololo \n");
        } 
        
        return -1;
    }
    
    /**
     * Vérifier si l'artiste expert est dans Artiste
     * Ajouter son/ses thème/s d'expertise dans EstExpertEn
     * @param expert
     * @return 
     */
    public static boolean addExpert(Expert expert) {
        String req= "INSERT INTO ArtisteExpert VALUES (" +expert.getID() + ")";
        String test = "SELECT codeArtiste FROM ArtisteExpert WHERE codeArtiste=" + expert.getId();
        try {
            ResultSet b = Getter.request(test);
            if (b.next()) {
                Iterator<Enum_theme> it = expert.getThemes().iterator();
                while (it.hasNext()) {
                    Enum_theme theme = it.next();
                    String s2 = "INSERT INTO EstExpertEn VALUES (" + expert.getID() + ", " + theme + ")";
                    Getter.request(s2);
                }
                Getter.request(req);
            return true;
            }
        } catch (SQLException e) {
            System.out.println("Wololo \n");
        }
        return false;
    } 
    /**
     * Vérifier que l'artiste présentateur est dans Artiste
     * @param spectacle
     * @return 
     */
    public static boolean addSpectacle(Spectacle spectacle) {
        String testArt = "SELECT codeArtiste FROM Artiste INNER JOIN Spectacle ON Artiste.codeArtiste=Spectacle.codeArtiste";
        String req = "INSERT INTO Spectacle (CodeSpectacle, JourSpectacle, HeureDebut, HeureFin, PrixSpectacle, CodeArtiste, Theme, codeFestival) VALUES (" + spectacle.getID() + " , " + spectacle.getJour() + " , " + spectacle.getDebut() + " , " + spectacle.getFin() + " , " + spectacle.getPrix()
                + " , " + spectacle.getPresentateur() + " , " + spectacle.getTheme() + " , " + spectacle.getCodeFestival() + ")";
        try {
            ResultSet b = Getter.request(testArt);
            if (!b.next()) {
                Getter.request(req);
                return true;
            }
        }
        catch(SQLException e) {
            System.out.println("Wololo \n");
        }
        return false;
    }
    /**
     * Vérifier que l'artiste principal est dans ArtistePrincipal, ArtisteParticipant et Artiste
     * @param numero
     * @return 
     */
    public static boolean addNumero(Numero numero) {
        System.out.println("Not yet Implemented!\n");
        return false;
    } 
    /**
     * Vérifier que le numéro existe
     * Vérifier que le spectacle existe
     * Vérifier l'heure si pas déjà fait
     * @param spectacle
     * @param numero
     * @return 
     */
    public static boolean addNumeroToSpectacle(Spectacle spectacle,Numero numero) {
        System.out.println("Not yet Implemented!\n");
        return false;
    }
    /**
     * Associer un numéro à un expert
     * @param get
     * @param numero 
     */
    public void associeNumeroExpert(Expert exp, Numero numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


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

    /**
     * Prendre tous les spectacles.
     * @return ResultatsSpectacles
     */
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
            System.out.println("Erreur SQL : Aucun spectacle");
        }
        return null;
    }
    public static ResultatsNumeros getNumeros() {
        //USELESS
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    
    
    /**
     * Prendre tous les numéros de thème theme.
     * @param theme
     * @return ResultatsNumeros
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
                        b.getBoolean("estCreation"),
                        b.getInt("codeArtiste"),
                        b.getString("themeNumero")                        
                );
                eval.add(num);
            }
        }
        catch(SQLException e) {
            System.out.println("Erreur SQL : Aucun numéro au thème" + theme);

        }
        return eval;

    }
    
    /**
     * Prendre tous les numeros du spectacle.
     * Verifie que le spectacle existe
     * @param codeSpec
     * @return ResultatsNumeros
     */
    public static ResultatsNumeros getNumerosInSpectacle(int codeSpec) {
        String s = "SELECT * FROM NumeroAccepte WHERE codeSpectacle = " + codeSpec;
        String test = "SELECT codeSpectacle FROM Spectacle WHERE codeSpectacle=" + codeSpec;
        ResultatsNumeros res = new ResultatsNumeros();
        try {
            ResultSet b = Getter.request(test);
            if (b.next()) {
                b = Getter.request(s);
                while(b.next()) {
                Numero num = new Numero(
                        b.getInt("codeNumero"),
                        b.getString("titreNumero"),
                        b.getString("resumeNumero"),
                        b.getInt("dureeNumero"),
                        b.getInt("nbArtisteNumero"),
                        b.getBoolean("estCreation"),
                        b.getInt("codeArtiste"),
                        b.getString("themeNumero")                        
                );
                res.add(num);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : Spectacle inconnu");
        }
        return res;
    }
    
    /**
     * Prendre toutes les evaluations relatives au numero.
     * Vérifie que le numéro existe
     * @param numero
     * @return ResultatsEvaluations
     */
    public static ResultatsEvaluations getNumeroEvaluations(Numero numero) {
        String cmd = "SELECT * FROM Evaluation WHERE codeNumero = " + numero.getID();
        String test = "SELECT codeNumero FROM Numero WHERE codeNumero=" + numero;
        ResultatsEvaluations res = new ResultatsEvaluations();
        try {
            ResultSet b = Getter.request(test);
            if (b.next()) {
                b = Getter.request(cmd);
                while (b.next()) {
                    Evaluation eval = new Evaluation(
                        b.getInt("codeArtiste"),
                        b.getInt("codeNumero"),
                        b.getString("evaluation"),
                        b.getInt("note")
                    );
                    res.add(eval);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : Numéro inconnu");
        }
        return res;
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
            System.out.println("Erreur SQL : Aucune note");
        } 
        return -1;
    }
    
    /**
     * Ajoute un expert dans la BD.
     * Vérifie si l'artiste expert est dans Artiste
     * Ajoute son/ses thème/s d'expertise dans EstExpertEn
     * @param expert
     * @return boolean
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
            System.out.println("Erreur SQL : Artiste inconnu");
        }
        return false;
    } 
    
    /**
     * Ajoute un spectacle dans la base.
     * Vérifie que l'artiste présentateur est dans Artiste
     * @param spectacle
     * @return boolean
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
            System.out.println("Erreur SQL : Artiste inconnu");
        }
        return false;
    }
    
    /**
     * Ajoute un numéro dans la BD.
     * Vérifie que l'artiste principal est dans ArtistePrincipal, ArtisteParticipant et Artiste
     * @param numero
     * @return boolean
     */
    public static boolean addNumero(Numero numero) {
        String test1 = "SELECT codeArtiste FROM Artiste WHERE codeArtiste=" + numero.getArtistePrincipal();
        String test2 = "SELECT codeArtiste FROM ArtisteParticipant WHERE codeArtiste=" + numero.getArtistePrincipal();
        String test3 = "SELECT codeArtiste FROM ArtistePrincipal WHERE codeArtiste=" + numero.getArtistePrincipal();
        String cmd = "INSERT INTO Numero VALUES (" + numero.getID() +", " + numero.getTitre() + ", " + numero.getResume() + ", " + numero.getDuree()
                + ", " + numero.getNbArtiste() + ", " + numero.getCreation() + ", " + numero.getArtistePrincipal() + ", " + numero.getTheme() + ")";
        try {
            ResultSet b = Getter.request(test1);
            if (b.next()) {
                b = Getter.request(test2);
                if (b.next()) {
                    b = Getter.request(test3);
                    if (b.next()) {
                        b = Getter.request(cmd);
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : Artiste Principal inconnu");
        }
        return false;
    } 
    /**
     * Ajoute un numero à un spectacle dans la BD.
     * Vérifie que le numéro existe
     * Vérifie que le spectacle existe
     * Vérifie l'heure si pas déjà fait
     * @param spectacle
     * @param numero
     * @param heure
     * @return boolean
     */
    public static boolean addNumeroToSpectacle(Spectacle spectacle,Numero numero, int heure) {
        String test1 = "SELECT * FROM Numero WHERE codeNumero=" + numero.getID();
        String test2 = "SELECT * FROM Spectacle WHERE codeSpectacle =" + spectacle.getID();
        String cmd = "INSERT INTO NumeroAccepte(codeNumero, codeSpectacle, HeureNumero ) VALUES ( " + numero.getID() + " , " + spectacle.getID() + " , " + heure + ")";
        try {
            ResultSet b = Getter.request(test1);
            if (b.next()) {
                b = Getter.request(test2);
                if (b.next()) {
                    Getter.request(cmd);
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : Spectacle ou Numero invalide");            
        }
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

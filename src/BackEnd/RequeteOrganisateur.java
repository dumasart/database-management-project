
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
     * @param codeSpec
     * @return ResultatsNumeros
     */
    public static ResultatsNumeros getNumerosInSpectacle(int codeSpec) {
        String s = "SELECT * FROM NumeroAccepte WHERE codeSpectacle = " + codeSpec;
        ResultatsNumeros res = new ResultatsNumeros();
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
                res.add(num);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : Spectacle inconnu");
        }
        return res;
    }
    
    /**
     * Prendre toutes les evaluations relatives au numero.
     * @param numero
     * @return ResultatsEvaluations
     */
    public static ResultatsEvaluations getNumeroEvaluations(Numero numero) {
        String cmd = "SELECT * FROM Evaluation WHERE codeNumero = " + numero.getID();
        ResultatsEvaluations res = new ResultatsEvaluations();
        try {
            ResultSet b = Getter.request(cmd);
            while (b.next()) {
                Evaluation eval = new Evaluation(
                    b.getInt("codeArtiste"),
                    b.getInt("codeNumero"),
                    b.getString("evaluation"),
                    b.getInt("note")
                );
                res.add(eval);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : Numéro inconnu");
        }
        return res;
    }
     
    public static int getMoyenneNumero(Numero numero){
        String cmd = "SELECT AVG(Note) FROM (evaluation INNER JOIN Numero WHERE evaluation.codeNumero = Numero.codeNumero) WHERE evaluation.codeNumero = " + numero.getID();
        try {
            ResultSet b = Getter.request(cmd);
            if (b.next()) {
                return b.getInt("AVG(Note)");
            }
        }
        catch(SQLException e) {
            System.out.println("Erreur SQL : Aucune note");
        } 
        return -1;
    }
    
    /**
     * Ajoute un expert dans la BD.
     * Ajoute son/ses thème/s d'expertise dans EstExpertEn
     * @param expert
     * @return boolean
     */
    public static boolean addExpert(Expert expert) {
        String req= "INSERT INTO ArtisteExpert VALUES (" +expert.getID() + ")";
        Iterator<Enum_theme> it = expert.getThemes().iterator();
        while (it.hasNext()) {
            Enum_theme theme = it.next();
            String s2 = "INSERT INTO EstExpertEn VALUES (" + expert.getID() + ", " + theme + ")";
            Getter.update(s2);
            return true;
        }
        Getter.update(req);
        return true;
    } 
    
    /**
     * Ajoute un spectacle dans la base.
     * @param spectacle
     * @return boolean
     */
    public static boolean addSpectacle(Spectacle spectacle) {
        String req = "INSERT INTO Spectacle (CodeSpectacle, JourSpectacle, HeureDebut, HeureFin, PrixSpectacle, CodeArtiste, Theme, codeFestival) VALUES (" + spectacle.getID() + " , " + spectacle.getJour() + " , " + spectacle.getDebut() + " , " + spectacle.getFin() + " , " + spectacle.getPrix()
                + " , " + spectacle.getPresentateur() + " , " + spectacle.getTheme() + " , " + spectacle.getCodeFestival() + ")";
        Getter.update(req);
        return true;
    }
    
    /**
     * Ajoute un numéro dans la BD.
     * @param numero
     * @return boolean
     */
    public static boolean addNumero(Numero numero) {
        String cmd = "INSERT INTO Numero VALUES (" + numero.getID() +", " + numero.getTitre() + ", " + numero.getResume() + ", " + numero.getDuree()
                + ", " + numero.getNbArtiste() + ", " + numero.getCreation() + ", " + numero.getArtistePrincipal() + ", " + numero.getTheme() + ")";
        Getter.update(cmd);
        return true;
    } 
    /**
     * Ajoute un numero à un spectacle dans la BD.
     * @param spectacle
     * @param numero
     * @param heure
     * @return boolean
     */
    public static boolean addNumeroToSpectacle(Spectacle spectacle,Numero numero, int heure) {
        String cmd = "INSERT INTO NumeroAccepte(codeNumero, codeSpectacle, HeureNumero ) VALUES ( " + numero.getID() + " , " + spectacle.getID() + " , " + heure + ")";
        Getter.update(cmd);
        return true;
    }
    
    /**
     * Affecte un numéro à un expert
     * @param exp
     * @param numero 
     */
    public static boolean associeNumeroExpert(Expert exp, Numero numero) {
        String cmd = "INSERT INTO Evaluation VALUES (" + exp.getId() + ", " + numero.getID() + ")";
        Getter.update(cmd);
        exp.ajouteNumero(numero);
        return true;
    }
    
    /**
     * Renvoi les numéros du thème donné classés par moyenne des notes
     * Ne renvoi pas la moyenne des notes !
     * Les numéros sont ajoutés dans ResultatsNumeros du mieux noté au moindre
     * @param theme
     * @return ResultatsNumeros
     */
    public static ResultatsNumeros getRankedNumeroByTheme(Enum_theme theme) {
        String cmd = "SELECT Numero.codeNumero, TitreNumero, ResumeNumero, DureeNumero, NbArtisteNumero, EstCreation, CodeArtiste, Theme "
                + "FROM Numero FULL JOIN (SELECT CodeNumero, AVG(Note) as Moyenne FROM Evaluation GROUP BY CodeNumero) Moy "
                + "ON Numero.CodeNumero=Moy.CodeNumero WHERE Theme=" + theme
                + "ORDER BY Moyenne DESC";
        ResultatsNumeros res = new ResultatsNumeros();
        try {
            ResultSet b = Getter.request(cmd);
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
        catch(SQLException e) {
            System.out.println("Erreur SQL : Aucun numéro au thème" + theme);
        }
        return res;
    }
}

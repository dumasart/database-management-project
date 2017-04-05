
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Model.Business.Enum_theme;
import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Organisateur;
import Model.Business.Spectacle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
                        rs.getDouble("prixSpectacle")
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
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    
    public static ResultatsNumeros getNumeros(int codeSpec) {
        String s = "SELECT FROM NumeroAccepte WHERE spectacle = " + codeSpec;
        ResultSet rs = Getter.request(s);
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResultatsEvaluations getEvaluations(Numero numero) {
        String cmd = "SELECT * FROM Evaluation WHERE codeNumero = " + numero.getID();
        ResultSet rs = Getter.request(cmd);
        System.out.println("Not yet Implemented!\n");
        return null;
    }
     
    public static ResultatsEvaluations getMoyenneNumero(Numero numero){
        // Je sais pas comment on remplit ResultatsInformation
        String cmd = "SELECT AVG(Notes) , codeNumero, TitreNumero FROM (evaluation INNER JOIN Numero WHERE evaluation.codeNumero = Numero.codeNumero)";
        ResultSet rs = Getter.request(cmd);
        ResultatsEvaluations info = new ResultatsEvaluations();
        // COMMENT ON STOCKE DES DATA QUI NE SONT PAS UN TYPE DONNÉ ?
        
        /* try {
            ResultSet b = Getter.request(cmd);
            while(b.next()) {
                Data = new (
                        b.getInt("Average"),
                        b.getString("codeNumero"),
                        b.getString("TitreNumero"),
                        false
                );
                info.add(Data);
            }
        }
        catch(SQLException e) {
            
        } */
        
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    
    /**
     * Vérifier si l'artiste expert est dans Artiste
     * Ajouter son/ses thème/s d'expertise dans EstExpertEn
     * @param expert
     * @return 
     */
    public static boolean addExpert(Expert expert) {
        String req= "INSERT INTO ArtisteExpert VALUES (" +expert.getID() + ")";
        ResultSet listeSpectacle = Getter.request(req);
        System.out.println("Not yet Implemented!\n");
        return false;
    } 
    /**
     * Vérifier que l'artiste présentateur est dans Artiste
     * Vérifier que le festival existe
     * @param spectacle
     * @return 
     */
    public static boolean addSpectacle(Spectacle spectacle) {
        System.out.println("Not yet Implemented!\n");
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

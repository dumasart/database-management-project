/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Spectacle;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author milang
 */
public class RequeteOrganisateur extends Requete {
    public static ResultatsSpectacles getSpectacles() {
        ResultSet rs = Getter.request("SELECT * FROM Festival");
        //Ici à compléter
        ResultatsSpectacles spectacles = new ResultatsSpectacles();
        try {
            while(rs.next()) {
                
            }
        }
        catch (SQLException e) {
            System.out.println("Euh!\n");
        }
        return null;
    }
    public static ResultatsNumeros getNumeros() {
        ResultSet rs = Getter.request("SELECT NumTelExpert FROM ArtisteExpert");
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResultatsNumeros getNumeros(Spectacle spectacle) {
        String s = "SELECT FROM NumeroAccepte WHERE spectacle = " + spectacle.getID();
        ResultSet rs = Getter.request(s);
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResultatsInformation getEvaluations(Numero numero) {
        String cmd = "SELECT * FROM Evaluation WHERE codeNumero = " + numero.getID();
        ResultSet rs = Getter.request(cmd);
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
    public static boolean addNumeroToSpectacl(Spectacle spectacle,Numero numero) {
        System.out.println("Not yet Implemented!\n");
        return false;
    }
}

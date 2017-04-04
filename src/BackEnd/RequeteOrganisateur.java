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

/**
 *
 * @author milang
 */
public class RequeteOrganisateur extends Requete {
    public static ResultatsSpectacles getSpectacles() {
        ResultSet listeSpectacle = Getter.request("SELECT * FROM Festival");
        //Ici à compléter
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResultatsNumeros getNumeros() {
        ResultSet listeSpectacle = Getter.request("SELECT NumTelExpert FROM ArtisteExpert");
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResultatsNumeros getNumeros(Spectacle spectacle) {
        String s = "SELECT FROM NumeroAccepte WHERE spectacle = " + spectacle.getID();
        ResultSet listeSpectacle = Getter.request(s);
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResultatsInformation getEvaluations(Numero numero) {
        String cmd = "SELECT * FROM Evaluation WHERE codeNumero = " + numero.getID();
        ResultSet listeSpectacle = Getter.request(cmd);
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static boolean addExpert(Expert expert) {
        String req= "insert into ArtisteExpert values(" +expert.getID() + ")";
        
        System.out.println("Not yet Implemented!\n");
        return false;
    } 
    public static boolean addSpectacle(Spectacle spectacle) {
        System.out.println("Not yet Implemented!\n");
        return false;
    }
    public static boolean addNumero(Numero numero) {
        System.out.println("Not yet Implemented!\n");
        return false;
    } 
    public static boolean addNumeroToSpectacl(Spectacle spectacle,Numero numero) {
        System.out.println("Not yet Implemented!\n");
        return false;
    }
}

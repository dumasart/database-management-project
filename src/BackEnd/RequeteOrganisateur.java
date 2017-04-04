/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Spectacle;

/**
 *
 * @author milang
 */
public class RequeteOrganisateur extends Requete {
    public static ResultatsSpectacles getSpectacles() {
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResultatsNumeros getNumeros() {
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResultatsNumeros getNumeros(Spectacle spectacle) {
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static ResulatsInformation getInfoJury(Numero numero) {
        System.out.println("Not yet Implemented!\n");
        return null;
    }
    public static boolean addExpert(Expert expert) {
        //String req="insert into ArtisteExpert values("+expert.+")";
        
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

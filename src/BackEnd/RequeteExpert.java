/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Application.Factory;
import Model.Business.Evaluation;
import Model.Business.Numero;
import java.sql.ResultSet;

/**
 *
 * @author Geoffrey b2o
 */
public class RequeteExpert extends Requete{
    //
    public static ResultatsNumeros getNumeros(){
        String s = "SELECT codeNumero, TitreNumero, ResumeNumero, DureeNumero, NbArtisteNumero,  EstCreation, codeArtiste, theme FROM Evaluation INNER JOIN ArtisteExpert WHERE (Evaluation.CodeArtiste = ArtisteExper.CodeArtiste AND codeArtiste="+Factory.getUser().getUserId() + ")";
        ResultSet b = Getter.request(s);
        //il faut analyser le ResultSet et renvoyer je ne sais quoi?
        return null;
    }
    public static ResultatsEvaluations getEvaluation() {
        String s = "SELECT * FROM Evaluation WHERE codeArtiste="+Factory.getUser().getUserId();
        ResultSet b = Getter.request(s);
        
        System.out.println("Not yest implemented!\n");
        return null;
    }
    
    public static boolean setEvaluation(Numero numero,Evaluation evaluation) {
        System.out.println("Not yet implemented!\n");
        return false;
    }
    
    public static boolean updateComment(Numero numero,String comment) {
        System.out.println("Not yet implemented!\n");
        return false;
    }
    
    public static boolean updateNote(Numero numero,int note) {
        System.out.println("Not yet implemented!\n");
        return false;
    }
}

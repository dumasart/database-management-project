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
import java.sql.SQLException;

/**
 *
 * @author Geoffrey b2o
 */
public class RequeteExpert extends Requete{
    //
    public static ResultatsNumeros getNumeros(){
        String s = "SELECT * FROM Evaluation JOIN Numero ON Evaluation.codeNumero=Numero.codeNumero WHERE codeArtiste="+Factory.getUser().getUserId();
        ResultatsNumeros nums = new ResultatsNumeros();
        try {
            ResultSet b = Getter.request(s);
            while(b.next()) {
                Numero num = new Numero(
                        b.getInt("codeNumero"),
                        b.getString("TitreNumero"),
                        b.getString("ResumeNumero"),
                        b.getInt("DureeNumero"),
                        b.getInt("NbArtiste"),
                        false
                );
                nums.add(num);
            }
        }
        catch(SQLException e) {
            
        }
        //il faut analyser le ResultSet et renvoyer je ne sais quoi?
        return nums;
    }
    public static ResultatsEvaluations getEvaluation() {
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

/**
 *
 * @author milang
 */ 
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
                        b.getString("theme")
                );
                nums.add(num);
            }
        }
        catch(SQLException e) {
            System.out.println("Wololo");
        }
        //il faut analyser le ResultSet et renvoyer je ne sais quoi?
        return nums;
    }
    public static ResultatsEvaluations getEvaluation() {
        String s = "SELECT * FROM Evaluation WHERE codeArtiste="+Factory.getUser().getUserId();
        ResultatsEvaluations eval = new ResultatsEvaluations();

        try {
            ResultSet b = Getter.request(s);
            while(b.next()) {
                Evaluation num = new Evaluation(
                        b.getInt("codeArtiste"),
                        b.getInt("codeNumero"),
                        b.getString("Evaluation"),
                        b.getInt("note")
                );
                eval.add(num);
            }
        }
        catch(SQLException e) {
            System.out.println("Wololo");

        }
        return eval;
    }
    
    /**
     * Vérifier si le numéro existe
     * @param numero
     * @param evaluation
     * @return boolean
     */
    public static boolean setEvaluation(Numero numero,Evaluation evaluation) {
        String s = "SELECT * FROM Evaluation WHERE codeNumero=" + numero.getID() + " AND codeArtiste= " + Factory.getUser().getUserId();
        String s2 = "SELECT * FROM Numero WHERE codeNumero=" + numero.getID();

        try {
            ResultSet b = Getter.request(s);
            ResultSet b2 = Getter.request(s2);
            if (!b.next()){
                if (!b2.next()){
                    // On est bon là
                    Getter.request("INSERT INTO Evaluation (codeArtiste, codeNumero, evaluation, note) VALUES (" +Factory.getUser().getUserId() + " , "
                    + numero.getID() + " , " + evaluation.getEvaluation() + " , " + evaluation.getNote() + " ) " );
                    return true;
                }
            }
        }
        catch(SQLException e) {
            System.out.println("Wololo \n");
        }
        
        return false;
    }
    
    /**
     * Vérifier si le numéro existe
     * Vérifier si il a déjà une évaluation
     * @param codeNumero
     * @param comment
     * @return boolean
     */
    public static boolean updateComment(int codeNumero, String comment) {
        String s = "SELECT * FROM Numero WHERE codeNumero=" + codeNumero;
        String s2 = "SELECT * FROM Evaluation WHERE codeNumero=" + codeNumero + " AND codeArtiste= " + Factory.getUser().getUserId();

        try {
            ResultSet b = Getter.request(s);
            ResultSet b2 = Getter.request(s2);
            if (!b.next()){
                if (!b2.next() ){
                    // On est bon là
                    Getter.request("UPDATE Evaluation SET evaluation = " + comment + " WHERE codeNumero = " + codeNumero + " AND codeArtiste = " +  Factory.getUser().getUserId() );
                    return true;
                }
            }
        }
        catch(SQLException e) {
            System.out.println("Wololo \n");
        }
        
        return false;
    }
    
    /**
     * Vérifier si le numéro existe
     * Vérifier si il a déjà une évaluation
     * @param codeNumero
     * @param note
     * @return boolean
     */
    public static boolean updateNote(int codeNumero,int note) {
        String s = "SELECT * FROM Numero WHERE codeNumero=" + codeNumero;
        String s2 = "SELECT * FROM Evaluation WHERE codeNumero=" + codeNumero + " AND codeArtiste= " + Factory.getUser().getUserId();

        try {
            ResultSet b = Getter.request(s);
            ResultSet b2 = Getter.request(s2);
            if (!b.next()){
                if (!b2.next()){
                    // On est bon là
                    Getter.request("UPDATE Evaluation SET note = " + note + " WHERE codeNumero = " + codeNumero + " AND codeArtiste = " +  Factory.getUser().getUserId() );
                    return true;
                }
            }
        }
        catch(SQLException e) {
            System.out.println("Wololo \n");
        }

        return false;
    }
}

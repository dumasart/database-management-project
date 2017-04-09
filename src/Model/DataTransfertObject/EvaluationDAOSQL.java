/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import DataAccessLayer.Getter;
import Model.Evaluation;
import Model.Expert;
import Model.Numero;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milang
 */
public class EvaluationDAOSQL implements EvaluationDAO {
    
    //TODO à voir si on en à besoin car on est parti du principe qu'une
    // évaluation ne peut pas etre modifiée après validation (saisie)
    @Override
    public boolean update(Evaluation evaluation) {
        String cmd = "UPDATE Evaluation SET note = " +
                evaluation.getNote() +
                " AND evaluation = " +
                evaluation.getEvaluation() +
                " WHERE codeArtiste = " +
                evaluation.getID() +
                " AND codeNumero = " + 
                evaluation.getCodeNumero();
        int res=Getter.update(cmd);
        if(res==0)
            return false;
        else 
            return true;
    }

    @Override
    public boolean delete(Evaluation evaluation) {
        String cmd = "DELETE from Evaluation WHERE codeArtiste = "+
                evaluation.getID()+
                " AND codeArtiste = "+
                evaluation.getCodeNumero();
        int res=Getter.update(cmd);
        if(res==0)
            return false;
        else 
            return true;
    }

    @Override
    public boolean insert(Evaluation evaluation, Numero numero, Expert expert) {
        String cmd = "INSERT INTO Evaluation (codeArtiste, codeNumero, evaluation, note) VALUES (" + expert.getID() + " , "
                    + numero.getID() + " , " + evaluation.getEvaluation() + " , " + evaluation.getNote() + " ) ";
        int res=Getter.update(cmd);
        if(res==0)
            return false;
        else 
            return true;
    }

    @Override
    public List<Evaluation> getEvaluationFromNumero(Numero numero) {
        String cmd = "SELECT * FROM Evaluation WHERE codeNumero = " + numero.getID();
        List<Evaluation> res = new ArrayList<>(); 
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
}

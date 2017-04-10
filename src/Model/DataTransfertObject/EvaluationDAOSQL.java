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
    /**
     * 
     * @param evaluation : evaluation to synchronize with the data-base
     * @return true on success
     */
    @Override
    public boolean update(Evaluation evaluation) {
        String cmd = "UPDATE Evaluation SET note = "
                + evaluation.getNote()
                + " AND evaluation = "
                + evaluation.getEvaluation()
                + " WHERE codeArtiste = "
                + evaluation.getID()
                + " AND codeNumero = "
                + evaluation.getCodeNumero();
        int res = Getter.update(cmd);
        if (res == 0) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 
     * @param evaluation to delete form the data-base
     * @return true on success 
     */
    @Override
    public boolean delete(Evaluation evaluation) {
        String cmd = "DELETE from Evaluation WHERE codeArtiste = "
                + evaluation.getID()
                + " AND codeArtiste = "
                + evaluation.getCodeNumero();
        int res = Getter.update(cmd);
        if (res == 0) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 
     * @param evaluation to insert in the data-base
     * @return true on success 
     */
    @Override
    public boolean insert(Evaluation evaluation) {
        String cmd = "INSERT INTO Evaluation (codeArtiste, codeNumero, evaluation, note) VALUES (" + evaluation.getID() + " , "
                + evaluation.getCodeNumero() + " , " + evaluation.getEvaluation() + " , " + evaluation.getNote() + " ) ";
        int res = Getter.update(cmd);
        if (res == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Give an act to evaluate to an expert
     *
     * @param exp
     * @param numero
     */
    public boolean insert(Expert exp, Numero numero) {
        String cmd = "INSERT INTO Evaluation VALUES (" + exp.getId() + ", " + numero.getID() + ")";
        Getter.update(cmd);
        exp.ajouteNumero(numero);
        return true;
    }
    /**
     * 
     * @param numero : act to find all the evaluation about 
     * @return all the evaluation about the act numero 
     */
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

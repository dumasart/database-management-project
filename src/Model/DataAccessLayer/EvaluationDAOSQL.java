/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import BackEnd.Getter;
import Model.Business.Evaluation;
import Model.Business.Expert;
import Model.Business.Numero;
import java.util.List;

/**
 *
 * @author milang
 */
public class EvaluationDAOSQL implements EvaluationDAO {
    @Override
    public boolean update(Evaluation evaluation) {
        String cmd = "UPDATE Evaluation SET note = " +
                evaluation.getNote() +
                " AND evaluation = " +
                evaluation.getEvaluation() +
                " WHERE codeArtiste = " +
                evaluation.getID() +
                " AND codeNumero = " + 
                evaluation.getCodeNumero() +";";
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
                evaluation.getCodeNumero()+
                ";";
        int res=Getter.update(cmd);
        if(res==0)
            return false;
        else 
            return true;
    }

    @Override
    public boolean insert(Evaluation evaluation, Numero numero, Expert expert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Evaluation> getEvaluationFromNumero(Numero numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}

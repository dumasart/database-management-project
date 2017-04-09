/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import Model.Evaluation;
import Model.Expert;
import Model.Numero;
import java.util.List;

/**
 *
 * @author milang
 */
public interface EvaluationDAO {
    public boolean update(Evaluation evaluation);
    public boolean delete(Evaluation evaluation);
    public boolean insert(Evaluation evaluation,Numero numero,Expert expert);
    public List<Evaluation> getEvaluationFromNumero(Numero numero);
}

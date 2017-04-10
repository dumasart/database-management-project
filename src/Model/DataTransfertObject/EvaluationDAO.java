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
<<<<<<< HEAD
    public boolean insert(Evaluation evaluation,Numero numero,Expert expert);
    public boolean insert(Expert exp, Numero numero);
=======
    public boolean insert(Evaluation evaluation,Numero numero,String ExpertID);
>>>>>>> 9f6353b321e0a7b93c493dbdfff73d6da2cf9895
    public List<Evaluation> getEvaluationFromNumero(Numero numero);
}

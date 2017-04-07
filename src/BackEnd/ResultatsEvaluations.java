/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import Model.Business.Evaluation;
import java.util.ArrayList;

/**
 *
 * @author milang
 */
public class ResultatsEvaluations {
    private ArrayList<Evaluation> evals;

    private float noteMoyenne;
    
    public float getNoteMoyenne() {
        return noteMoyenne;
    }
    
    public void add(Evaluation e){
        evals.add(e);
    }
    // TO COMPLETE
}

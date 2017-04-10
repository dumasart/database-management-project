/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * 
 * @author milang
 */
public class Evaluation {
    /**
     * code of the expert tat does the evaluation 
     */
    private int codeArtiste;
    /**
     * code of the evaluated act 
     */
    private int codeNumero;
    /**
     * comment of the evaluation set by the expert  
     */
    private String evaluation;
    /**
     * note given by the expert
     */
    private int note;
    /**
     * Constructor of the Evaluation class
     * @param codeArtiste : code of the expert
     * @param codeNumero : code of the act
     * @param evaluation : comment of the evaluation
     * @param note : note of the evaluation
     */
    public Evaluation(int codeArtiste, int codeNumero, String evaluation, int note){
        this.codeArtiste = codeArtiste;
        this.codeNumero = codeNumero;
        this.evaluation = evaluation;
        this.note = note;
    }
    /**
     * 
     * @return code of the act evaluated 
     */
    public int getCodeNumero(){
        return this.codeNumero;
    }
    /**
     * 
     * @return code of the evaluator  
     */
    public int getID(){
        return codeArtiste;
    }
    /**
     * 
     * @return return the comment of the evaluation 
     */
    public String getEvaluation(){
        return this.evaluation;
    }
    /**
     * 
     * @return return note given by the expert 
     */
    public int getNote(){
        return this.note;
    }
    /**
     * 
     * @return introduction of the evaluation
     */
    @Override 
    public String toString() {
        return "Le numero: "+this.codeNumero+", evalué par: "+this.codeArtiste+
                ", a reçus la note: "+this.note+".\n Le commentaire donné est: \n"+
                this.evaluation;
    }
}

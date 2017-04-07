/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Business;

/**
 *
 * 
 * @author milang
 */
public class Evaluation {
    
    private int codeArtiste;
    private int codeNumero;
    private String evaluation;
    private int note;
    
    public Evaluation(int codeArtiste, int codeNumero, String evaluation, int note){
        this.codeArtiste = codeArtiste;
        this.codeNumero = codeNumero;
        this.evaluation = evaluation;
        this.note = note;
    }
    
    public int getID(){
        return codeArtiste;
    }
    
    public String getEvaluation(){
        return this.evaluation;
    }
    
    public int getNote(){
        return this.note;
    }
    // Cela correspond évaluation d'un expert
}

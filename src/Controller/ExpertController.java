/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Business.Numero;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Classe mère pour les controleurs Experts
 * @author nomezing
 */
public class ExpertController {
    
    private Collection<Numero> listeNumeros;
    
    
    public Iterator<Numero> getNumerosIterator() {
        if (this.listeNumeros != null) {
            return this.listeNumeros.iterator();
        }
        return null;
    }
    
    public int getIDNumero(int index) {
        return ((ArrayList<Numero>)listeNumeros).get(index).getID();
    }
    
    public void commentaire(int codeNum, String com) {
        //dao.ajouteCommentairePourNumero(codeNum, com);
        //updateData();
    }
    
    public void ajouteNote(int codeNum, int note) {
        //dao.ajouteNotePourNumero(codeNum, note);
        //updateData();
    }
    
    public void valideNumero(int codeNum) {
        // TODO
    }
    
    public void updateData() {
        //this.listeNumeros = dao.getNumerosPourEvaluer();
    }
    
}

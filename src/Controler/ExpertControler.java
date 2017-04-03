/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.Business.Numero;
import Model.DataAccessLayer.DAO;
import View.UserInterface;
import java.util.Collection;

/**
 *
 * @author luud
 */
public class ExpertControler {
    private Collection<Numero> listeNumeros;
    private UserInterface tView;
    
    public ExpertControler(Collection<Numero> nums, UserInterface view) {
        this.listeNumeros = nums;
        this.tView = view;
    }
    
    public void commentaire(int codeNum, String com) {
        DAO dao = new DAO();
        dao.ajouteCommentairePourNumero(codeNum, com);
    }
    
    public void ajouteNote(int codeNum, int note) {
        DAO dao = new DAO();
        dao.ajouteNotePourNumero(codeNum, note);
    }
    
    public void valideNumero(int codeNum) {
        // TODO
    }
    
    public void afficheNumeros() {
        this.tView.displayNumeros(this.listeNumeros.iterator());
    }
    
}

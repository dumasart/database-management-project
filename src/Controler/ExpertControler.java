/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.DataAccessLayer.DAO;

/**
 *
 * @author luud
 */
public class ExpertControler {
    private Collection<Numero> listeNumeros;
    private UserInterface view;
    
    public void commentaire(Numero num, String com) {
        DAO dao = new DAO();
        dao.ajouteCommentairePourNumero(num, com);
    }
    
    public void ajouteNote(Numero num, int note) {
        DAO dao = new DAO();
        dao.ajouteNotePourNumero(num, note);
    }
    
    public void valideNumero(Numero num) {
        // TODO
    }
}

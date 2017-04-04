/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.Factory;
import Model.Business.Numero;
import Model.Business.Spectacle;
import Model.DataAccessLayer.DAO;
import java.util.Collection;

/**
 * Ce contrôleur va vérifier et ajouter les numéros dans le Spectacle
 * @author luud
 */
public class JuryViewController {
    private Collection<Numero> listeMeilleursNumeros;
    private Collection<Spectacle> listeSpectacles;
    
    public JuryViewController() {
        updateData();
    }
    
    public void updateData() {
        DAO dao = Factory.getDAO();
        this.listeMeilleursNumeros = dao.getNumerosValides();
        this.listeSpectacles = dao.getSpectacles();
    }
    
    public void ajouteNumeroASpectacle(Numero num, Spectacle spec) {
        Factory.getDAO().ajouteNumeroASpectacle(num, spec);
    }
}

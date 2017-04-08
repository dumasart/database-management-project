/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Business.Factory;
import Model.Business.Enum_theme;
import Model.Business.Numero;
import Model.Business.Spectacle;
import Model.DataAccessLayer.DAO;
import java.util.Collection;
import java.util.Map;

/**
 * Ce contrôleur va vérifier et ajouter les numéros dans le Spectacle
 * @author luud
 */
public class JuryViewController {
    private Map<Float, Numero> listeMeilleursNumeros;
    private Collection<Spectacle> listeSpectacles;
    
    public JuryViewController() {
        updateData(Enum_theme.Acrobatie);
    }
    
    public void updateData(Enum_theme theme) {
        DAO dao = Factory.getDAO();
        this.listeMeilleursNumeros = dao.getMeilleursNumerosParTheme(theme);
        this.listeSpectacles = dao.getSpectacles();
    }
    
    public void ajouteNumeroASpectacle(Numero num, Spectacle spec) {
        Factory.getDAO().ajouteNumeroASpectacle(num, spec);
    }
}
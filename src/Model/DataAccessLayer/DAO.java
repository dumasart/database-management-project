/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import BackEnd.RequeteOrganisateur;
import BackEnd.RequeteExpert;
import BackEnd.RequeteOrganisateur;
import Model.Business.Artiste;
import Model.Business.Enum_theme;
import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Spectacle;
import Model.Business.User;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author luud
 */
public class DAO {
    
    // Des méthodes pour manipuler la donnée
    /**
     * Un expert saisit des commentaires pour un numero
     * @param codeNum
     * @param com 
     */
    public void ajouteCommentairePourNumero(int codeNum, String com) {
        RequeteExpert.updateComment(codeNum, com);
    }
    
    /**
     * Un expert saisit la note pour un numéro
     * @param codeNum
     * @param note 
     */
    public void ajouteNotePourNumero(int codeNum, int note) {
        RequeteExpert.updateNote(codeNum, note);
    }
    
    /**
     * Un expert reprend la liste des numéros qu'il doit évaluer
     * @return liste des numéros
     */
    public Collection<Numero> getNumerosPourEvaluer() {
        Collection<Numero> rets= RequeteExpert.getNumeros().getNumeros();
        return rets;
    }
    
    
    public void ajouteExpert(Expert exp) {
        RequeteOrganisateur.addExpert(exp);
    }
    
    public void ajouteArtiste(Artiste artiste) {
        
    }
    
    public void ajouteSpectacle(Spectacle spectacle) {
        RequeteOrganisateur.addSpectacle(spectacle);
    }  
    
    public void ajouteNumero(Numero numero) {
        RequeteOrganisateur.addNumero(numero);
    }
    
    public Collection<Expert> getAllExperts() {
        // TODO
        return null;
    }

    public Collection<Numero> getProgrammeSpectacle(int codeSpec) {
        return RequeteOrganisateur.getNumerosInSpectacle(codeSpec).getNumeros();
    }

    
    /**
     * S'authentifier
     * @param username
     * @param password
     * @return un user (expert ou organisateur)
     */    
    public User getUserByUserNameAndPassword(String username, String password) {
        System.out.println("Not yet Implemented!\n");
        return new User(username, password);
        // TO COMPLETE
    }

    /**
     * Prendre le programme du festival
     * @return liste des spectacles dans le festival
     */
    public Collection<Spectacle> getSpectacles() {
        return RequeteOrganisateur.getSpectacles().getSpectacles();
    }

    /**
     * Ajouter un numéro à un spectacle
     * @param num
     * @param spec 
     */
    public void ajouteNumeroASpectacle(Numero num, Spectacle spec) {
        RequeteOrganisateur.addNumeroToSpectacle(spec, num);
    }


    /**
     * @param theme
     * @return liste des meilleurs numéros par theme
     */
    public Map<Float, Numero> getMeilleursNumerosParTheme(Enum_theme theme) {
        // Get all numeros par theme
        Collection<Numero> listeNumerosParTheme = RequeteOrganisateur.getNumerosByTheme(theme).getNumeros();
        Map<Float, Numero> classement = new TreeMap<Float, Numero>(Collections.reverseOrder());
        
        for (Numero num: listeNumerosParTheme) {
            float noteMoyenne = RequeteOrganisateur.getMoyenneNumero(num);
            classement.put(noteMoyenne, num);
        }
        
        // Résultats
        return classement;
    }

}
    
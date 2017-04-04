/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import BackEnd.RequeteOrganisateur;
import Model.Business.Artiste;
import Model.Business.Numero;
import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Spectacle;
import Model.Business.User;
import java.util.Collection;

/**
 *
 * @author luud
 */
public class DAO {
    private TheConnection cntion;
    //
    
    // Des méthodes pour manipuler la donnée
    public void ajouteCommentairePourNumero(int codeNum, String com) {
        //TODO
        System.out.println("Not yet Implemented!\n");
    }
    
    
    public void ajouteNotePourNumero(int codeNum, int note) {
        //TODO
    }
    
    public Collection<Numero> getNumeros() {
        System.out.println("Not yet Implemented!\n");
        //RequeteExpert ret = new RequetExpert();
        //Collection<Numero> rets= ret.getNumeros();
        //return rets;
        return null;
    }
    
    
    public void ajouteExpert(Expert exp) {
        RequeteOrganisateur req = new RequeteOrganisateur();
        
        req.addExpert(exp);
    }
    
    public void ajouteArtiste(Artiste artiste) {
        
    }
    
    public void ajouteSpectacle(Spectacle spectacle) {
        RequeteOrganisateur req = new RequeteOrganisateur();
        
        req.addSpectacle(spectacle);
    }  
    
    public void ajouteNumero(Numero numero) {
        RequeteOrganisateur req = new RequeteOrganisateur();
        
        req.addNumero(numero);
    }
    
    public User getUserByUserNameAndPassword(String username, String password) {
        System.out.println("Not yet Implemented!\n");
        return new User(username, password);
    }
}
    
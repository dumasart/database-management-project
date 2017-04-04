/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;


import BackEnd.RequeteExpert;
import Model.Business.Artiste;
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
    
    // Des méthodes pour manipuler la donnée
    public void ajouteCommentairePourNumero(int codeNum, String com) {
        //TODO
        System.out.println("Not yet Implemented!\n");
    }
    
    
    public void ajouteNotePourNumero(int codeNum, int note) {
        //TODO
    }
    
    public Collection<Numero> getNumeros() {
        RequeteExpert ret = new RequeteExpert();
        Collection<Numero> rets= ret.getNumeros().getNumeros();
        return rets;
    }
    
    
    public void ajouteExpert(Expert exp) {
        // TODO
    }
    
    public void ajouteArtiste(Artiste artiste) {
        //TODO:
    }
    
    public void ajouteSpectacle(Spectacle spectacle) {
        //TODO:
    }  
    
    public void ajouteNumero(Numero numero) {
        //TODO:
    }
    
    public User getUserByUserNameAndPassword(String username, String password) {
        System.out.println("Not yet Implemented!\n");
        return new User(username, password);
    }
}
    
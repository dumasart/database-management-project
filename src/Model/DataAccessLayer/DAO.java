/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import Model.Business.Numero;
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
        System.out.println("Not yet Implemented!\n");
    }
    
    public Collection<Numero> getNumeros() {
        System.out.println("Not yet Implemented!\n");
        //RequeteExpert ret = new RequetExpert();
        //Collection<Numero> rets= ret.getNumeros();
        //return rets;
        return null;
    }
    
    
    
    public User getUserByUserNameAndPassword(String username, String password) {
        System.out.println("Not yet Implemented!\n");
        return new User(username, password);
    }
}
    
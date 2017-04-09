/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Business.Factory;
import Model.Business.User;

/**
 *
 * @author nomezing
 */
public abstract class LoginController {
    
        
    /**
     * Méthode pour gérer la vérification de l'identifiant et du mot de passe
     * @param username
     * @param password
     * @return 
     */
    public User identifieUser(String username, String password) {
        /*
        DAO dao = Factory.getDAO();
        User user = dao.getUserByUserNameAndPassword(username, password);
        
        if (user != null) {
            //Factory.setUser(user);
            return user;
        }
        */
        return null;
    }
    
}

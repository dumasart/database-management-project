/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;

/**
 *
 * @author nomezing
 */
public abstract class LoginController {
    
    //private UserDAO dao = new UserDAOSQL();
        
    /**
     * Méthode pour gérer la vérification de l'identifiant et du mot de passe
     * @param username
     * @param password
     * @return 
     */
    public User identifieUser(String username, String password) {
        /*
        User user = dao.getUserByUserNameAndPassword(username, password);
        
        if (user != null) {
            return user;
        }
        */
        return null;
    }
    
}

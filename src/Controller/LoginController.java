/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DataAccessLayer.ConnectionSQL;
import Model.DataTransfertObject.UserDAO;
import Model.DataTransfertObject.UserDAOSQL;
import Model.DataTransfertObject.User;

/**
 *
 * @author nomezing
 */
public abstract class LoginController extends MainController {
    
    private final UserDAO userDAO = new UserDAOSQL();
        
    /**
     * Méthode pour gérer la vérification de l'identifiant et du mot de passe
     * @param username
     * @param password
     * @return 
     */
    public boolean identifyUser(String username, String password) {
        
        User user = userDAO.getUserByUserNameAndPassword(username, password);
        
        if (user != null) {
            System.out.println("je suis connecté");
            this.setConnectedUser(user);
            return true;
        }
        return false;
    }
    
}

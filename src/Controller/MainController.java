/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Business.User;

/**
 *
 * @author nomezing
 */
class MainController {
    
    private User connectedUser;

    User getConnectedUser() {
        return connectedUser;
    }

    void setConnectedUser(User connectedUser) {
        this.connectedUser = connectedUser;
    }
    
}

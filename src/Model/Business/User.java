/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Business;

/**
 *
 * @author luud
 */
public class User {
    private String username;
    private String password;
    private boolean isOrganisateur;
    private int userId;
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public int getUserId() {
        return this.userId;
    }
}

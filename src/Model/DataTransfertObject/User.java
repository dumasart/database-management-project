/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

/**
 *
 * @author luud
 */
public class User {


    
    public enum UserType {EXPERT, ORGANISATEUR, JURY};
    /**
     * username of the user
     */
    private final String username;
    /**
     * password of the user account
     */
    private final String password;
    /**
     * type of the user (expert or organisateur)
     */
    private final UserType type;
    
    /**
     * Constructor
     * @param username
     * @param password
     * @param type 
     */
    User(String username, String password, UserType type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    /**
     * 
     * @return username of the user
     */
    public String getIdentifiant() {
        return this.username;
    }
    /**
     * 
     * @return type of the user
     */
    public UserType getUserType() {
        return this.type;
    }
    
    /**
     * 
     * @return password of the user  
     */
    String getPassword() {
        return password;
    }
    
}

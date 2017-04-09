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
    
    private final String username;
    private final String password;
    private final UserType type;
    
    
    User(String username, String password, UserType type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    
    public String getIdentifiant() {
        return this.username;
    }
    
    public UserType getUserType() {
        return this.type;
    }
    
    
    String getPassword() {
        return password;
    }
    
}

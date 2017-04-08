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
    
    public enum UserType {EXPERT, ORGANISATEUR, JURY};
    
    private String username;
    private String password;
    private UserType type;
    
    // TODO 
    /*réduire la portée du constructeur pour qu'on ne puisse pas
      y acceder en dehors du modèle (question de sécurité) */
    public User(String username, String password, UserType type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getUserId() {
        return this.username;
    }
    
    public UserType getUserType() {
        return this.type;
    }
}

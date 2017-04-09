/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import BackEnd.Getter;
import Model.Business.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author bonhomme
 */
public class UserDAOSQL {
   
    /**
     * update the password of a user
     * @param u
     * @param newPwd
     * @param oldPwd
     * @return 
     */
    public static boolean update(User u, String newPwd, String oldPwd){
        String test = "SELECT * FROM Login WHERE codeArtiste = " + u.getUserId();
        //
        try {
            ResultSet b = Getter.request(test);
            if (b.next()) {
                String pwd = b.getString("motDePasse");
                if (pwd.equals(oldPwd)){
                    Getter.request("UPDATE Login Set MotDePasse="+newPwd+" WHERE codeArtiste = " + u.getUserId());
                    // TODO: Factory.setUser est mal utilisé
                    // Factory.setUser(Factory.getUser().getUserId(), newPwd);
                    return true;
                }
            }
            else{
                return false;
            }
        }
        catch(SQLException e) {
            System.out.println("SQL erreur : Aucun numéro");
        }
        return false;
    }
    
    /** 
     * créer un nouveau compte en lui donnant un login
     * @param Pwd
     * @return true si l'account a bien été crée, false sinon
     */
    public static boolean insert(User u, String pwd){
        String test = "SELECT * FROM Artiste WHERE codeArtiste = " + u.getUserId();
        try {
            ResultSet b = Getter.request(test);
            if (b.next()) {
                Getter.request("INSERT INTO Login VALUES ( " + u.getUserId() + " , " + pwd+ " )");
                // TODO: Factory.setUser est mal utilisé
                // Factory.setUser(codeArt, Pwd);
                return true;
            }
        }
        catch(SQLException e){
            System.out.println("SQL erreur : Aucun numéro");
        }
        return false;
    }
    
    public boolean delete(User u){
        String del = "DELETE * FROM Login WHERE codeArtiste = " + u.getUserId();
        Getter.request(del);
        return true;
    }

    
}

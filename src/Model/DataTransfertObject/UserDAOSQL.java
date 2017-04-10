/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import DataAccessLayer.ConnectionSQL;
import DataAccessLayer.Getter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author dumasart
 */
public class UserDAOSQL implements UserDAO {
   
    /**
     * update the password of a user
     * @param u
     * @param newPwd
     * @param oldPwd
     * @return 
     */
    @Override
    public boolean update(User u, String newPwd, String oldPwd) {
        String test = "SELECT * FROM CompteUtilisateur WHERE codeArtiste = " + u.getIdentifiant();
        //
        try {
            ResultSet b = Getter.request(test);
            if (b.next()) {
                String pwd = b.getString("motDePasse");
                if (pwd.equals(oldPwd)){
                    Getter.request("UPDATE CompteUtilisateur Set MotDePasse="+newPwd+" WHERE codeArtiste = " + u.getIdentifiant());
                    // TODO: Factory.setUser est mal utilisé
                    // Factory.setUser(Factory.getUser().getIdentifiant(), newPwd);
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
     * créer un nouveau compte Expert
     * @param user
     * @param pwd
     * @return true si l'account a bien été crée, false sinon
     */
    @Override
    public boolean insert(User user, String pwd) {
        String test = "SELECT * FROM Artiste WHERE codeArtiste = " + user.getIdentifiant();
        try {
            ResultSet b = Getter.request(test);
            if (b.next()) {
                Getter.request(
                        "INSERT INTO CompteUtilisateur VALUES ( " + user.getIdentifiant() + " , " + pwd + " , Expert)");
                return true;
            }
        }
        catch(SQLException e){
            System.out.println("SQL erreur : Aucun numéro");
        }
        return false;
    }
    
    @Override
    public boolean delete(User u){
        String del = "DELETE * FROM CompteUtilisateur WHERE codeArtiste = " + u.getIdentifiant();
        Getter.request(del);
        return true;
    }

    /**
     * Fonction d'authentification 
     * Si le mot de passe et l'identifiant sont correct on récupère un User
     * qui contient les information
     * @param username
     * @param password
     * @return 
     */
    @Override
    public User getUserByUserNameAndPassword(String username, String password) {
        try {
            Connection connection =ConnectionSQL.getDBConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM CompteUtilisateur WHERE identifiant= '" 
                    + username + "' AND motDePasse = '" + password + "'"); 

            if (rs.next()) {
                User.UserType type;
                if ( rs.getString("typeCompte").compareTo("Admin") == 0) {
                            type = User.UserType.ORGANISATEUR;
                } else {
                    type = User.UserType.EXPERT;
                }
                
                User newUser = new User (
                        rs.getString("identifiant"),
                        rs.getNString("motDePasse"),
                        type
                        );
                
                stmt.close();
                
                return newUser;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Echec d'authentification");
        }
        
        return null;
    }

    
}

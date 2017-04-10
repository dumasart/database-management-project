/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.*;

/**
 *
 * @author milang
 * class local qui ne sert qu'à effectuer les requètes 
 */
public class Getter {
    private static Statement stmt=null;
    public static ResultSet request(String requete) {
        Connection connection;
        ResultSet rs;
        try {
            connection = ConnectionSQL.getDBConnection();
            if(stmt!=null) {
                stmt.close();
            }
            stmt = connection.createStatement();
            rs = stmt.executeQuery(requete);
            
            return rs;
        }
        catch(SQLException e) {
            System.out.println("Statement non crée");
        }
        return null;
    }
    
    public static int update(String request) {
        Connection connection;
        int res;
        try {
            if(stmt!=null) {
                stmt.close();
            }
            connection = ConnectionSQL.getDBConnection();
            stmt = connection.createStatement();
            res = stmt.executeUpdate(request);
            return res;
        } catch (SQLException e) {
            System.out.println("Update non traitée");
        }
        return 0;
    }
    public static void close() {
        try {
            stmt.close();
            stmt=null;
        }
        catch(SQLException e) {
            System.out.println("Statement non crée");
        }
    }
}

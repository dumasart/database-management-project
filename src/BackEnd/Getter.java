/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.*;

/**
 *
 * @author milang
 * class local qui ne sert qu'à effectuer les requètes 
 */
class Getter {
    private static Statement stmt = null;
    public static ResultSet request(String requete) {
        Connection connection;
        Statement stmt;
        ResultSet rs;
        try {
            connection = ConnectionPacket.getDBConnection();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(requete);
            // libère les ressources de la base de données
            connection.close();
            stmt.close();
            return rs;
        }
        catch(SQLException e) {
            System.out.println("Statement non crée");
        }
        return null;
    }
    
    public static int update(String request) {
        try {
            if (stmt == null) {
                stmt = ConnectionPacket.getDBConnection().createStatement();
            }
            return stmt.executeUpdate(request);
        } catch (SQLException e) {
            System.out.println("Update non traitée");
        }
        return 0;
    }
}

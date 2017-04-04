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
    public ResultSet request(String requete) {
        try {
        Statement stmt = ConnectionPacket.getConnectionAccess().createStatement();
        }
        catch(SQLException e) {
            System.out.println("Statement non crée");
        }
        return null;
    }
}

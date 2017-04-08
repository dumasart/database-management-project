/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author milang
 */
class ConnectionPacket {

    /* parametres de connexion écrits en dur */
    private static final String BD_URL    = "";
    private static final String BD_USER   = "";
    private static final String BD_PWD    = "";
    
    /**
     * Méthode pour récupérer une connection à la base de données
     * @return 
     */
    static Connection getDBConnection() throws RuntimeException {
        try {
            //TODO 
            /* quand on aura fini il faudrait pouvoir changer le type de base de donnée */
            Class.forName("oracle.jdbc.OracleDriver");
            return DriverManager.getConnection(BD_URL,BD_USER,BD_PWD);
        }
        catch(SQLException ex) {
            throw new RuntimeException("Impossible de se connecter à la base de donnée!\n",ex);
        }
        catch(ClassNotFoundException ex) {
            throw new RuntimeException("Driver de base de données incorrect!\n",ex);
        }
    }

}
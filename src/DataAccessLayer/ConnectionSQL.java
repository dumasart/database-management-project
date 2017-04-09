/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author milang
 */
class ConnectionSQL {

    /* parametres de connexion écrits en dur */
    private static final String BD_URL    = "";
    private static final String BD_USER   = "";
    private static final String BD_PWD    = "";
    private static Connection connection=null;
    /**
     * Méthode pour récupérer une connection à la base de données
     * @return 
     */
    static Connection getDBConnection() throws RuntimeException {
        try {
            if (connection == null) {
                Class.forName("oracle.jdbc.OracleDriver");
                connection = DriverManager.getConnection(BD_URL, BD_USER, BD_PWD);
                return connection;
            } else {
                return connection;
            }
        }
        catch(SQLException ex) {
            throw new RuntimeException("Impossible de se connecter à la base de donnée!\n",ex);
        }
        catch(ClassNotFoundException ex) {
            throw new RuntimeException("Driver de base de données incorrect!\n",ex);
        }
    }

}

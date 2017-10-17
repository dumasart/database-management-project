/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;

/**
 *
 * @author milang
 */
public class ConnectionSQL {

    /* parametres de connexion écrits en dur */
    private static final String BD_URL    = "jdbc:oracle:thin:@ensioracle1.imag.fr:1521:ensioracle1";
    // private static final String BD_USER   = ""; //Your tag
    // private static final String BD_PWD    = ""; // Your pwd
    private static Connection connection=null;
    private static Savepoint svpt =null;
    /**
     * Méthode pour récupérer une connection à la base de données
     * @return 
     */
    public static Connection getDBConnection() throws RuntimeException {
        try {
            if (connection == null) {
                Class.forName("oracle.jdbc.OracleDriver");
                connection = DriverManager.getConnection(BD_URL, BD_USER, BD_PWD);
                connection.setAutoCommit(false);
                
            }
            return connection;
        }
        catch(SQLException ex) {
            throw new RuntimeException("Impossible de se connecter à la base de donnée!\n",ex);
        }
        catch(ClassNotFoundException ex) {
            throw new RuntimeException("Driver de base de données incorrect!\n",ex);
        }
    }
    
    public static void closeConnection() throws SQLException {
        // ferme la connection
        if (!connection.isClosed()) {
            System.out.println("Closing connection...");
            do {
            connection.close();
            } while (!connection.isClosed());
        }
        System.out.println("Connection closed ...");
    }
    
    
    public static boolean commit() {
        try {
            getDBConnection().commit();
            return true;
        }
        catch(SQLException e) {
            return false;
        }
        
    }
    
    
    public static boolean rollback() {
        try {
            getDBConnection().rollback();
            return true;
        }
        catch(SQLException e) {
            return false;
        }
        
    }
    
    
    public static boolean savePoint() {
        
        try {
            getDBConnection().setSavepoint();
            return true;
        }
        catch(SQLException e) {
            return false;
        }
        
    }
}

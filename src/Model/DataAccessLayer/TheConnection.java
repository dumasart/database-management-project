s/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;
import java.sql.*;
import jdbcSTUB.*;
/**
 *
 * @author luud
 */


public class TheConnection {
    
    private ConnectionInfo info;
    private Connection conn;

    public void open () {
	try {
	    // Enregistrement du driver Oracle
	    System.out.print("Loading Oracle driver... ");
	    //DriverManager.registerDriver(new
	    //oracle.jdbc.driver.OracleDriver());
	    DriverManager.registerDriver();
	    System.out.println("loaded");
	    
	    // Etablissement de la connection
	    System.out.print("Connecting to the database... ");
	    conn = DriverManager.getConnection
		(info.CONN_URL, info.USER, info.PASSWD);
	    System.out.println("connected");
        } catch (SQLException e) {
            System.err.println("failed");
            e.printStackTrace(System.err);
        }
	
    }
    public void close () { conn.close (); }
    
    Connection getConnection () { return conn; } // bof...

    public TheConnection (ConnectionInfo info) { this.info = info; }
}
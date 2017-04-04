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
public class ConnectionPacket {
    private static Connection co=null;
    public static void openConnection(String BD_URL,String BD_USER,String BD_PWD){
        if(co==null) {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
                co = DriverManager.getConnection(BD_URL,BD_USER,BD_PWD);
            }
            catch(SQLException e) {
                System.out.println("Oups!\n");
            }
            catch(ClassNotFoundException e) {
                System.out.println("Demander pourquoi pas le bon driver!\n");
            }
        }
    }
    public static Connection getConnectionAccess() {
        return co;
    }
    public static void closeConnection() {
        while(co!=null) {
            try {
                co.close();
                co=null;
            }
            catch(SQLException e) {
                System.out.println("RIP le systeme de l'imag!!!!\n");
            }
        }
    }
}

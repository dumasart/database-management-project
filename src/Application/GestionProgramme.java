/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import DataAccessLayer.ConnectionSQL;
import DataAccessLayer.Getter;
import View.Console.GesProgrammeConsole;
import java.sql.SQLException;

/**
 *La classe pour gérer les programmes de façon globale :
 *          -Afficher le programme global du festival
 *          -Afficher le programme pour chaque spectacle
 * @author nabem
 */
public class GestionProgramme {  
    
    public  static void main(String args[]) throws SQLException {
        try {
            GesProgrammeConsole console = new GesProgrammeConsole();
            console.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ferme la connection si elle n'a pas été fermée
            Getter.close();
            ConnectionSQL.closeConnection();
        }
    }
}
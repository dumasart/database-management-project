/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import DataAccessLayer.ConnectionSQL;
import DataAccessLayer.Getter;
import View.Console.ExpertConsole;
import java.sql.SQLException;

/**
 * Exécutable de saisie des évaluations: un expert se connecte, chosit un 
 * des numéros qu'il doit évaluer, saisi la note ainsi que le commentaire
 * @author nomezing
 */

public class ExpertApplication {
    
    public static void main(String[] args) throws SQLException {
        try {
            // crée un nouvelle console expert et lance le programme
            ExpertConsole ec = new ExpertConsole();
            ec.start();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ferme la connection si elle n'a pas été fermée
            Getter.close(); 
            ConnectionSQL.closeConnection();
        }
    }   
}

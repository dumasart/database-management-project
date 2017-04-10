
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;


import Model.ArtisteParticipant;
import Model.ArtistePrincipal;
import Model.Expert;
import Model.Numero;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author milang
 */
public class RequeteOrganisateur {

 
     
    public static int getMoyenneNumero(Numero numero){
        String cmd = "SELECT AVG(Note) FROM (evaluation INNER JOIN Numero WHERE evaluation.codeNumero = Numero.codeNumero) WHERE evaluation.codeNumero = " + numero.getID();
        try {
            ResultSet b = Getter.request(cmd);
            if (b.next()) {
                return b.getInt("AVG(Note)");
            }
        }
        catch(SQLException e) {
            System.out.println("Erreur SQL : Aucune note");
        } 
        return -1;
    }
   
    
    /**
     * crée un article principal
     * @param ap
     * @return 
     */
    public static boolean addPrincipal (ArtistePrincipal ap) {
       // addParticipant(ap);
        String req= "INSERT INTO ArtistePrincipal VALUES (" +ap.getNumTel() + ")";
        return true;
    }     



 
}

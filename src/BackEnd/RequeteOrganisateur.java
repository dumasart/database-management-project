
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;


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
     * Ajoute un participant dans la BD.
     * Ajoute son/ses thème/s d'expertise dans EstExpertEn
     * @param ap
     * @return boolean
     */
    public static boolean addParticipant(ArtisteParticipant ap) {
        //addArtiste(ap);
        String req= "INSERT INTO ArtisteParticipant VALUES (" +ap.getID() + ")";
        Iterator<Integer> it = ap.getListeNumero().iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            String s2 = "INSERT INTO ParticipeA VALUES (" + ap.getID() + ", " + i + ")";
            Getter.update(s2);
        }
        Getter.update(req);
        return true;
    }     
    
    /**
     * crée un article principal
     * @param ap
     * @return 
     */
    public static boolean addPrincipal (ArtistePrincipal ap) {
        addParticipant(ap);
        String req= "INSERT INTO ArtistePrincipal VALUES (" +ap.getNumTel() + ")";
        return true;
    }     
    
    /**
     * Affecte un numéro à un expert
     * @param exp
     * @param numero 
     */
    public static boolean associeNumeroExpert(Expert exp, Numero numero) {
        String cmd = "INSERT INTO Evaluation VALUES (" + exp.getId() + ", " + numero.getID() + ")";
        Getter.update(cmd);
        exp.ajouteNumero(numero);
        return true;
    }

    public void getExpertsAvailable(ArrayList<Expert> liste1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}

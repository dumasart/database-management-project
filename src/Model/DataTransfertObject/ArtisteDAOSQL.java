/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import DataAccessLayer.Getter;
import Model.Artiste;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nomezing
 */
public class ArtisteDAOSQL implements ArtisteDAO {
    

    /**
     * Met à jour un artiste
     * @param artiste
     * @return true si ça a marché
     */
    @Override
    public boolean update(Artiste artiste) {
        String up = "UPDATE Artiste SET codeCirque=" + artiste.getCodeCirque()
                + " , nomArtiste=" + artiste.getNom()
                + " , prenomArtiste=" + artiste.getPrenom()
                + " , dateNaissanceArtiste" + artiste.getDate()
                + " , adresseArtiste=" + artiste.getAdresse()
                + " WHERE codeArtiste=" + artiste.getID();
        return Getter.update(up) == 1;
    }

    /**
     * Ajoute un artiste dans la BD
     * @param artiste
     * @return true si l'insertion s'est bien passée
     */
    @Override
    public boolean insert(Artiste artiste) {
        String req= "INSERT INTO Artiste VALUES (" +artiste.getID() + " , " +
                artiste.getCodeCirque() + " , " + artiste.getNom() + " , " +
                artiste.getPrenom() + " , " + artiste.getDate() + " , " +
                artiste.getAdresse() + ")";
        return Getter.update(req) == 1;
    }

    /**
     * Supprime un artiste de la BD et toutes ses dépendances
     * @param artiste
     * @return true si OK
     */
    @Override
    public boolean delete(Artiste artiste) {
        ExpertDAOSQL expertDAOSQL = new ExpertDAOSQL();
        ParticipantDAOSQL participantDAOSQL = new ParticipantDAOSQL();
        String test = "SELECT codeArtiste FROM Spectacle"
                + " UNION SELECT codeArtiste FROM Numero"
                + " UNION SELECT codeArtiste FROM ParticipeA"
                + " WHERE codeArtiste=" + artiste.getID();
        ResultSet rs;
        try {
            rs = Getter.request(test);
            rs.next();
            System.out.println("Erreur SQL : Impossible de supprimer l'artiste "+ artiste.getID() +", il est présentateur,"
                    + " participant ou principal de numero(s)");
            return false;
        } catch (SQLException e) {
            String cmd = "DELETE FROM Artiste WHERE CodeArtiste=" + artiste.getID();
            if (Getter.update(cmd) == 0) {
                return false;
            }
            cmd = "DELETE FROM ArtisteExpert WHERE CodeArtiste=" + artiste.getID();
            if (Getter.update(cmd) == 0) {
                return false;
            }
            cmd = "DELETE FROM ArtisteParticipant WHERE CodeArtiste=" + artiste.getID();
            if (Getter.update(cmd) == 0) {
                return false;
            }            
            cmd = "DELETE FROM ArtistePrincipal WHERE CodeArtiste=" + artiste.getID();
            if (Getter.update(cmd) == 0) {
                return false;
            }
            return true;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import DataAccessLayer.Getter;
import Model.Artiste;

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
                + " and nomArtiste=" + artiste.getNom()
                + " and prenomArtiste=" + artiste.getPrenom()
                + " and dateNaissanceArtiste" + artiste.getDate()
                + " and adresseArtiste=" + artiste.getAdresse()
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
        return true;
    }
    
}

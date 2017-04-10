/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import DataAccessLayer.Getter;
import Model.ArtisteParticipant;
import Model.Theme;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

/**
 *
 * @author piersonr
 */
public class ParticipantDAOSQL implements ParticipantDAO {
    private ArtisteDAO artisteDAO = new ArtisteDAOSQL();

    @Override
    public boolean update(ArtisteParticipant participant) {
        return artisteDAO.update(participant);
    }

    @Override
    public boolean insert(ArtisteParticipant participant) {
        String test = "SELECT codeArtiste FROM Artiste WHERE codeArtiste=" + participant.getID();
        ResultSet rs = Getter.request(test);
        try {
            rs.next();
        } catch (SQLException e) {
            if (!artisteDAO.insert(participant)) {
                System.out.println("Erreur SQL : Artiste Participant non répertorié dans Artiste; échec de l'insertion Artiste");
                return false;
            }
        }
        String req= "INSERT INTO ArtisteParticipant VALUES (" +participant.getID() + ")";
        return Getter.update(req) == 1;
    }

    @Override
    public boolean delete(ArtisteParticipant participant) {
        String cmd = "DELETE FROM ArtisteParticipant WHERE CodeArtiste=" + participant.getID();
        return Getter.update(cmd) == 1;    
    }
}

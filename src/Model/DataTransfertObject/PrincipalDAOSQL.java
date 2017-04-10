/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import DataAccessLayer.Getter;
import Model.ArtistePrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author piersonr
 */
public class PrincipalDAOSQL implements PrincipalDAO {
        private ParticipantDAO participantDAO = new ParticipantDAOSQL();


    @Override
    public boolean update(ArtistePrincipal principal) {
        if (!participantDAO.update(principal)) {
            return false;
        }
        String up = "UPDATE ArtistePrincipal SET NumTelPrincipal=" + principal.getNumTel()
                + " WHERE codeArtiste=" + principal.getID();
        return Getter.update(up) == 1;
    }

    @Override
    public boolean insert(ArtistePrincipal principal) {
        String test = "SELECT codeArtiste FROM Artiste "
                + "UNION SELECT codeArtiste FROM ArtisteParticipant "
                + "WHERE codeArtiste=" + principal.getID();
        ResultSet rs = Getter.request(test);
        try {
            rs.next();
        } catch (SQLException e) {
            if (!participantDAO.insert(principal)) {
                System.out.println("Erreur SQL : Artiste Participant non répertorié dans Artiste; échec de l'insertion Artiste");
                return false;
            }
        }
        String req= "INSERT INTO ArtisteParticipant VALUES (" +principal.getID() + ")";
        return Getter.update(req) == 1;
    }

    @Override
    public boolean delete(ArtistePrincipal principal) {
        String test = "SELECT codeArtiste FROM Numero"
                + " WHERE codeArtiste=" + principal.getID();
        ResultSet rs;
        try {
            rs = Getter.request(test);
            rs.next();
            System.out.println("Erreur SQL : Impossible de supprimer l'artiste "+ principal.getID() +", il est principal de numero(s)");
            return false;
        } catch (SQLException e) {
            String cmd = "DELETE FROM ArtistePrincipal WHERE CodeArtiste=" + principal.getID();
            return Getter.update(cmd) == 1;
        }
    }
    
}

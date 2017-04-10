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
 * @author romain
 */
public class OrganisateurDAOSQL implements OrganisateurDAO {
    private ArtisteDAOSQL artisteDAO = new ArtisteDAOSQL();

    @Override
    public boolean update(Artiste organisateur) {
        return artisteDAO.update(organisateur);
    }

    @Override
    public boolean insert(Artiste organisateur) {
        String test = "SELECT codeArtiste FROM Artiste WHERE codeArtiste=" + organisateur.getID();
        ResultSet rs = Getter.request(test);
        try {
            rs.next();
        } catch (SQLException e) {
            if (!artisteDAO.insert(organisateur)) {
                System.out.println("Erreur SQL : Artiste Organisateur non répertorié dans Artiste; échec de l'insertion Artiste");
                return false;
            }
        }
        String req= "INSERT INTO ArtisteOrganisateur VALUES (" +organisateur.getID() + ")";
        return Getter.update(req) == 1;    
    }

    @Override
    public boolean delete(Artiste organisateur) {
        String cmd = "DELETE FROM ArtisteOrganisateur WHERE CodeArtiste=" + organisateur.getID();
        return Getter.update(cmd) == 1; 
    }
    
}

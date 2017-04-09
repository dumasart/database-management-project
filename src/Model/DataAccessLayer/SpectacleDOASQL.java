/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import BackEnd.Getter;
import Model.Business.Spectacle;
import Model.Business.Theme;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milang
 */
public class SpectacleDOASQL implements SpectacleDAO{

    @Override
    public boolean update(Spectacle spectacle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Spectacle spectacle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Spectacle spectacle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Spectacle> getAllSpectacle() {
        ResultSet rs = Getter.request("SELECT * FROM Spectacle");
        List<Spectacle> spectacles = new ArrayList<>();
        try {
            while(rs.next()) {
                Spectacle spec=new Spectacle(
                        rs.getInt("codeSpectacle"),
                        rs.getDate("jourSpectacle").toString(),
                        rs.getInt("heureDebut"),
                        rs.getInt("heureFin"),
                        rs.getDouble("prixSpectacle"),
                        rs.getInt("codeArtiste"),
                        Theme.valueOf(rs.getString("theme")),
                        rs.getInt("codeFestival")
                );
                spectacles.add(spec);
            }
            return spectacles;
        }
        catch (SQLException e) {
            System.out.println("Erreur SQL : Aucun spectacle");
        }
        return null;
    }
    
}

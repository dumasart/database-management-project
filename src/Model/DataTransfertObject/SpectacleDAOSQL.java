/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import DataAccessLayer.ConnectionSQL;
import DataAccessLayer.Getter;
import Model.Numero;
import Model.Spectacle;
import Model.Theme;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author milang
 */
public class SpectacleDAOSQL implements SpectacleDAO{

    @Override
    public boolean update(Spectacle spectacle) {
        String cmd = "UPDATE Spectacle SET codeFestival = " +
                spectacle.getCodeFestival() +
                " AND jourSpectacle = " +
                spectacle.getJour() +
                " AND heureDebut = " +
                spectacle.getDebut() +
                " AND heureFin = " +
                spectacle.getFin() +
                " AND prixSpectacle = " +
                spectacle.getPrix() +
                " AND codeArtiste = " +
                spectacle.getPresentateur()+
                " AND theme = "+ 
                spectacle.getTheme() +
                " WHERE codeSpectacle = "+
                spectacle.getID()+";";
        int res=Getter.update(cmd);
        if(res==0)
            return false;
        else 
            return true;   
    }

    @Override
    public boolean insert(Spectacle spectacle) {
        String req = "INSERT INTO Spectacle (CodeSpectacle, JourSpectacle, HeureDebut, HeureFin, PrixSpectacle, CodeArtiste, Theme, codeFestival) VALUES (" + spectacle.getID() + " , " + spectacle.getJour() + " , " + spectacle.getDebut() + " , " + spectacle.getFin() + " , " + spectacle.getPrix()
                + " , " + spectacle.getPresentateur() + " , " + spectacle.getTheme() + " , " + spectacle.getCodeFestival() + ")";
        int res=Getter.update(req);
        if(res==0)
            return false;
        else 
            return true;
    }

    @Override
    public boolean delete(Spectacle spectacle) {
        String cmd = "DELETE from SPECTACLE WHERE CODESPECTACLE = "+spectacle.getID()+";";
        int res=Getter.update(cmd);
        if(res==0)
            return false;
        else 
            return true;
    }

    @Override
    public List<Spectacle> getAllSpectacle() {
        try {
            ResultSet rs = Getter.request("SELECT * FROM Spectacle");
            List<Spectacle> spectacles = new ArrayList<>();
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
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addNumero(Spectacle spectacle, Numero numero,int heure) {
        String cmd = "INSERT INTO NumeroAccepte(codeNumero, codeSpectacle, HeureNumero ) VALUES ( " + numero.getID() + " , " + spectacle.getID() + " , " + heure + ")";
        int res=Getter.update(cmd);
        if(res==0)
            return false;
        else 
            return true;
    }
        
}

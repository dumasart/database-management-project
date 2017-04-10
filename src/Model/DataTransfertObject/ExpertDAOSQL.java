/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import DataAccessLayer.Getter;
import Model.Expert;
import Model.Numero;
import Model.Theme;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author romain
 */
public class ExpertDAOSQL implements ExpertDAO {
    private ArtisteDAO artisteDAO = new ArtisteDAOSQL();

    @Override
    public boolean update(Expert expert) {
        artisteDAO.update(expert);
        String up = "UPDATE ArtisteExpert SET NumTelExpert=" + expert.getNumeroTel()
                + " WHERE codeArtiste=" + expert.getId();
        int rs = Getter.update(up);
        if (rs == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    @Override
    public boolean insert(Expert expert) {
        artisteDAO.insert(expert);
        String req= "INSERT INTO ArtisteExpert VALUES (" +expert.getID() + ")";
        Iterator<Theme> it = expert.getThemes().iterator();
        while (it.hasNext()) {
            Theme theme = it.next();
            String s2 = "INSERT INTO EstExpertEn VALUES (" + expert.getID() + ", " + theme + ")";
            Getter.update(s2);
        }
        Getter.update(req);
        return true;
    }

    @Override
    public boolean delete(Expert expert) {
        artisteDAO.delete(expert);
        String cmd = "DELETE FROM ArtisteExpert WHERE CodeArtiste=" + expert.getId();
        int rs = Getter.update(cmd);
        if (rs == 0) {
            return false;
        } else {
            return true;
        }
    }

    //TODO reprendre cette fonction, le comportement est bizarre
    // voir si y'a pas moyen d'avoir les expert disponible dans la BD
    // au lieu de passer une liste d'expert
    @Override
    public List<Expert> getExpertsAvailable(List<Expert> listeExp) {
        String cmd = "SELECT * FROM ArtisteExpert FULL JOIN Artiste ON ArtisteExpert.CodeArtiste=Artiste.CodeArtiste";
        if (listeExp.size() > 0) {
            cmd += " WHERE codeArtiste!=" + listeExp.get(0).getId();
        }
        if (listeExp.size() > 1) {
            cmd += " and codeArtiste!=" + listeExp.get(1).getId();
        }
        ArrayList<Expert> res = new ArrayList<Expert>();
        try {
            ResultSet b = Getter.request(cmd);
            while (b.next()) {
                Expert exp = new Expert(
                        b.getInt("codeArtiste"),
                        b.getInt("codeCirque"),
                        b.getString("nomArtiste"),
                        b.getString("prenomArtiste"),
                        b.getString("dateNaissanceArtiste"),
                        b.getString("adresseArtiste"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        b.getString("numTelExpert"),
                        new ArrayList<>()
                );
                res.add(exp);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : Aucun expert");
        }
        return res;
    }

    @Override
    public List<Expert> getAllExpert() {
        String cmd = "SELECT * FROM ArtisteExpert";
        ArrayList<Expert> res = new ArrayList<Expert>();
        try {
            ResultSet b = Getter.request(cmd);
            while (b.next()) {
                Expert exp = new Expert(
                        b.getInt("codeArtiste"),
                        b.getInt("codeCirque"),
                        b.getString("nomArtiste"),
                        b.getString("prenomArtiste"),
                        b.getString("dateNaissanceArtiste"),
                        b.getString("adresseArtiste"),
                        new ArrayList<>(),
                        new ArrayList<>(),
                        b.getString("numTelExpert"),
                        new ArrayList<>()
                );
                res.add(exp);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : Aucun expert");
        }
        return res;
    }
    
    @Override
    public Expert getExpertByID(int codeArtiste) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

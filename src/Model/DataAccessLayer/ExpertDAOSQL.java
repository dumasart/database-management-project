/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import BackEnd.Getter;
import BackEnd.ResultatsExperts;
import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Theme;
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

    @Override
    public boolean update(Expert expert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean insert(Expert expert) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Expert> getExpertsAvailable(List<Expert> listeExp) {
        String cmd = "SELECT * FROM ArtisteExpert FULL JOIN Artiste ON ArtisteExpert.CodeArtiste=Artiste.CodeArtiste";
        if (listeExp.size() > 0) {
            cmd += " WHERE codeArtiste!=" + listeExp.get(0);
        }
        if (listeExp.size() > 1) {
            cmd += " and codeArtiste!=" + listeExp.get(1);
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
                        new ArrayList<Numero>(),
                        new ArrayList<Theme>(),
                        b.getString("numTelExpert"),
                        new ArrayList<String>()
                );
                res.add(exp);
            }
        } catch (SQLException e) {
            System.out.println("Erreur SQL : Aucun expert");
        }
        return res;
    }

    @Override
    public List<Expert> getExpertsNumero(Numero numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

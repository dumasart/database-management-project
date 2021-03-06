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
    private ArtisteDAOSQL artisteDAO = new ArtisteDAOSQL();

    /**
     * Met à jour un artiste expert dans la base
     * @param expert
     * @return true si OK
     */
    @Override
    public boolean update(Expert expert) {
        if (!artisteDAO.update(expert)) {
            return false;
        }
        String up = "UPDATE ArtisteExpert SET NumTelExpert=" + expert.getNumeroTel()
                + " WHERE codeArtiste=" + expert.getId();
        return Getter.update(up) == 1;
    }
    
    /**
     * Ajoute un expert dans la base avec ses thèmes
     * @param expert
     * @return true si OK
     */
    @Override
    public boolean insert(Expert expert) {
        String test = "SELECT codeArtiste FROM Artiste WHERE codeArtiste=" + expert.getID();
        ResultSet rs = Getter.request(test);
        try {
            rs.next();
        } catch (SQLException e) {
            if (!artisteDAO.insert(expert)) {
                System.out.println("Erreur SQL : Artiste Expert non répertorié dans Artiste; échec de l'insertion Artiste");
                return false;
            }
        }
        String req = "INSERT INTO ArtisteExpert VALUES (" + expert.getID() + ")";
        Iterator<Theme> it = expert.getThemes().iterator();
        while (it.hasNext()) {
            Theme theme = it.next();
            String s2 = "INSERT INTO EstExpertEn VALUES (" + expert.getID() + ", " + theme + ")";
            if (Getter.update(s2) == 0) {
                System.out.println("ErreurSQL : Echec de l'insertion du theme" + theme + " associé à l'expert " + expert.getID());
                return false;
            }
        }
        return Getter.update(req) == 1;
    }

    /**
     * Supprime un expert de la base avec ses évaluations et ses thèmes
     * @param expert
     * @return true si OK
     */
    @Override
    public boolean delete(Expert expert) {
        String cmd = "DELETE FROM ArtisteExpert WHERE CodeArtiste=" + expert.getId();
        return Getter.update(cmd) == 1;
    }

    //TODO reprendre cette fonction, le comportement est bizarre
    // voir si y'a pas moyen d'avoir les expert disponible dans la BD
    // au lieu de passer une liste d'expert
    /**
     * Renvoi la liste des experts qui ne sont passés en argument
     * @param listeExp
     * @return List<Expert>
     */
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
    /**
     * 
     * @return all the expert in the data-base
     */
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
    public List<Expert> getExpertsWithoutEvaluationOnNumero(int numeroID) {
        String cmd = "SELECT codeArtiste, codeCirque, nomArtiste, prenomArtiste, datenaissanceArtiste, adresseArtiste, numTelExpert"
                + " FROM Artiste WHERE codeArtiste IN ( "
                + "SELECT codeArtiste FROM Evaluation "
                + "WHERE codeNumero=" + numeroID + "AND note is null";

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
            System.out.println("Erreur SQL : Aucun expert n'a pas évalué le numero " + numeroID);
        }
        return res;
    }
}

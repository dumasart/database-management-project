/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataTransfertObject;

import DataAccessLayer.Getter;
import Model.Expert;
import Model.Numero;
import Model.Spectacle;
import Model.Theme;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nomezing
 */
public class NumeroDAOSQL implements NumeroDAO {

    /**
     * 
     * @param numero to synchronize with the data-base
     * @return true eon success 
     */
    @Override
    public boolean update(Numero numero) {
        String up = "UPDATE Numero SET TitreNumero=" + numero.getTitre() + " and ResumeNumero="
                + numero.getResume() + " and DureeNumero=" + numero.getDuree()
                + " and NbArtisteNumero=" + numero.getNbArtiste() + " and EstCreation="
                + numero.getCreation() + " and codeArtiste=" + numero.getArtistePrincipal()
                + " and theme=" + numero.getTheme() + " WHERE codeNumero=" + numero.getID();
        int rs = Getter.update(up);
        if (rs == 0) {
            return false;
        } else {
            return true;
        }    
    }

    /**
     * 
     * @param numero to insert in the data-base
     * @return true on success 
     */
    @Override
    public boolean insert(Numero numero) {
        String cmd = "INSERT INTO Numero VALUES (" + numero.getID() +", " + numero.getTitre() + ", " + numero.getResume() + ", " + numero.getDuree()
                + ", " + numero.getNbArtiste() + ", " + numero.getCreation() + ", " + numero.getArtistePrincipal() + ", " + numero.getTheme() + ")";
        int rs = Getter.update(cmd);
        if (rs == 0) {
            return false;
        } else {
            return true;
        }    }
    
    /**
     * 
     * @param numero to delete from the data-base
     * @return true on success
     */
    @Override
    public boolean delete(Numero numero) {
        String cmd = "DELETE FROM Numero WHERE CodeNumero=" + numero.getID();
        int rs = Getter.update(cmd);
        if (rs == 0) {
            return false;
        } else {
            return true;
        }
    }
    /**
     * 
     * @param u user as expert 
     * @return return all the act that the user has to evaluate 
     */
    public List<Numero> getAllNumero(User u) {
        String s = "SELECT * FROM Evaluation JOIN Numero ON Evaluation.codeNumero=Numero.codeNumero WHERE codeArtiste="+u.getIdentifiant();
        ArrayList<Numero> nums = new ArrayList<Numero>();
        try {
            ResultSet b = Getter.request(s);
            while(b.next()) {
                Numero num = new Numero(
                        b.getInt("codeNumero"),
                        b.getString("TitreNumero"),
                        b.getString("ResumeNumero"),
                        b.getInt("DureeNumero"),
                        b.getInt("NbArtiste"),
                        b.getBoolean("estCreation"),
                        b.getInt("codeArtiste"),
                        b.getString("theme")
                );
                nums.add(num);
            }
        }
        catch(SQLException e) {
            System.out.println("SQL erreur : Aucun numéro");
        }
        return nums;
    }

    /**
     * 
     * @return return all the act in the data-base
     */
    @Override
    public List<Numero> getAllNumero() {
        String s = "SELECT * FROM Evaluation JOIN Numero ON Evaluation.codeNumero=Numero.codeNumero ";
        ArrayList<Numero> nums = new ArrayList<Numero>();
        try {
            ResultSet b = Getter.request(s);
            while(b.next()) {
                Numero num = new Numero(
                        b.getInt("codeNumero"),
                        b.getString("TitreNumero"),
                        b.getString("ResumeNumero"),
                        b.getInt("DureeNumero"),
                        b.getInt("NbArtiste"),
                        b.getBoolean("estCreation"),
                        b.getInt("codeArtiste"),
                        b.getString("theme")
                );
                nums.add(num);
            }
        }
        catch(SQLException e) {
            System.out.println("SQL erreur : Aucun numéro");
        }
        return nums;
    }

    /**
     * 
     * @param expertID : code of the expert 
     * @return all the act that the expert has to evaluate 
     */
    @Override
    public List<Numero> getNumeroByExpertID(String expertID) {

        String s = "SELECT codeNumero, TitreNumero, ResumeNumero, DureeNumero, "
                + "NbArtisteNumero, EstCreation, CodeArtiste, ThemeNumero "
                + "FROM Evaluation WHERE codeArtiste=" + expertID;
        ArrayList<Numero> nums = new ArrayList<>();
        try {
            ResultSet b = Getter.request(s);
            while(b.next()) {
                Numero num = new Numero(
                        b.getInt("codeNumero"),
                        b.getString("titreNumero"),
                        b.getString("resumeNumero"),
                        b.getInt("dureeNumero"),
                        b.getInt("nbArtisteNumero"),
                        b.getBoolean("estCreation"),
                        b.getInt("codeArtiste"),
                        b.getString("theme")                        
                );
                nums.add(num);
            }
            return nums;
        }
        catch(SQLException e) {
            System.out.println("Erreur SQL : Aucun numero pour l'expert" + expertID);
        }
        return null;
    }
    /**
     * 
     * @param spectacle : show that contain the acts
     * @return the acts in the show 
     */
    @Override
    public List<Numero> getNumerosBySpectacle(Spectacle spectacle) {
        String s = "SELECT codeNumero, TitreNumero, ResumeNumero, DureeNumero, "
                + "NbArtisteNumero, EstCreation, CodeArtiste, ThemeNumero "
                + "FROM NumeroAccepte FULL JOIN Numero ON NumeroAccepte.CodeNumero=Numero.CodeNumero"
                + " WHERE codeSpectacle=" + spectacle.getID();
        ArrayList<Numero> nums = new ArrayList<Numero>();
        try {
            ResultSet b = Getter.request(s);
            while(b.next()) {
                Numero num = new Numero(
                        b.getInt("codeNumero"),
                        b.getString("titreNumero"),
                        b.getString("resumeNumero"),
                        b.getInt("dureeNumero"),
                        b.getInt("nbArtisteNumero"),
                        b.getBoolean("estCreation"),
                        b.getInt("codeArtiste"),
                        b.getString("themeNumero")                        
                );
                nums.add(num);
            }
        }
        catch(SQLException e) {
            System.out.println("Erreur SQL : Aucun numero pour le spectacle" + spectacle.getID());
        }
        return nums;
    }
    /**
     * 
     * @param theme : theme in which all the acts belong to 
     * @return all the acts in the theme ranked by their note Average
     */
    @Override
    public List<Numero> getNumerosRankedByTheme(Theme theme) {
        String cmd = "SELECT Numero.codeNumero, TitreNumero, ResumeNumero, DureeNumero, NbArtisteNumero, EstCreation, CodeArtiste, Theme "
                + "FROM Numero FULL JOIN (SELECT CodeNumero, AVG(Note) as Moyenne FROM Evaluation GROUP BY CodeNumero) Moy "
                + "ON Numero.CodeNumero=Moy.CodeNumero WHERE Theme=" + theme
                + "ORDER BY Moyenne DESC";
        ArrayList<Numero> nums = new ArrayList<Numero>();
        try {
            ResultSet b = Getter.request(cmd);
            while(b.next()) {
                Numero num = new Numero(
                        b.getInt("codeNumero"),
                        b.getString("titreNumero"),
                        b.getString("resumeNumero"),
                        b.getInt("dureeNumero"),
                        b.getInt("nbArtisteNumero"),
                        b.getBoolean("estCreation"),
                        b.getInt("codeArtiste"),
                        b.getString("themeNumero")                        
                );
                nums.add(num);
            }
        }
        catch(SQLException e) {
            System.out.println("Erreur SQL : Aucun numéro au thème" + theme);
        }
        return nums;
    }
    /**
     * 
     * @param theme of the acts to select 
     * @return the acts which the theme is theme 
     */
    @Override
    public List<Numero> getNumerosByTheme(Theme theme) {
        String s = "SELECT * FROM Numero WHERE theme = " + theme;
        ArrayList<Numero> nums = new ArrayList<Numero>();
        try {
            ResultSet b = Getter.request(s);
            while(b.next()) {
                Numero num = new Numero(
                        b.getInt("codeNumero"),
                        b.getString("titreNumero"),
                        b.getString("resumeNumero"),
                        b.getInt("dureeNumero"),
                        b.getInt("nbArtisteNumero"),
                        b.getBoolean("estCreation"),
                        b.getInt("codeArtiste"),
                        b.getString("themeNumero")                        
                );
                nums.add(num);
            }
        }
        catch(SQLException e) {
            System.out.println("Erreur SQL : Aucun numéro au thème" + theme);
        }
        return nums;
    }

}
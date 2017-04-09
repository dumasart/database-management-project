/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import BackEnd.Getter;
import BackEnd.ResultatsNumeros;
import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Spectacle;
import Model.Business.Theme;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nomezing
 */
public class NumeroDAOSQL implements NumeroDAO {

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

    @Override
    public List<Numero> getAllNumero() {
        String s = "SELECT * FROM Evaluation JOIN Numero ON Evaluation.codeNumero=Numero.codeNumero WHERE codeArtiste="+Factory.getUser().getUserId();
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

    @Override
    public List<Numero> getNumeroByExpert(Expert expert) {
        String s = "SELECT codeNumero, TitreNumero, ResumeNumero, DureeNumero, "
                + "NbArtisteNumero, EstCreation, CodeArtiste, ThemeNumero "
                + "FROM Evaluation WHERE codeArtiste=" + expert.getId();
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
            System.out.println("Erreur SQL : Aucun numero pour l'expert" + expert.getId());
        }
        return nums;
    }

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
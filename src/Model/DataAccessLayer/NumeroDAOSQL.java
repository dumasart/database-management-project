/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import BackEnd.ResultatsNumeros;
import Model.Business.Expert;
import Model.Business.Factory;
import Model.Business.Numero;
import Model.Business.Spectacle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author nomezing
 */
public class NumeroDAOSQL implements NumeroDAO {

    @Override
    public boolean update(Numero numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(Numero numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Numero numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Numero> getAllNumero() {
        /*
        String s = "SELECT * FROM Evaluation JOIN Numero ON Evaluation.codeNumero=Numero.codeNumero WHERE codeArtiste="+Factory.getUser().getUserId();
        ResultatsNumeros nums = new ResultatsNumeros();
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
        //il faut analyser le ResultSet et renvoyer je ne sais quoi?
        return nums;
        */
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Numero> getNumeroByExpert(Expert expert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Numero> getNumerosBySpectacle(Spectacle spectacle) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
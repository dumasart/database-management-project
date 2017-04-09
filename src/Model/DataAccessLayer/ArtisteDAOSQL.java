/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DataAccessLayer;

import BackEnd.Getter;
import Model.Artiste;

/**
 *
 * @author nomezing
 */
public class ArtisteDAOSQL implements ArtisteDAO {

    @Override
    public boolean update(Artiste artiste) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Ajoute un artiste dans la BD
     * @param artiste
     * @return true si l'insertion s'est bien passée
     */
    @Override
    public boolean insert(Artiste artiste) {
        String req= "INSERT INTO Artiste VALUES (" +artiste.getID() + " , " +
                artiste.getCodeCirque() + " , " + artiste.getNom() + " , " +
                artiste.getPrenom() + " , " + artiste.getDate() + " , " +
                artiste.getAdresse() + ")";
        int res = Getter.update(req);
        if(res==0)
            return false;
        else 
            return true;
    }

    @Override
    public boolean delete(Artiste artiste) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

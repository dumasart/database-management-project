/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.Factory;
import Model.Business.Artiste;
import Model.Business.Expert;
import Model.Business.Numero;
import Model.Business.Spectacle;
import Model.DataAccessLayer.DAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author nomezing
 */
public class OrganisateurViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void ajouteExpert(Expert expert) {
        DAO dao = Factory.getDAO();
        dao.ajouteExpert(expert);
    }
    
    public void ajouteArtiste(Artiste artiste) {
        DAO dao = Factory.getDAO();
        dao.ajouteArtiste(artiste);
    }
    
    public void ajouteSpectacle(Spectacle spectacle) {
        DAO dao = Factory.getDAO();
        dao.ajouteSpectacle(spectacle);
    }  
    
    public void ajouteNumero(Numero numero) {
        DAO dao = Factory.getDAO();
        dao.ajouteNumero(numero);
        
        
    }
}

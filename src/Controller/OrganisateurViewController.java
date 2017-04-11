/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author nomezing
 */
public class OrganisateurViewController extends MainController implements Initializable {


    @FXML 
    BorderPane borderPaneTab1;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    /**
     * evenement dans l'onglet edition/création pour passer en mode ajout,
     * edition ou suppression
     * @param event 
     */
    @FXML
    public void ArtisteClicked(Event event) {
        
        setBorderPaneCenter("/View/Organisateur/ArtisteViewAdd.fxml", borderPaneTab1);
    }
    
    
    /**
     * 
     * @param event 
     */
    @FXML
    public void numeroClicked(Event event) {
        setBorderPaneCenter("/View/Organisateur/NumeroViewAdd.fxml", borderPaneTab1);
    }   
    
    @FXML
    public void spectacleClicked(Event event) {
        setBorderPaneCenter("/View/Organisateur/SpectacleViewAdd.fxml", borderPaneTab1);
    }
    
    
    /**
     * Méthode interne pour modifier l'affichage lors
     * @param source Le nom du fichier fxml à charger (chemin absolu) 
     */
    private void setBorderPaneCenter(String source, BorderPane destination) {
        try {
            
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(source));
            Node centerPane = loader.load();
            destination.setCenter(centerPane);
            
        } catch (IOException e){
            System.out.println(e.getMessage() + "unable to initialize center");
        }
    }
}

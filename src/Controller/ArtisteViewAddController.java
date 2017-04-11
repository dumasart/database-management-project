/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Artiste;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 *
 * @author nomezing
 */
public class ArtisteViewAddController extends ArtistController implements Initializable {
    
    @FXML
    private ComboBox comboBox;
    
    private ListProperty<Artiste> listeArtistes = 
            new SimpleListProperty<Artiste>(FXCollections.observableArrayList());  
     
        
    /**
     * Méthode interne pour gérer la mise à jour des données à partir de la base de données
     * Cette méthode est appelée au démarrage et après chaque annulation ou saisie validée
     */
    private void updateListFromDB() {
        //met à jour la liste
        listeArtistes.clear();
        listeArtistes.addAll(
                artisteDAO.getAllArtistes());
        // affiche message aucun élément à évaluer et invite à quitter
        if (listeArtistes.isEmpty()) {
            // cache la partie saisie évaluation
            //mainVBox.setVisible(false);
            // affiche un message à la place
            //emptyListLabel.setVisible(true);
        } else {
            //resetGrilleEvaluation();
            //listView.getSelectionModel().selectFirst();
        }
    }
    
    
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBox.itemsProperty().bind(listeArtistes);
        
    updateListFromDB();
    }  
}

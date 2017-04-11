/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Window;

/**
 *
 * @author nomezing
 */
public class JFXCommon {
    
        
    /**
     * Méthode pour ouvrir une fenetre pop-up de confirmation
     * @param question question à poser à l'utilisateur
     * @param owner fenetre mère 
     * @return  renvoi le résultat de la confirmation (bouton cliqué)
     */
    public static Optional<ButtonType> showConfirmationDialog(String question, Window owner) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(question);
        alert.initOwner(owner);
        alert.initModality(Modality.WINDOW_MODAL);
        
        return alert.showAndWait();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Numero;
import View.Utils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * Controleur qui gère l'inteface graphique spécifique aux Experts
 * @author nomezing
 */
public class ExpertViewController extends ExpertController implements Initializable {

    @FXML
    private VBox mainVBox;
    
    @FXML
    private Label emptyListLabel;
    
    @FXML
    private ListView listView;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private ChoiceBox choiceBox;
    
    @FXML
    private Text errorMessage;
    
    
    /* la liste de numero est bindé avec la listeView dans la vue expert */
    private ListProperty<Numero> listeNumero = 
            new SimpleListProperty<Numero>(FXCollections.observableArrayList());
    
    
    /**
     * Méthode interne pour gérer la mise à jour des données à partir de la base de données
     * Cette méthode est appelée au démarrage et après chaque annulation ou saisie validée
     */
    private void updateListViewFromDB() {
        //met à jour la liste
        listeNumero.clear();
        listeNumero.addAll(
                numeroDAO.getNumeroNonEvalueByExpertID(getConnectedUser().getIdentifiant())
        );
        // affiche message aucun élément à évaluer et invite à quitter
        if (listeNumero.isEmpty()) {
            // cache la partie saisie évaluation
            mainVBox.setVisible(false);
            // affiche un message à la place
            emptyListLabel.setVisible(true);
        } else {
            resetGrilleEvaluation();
            listView.getSelectionModel().selectFirst();
        }
    }
    
    /**
     * Méthode pour réinitialiser la grille d'évaluation
     */
    private void resetGrilleEvaluation () {
        textArea.clear();
        choiceBox.getSelectionModel().selectFirst();
        errorMessage.setVisible(false);
    }

    
    /**
     * Méthode qui gère l'évènement de click sur le bouton valider
     * récupère et vérifie la saisie et demande confirmation si l'evaluation est complète
     * ou affchiche un message d'erreur si le texte est vide
     * @param event 
     */
    @FXML
    public void validButtonClicked (Event event) {
        //numSelect et note ne peuvent pas etre null on en à un selectionné par défaut
        Numero numSelect = (Numero) listView.getSelectionModel().getSelectedItem();
        int note = (int)choiceBox.getSelectionModel().getSelectedItem();
        
        // netoyage de la chaine pour enlever les caractères gênant
        String comment = Utils.netoyerString(textArea.getText().trim());
            
        // ajoute l'évaluation dans la base
        if(!comment.isEmpty()) {
            evaluerNumero( numSelect, comment, note);
            updateListViewFromDB();
        } else {
            // affiche un message en rouge pour prévenir qu'il doit saisi
            errorMessage.setVisible(true);
            System.out.println("Vous devez saisir un commentaire");
        }
    }
    
    
    /**
     * Méthode qui gère l'évènement de click sur le bouton annuler
     * Efface les informations saisies dans la textBox et remet 
     * la note à 0
     * @param event 
     */
    @FXML
    public void cancelButtonClicked (Event event) {
        resetGrilleEvaluation ();
    }
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // connecte (bind) la listView avec la liste de Numéro maintenue localement
        listView.itemsProperty().bind(listeNumero);
        
        // charge les numéros à évaluer dans la liste
        updateListViewFromDB();
        
        // défini les élément de la liste de choix pour la note
        choiceBox.setItems(
                FXCollections.observableArrayList(0,1,2,3,4,5,6,7,8,9)
        );
        /* séléctionne par défaut la première note (0) pour éviter d'avoir 
            un nullPointer sur la note */
        choiceBox.getSelectionModel().selectFirst();
    }
}
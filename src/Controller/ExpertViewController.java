/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Numero;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 * Controleur qui gère l'inteface graphique spécifique aux Experts
 * @author nomezing
 */
public class ExpertViewController extends ExpertController implements Initializable {

    @FXML
    private GridPane grilleEvaluation;
    
    @FXML
    private ListView listView;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private ChoiceBox choiceBox;
    
    
    /* la liste de numero est bindé avec la listeView dans la vue expert */
    private List<Numero> listeNumero = numeroDAO.getNumeroNonEvalueByExpertID(getConnectedUser().getIdentifiant());
    
    /**
     * Méthode pour gérer l'évenement de selection
     * @param event 
     */
    public void itemSelectedAction(Event event) {
        // on autorise la saisie des commentaires
        grilleEvaluation.setVisible(true);
        /*
        textArea.setDisable(false);
        choiceBox.setDisable(false);
        */
    }
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // sélectionne le premier élément de la liste par défaut
        listView.getSelectionModel().selectFirst();
    }
}
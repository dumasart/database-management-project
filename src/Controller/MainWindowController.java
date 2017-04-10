package Controller;

import Controller.LoginViewController.LoggedInEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;


public class MainWindowController extends MainController implements Initializable {

    @FXML
    private BorderPane rootNode;
    
    @FXML
    private Button logoutButton;
    
    
    /**
     * Méthode pour gérer l'evenement de click sur le bouton
     * déconnxeion dans la fentre principale
     * @param event l'evenement déclenché
     */
    @FXML
    private void logoutButtonAction(Event event) {
        /* ouvre une fenetre pour demander la confirmation
         * avant de quitter */
        Optional<ButtonType> result = showLogoutDialog();
           
        if (result.get() == ButtonType.OK) {
            logoutButton.setVisible(false);
            this.setBorderPaneCenter("/View/LoginView.fxml");
        }
    }
    
    
    /**
     * Méthode pour ouvrir une fenetre pop-up de confirmation
     * @param owner fenetre mère 
     */
    private Optional<ButtonType> showLogoutDialog() {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation déconnexion");
        //alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Etes-vous sur de vouloir vous déconnecter?");
        alert.initOwner(rootNode.getScene().getWindow());
        alert.initModality(Modality.WINDOW_MODAL);
        
        return alert.showAndWait();
    }
    

    /**
     * Méthode qui gère l'évènement de fermeture de la fenetre principale
     * Gère la terminaison du programme notamment la déconnexion de la base
     * @param e 
     */
    private void closeWindow(Event e)
    {
        // TODO
        // - verifier que la connxeion à la base de données est fermée
        // - terminer les transactions en cours
        ((Node)e.getSource()).getScene().getWindow().hide();
    }
   
      
    /**
     * Méthode interne pour modifier l'affichage dans le 'center'
     * Permet de naviguer entre les vues sans ouvrir un tas de nouvelles fenêtres 
     * @param source Le nom du fichier fxml à charger (chemin absolu) 
     */
    private void setBorderPaneCenter(String source) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(source));
            Node centerPane = loader.load();
            rootNode.setCenter(centerPane);
        } catch (IOException e){
            System.out.println(e.getMessage() + "unable to initialize center");
        }
    }
    
    
    /**
     * Gestionnaire d'évenement pour la connexion d'un utilisateur
     * @param event l'évenement de connection envoyé par la vue login
     */
    private void LoggedInEventHandler(LoggedInEvent event) {
        String ressource;
        
        /* Récupère le type d'utilisateur pour afficher l'écran correspondant
           au type d'utilisateur connecté */
        switch(this.getConnectedUser().getUserType()) {
            case EXPERT : 
                ressource="/View/ExpertView.fxml";
                break;
            case ORGANISATEUR :
                ressource="/View/OrganisateurView.fxml";
                break;
            default:
                throw new RuntimeException("Connexion impossible, utilisateur corrompu");
        }
        // affiche la bonne interface utilisateur
        setBorderPaneCenter(ressource);
        // rend visible le bouton de déconnexion
        logoutButton.setVisible(true);
    }
    
    
    /**
     * Méthode d'initialisation de la fenetre principale
     * @param location
     * @param resources 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBorderPaneCenter("/View/LoginView.fxml");
        // défini le gestionnaire d'évenement pour la connection réussie
        rootNode.addEventHandler(LoggedInEvent.LOGIN_SUCCESS,
                event -> LoggedInEventHandler(event));
    }
}
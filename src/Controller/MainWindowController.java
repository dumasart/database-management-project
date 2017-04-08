package Controller;

import Controller.LoginViewController.LoggedInEvent;
import Model.Business.User;
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
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Window;


public class MainWindowController implements Initializable {

    @FXML
    private BorderPane rootNode;
    
    @FXML
    private Button logoutButton;
    
    @FXML
    private Pane centerView;
    
    private User connectedUser;

    
    /**
     * 
     * @param event 
     */
    @FXML
    private void logoutButtonAction(Event event) {
        Window owner = ((Node)(event.getSource())).getScene().getWindow();
        /* ouvre une fenetre pour demander la confirmation
         * avant de quitter */
        showLogoutDialog(owner);
    }

    /**
     * 
     */
    void showLogoutButton() {
        logoutButton.setVisible(true);
    }
    
    
    private void showLogoutDialog(Window owner) {
        
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation déconnexion");
        //alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Etes-vous sur de vouloir vous déconnecter?");
        alert.initOwner(owner);
        alert.initModality(Modality.WINDOW_MODAL);
        
        Optional<ButtonType> result = alert.showAndWait();
           
        if (result.get() == ButtonType.OK) {
            logoutButton.setVisible(false);
            this.setBorderPaneCenter("/View/LoginView.fxml");
        }
    }
    

    /**
     * 
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
     * 
     * @param fxmlSource 
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
     * Gestionnaire d'évenement pour la connction d'un utilisateur
     * @param event 
     */
    private void LoggedInEventHandler(LoggedInEvent event) {
        String ressource;
        /* récupère l'utilisateur qui s'est connecté pour avoir 
           le nom, le type de compte,... */
        connectedUser = event.getUser();
        
        /* Récupère le type de compte pour afficher l'écran correspondant
           au type d'utilisateur connecté */
        switch(connectedUser.getUserType()) {
            case EXPERT : 
                ressource="/View/ExpertView.fxml";
                break;
            case ORGANISATEUR :
                ressource="/View/OrganisateurView.fxml";
                break;
            default:
                throw new RuntimeException("Connexion impossible, utilisateur corrompu");
        }
        
        setBorderPaneCenter(ressource);
        showLogoutButton();
    }
    
    
    /**
     * 
     * @param location
     * @param resources 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBorderPaneCenter("/View/LoginView.fxml");
        // défini le gestionnaire d'évenement pour la connection
        rootNode.addEventHandler(LoggedInEvent.LOGIN_SUCCESS,
                event -> LoggedInEventHandler(event));
    }
}
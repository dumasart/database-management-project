package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class MainWindowController implements Initializable {
     
    @FXML
    private BorderPane parentNode;
    
    private Node centerPane;
    
    @FXML
    private Button logoutButton;
        
    @FXML
    public void logoutClickAction(Event event) {
        initializeCenterView();
    }
    
    private void initializeCenterView() {
        try {
            // charge la vue de connexion par défaut
            centerPane = FXMLLoader.load(getClass().getResource("/GUI/LoginView.fxml"));
            parentNode.setCenter(centerPane);
        } catch (IOException e){ 
            //TODO
            System.out.println(e.getMessage() + "unable to initialize center");
        }       
    }   
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeCenterView();
        // cache le bouton de déconnexion
        logoutButton.setVisible(false);
    }
}
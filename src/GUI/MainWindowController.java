package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class MainWindowController implements Initializable {
     
    @FXML
    private TextField loginField;
    
    @FXML
    private TextField passwordField;
    
    @FXML
    private Button connexionButton;
    
    @FXML
    private Text errorMessage;
    
    private static boolean LOGIN_EMPTY=true,PASSWORD_EMPTY=true;
 
    
    @FXML
    public void connexionClickAction(Event event) {
        System.out.println("You clicked me!");
        // vérifier le login et le mot de passe
        // retourne le type de compte (organisateur, expert,..)
        
        // si type de compte "organisateur" : ouvrir fenetre organisateur
        
        // si type de compte "expert" : ouvrir la fenetre expert (saisie evaluation)
        
        // si type vide (login et/ou mot de passe invalide) : afficher message d'erreur et rester sur la fenetre d'accueil
        connexionButton.setDisable(true);
        errorMessage.setVisible(true);
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        /* ajoute un change listener au champ "login" et "mot de passe"
         * pour désactiver le bouton connexion si le champ login et/ou mot de passe sont vides
         * et changer le contour des champs en rouge s'ils sont vides 
         */
        loginField.textProperty().addListener((observable, oldValue,newValue) -> {
            LOGIN_EMPTY = newValue.trim().isEmpty();
            connexionButton.setDisable(LOGIN_EMPTY||PASSWORD_EMPTY);
            loginField.setStyle(LOGIN_EMPTY?"-fx-text-box-border:red":"-fx-border-color:white");
        });
        
        passwordField.textProperty().addListener((observable, oldValue,newValue) -> {
            PASSWORD_EMPTY = newValue.trim().isEmpty();
            connexionButton.setDisable(LOGIN_EMPTY||PASSWORD_EMPTY);
            passwordField.setStyle(PASSWORD_EMPTY?"-fx-border-color:red":"-fx-border-color:white");
        });
    }
    
}

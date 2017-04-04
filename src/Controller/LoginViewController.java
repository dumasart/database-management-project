/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Application.Factory;
import Model.Business.User;
import Model.DataAccessLayer.DAO;
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

public class LoginViewController implements Initializable {

    @FXML
    private TextField loginField;
    
    @FXML
    private TextField passwordField;
    
    @FXML
    private Button connexionButton;
    
    @FXML
    private Text errorMessage;
    
    private static boolean LOGIN_EMPTY=true, PASSWORD_EMPTY=true;
    
    /**
     *
     * @param event
     * @throws java.io.IOException
     */
    @FXML
    public void loginClickAction(Event event) throws IOException {
        String ressource;
        /* vérifcation du login et du mot de passe
         * retourne le type de compte (organisateur, expert,..)*/
        //userType=checkAuthentification(loginField.getText(),passwordField.getText());
        /* si type vide (login et/ou mot de passe invalide) :
         *   afficher message d'erreur et rester sur la fenetre d'accueil */
        //if(userType.isNull())
        //{
        //    errorMessage.setVisible(true);
        //    return;
        //}
        //switch(UserType) {
        //    case EXPERT : 
        ressource="/GUI/ExpertView.fxml";
        //        break;
        //    case ORGANISATEUR :
        //        ressource="/GUI/OrganisateurView.fxml";
        //        break;
        //    default:
                
        //}
        
        // Ouvre la fenetre correspondant au type utilisateur connecté
        BorderPane parent = (BorderPane) ((Node) event.getSource()).getScene().getRoot();
        Node centerPane = FXMLLoader.load(getClass().getResource(ressource));
        parent.setCenter(centerPane);
        
        //parentNode.setCenter(centerPane);

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        /* ajoute un change listener au champ "login" et "mot de passe"
         * pour désactiver le bouton connexion si le champ login et/ou mot de passe sont vides
         * et changer le contour des champs en rouge s'ils sont vides 
         */
        loginField.textProperty().addListener((observable, oldValue,newValue) -> {
            LOGIN_EMPTY = newValue.trim().isEmpty();
            connexionButton.setDisable(LOGIN_EMPTY||PASSWORD_EMPTY);
            loginField.setStyle(LOGIN_EMPTY?"-fx-border-color:red":"-fx-border-color:white");
        });
        
        passwordField.textProperty().addListener((observable, oldValue,newValue) -> {
            PASSWORD_EMPTY = newValue.trim().isEmpty();
            connexionButton.setDisable(LOGIN_EMPTY||PASSWORD_EMPTY);
            passwordField.setStyle(PASSWORD_EMPTY?"-fx-border-color:red":"-fx-border-color:white");
        });
    }    
    
    
    public boolean idenfieUser(String username, String password) {
        DAO dao = Factory.getDAO();
        User user = dao.getUserByUserNameAndPassword(username, password);
        
        if (user != null) {
            Factory.setUser(user);
            return true;
        }
        
        return false;
    }
}

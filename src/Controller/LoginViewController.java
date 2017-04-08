/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import Model.Business.Factory;
import Model.Business.User;
import Model.DataAccessLayer.DAO;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
     * @param event
     * @throws java.io.IOException
     */
    @FXML
    private void loginClickAction(Event event) throws IOException {
        
        /* vérifcation du login et du mot de passe
         * retourne un User contenant le type de compte (organisateur, expert,..)
         * le nom de l'utilisateur,... */
        // TODO appel fonction d'authentification
        User user = new User("Grissom","MotDePasse");
                //checkAuthentification(loginField.getText(),passwordField.getText());
        
        /* si user vaut NULL (login et/ou mot de passe invalide) :
         *   afficher message d'erreur et rester sur la fenetre d'accueil */
        //if(userType.isNull())
        //{
        //    errorMessage.setVisible(true);
        //    return;
        //}
        Event ev = new LoggedInEvent(user);
        ((Node)event.getSource()).fireEvent(ev);  
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        /* ajoute un change listener au champ "login" et "mot de passe"
         * pour désactiver le bouton connexion et changer le contour des champs 
         * en rouge si le champ login et/ou mot de passe sont vides
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
            //Factory.setUser(user);
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Déclaration d'un type d'évènement personnalisé pour gérer la connexion
     * d'un utilisateur au niveau du controleur principal
     */
    static class LoggedInEvent extends Event {
        
        public static final EventType<LoggedInEvent> LOGIN_SUCCESS 
                = new EventType<>(Event.ANY, "LOGIN_SUCCESS");
        
        private User loggedUser;
        
        /**
         * On ne peut pas déclencher l'évenement en dehors de ce controleur
         * pour éviter les connexions pirate 
         * @param user l'utilisateur qui s'est connecté
         */
        private LoggedInEvent(User user) {
            super(LOGIN_SUCCESS);
            this.loggedUser = user;
        }
        
        /**
         * Fonction pour récupérer l'utilisateur connecté
         * @return l'utilisateur connecté
         */
        public User getUser() {
            // TODO ajouter le User au constructeur
            return this.loggedUser;
        }
    }
    
}

package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Window;
import javafx.util.Pair;


public class MainWindowController extends Controller implements Initializable {

    @FXML
    private BorderPane rootNode;
    
    @FXML
    private Button logoutButton;
    
    @FXML
    private Pane centerView; 

    
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
        
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
        getClass().getResource("../Resources/application.css").toExternalForm());
        //dialogPane.getStyleClass().add("myDialog");
        
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
    void setBorderPaneCenter(String source) {
        try {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource(source));
            Node centerPane = loader.load();
            Controller controller = loader.getController();
            controller.initOwner(this);
            rootNode.setCenter(centerPane);
        } catch (IOException e){
            System.out.println(e.getMessage() + "unable to initialize center");
        }
    }
    
    /**
     * 
     * @param location
     * @param resources 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setBorderPaneCenter("/View/LoginView.fxml");
    }
}
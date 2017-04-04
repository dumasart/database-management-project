package Application;

import Controler.ExpertControler;
import Model.Business.Numero;
import Model.DataAccessLayer.DAO;
import View.*;
import Model.Business.Numero;
import Model.DataAccessLayer.DAO;
import java.util.Collection;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GraphicApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/MainWindow.fxml"));
        Scene scene = new Scene(root,800,600);
        stage.setTitle("Festival du cirque manager");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        DAO dao = new DAO();
        Collection<Numero> listeNumeros = dao.getNumeros();
        
        UserInterface usrInf = new TextualInterface();
        
        ExpertControler expCtrl = new ExpertControler(listeNumeros, usrInf);
       
        expCtrl.afficheNumeros();
        System.out.printf("Choix le numero pour saisir des evalutations");
        Scanner terminalInput = new Scanner(System.in);
        int code = terminalInput.nextInt();
    }
    
}

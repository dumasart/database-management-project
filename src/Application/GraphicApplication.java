package Application;

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
    }
    
}

package Application;

import DataAccessLayer.ConnectionSQL;
import DataAccessLayer.Getter;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GraphicApplication extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/MainWindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Festival du cirque manager");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // ferme la connection si elle n'a pas été fermée
            Getter.close();
            ConnectionSQL.closeConnection();
        }
    }
    
}

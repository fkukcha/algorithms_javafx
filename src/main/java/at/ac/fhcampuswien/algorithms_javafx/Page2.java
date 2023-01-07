package at.ac.fhcampuswien.algorithms_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * The main class for the second page of the application.
 */
public class Page2 extends Application {


    /**
     * This method is called when the application is launched. It sets up the window and loads the
     * FXML file for the second page.
     *
     * @param stage the Stage to be displayed
     * @throws Exception if there is an error loading the FXML file
     */
    @Override
    public void start(Stage stage) throws Exception {

        // Load the FXML file for the second page
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secondPage.fxml")));

        // Create a new Scene with the loaded FXML file as the root node
        Scene scene = new Scene(root);

        // Set the Scene for the Stage and show it
        stage.setScene(scene);
        stage.show();
    }


    /**
     * The main method, which launches the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
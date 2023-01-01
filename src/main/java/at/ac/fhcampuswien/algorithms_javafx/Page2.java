package at.ac.fhcampuswien.algorithms_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Page2 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Page2.class.getResource("page2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 650);
        stage.setTitle("Sorting Algorithms");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
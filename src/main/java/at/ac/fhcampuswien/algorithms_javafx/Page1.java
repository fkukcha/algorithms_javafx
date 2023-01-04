package at.ac.fhcampuswien.algorithms_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Page1 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Page1.class.getResource("page1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 734);
        stage.setTitle("Sorting Algorithms");
        stage.setScene(scene);
        stage.show();
    }

    public void secondScreen(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Page1.class.getResource("page2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 800);
        stage.setTitle("Sorting Algorithms");
        stage.setScene(scene);
        stage.show();
    }

    public void thirdScreen(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Page1.class.getResource("page3.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 800);
        stage.setTitle("Sorting Algorithms");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
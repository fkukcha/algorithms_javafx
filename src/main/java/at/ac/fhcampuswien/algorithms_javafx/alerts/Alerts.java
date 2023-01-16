package at.ac.fhcampuswien.algorithms_javafx.alerts;

import javafx.scene.control.Alert;

public class Alerts {
    public static void identicalAlgorithms(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setHeaderText("Please select two different algorithms to compare.");
        alert.showAndWait();
    }
    public static void emptySelection(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning!");
        alert.setHeaderText("Please select both algorithms for comparison and also the array size.");
        alert.showAndWait();
    }
}

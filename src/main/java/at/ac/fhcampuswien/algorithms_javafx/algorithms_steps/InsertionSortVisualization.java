package at.ac.fhcampuswien.algorithms_javafx.algorithms_steps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class InsertionSortVisualization extends Application {

    private ArrayStructures arrayStructures = new ArrayStructures();

    public InsertionSortVisualization() {
        arrayStructures.generateRandomArray();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Create a bar chart
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Index");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Value");
        BarChart<String, Number> chart = new BarChart<>(xAxis, yAxis);
        chart.setTitle("Insertion Sort Visualization");

        // Create a copy of the array to store the sorted data
        int[] sortedArray = arrayStructures.getArray().clone();
        // Sort the array
        insertionSort(sortedArray);

        // Add unsorted data to the chart
        XYChart.Series<String, Number> unsortedData = new XYChart.Series<>();
        unsortedData.setName("Unsorted Data");
        for (int i = 0; i < arrayStructures.getArraySize(); i++) {
            unsortedData.getData().add(new XYChart.Data<>(Integer.toString(i), arrayStructures.getArray()[i]));
        }
        chart.getData().add(unsortedData);

        // Add sorted data to the chart
        XYChart.Series<String, Number> sortedData = new XYChart.Series<>();
        sortedData.setName("Sorted Data");
        for (int i = 0; i < sortedArray.length; i++) {
            sortedData.getData().add(new XYChart.Data<>(Integer.toString(i), sortedArray[i]));
        }
        chart.getData().add(sortedData);

        // Add the chart to the scene and display
        Scene scene = new Scene(chart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}





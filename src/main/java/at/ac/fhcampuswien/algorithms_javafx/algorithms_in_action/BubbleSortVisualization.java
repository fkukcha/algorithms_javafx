package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class BubbleSortVisualization extends Application {
    private ArrayStructures arrayStructures = new ArrayStructures();

    public BubbleSortVisualization() {
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
        chart.setTitle("Bubble Sort Visualization");

        // Add unsorted data to the chart
        XYChart.Series<String, Number> unsortedData = new XYChart.Series<>();
        unsortedData.setName("Unsorted Data");
        for (int i = 0; i < arrayStructures.getArraySize(); i++) {
            unsortedData.getData().add(new XYChart.Data<>(Integer.toString(i), arrayStructures.getArray()[i]));
        }
        chart.getData().add(unsortedData);

        // Sort the array and add sorted data to the chart
        XYChart.Series<String, Number> sortedData = new XYChart.Series<>();
        sortedData.setName("Sorted Data");
        for (int i = 0; i < arrayStructures.getArraySize(); i++) {
            sortedData.getData().add(new XYChart.Data<>(Integer.toString(i), arrayStructures.getArray()[i]));
        }
        bubbleSort(chart, sortedData);
        chart.getData().add(sortedData);

        // Add the chart to the scene and display
        Scene scene = new Scene(chart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void bubbleSort(BarChart<String, Number> chart, XYChart.Series<String, Number> data) {
        for (int i = arrayStructures.getArraySize() - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayStructures.getArray()[j] > arrayStructures.getArray()[j + 1]) {
                    // Swap the elements
                    int temp = arrayStructures.getArray()[j];
                    arrayStructures.getArray()[j] = arrayStructures.getArray()[j + 1];
                    arrayStructures.getArray()[j + 1] = temp;
                    // Update the chart
                    data.getData().get(j).setYValue(arrayStructures.getArray()[j]);
                    data.getData().get(j+1).setYValue(arrayStructures.getArray()[j+1]);
                    try {
                        Thread.sleep(1000); // added delay to visualize
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}














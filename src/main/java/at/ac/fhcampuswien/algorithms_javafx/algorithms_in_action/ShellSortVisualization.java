package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShellSortVisualization extends Application {
    int[] array = {5, 1, 4, 2, 8};

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
        chart.setTitle("Shell Sort Visualization");

        // Add unsorted data to the chart
        XYChart.Series<String, Number> unsortedData = new XYChart.Series<>();
        unsortedData.setName("Unsorted Data");
        for (int i = 0; i < array.length; i++) {
            unsortedData.getData().add(new XYChart.Data<>(Integer.toString(i), array[i]));
        }
        chart.getData().add(unsortedData);

        // Sort the array and update the chart to reflect changes
        int[] sortedArray = shellSort(array);
        updateChart(chart, sortedArray);

        // Add the chart to the scene and display
        Scene scene = new Scene(chart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public int[] shellSort(int[] array) {
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
            gap /= 2;
        }
        return array;
    }

    public void updateChart(BarChart<String, Number> chart, int[] array) {
        XYChart.Series<String, Number> sortedData = new XYChart.Series<>();
        sortedData.setName("Sorted Data");
        for (int i = 0; i < array.length; i++) {
            sortedData.getData().add(new XYChart.Data<>(Integer.toString(i), array[i]));
        }
        chart.getData().add(sortedData);
    }
}



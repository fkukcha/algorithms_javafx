package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class SelectionSortVisualization extends Application {
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
        chart.setTitle("Selection Sort Visualization");

        // Add unsorted data to the chart
        XYChart.Series<String, Number> sortedData = new XYChart.Series<>();
        sortedData.setName("Sorted Data");
        for (int i = 0; i < array.length; i++) {
            sortedData.getData().add(new XYChart.Data<>(Integer.toString(i), array[i]));
        }
        chart.getData().add(sortedData);

        // Sort the array and update the chart to reflect changes
        int[] sortedArray = array.clone();
        selectionSort(chart, sortedArray);

        // Add sorted data to the chart
        XYChart.Series<String, Number> unsortedData = new XYChart.Series<>();
        unsortedData.setName("Unsorted Data");
        for (int i = 0; i < array.length; i++) {
            unsortedData.getData().add(new XYChart.Data<>(Integer.toString(i), sortedArray[i]));
        }
        chart.getData().add(unsortedData);

        // Add the chart to the scene and display
        Scene scene = new Scene(chart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void updateChart(BarChart<String, Number> chart, int[] array) {
        for (int i = 0; i < array.length; i++) {
            XYChart.Series<String, Number> series = (XYChart.Series<String, Number>) chart.getData().get(0);
            series.getData().get(i).setYValue(array[i]);
        }
        try {
            Thread.sleep(1000); // added delay to visualize
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void selectionSort(BarChart<String, Number> chart, int[] array) {
        int[] sortedArray = array.clone(); // create a copy of the array to store the sorted data
        for (int i = 0; i < sortedArray.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[j] < sortedArray[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = sortedArray[minIndex];
            sortedArray[minIndex] = sortedArray[i];
            sortedArray[i] = temp;
            updateChart(chart, sortedArray); // update the chart to reflect changes
        }
    }
}











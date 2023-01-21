package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class QuickSortVisualization extends Application {
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
        chart.setTitle("Quick Sort Visualization");

        // Create a copy of the original unsorted array
        int[] unsortedArray = array.clone();

        // Add unsorted data to the chart
        XYChart.Series<String, Number> unsortedData = new XYChart.Series<>();
        unsortedData.setName("Unsorted Data");
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedData.getData().add(new XYChart.Data<>(Integer.toString(i), unsortedArray[i]));
        }
        chart.getData().add(unsortedData);

        // Sort the original array and update the chart to reflect changes
        int low = 0;
        int high = array.length - 1;
        quickSort(chart, array, low, high);

        // Add sorted data to the chart
        XYChart.Series<String, Number> sortedData = new XYChart.Series<>();
        sortedData.setName("Sorted Data");
        for (int i = 0; i < array.length; i++) {
            sortedData.getData().add(new XYChart.Data<>(Integer.toString(i), array[i]));
        }
        chart.getData().add(sortedData);

        // Add the chart to the scene and display
        Scene scene = new Scene(chart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void quickSort(BarChart<String, Number> chart, int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(chart, array, low, high);
            // Take snapshot of array state before partitioning left side
            int[] leftArraySnapshot = array.clone();
            updateChart(chart, leftArraySnapshot);
            quickSort(chart, array, low, pivotIndex - 1);
            // Take snapshot of array state before partitioning right side
            int[] rightArraySnapshot = array.clone();
            updateChart(chart, rightArraySnapshot);
            quickSort(chart, array, pivotIndex + 1, high);
        }
    }


    public int partition(BarChart<String, Number> chart, int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        updateChart(chart, array);
        return i + 1;
    }

    public void updateChart(BarChart<String, Number> chart, int[] array) {
        for (int i = 0; i < array.length; i++) {
            XYChart.Series<String, Number> series = (XYChart.Series<String, Number>) chart.getData().get(0);
            series.getData().get(i).setYValue(array[i]);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}











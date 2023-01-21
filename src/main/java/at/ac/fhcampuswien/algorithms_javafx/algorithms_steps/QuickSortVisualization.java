package at.ac.fhcampuswien.algorithms_javafx.algorithms_steps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class QuickSortVisualization extends Application {

    private ArrayStructures arrayStructures = new ArrayStructures();

    public QuickSortVisualization() {
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
        chart.setTitle("Quick Sort Visualization");

        int[] unsortedArray = arrayStructures.getArray().clone();

        // Add unsorted data to the chart
        XYChart.Series<String, Number> unsortedData = new XYChart.Series<>();
        unsortedData.setName("Unsorted Data");
        for (int i = 0; i < unsortedArray.length; i++) {
            unsortedData.getData().add(new XYChart.Data<>(Integer.toString(i), unsortedArray[i]));
        }
        chart.getData().add(unsortedData);

        // Add unsorted data to the chart
        XYChart.Series<String, Number> sortedData = new XYChart.Series<>();
        sortedData.setName("Sorted Data");
        for (int i = 0; i < arrayStructures.getArraySize(); i++) {
            sortedData.getData().add(new XYChart.Data<>(Integer.toString(i), arrayStructures.getArray()[i]));
        }
        chart.getData().add(sortedData);
        int low = 0;
        int high = arrayStructures.getArraySize() - 1;
        quickSort(chart, arrayStructures.getArray(), low, high);
        Scene scene = new Scene(chart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public void quickSort(BarChart<String, Number> chart, int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(chart, array, low, high);
            quickSort(chart, array, low, partitionIndex - 1);
            quickSort(chart, array, partitionIndex + 1, high);
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
                updateChart(chart, array);
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
            XYChart.Data<String, Number> data = (XYChart.Data<String, Number>) chart.getData().get(0).getData().get(i);
            data.setYValue(array[i]);
        }
    }
}














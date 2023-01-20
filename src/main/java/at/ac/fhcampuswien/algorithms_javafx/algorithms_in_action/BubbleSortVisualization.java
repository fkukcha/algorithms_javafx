package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


public class BubbleSortVisualization extends Application {

    int[] array = {21, 13, 2, 6, 3, 44, 54, 2, 8, 6};

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

        // Add data to the chart
        XYChart.Series<String, Number> data = new XYChart.Series<>();
        for (int i = 0; i < array.length; i++) {
            data.getData().add(new XYChart.Data<>(Integer.toString(i), array[i]));
        }
        chart.getData().add(data);

        // Sort the array and update the chart to reflect changes
        bubbleSort(chart, data);

        // Add the chart to the scene and display
        Scene scene = new Scene(chart, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void bubbleSort(BarChart<String, Number> chart, XYChart.Series<String, Number> data) {
        for (int i = array.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap the elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    // Update the chart
                    data.getData().get(j).setYValue(array[j]);
                    data.getData().get(j+1).setYValue(array[j+1]);
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














package at.ac.fhcampuswien.algorithms_javafx;

import at.ac.fhcampuswien.algorithms_javafx.algorithms.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.text.DecimalFormat;

public class Page1Controller {
    public Button btnPage1;
    public Button btnPage2;
    public Button btnPage3;
    DecimalFormat df = new DecimalFormat("0.0000");
    @FXML
    private Label lBExecutionTime;
    @FXML
    private Label lBMemoryUsage;
    @FXML
    private ComboBox cBSelectSortingAlgorithm;
    @FXML
    private ComboBox cBArraySize;

    @FXML
    protected void onBtnSortArrayClick() {

        cBSelectSortingAlgorithm.getValue();
        cBArraySize.getValue();

        String selectedAlgorithm =  cBSelectSortingAlgorithm.getValue().toString();
        String selectedArraySize =  cBArraySize.getValue().toString();
        int arraySize = switch (selectedArraySize) {
            case "Thousand" -> 1000;
            case "Ten thousand" -> 10000;
            case "Hundred thousand" -> 100000;
            default -> 0;
        };
        CreateRandomArray createRandomArray = new CreateRandomArray(arraySize);
        long totalExecutionTime = 0;
        long usedMemory = 0;

        switch (selectedAlgorithm) {
            case "BubbleSort" -> {
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.bubbleSort(createRandomArray.getRandomArray());
                usedMemory = bubbleSort.getUsedMemoryBubbleSort();
                totalExecutionTime = bubbleSort.getTotalExecutionTimeBubbleSort();
                lBExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsage.setText(usedMemory / 1000_000f + " MB");
            }
            case "CocktailSort" -> {
                CocktailSort cocktailSort = new CocktailSort();
                cocktailSort.cocktailSort(createRandomArray.getRandomArray());
                usedMemory = cocktailSort.getUsedMemoryCocktailSort();
                totalExecutionTime = cocktailSort.getTotalExecutionTimeCocktailSort();
                lBExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsage.setText(usedMemory / 1000_000f + " MB");
            }
            case "CombSort" -> {
                CombSort combSort = new CombSort();
                combSort.combSort(createRandomArray.getRandomArray());
                usedMemory = combSort.getUsedMemoryCombSort();
                totalExecutionTime = combSort.getTotalExecutionTimeCombSort();
                lBExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsage.setText(usedMemory / 1000_000f + " MB");
            }
            case "CycleSort" -> {
                CycleSort cycleSort = new CycleSort();
                cycleSort.cycleSort(createRandomArray.getRandomArray());
                usedMemory = cycleSort.getUsedMemoryCycleSort();
                totalExecutionTime = cycleSort.getTotalExecutionTimeCycleSort();
                lBExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsage.setText(usedMemory / 1000_000f + " MB");
            }
            case "GnomeSort" -> {
                GnomeSort gnomeSort = new GnomeSort();
                gnomeSort.gnomeSort(createRandomArray.getRandomArray());
                usedMemory = gnomeSort.getUsedMemoryGnomeSort();
                totalExecutionTime = gnomeSort.getTotalExecutionTimeGnomeSort();
                lBExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsage.setText(usedMemory / 1000_000f + " MB");
            }
            case "HeapSort" -> {
                HeapSort heapSort = new HeapSort();
                heapSort.heapSort(createRandomArray.getRandomArray());
                usedMemory = heapSort.getUsedMemoryHeapSort();
                totalExecutionTime = heapSort.getTotalExecutionTimeHeapSort();
                lBExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsage.setText(usedMemory / 1000_000f + " MB");
            }
            case "OddEvenSort" -> {
                OddEvenSort oddEvenSort = new OddEvenSort();
                oddEvenSort.oddEvenSort(createRandomArray.getRandomArray());
                usedMemory = oddEvenSort.getUsedMemoryOddEvenSort();
                totalExecutionTime = oddEvenSort.getTotalExecutionTimeOddEvenSort();
                lBExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsage.setText(usedMemory / 1000_000f + " MB");
            }
            default -> {
            }
        }
    }

    public void onBtnPage1Click(ActionEvent event) throws IOException {
    }

    public void onBtnPage2Click(ActionEvent event) throws IOException{
    }

    public void onBtnPage3Click(ActionEvent event) throws IOException{
    }
}
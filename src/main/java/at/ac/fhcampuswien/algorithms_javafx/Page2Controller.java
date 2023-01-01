package at.ac.fhcampuswien.algorithms_javafx;

import at.ac.fhcampuswien.algorithms_javafx.algorithms.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.text.DecimalFormat;

public class Page2Controller {
    public Button btnPage1;
    public Button btnPage2;
    public Button btnPage3;
    DecimalFormat df = new DecimalFormat("0.0000");
    @FXML
    private Label lBExecutionTimeOne;
    @FXML
    private Label lBExecutionTimeTwo;
    @FXML
    private Label lBMemoryUsageOne;
    @FXML
    private Label lBMemoryUsageTwo;
    @FXML
    private ComboBox cBSelectSortingAlgorithmOne;
    @FXML
    private ComboBox cBSelectSortingAlgorithmTwo;
    @FXML
    private ComboBox cBArraySize;
    @FXML
    private Label lBSelectedAlgorithmOne;
    @FXML
    private Label lBSelectedAlgorithmTwo;


    @FXML
    protected void onBtnSortArrayClick() {

        cBSelectSortingAlgorithmOne.getValue();
        cBSelectSortingAlgorithmTwo.getValue();
        cBArraySize.getValue();

        String selectedAlgorithmOne =  cBSelectSortingAlgorithmOne.getValue().toString();
        String selectedAlgorithmTwo =  cBSelectSortingAlgorithmTwo.getValue().toString();
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

        switch (selectedAlgorithmOne) {
            case "BubbleSort" -> {
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.bubbleSort(createRandomArray.getRandomArray());
                usedMemory = bubbleSort.getUsedMemoryBubbleSort();
                totalExecutionTime = bubbleSort.getTotalExecutionTimeBubbleSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(usedMemory / 1000_000f + " MB");
                lBSelectedAlgorithmOne.setText("Bubble Sort:");
            }
            case "CocktailSort" -> {
                CocktailSort cocktailSort = new CocktailSort();
                cocktailSort.cocktailSort(createRandomArray.getRandomArray());
                usedMemory = cocktailSort.getUsedMemoryCocktailSort();
                totalExecutionTime = cocktailSort.getTotalExecutionTimeCocktailSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(usedMemory / 1000_000f + " MB");
                lBSelectedAlgorithmOne.setText("Cocktail Sort:");
            }
            case "CombSort" -> {
                CombSort combSort = new CombSort();
                combSort.combSort(createRandomArray.getRandomArray());
                usedMemory = combSort.getUsedMemoryCombSort();
                totalExecutionTime = combSort.getTotalExecutionTimeCombSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(usedMemory / 1000_000f + " MB");
                lBSelectedAlgorithmOne.setText("Comb Sort:");
            }
            case "CycleSort" -> {
                CycleSort cycleSort = new CycleSort();
                cycleSort.cycleSort(createRandomArray.getRandomArray());
                usedMemory = cycleSort.getUsedMemoryCycleSort();
                totalExecutionTime = cycleSort.getTotalExecutionTimeCycleSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(usedMemory / 1000_000f + " MB");
                lBSelectedAlgorithmOne.setText("Cycle Sort:");
            }
            case "GnomeSort" -> {
                GnomeSort gnomeSort = new GnomeSort();
                gnomeSort.gnomeSort(createRandomArray.getRandomArray());
                usedMemory = gnomeSort.getUsedMemoryGnomeSort();
                totalExecutionTime = gnomeSort.getTotalExecutionTimeGnomeSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(usedMemory / 1000_000f + " MB");
                lBSelectedAlgorithmOne.setText("Gnome Sort:");
            }
            case "HeapSort" -> {
                HeapSort heapSort = new HeapSort();
                heapSort.heapSort(createRandomArray.getRandomArray());
                usedMemory = heapSort.getUsedMemoryHeapSort();
                totalExecutionTime = heapSort.getTotalExecutionTimeHeapSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(usedMemory / 1000_000f + " MB");
                lBSelectedAlgorithmOne.setText("Heap Sort:");
            }
            case "OddEvenSort" -> {
                OddEvenSort oddEvenSort = new OddEvenSort();
                oddEvenSort.oddEvenSort(createRandomArray.getRandomArray());
                usedMemory = oddEvenSort.getUsedMemoryOddEvenSort();
                totalExecutionTime = oddEvenSort.getTotalExecutionTimeOddEvenSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(usedMemory / 1000_000f + " MB");
                lBSelectedAlgorithmOne.setText("Odd Even Sort:");
            }
            default -> {
            }
        }

        switch (selectedAlgorithmTwo) {
            case "BubbleSort" -> {
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.bubbleSort(createRandomArray.getRandomArray());
                usedMemory = bubbleSort.getUsedMemoryBubbleSort();
                totalExecutionTime = bubbleSort.getTotalExecutionTimeBubbleSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(usedMemory / 1000_000f + " MB");
            }
            case "CocktailSort" -> {
                CocktailSort cocktailSort = new CocktailSort();
                cocktailSort.cocktailSort(createRandomArray.getRandomArray());
                usedMemory = cocktailSort.getUsedMemoryCocktailSort();
                totalExecutionTime = cocktailSort.getTotalExecutionTimeCocktailSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(usedMemory / 1000_000f + " MB");
            }
            case "CombSort" -> {
                CombSort combSort = new CombSort();
                combSort.combSort(createRandomArray.getRandomArray());
                usedMemory = combSort.getUsedMemoryCombSort();
                totalExecutionTime = combSort.getTotalExecutionTimeCombSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(usedMemory / 1000_000f + " MB");
            }
            case "CycleSort" -> {
                CycleSort cycleSort = new CycleSort();
                cycleSort.cycleSort(createRandomArray.getRandomArray());
                usedMemory = cycleSort.getUsedMemoryCycleSort();
                totalExecutionTime = cycleSort.getTotalExecutionTimeCycleSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(usedMemory / 1000_000f + " MB");
            }
            case "GnomeSort" -> {
                GnomeSort gnomeSort = new GnomeSort();
                gnomeSort.gnomeSort(createRandomArray.getRandomArray());
                usedMemory = gnomeSort.getUsedMemoryGnomeSort();
                totalExecutionTime = gnomeSort.getTotalExecutionTimeGnomeSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(usedMemory / 1000_000f + " MB");
            }
            case "HeapSort" -> {
                HeapSort heapSort = new HeapSort();
                heapSort.heapSort(createRandomArray.getRandomArray());
                usedMemory = heapSort.getUsedMemoryHeapSort();
                totalExecutionTime = heapSort.getTotalExecutionTimeHeapSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(usedMemory / 1000_000f + " MB");
            }
            case "OddEvenSort" -> {
                OddEvenSort oddEvenSort = new OddEvenSort();
                oddEvenSort.oddEvenSort(createRandomArray.getRandomArray());
                usedMemory = oddEvenSort.getUsedMemoryOddEvenSort();
                totalExecutionTime = oddEvenSort.getTotalExecutionTimeOddEvenSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(usedMemory / 1000_000f + " MB");
                lBSelectedAlgorithmOne.setText("Odd Even Sort:");
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
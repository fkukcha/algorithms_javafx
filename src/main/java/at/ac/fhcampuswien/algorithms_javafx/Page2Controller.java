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
        int[] randomArray = createRandomArray.getRandomArray();
        // creation of two array copies to avoid altering the original array
        int[] randomArrayAlgorithmOne = randomArray.clone();
        int[] randomArrayAlgorithmTwo = randomArray.clone();


        long totalExecutionTime = 0;
        long usedMemoryAlgorithmOne = 0;
        long usedMemoryAlgorithmTwo = 0;





        switch (selectedAlgorithmOne) {
            case "BubbleSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.bubbleSort(randomArrayAlgorithmOne);
                usedMemoryAlgorithmOne = totalMemory - freeMemory;
                System.out.println("Used Memory Algo 1: "+usedMemoryAlgorithmOne);
                totalExecutionTime = bubbleSort.getTotalExecutionTimeBubbleSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(df.format(usedMemoryAlgorithmOne / 1000_000f)+ " MB");
                lBSelectedAlgorithmOne.setText("Bubble Sort:");
            }
            case "CocktailSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                CocktailSort cocktailSort = new CocktailSort();
                cocktailSort.cocktailSort(randomArrayAlgorithmOne);
                usedMemoryAlgorithmOne = totalMemory - freeMemory;
                //usedMemory = cocktailSort.getUsedMemoryCocktailSort();
                totalExecutionTime = cocktailSort.getTotalExecutionTimeCocktailSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(df.format(usedMemoryAlgorithmOne / 1000_000f)+ " MB");
                lBSelectedAlgorithmOne.setText("Cocktail Sort:");
            }
            case "CombSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                CombSort combSort = new CombSort();
                combSort.combSort(randomArrayAlgorithmOne);
                 usedMemoryAlgorithmOne = totalMemory - freeMemory;
                //usedMemory = combSort.getUsedMemoryCombSort();
                totalExecutionTime = combSort.getTotalExecutionTimeCombSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(df.format(usedMemoryAlgorithmOne / 1000_000f)+ " MB");
                lBSelectedAlgorithmOne.setText("Comb Sort:");
            }
            case "CycleSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                CycleSort cycleSort = new CycleSort();
                cycleSort.cycleSort(randomArrayAlgorithmOne);
                usedMemoryAlgorithmOne = totalMemory - freeMemory;
                //usedMemory = cycleSort.getUsedMemoryCycleSort();
                totalExecutionTime = cycleSort.getTotalExecutionTimeCycleSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(df.format(usedMemoryAlgorithmOne / 1000_000f)+ " MB");
                lBSelectedAlgorithmOne.setText("Cycle Sort:");
            }
            case "GnomeSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                GnomeSort gnomeSort = new GnomeSort();
                gnomeSort.gnomeSort(randomArrayAlgorithmOne);
                usedMemoryAlgorithmOne = totalMemory - freeMemory;
                //usedMemory = gnomeSort.getUsedMemoryGnomeSort();
                totalExecutionTime = gnomeSort.getTotalExecutionTimeGnomeSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(df.format(usedMemoryAlgorithmOne / 1000_000f)+ " MB");
                lBSelectedAlgorithmOne.setText("Gnome Sort:");
            }
            case "HeapSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                HeapSort heapSort = new HeapSort();
                heapSort.heapSort(randomArrayAlgorithmOne);
                usedMemoryAlgorithmOne = totalMemory - freeMemory;
                //usedMemory = heapSort.getUsedMemoryHeapSort();
                totalExecutionTime = heapSort.getTotalExecutionTimeHeapSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(df.format(usedMemoryAlgorithmOne / 1000_000f)+ " MB");
                lBSelectedAlgorithmOne.setText("Heap Sort:");
            }
            case "OddEvenSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                OddEvenSort oddEvenSort = new OddEvenSort();
                oddEvenSort.oddEvenSort(randomArrayAlgorithmOne);
                usedMemoryAlgorithmOne = totalMemory - freeMemory;
                //usedMemory = oddEvenSort.getUsedMemoryOddEvenSort();
                totalExecutionTime = oddEvenSort.getTotalExecutionTimeOddEvenSort();
                lBExecutionTimeOne.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageOne.setText(df.format(usedMemoryAlgorithmOne / 1000_000f)+ " MB");
                lBSelectedAlgorithmOne.setText("Odd Even Sort:");
            }
            default -> {
            }
        }


        switch (selectedAlgorithmTwo) {
            case "BubbleSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                BubbleSort bubbleSort2 = new BubbleSort();
                bubbleSort2.bubbleSort(randomArrayAlgorithmTwo);
                usedMemoryAlgorithmTwo = totalMemory - freeMemory;
                //usedMemory = bubbleSort2.getUsedMemoryBubbleSort();
                totalExecutionTime = bubbleSort2.getTotalExecutionTimeBubbleSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(df.format(usedMemoryAlgorithmTwo / 1000_000f)+ " MB");
                lBSelectedAlgorithmTwo.setText("Bubble Sort:");
            }
            case "CocktailSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                CocktailSort cocktailSort2 = new CocktailSort();
                cocktailSort2.cocktailSort(randomArrayAlgorithmTwo);
                usedMemoryAlgorithmTwo = totalMemory - freeMemory;
                //usedMemory = cocktailSort2.getUsedMemoryCocktailSort();
                totalExecutionTime = cocktailSort2.getTotalExecutionTimeCocktailSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(df.format(usedMemoryAlgorithmTwo / 1000_000f)+ " MB");
                lBSelectedAlgorithmTwo.setText("Cocktail Sort:");
            }
            case "CombSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                CombSort combSort2 = new CombSort();
                combSort2.combSort(randomArrayAlgorithmTwo);
                usedMemoryAlgorithmTwo = totalMemory - freeMemory;
                //usedMemory = combSort2.getUsedMemoryCombSort();
                totalExecutionTime = combSort2.getTotalExecutionTimeCombSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(df.format(usedMemoryAlgorithmTwo / 1000_000f)+ " MB");
                lBSelectedAlgorithmTwo.setText("Comb Sort:");
            }
            case "CycleSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                CycleSort cycleSort2 = new CycleSort();
                cycleSort2.cycleSort(randomArrayAlgorithmTwo);
                usedMemoryAlgorithmTwo = totalMemory - freeMemory;
                //usedMemory = cycleSort2.getUsedMemoryCycleSort();
                totalExecutionTime = cycleSort2.getTotalExecutionTimeCycleSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(df.format(usedMemoryAlgorithmTwo / 1000_000f)+ " MB");
                lBSelectedAlgorithmTwo.setText("Cycle Sort:");
            }
            case "GnomeSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                GnomeSort gnomeSort2 = new GnomeSort();
                gnomeSort2.gnomeSort(randomArrayAlgorithmTwo);
                usedMemoryAlgorithmTwo = totalMemory - freeMemory;
                //usedMemory = gnomeSort2.getUsedMemoryGnomeSort();
                totalExecutionTime = gnomeSort2.getTotalExecutionTimeGnomeSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(df.format(usedMemoryAlgorithmTwo / 1000_000f)+ " MB");
                lBSelectedAlgorithmTwo.setText("Gnome Sort:");
            }
            case "HeapSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                HeapSort heapSort2 = new HeapSort();
                heapSort2.heapSort(randomArrayAlgorithmTwo);
                usedMemoryAlgorithmTwo = totalMemory - freeMemory;
                //usedMemory = heapSort2.getUsedMemoryHeapSort();
                totalExecutionTime = heapSort2.getTotalExecutionTimeHeapSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(df.format(usedMemoryAlgorithmTwo / 1000_000f)+ " MB");
                lBSelectedAlgorithmTwo.setText("Heap Sort:");
            }
            case "OddEvenSort" -> {
                Runtime runtime = Runtime.getRuntime();
                long totalMemory = runtime.totalMemory();
                long freeMemory = runtime.freeMemory();

                OddEvenSort oddEvenSort2 = new OddEvenSort();
                oddEvenSort2.oddEvenSort(randomArrayAlgorithmTwo);
                usedMemoryAlgorithmTwo = totalMemory - freeMemory;
                //usedMemory = oddEvenSort2.getUsedMemoryOddEvenSort();
                totalExecutionTime = oddEvenSort2.getTotalExecutionTimeOddEvenSort();
                lBExecutionTimeTwo.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                lBMemoryUsageTwo.setText(df.format(usedMemoryAlgorithmTwo / 1000_000f)+ " MB");
                lBSelectedAlgorithmTwo.setText("Odd Even Sort:");
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
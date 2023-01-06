package at.ac.fhcampuswien.algorithms_javafx;

import at.ac.fhcampuswien.algorithms_javafx.algorithms.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class Page2Controller {
    @FXML
    public Button btnPage1;
    @FXML
    private Stage stage;
    DecimalFormat df = new DecimalFormat("0.0000");
    @FXML
    private Label lbExecutionTimeOne;
    @FXML
    private Label lbExecutionTimeTwo;

    @FXML
    private ComboBox cBSelectedAlgorithmOne;
    @FXML
    private ComboBox cBSelectedAlgorithmTwo;
    @FXML
    private ComboBox cBArraySize;
    @FXML
    private Label lBSelectedAlgorithmOne;
    @FXML
    private Label lBSelectedAlgorithmTwo;
    @FXML
    private Label lbArraySwapsOne;
    @FXML
    private Label lbComparisonsOne;
    @FXML
    private Label lbArraySwapsTwo;
    @FXML
    private Label lbComparisonsTwo;


    @FXML
    protected void onBtnSortArrayClick() {

        String selectedAlgorithmOne =  cBSelectedAlgorithmOne.getValue().toString();
        String selectedAlgorithmTwo =  cBSelectedAlgorithmTwo.getValue().toString();
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

        long totalExecutionTimeOne = 0;
        long totalExecutionTimeTwo = 0;

        switch (selectedAlgorithmOne) {
            case "BubbleSort" -> {
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.bubbleSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = bubbleSort.getTotalExecutionTimeBubbleSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(bubbleSort.getComparisonsBubbleSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(bubbleSort.getSwapsBubbleSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Bubble Sort");
            }
            case "CocktailSort" -> {
                CocktailSort cocktailSort = new CocktailSort();
                cocktailSort.cocktailSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = cocktailSort.getTotalExecutionTimeCocktailSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(cocktailSort.getComparisonsCocktailSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(cocktailSort.getSwapsCocktailSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Cocktail Sort");
            }
            case "CombSort" -> {
                CombSort combSort = new CombSort();
                combSort.combSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = combSort.getTotalExecutionTimeCombSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(combSort.getComparisonsCombSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(combSort.getSwapsCombSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Comb Sort");
            }
            case "CycleSort" -> {
                CycleSort cycleSort = new CycleSort();
                cycleSort.cycleSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = cycleSort.getTotalExecutionTimeCycleSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(cycleSort.getComparisonsCycleSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(cycleSort.getSwapsCycleSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Cycle Sort");
            }
            case "GnomeSort" -> {
                GnomeSort gnomeSort = new GnomeSort();
                gnomeSort.gnomeSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = gnomeSort.getTotalExecutionTimeGnomeSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(gnomeSort.getComparisonsGnomeSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(gnomeSort.getSwapsGnomeSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Gnome Sort");
            }
            case "HeapSort" -> {
                HeapSort heapSort = new HeapSort();
                heapSort.heapSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = heapSort.getTotalExecutionTimeHeapSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(heapSort.getComparisonsHeapSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(heapSort.getSwapsHeapSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Heap Sort");
            }
            case "OddEvenSort" -> {
                OddEvenSort oddEvenSort = new OddEvenSort();
                oddEvenSort.oddEvenSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = oddEvenSort.getTotalExecutionTimeOddEvenSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(oddEvenSort.getComparisonsOddEvenSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(oddEvenSort.getSwapsOddEvenSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Odd/Even Sort");
            }
            case "InsertionSort" -> {
                InsertionSort insertionSort = new InsertionSort();
                insertionSort.insertionSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = insertionSort.getTotalExecutionTimeInsertionSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(insertionSort.getComparisonsInsertionSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(insertionSort.getSwapsInsertionSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Insertion Sort");
            }
            case "SelectionSort" -> {
                SelectionSort selectionSort = new SelectionSort();
                selectionSort.selectionSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = selectionSort.getTotalExecutionTimeSelectionSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(selectionSort.getComparisonsSelectionSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(selectionSort.getSwapsSelectionSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Selection Sort");
            }
            case "QuickSort" -> {
                QuickSort quickSort = new QuickSort();
                quickSort.quickSort(randomArrayAlgorithmOne);
                totalExecutionTimeOne = quickSort.getTotalExecutionTimeQuickSort();
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");
                String comparisons = String.valueOf(quickSort.getComparisonsQuickSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(quickSort.getSwapsQuickSort());
                lbArraySwapsOne.setText(swaps);
                lBSelectedAlgorithmOne.setText("Quick Sort");
            }
            default -> {
            }
        }

        switch (selectedAlgorithmTwo) {
            case "BubbleSort" -> {
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.bubbleSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = bubbleSort.getTotalExecutionTimeBubbleSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(bubbleSort.getComparisonsBubbleSort());
                lbComparisonsTwo.setText(comparisons);
                String swaps = String.valueOf(bubbleSort.getSwapsBubbleSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Bubble Sort");
            }
            case "CocktailSort" -> {
                CocktailSort cocktailSort = new CocktailSort();
                cocktailSort.cocktailSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = cocktailSort.getTotalExecutionTimeCocktailSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(cocktailSort.getComparisonsCocktailSort());
                lbComparisonsTwo.setText(comparisons);
                String swaps = String.valueOf(cocktailSort.getSwapsCocktailSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Cocktail Sort");
            }
            case "CombSort" -> {
                CombSort combSort = new CombSort();
                combSort.combSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = combSort.getTotalExecutionTimeCombSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(combSort.getComparisonsCombSort());
                lbComparisonsTwo.setText(comparisons);
                String swaps = String.valueOf(combSort.getSwapsCombSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Comb Sort");
            }
            case "CycleSort" -> {
                CycleSort cycleSort = new CycleSort();
                cycleSort.cycleSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = cycleSort.getTotalExecutionTimeCycleSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(cycleSort.getComparisonsCycleSort());
                lbComparisonsTwo.setText(comparisons);
                String swaps = String.valueOf(cycleSort.getSwapsCycleSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Cycle Sort");
            }
            case "GnomeSort" -> {
                GnomeSort gnomeSort = new GnomeSort();
                gnomeSort.gnomeSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = gnomeSort.getTotalExecutionTimeGnomeSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(gnomeSort.getComparisonsGnomeSort());
                lbComparisonsTwo.setText(comparisons);
                String swaps = String.valueOf(gnomeSort.getSwapsGnomeSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Gnome Sort");
            }
            case "HeapSort" -> {
                HeapSort heapSort = new HeapSort();
                heapSort.heapSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = heapSort.getTotalExecutionTimeHeapSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(heapSort.getComparisonsHeapSort());
                lbComparisonsOne.setText(comparisons);
                String swaps = String.valueOf(heapSort.getSwapsHeapSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Heap Sort");
            }
            case "OddEvenSort" -> {
                OddEvenSort oddEvenSort = new OddEvenSort();
                oddEvenSort.oddEvenSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = oddEvenSort.getTotalExecutionTimeOddEvenSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(oddEvenSort.getComparisonsOddEvenSort());
                lbComparisonsTwo.setText(comparisons);
                String swaps = String.valueOf(oddEvenSort.getSwapsOddEvenSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Odd/Even Sort");
            }
            case "InsertionSort" -> {
                InsertionSort insertionSort = new InsertionSort();
                insertionSort.insertionSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = insertionSort.getTotalExecutionTimeInsertionSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(insertionSort.getComparisonsInsertionSort());
                lbComparisonsTwo.setText(comparisons);
                String swaps = String.valueOf(insertionSort.getSwapsInsertionSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Insertion Sort");
            }
            case "SelectionSort" -> {
                SelectionSort selectionSort = new SelectionSort();
                selectionSort.selectionSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = selectionSort.getTotalExecutionTimeSelectionSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(selectionSort.getComparisonsSelectionSort());
                lbComparisonsTwo.setText(comparisons);
                String swaps = String.valueOf(selectionSort.getSwapsSelectionSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Selection Sort");
            }
            case "QuickSort" -> {
                QuickSort quickSort = new QuickSort();
                quickSort.quickSort(randomArrayAlgorithmTwo);
                totalExecutionTimeTwo = quickSort.getTotalExecutionTimeQuickSort();
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");
                String comparisons = String.valueOf(quickSort.getComparisonsQuickSort());
                lbComparisonsTwo.setText(comparisons);
                String swaps = String.valueOf(quickSort.getSwapsQuickSort());
                lbArraySwapsTwo.setText(swaps);
                lBSelectedAlgorithmTwo.setText("Quick Sort");
            }
            default -> {
            }
        }
    }




}
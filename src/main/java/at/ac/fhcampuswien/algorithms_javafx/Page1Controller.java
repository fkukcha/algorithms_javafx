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
    private Label lbExecutionTime;
    @FXML
    private Label lbArraySwaps;
    @FXML
    private Label lbComparisons;
    @FXML
    private Label lbSelectedAlgorithm;

    @FXML
    private ComboBox cbSelectedAlgorithm;
    @FXML
    private ComboBox cbArraySize;

    @FXML
    protected void onBtnSortArrayClick() {

        cbSelectedAlgorithm.getValue();
        cbArraySize.getValue();

        String selectedAlgorithm =  cbSelectedAlgorithm.getValue().toString();
        String selectedArraySize =  cbArraySize.getValue().toString();
        int arraySize = switch (selectedArraySize) {
            case "Thousand" -> 1000;
            case "Ten thousand" -> 10000;
            case "Hundred thousand" -> 100000;
            default -> 0;
        };

        CreateRandomArray createRandomArray = new CreateRandomArray(arraySize);
        long totalExecutionTime = 0;

        switch (selectedAlgorithm) {
            case "BubbleSort" -> {
                BubbleSort bubbleSort = new BubbleSort();
                bubbleSort.bubbleSort(createRandomArray.getRandomArray());
                totalExecutionTime = bubbleSort.getTotalExecutionTimeBubbleSort();
                lbExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                String comparisons = String.valueOf(bubbleSort.getComparisonsBubbleSort());
                lbComparisons.setText(comparisons);
                String swaps = String.valueOf(bubbleSort.getSwapsBubbleSort());
                lbArraySwaps.setText(swaps);
                lbSelectedAlgorithm.setText("Bubble Sort");
            }
            case "CocktailSort" -> {
                CocktailSort cocktailSort = new CocktailSort();
                cocktailSort.cocktailSort(createRandomArray.getRandomArray());
                totalExecutionTime = cocktailSort.getTotalExecutionTimeCocktailSort();
                lbExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                String comparisons = String.valueOf(cocktailSort.getComparisonsCocktailSort());
                lbComparisons.setText(comparisons);
                String swaps = String.valueOf(cocktailSort.getSwapsCocktailSort());
                lbArraySwaps.setText(swaps);
                lbSelectedAlgorithm.setText("Cocktail Sort");
            }
            case "CombSort" -> {
                CombSort combSort = new CombSort();
                combSort.combSort(createRandomArray.getRandomArray());
                totalExecutionTime = combSort.getTotalExecutionTimeCombSort();
                lbExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                String comparisons = String.valueOf(combSort.getComparisonsCombSort());
                lbComparisons.setText(comparisons);
                String swaps = String.valueOf(combSort.getSwapsCombSort());
                lbArraySwaps.setText(swaps);
                lbSelectedAlgorithm.setText("Comb Sort");
            }
            case "CycleSort" -> {
                CycleSort cycleSort = new CycleSort();
                cycleSort.cycleSort(createRandomArray.getRandomArray());
                totalExecutionTime = cycleSort.getTotalExecutionTimeCycleSort();
                lbExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                String comparisons = String.valueOf(cycleSort.getComparisonsCycleSort());
                lbComparisons.setText(comparisons);
                String swaps = String.valueOf(cycleSort.getSwapsCycleSort());
                lbArraySwaps.setText(swaps);
                lbSelectedAlgorithm.setText("Cycle Sort");
            }
            case "GnomeSort" -> {
                GnomeSort gnomeSort = new GnomeSort();
                gnomeSort.gnomeSort(createRandomArray.getRandomArray());
                totalExecutionTime = gnomeSort.getTotalExecutionTimeGnomeSort();
                lbExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                String comparisons = String.valueOf(gnomeSort.getComparisonsGnomeSort());
                lbComparisons.setText(comparisons);
                String swaps = String.valueOf(gnomeSort.getSwapsGnomeSort());
                lbArraySwaps.setText(swaps);
                lbSelectedAlgorithm.setText("Gnome Sort");
            }
            case "HeapSort" -> {
                HeapSort heapSort = new HeapSort();
                heapSort.heapSort(createRandomArray.getRandomArray());
                totalExecutionTime = heapSort.getTotalExecutionTimeHeapSort();
                lbExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                String comparisons = String.valueOf(heapSort.getComparisonsHeapSort());
                lbComparisons.setText(comparisons);
                String swaps = String.valueOf(heapSort.getSwapsHeapSort());
                lbArraySwaps.setText(swaps);
                lbSelectedAlgorithm.setText("Heap Sort");
            }
            case "OddEvenSort" -> {
                OddEvenSort oddEvenSort = new OddEvenSort();
                oddEvenSort.oddEvenSort(createRandomArray.getRandomArray());
                totalExecutionTime = oddEvenSort.getTotalExecutionTimeOddEvenSort();
                lbExecutionTime.setText(df.format(totalExecutionTime / 1000000F) + " ms");
                String comparisons = String.valueOf(oddEvenSort.getComparisonsOddEvenSort());
                lbComparisons.setText(comparisons);
                String swaps = String.valueOf(oddEvenSort.getSwapsOddEvenSort());
                lbArraySwaps.setText(swaps);
                lbSelectedAlgorithm.setText("Odd Even Sort");
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
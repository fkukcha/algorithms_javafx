package at.ac.fhcampuswien.algorithms_javafx;

import at.ac.fhcampuswien.algorithms_javafx.algorithms.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 * The controller class for the first page of the application.
 */
public class Page1Controller {

    /**
     * The button for navigating to the second page.
     */
    @FXML
    private Button btnPage2;

    /**
     * A {@link DecimalFormat} object for formatting decimal numbers.
     */
    final DecimalFormat df = new DecimalFormat("0.0000");

    /**
     * The label for displaying the execution time.
     */
    @FXML
    private Label lbExecutionTime;

    /**
     * The label for displaying the number of array swaps.
     */
    @FXML
    private Label lbArraySwaps;

    /**
     * The label for displaying the number of comparisons.
     */
    @FXML
    private Label lbComparisons;

    /**
     * The label for displaying the selected sorting algorithm.
     */
    @FXML
    private Label lbSelectedAlgorithm;

    /**
     * The Box for selecting the sorting algorithm.
     */
    @FXML
    private ComboBox cbSelectedAlgorithm;

    /**
     * The Box for selecting the array size.
     */
    @FXML
    private ComboBox cbArraySize;

    /**
     * Method for sorting the array with the usage of the bubble sort algorithm and outputting the
     * results in the designated labels
     */
    public void bubbleSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Bubble Sort");

        // Create a new BubbleSort object
        BubbleSort bubbleSort = new BubbleSort();

        // Sort the array using the bubble sort algorithm
        bubbleSort.bubbleSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(bubbleSort.getTotalExecutionTimeBubbleSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(bubbleSort.getComparisonsBubbleSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(bubbleSort.getSwapsBubbleSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * Method for sorting the array with the usage of the cocktail sort algorithm and outputting the
     * results in the designated labels
     */
    public void cocktailSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Cocktail Sort");
        // Create a CocktailSort object
        CocktailSort cocktailSort = new CocktailSort();

        // Sort the array using the cocktail sort algorithm
        cocktailSort.cocktailSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(cocktailSort.getTotalExecutionTimeCocktailSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(cocktailSort.getComparisonsCocktailSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(cocktailSort.getSwapsCocktailSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * Method for sorting the array with the usage of the comb sort algorithm and outputting the
     * results in the designated labels
     */
    public void combSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Comb Sort");

        // Create a CombSort object
        CombSort combSort = new CombSort();

        // Sort the array using the comb sort algorithm
        combSort.combSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(combSort.getTotalExecutionTimeCombSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(combSort.getComparisonsCombSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(combSort.getSwapsCombSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * Method for sorting the array with the usage of the cycle sort algorithm and outputting the
     * results in the designated labels
     */
    public void cycleSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Cycle Sort");

        // Create a CycleSort object
        CycleSort cycleSort = new CycleSort();

        // Sort the array using the cycle sort algorithm
        cycleSort.cycleSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(cycleSort.getTotalExecutionTimeCycleSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(cycleSort.getComparisonsCycleSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(cycleSort.getSwapsCycleSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * Method for sorting the array with the usage of the gnome sort algorithm and outputting the
     * results in the designated labels
     */
    public void gnomeSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Gnome Sort");

        // Create a GnomeSort object
        GnomeSort gnomeSort = new GnomeSort();

        // Sort the array using the gnome sort algorithm
        gnomeSort.gnomeSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(gnomeSort.getTotalExecutionTimeGnomeSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(gnomeSort.getComparisonsGnomeSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(gnomeSort.getSwapsGnomeSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * Method for sorting the array with the usage of the heap sort algorithm and outputting the
     * results in the designated labels
     */
    public void heapSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Heap Sort");

        // Create a HeapSort object
        HeapSort heapSort = new HeapSort();

        // Sort the array using the heap sort algorithm
        heapSort.heapSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(heapSort.getTotalExecutionTimeHeapSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(heapSort.getComparisonsHeapSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(heapSort.getSwapsHeapSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * Method for sorting the array with the usage of the insertion sort algorithm and outputting the
     * results in the designated labels
     */
    public void insertionSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Insertion Sort");

        //Create an InsertionSort Object
        InsertionSort insertionSort = new InsertionSort();

        // Sort the array using the insertion sort algorithm
        insertionSort.insertionSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(insertionSort.getTotalExecutionTimeInsertionSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(insertionSort.getComparisonsInsertionSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(insertionSort.getSwapsInsertionSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * Method for sorting the array with the usage of the odd/even sort algorithm and outputting the
     * results in the designated labels
     */
    public void oddEvenSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Odd/Even Sort");

        //Create an OddEvenSort Object
        OddEvenSort oddEvenSort = new OddEvenSort();

        // Sort the array using the odd-even sort algorithm
        oddEvenSort.oddEvenSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(oddEvenSort.getTotalExecutionTimeOddEvenSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(oddEvenSort.getComparisonsOddEvenSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(oddEvenSort.getSwapsOddEvenSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * Method for sorting the array with the usage of the quick sort algorithm and outputting the
     * results in the designated labels
     */
    public void quickSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Quick Sort");

        //Create a QuickSort Object
        QuickSort quickSort = new QuickSort();

        // Sort the array using the quick sort algorithm
        quickSort.quickSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(quickSort.getTotalExecutionTimeQuickSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(quickSort.getComparisonsQuickSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(quickSort.getSwapsQuickSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * Method for sorting the array with the usage of the selection sort algorithm and outputting the
     * results in the designated labels
     */
    public void selectionSort(int[] randomArray){
        // Set the text for the selected algorithm label
        lbSelectedAlgorithm.setText("Selection Sort");

        //Create a SelectionSort Object
        SelectionSort selectionSort = new SelectionSort();

        // Sort the array using the selection sort algorithm
        selectionSort.selectionSort(randomArray);

        // Set the text for the execution time label
        lbExecutionTime.setText(df.format(selectionSort.getTotalExecutionTimeSelectionSort() / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(selectionSort.getComparisonsSelectionSort());
        lbComparisons.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(selectionSort.getSwapsSelectionSort());
        lbArraySwaps.setText(swaps);
    }

    /**
     * This method is called when the "Sort Array" button is clicked.
     * It gets the selected sorting algorithm and array size,
     * creates a random array, sorts it using the selected algorithm, and displays the execution time,
     * number of comparisons, and number of swaps.
     */
    @FXML
    protected void onBtnSortArrayClick() {

        // Get the selected algorithm and array size
        cbSelectedAlgorithm.getValue();
        cbArraySize.getValue();

        // Convert the selected algorithm and array size to strings and store them in variables
        String selectedAlgorithm =  cbSelectedAlgorithm.getValue().toString();
        String selectedArraySize =  cbArraySize.getValue().toString();

        // Use a switch statement to convert the selected array size string to an int
        int arraySize = switch (selectedArraySize) {
            case "Thousand" -> 1000;
            case "Ten thousand" -> 10000;
            case "Hundred thousand" -> 100000;
            default -> 0;
        };

        // Creation of a random array of the selected size
        CreateRandomArray createRandomArray = new CreateRandomArray(arraySize);
        int[] randomArray = createRandomArray.getRandomArray();

        // Use a switch statement to sort the array using the selected algorithm
        // and display the execution time, number of comparisons and number of swaps
        switch (selectedAlgorithm) {
            case "BubbleSort" -> bubbleSort(randomArray);
            case "CocktailSort" -> cocktailSort(randomArray);
            case "CombSort" -> combSort(randomArray);
            case "CycleSort" -> cycleSort(randomArray);
            case "GnomeSort" -> gnomeSort(randomArray);
            case "HeapSort" -> heapSort(randomArray);
            case "OddEvenSort" -> oddEvenSort(randomArray);
            case "InsertionSort" -> insertionSort(randomArray);
            case "SelectionSort" -> selectionSort(randomArray);
            case "QuickSort" -> quickSort(randomArray);
            default -> {
            }
        }
    }

    /**
     * This method is called when the "Compare two sorting algorithms" button is clicked. It changes the scene to the second page.
     *
     * @param event the action event that triggered this method
     * @throws IOException if there is an error loading the FXML file for the second page
     */
    @FXML
    protected void onChangeToSecondScene (ActionEvent event) throws IOException {

        // Get the Stage and set it to the current window
        Stage switchToSceneTwo;
        switchToSceneTwo = (Stage) btnPage2.getScene().getWindow();

        // Load the FXML file for the second page and set it as the root node
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("secondPage.fxml")));

        // Create a new Scene with the loaded FXML file as the root node
        Scene scene = new Scene(root);

        // Set the Scene for the Stage and show it
        switchToSceneTwo.setScene(scene);
        switchToSceneTwo.show();
    }
}
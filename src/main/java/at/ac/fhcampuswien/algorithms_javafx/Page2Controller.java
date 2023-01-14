package at.ac.fhcampuswien.algorithms_javafx;

import at.ac.fhcampuswien.algorithms_javafx.algorithms.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Objects;

public class Page2Controller {
    /**
     * The controller class for the second page of the application.
     */
    @FXML
    public Button btnPage1;

    /**
     * The Stage for the second page.
     */
    @FXML
    private Stage stage;

    /**
     * A {@link DecimalFormat} object for formatting decimal numbers.
     */
    DecimalFormat df = new DecimalFormat("0.0000");

    /**
     * The label for displaying the execution time of the first sorting algorithm.
     */
    @FXML
    private Label lbExecutionTimeOne;

    /**
     * The label for displaying the execution time of the second sorting algorithm.
     */
    @FXML
    private Label lbExecutionTimeTwo;

    /**
     * The ComboBox for selecting the first sorting algorithm.
     */
    @FXML
    private ComboBox cBSelectedAlgorithmOne;

    /**
     * The ComboBox for selecting the second sorting algorithm.
     */
    @FXML
    private ComboBox cBSelectedAlgorithmTwo;

    /**
     * The ComboBox for selecting the array size.
     */
    @FXML
    private ComboBox cBArraySize;

    /**
     * The label for displaying the selected first sorting algorithm.
     */
    @FXML
    private Label lBSelectedAlgorithmOne;

    /**
     * The label for displaying the selected second sorting algorithm.
     */
    @FXML
    private Label lBSelectedAlgorithmTwo;

    /**
     * The label for displaying the number of array swaps for the first sorting algorithm.
     */
    @FXML
    private Label lbArraySwapsOne;

    /**
     * The label for displaying the number of comparisons for the first sorting algorithm.
     */
    @FXML
    private Label lbComparisonsOne;

    /**
     * The label for displaying the number of array swaps for the second sorting algorithm.
     */
    @FXML
    private Label lbArraySwapsTwo;

    /**
     * The label for displaying the number of comparisons for the second sorting algorithm.
     */
    @FXML
    private Label lbComparisonsTwo;

    /**
     * This method is called when the "Sort Arrays" button is clicked. It gets the selected sorting algorithms
     * and array size, creates 2 random arrays, sorts them using the selected algorithms, and displays the
     * execution time, number of comparisons, and number of swaps of both arrays.
     */
    @FXML
    protected void onBtnSortArrayClick() {

        // Get the selected algorithms and array size from the combo boxes
        String selectedAlgorithmOne =  cBSelectedAlgorithmOne.getValue().toString();
        String selectedAlgorithmTwo =  cBSelectedAlgorithmTwo.getValue().toString();
        String selectedArraySize =  cBArraySize.getValue().toString();

        //Make sure that not the same algorithms are chosen
        if(selectedAlgorithmOne.equals(selectedAlgorithmTwo)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning!");
            alert.setHeaderText("Please select different algorithms to compare.");
            alert.showAndWait();

            //Resets the choices
            cBSelectedAlgorithmOne.setValue(null);
            cBSelectedAlgorithmTwo.setValue(null);
            cBArraySize.setValue(null);
            return;
        }

        // Convert the selected array size to an integer
        int arraySize = switch (selectedArraySize) {
            case "Thousand" -> 1000;
            case "Ten thousand" -> 10000;
            case "Hundred thousand" -> 100000;
            default -> 0;
        };

        // Create a random array of the specified size
        CreateRandomArray createRandomArray = new CreateRandomArray(arraySize);
        int[] randomArray = createRandomArray.getRandomArray();

        // creation of two array copies to avoid altering the original array
        int[] randomArrayAlgorithmOne = randomArray.clone();
        int[] randomArrayAlgorithmTwo = randomArray.clone();

        // Initialize the total execution times for both algorithms
        long totalExecutionTimeOne = 0;
        long totalExecutionTimeTwo = 0;

        // Use a switch statement to sort the array using the first selected algorithm
        // and display the execution time, number of comparisons,
        // and number of swaps
        switch (selectedAlgorithmOne) {
            case "BubbleSort" -> {

                // Create a new BubbleSort object
                BubbleSort bubbleSort = new BubbleSort();

                // Sort the array using the bubble sort algorithm
                bubbleSort.bubbleSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = bubbleSort.getTotalExecutionTimeBubbleSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(bubbleSort.getComparisonsBubbleSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(bubbleSort.getSwapsBubbleSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Bubble Sort");
            }
            case "CocktailSort" -> {

                // Create a CocktailSort object
                CocktailSort cocktailSort = new CocktailSort();

                // Sort the array using the cocktail sort algorithm
                cocktailSort.cocktailSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = cocktailSort.getTotalExecutionTimeCocktailSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(cocktailSort.getComparisonsCocktailSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(cocktailSort.getSwapsCocktailSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Cocktail Sort");
            }
            case "CombSort" -> {

                // Create a CombSort object
                CombSort combSort = new CombSort();

                // Sort the array using the comb sort algorithm
                combSort.combSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = combSort.getTotalExecutionTimeCombSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(combSort.getComparisonsCombSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(combSort.getSwapsCombSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Comb Sort");
            }
            case "CycleSort" -> {

                // Create a CycleSort object
                CycleSort cycleSort = new CycleSort();

                // Sort the array using the cycle sort algorithm
                cycleSort.cycleSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = cycleSort.getTotalExecutionTimeCycleSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(cycleSort.getComparisonsCycleSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(cycleSort.getSwapsCycleSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Cycle Sort");
            }
            case "GnomeSort" -> {

                // Create a GnomeSort object
                GnomeSort gnomeSort = new GnomeSort();

                // Sort the array using the gnome sort algorithm
                gnomeSort.gnomeSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = gnomeSort.getTotalExecutionTimeGnomeSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(gnomeSort.getComparisonsGnomeSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(gnomeSort.getSwapsGnomeSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Gnome Sort");
            }
            case "HeapSort" -> {

                // Create a HeapSort object
                HeapSort heapSort = new HeapSort();

                // Sort the array using the heap sort algorithm
                heapSort.heapSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = heapSort.getTotalExecutionTimeHeapSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(heapSort.getComparisonsHeapSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(heapSort.getSwapsHeapSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Heap Sort");
            }
            case "OddEvenSort" -> {

                //Create an OddEvenSort Object
                OddEvenSort oddEvenSort = new OddEvenSort();

                // Sort the array using the odd-even sort algorithm
                oddEvenSort.oddEvenSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = oddEvenSort.getTotalExecutionTimeOddEvenSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(oddEvenSort.getComparisonsOddEvenSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(oddEvenSort.getSwapsOddEvenSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Odd/Even Sort");
            }
            case "InsertionSort" -> {

                //Create an InsertionSort Object
                InsertionSort insertionSort = new InsertionSort();

                // Sort the array using the insertion sort algorithm
                insertionSort.insertionSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = insertionSort.getTotalExecutionTimeInsertionSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(insertionSort.getComparisonsInsertionSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(insertionSort.getSwapsInsertionSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Insertion Sort");
            }
            case "SelectionSort" -> {

                //Create a SelectionSort Object
                SelectionSort selectionSort = new SelectionSort();

                // Sort the array using the selection sort algorithm
                selectionSort.selectionSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = selectionSort.getTotalExecutionTimeSelectionSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(selectionSort.getComparisonsSelectionSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(selectionSort.getSwapsSelectionSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Selection Sort");
            }
            case "QuickSort" -> {

                //Create a QuickSort Object
                QuickSort quickSort = new QuickSort();

                // Sort the array using the quick sort algorithm
                quickSort.quickSort(randomArrayAlgorithmOne);

                // Get the execution time and store it in the totalExecutionTimeOne variable
                totalExecutionTimeOne = quickSort.getTotalExecutionTimeQuickSort();

                // Set the text for the execution time label
                lbExecutionTimeOne.setText(df.format(totalExecutionTimeOne / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(quickSort.getComparisonsQuickSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(quickSort.getSwapsQuickSort());
                lbArraySwapsOne.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmOne.setText("Quick Sort");
            }
            default -> {
            }
        }

        // Use a switch statement to sort the array using the second selected algorithm
        // and display the execution time, number of comparisons,
        // and number of swaps
        switch (selectedAlgorithmTwo) {
            case "BubbleSort" -> {

                // Create a new BubbleSort object
                BubbleSort bubbleSort = new BubbleSort();

                // Sort the array using the bubble sort algorithm
                bubbleSort.bubbleSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = bubbleSort.getTotalExecutionTimeBubbleSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(bubbleSort.getComparisonsBubbleSort());
                lbComparisonsTwo.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(bubbleSort.getSwapsBubbleSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Bubble Sort");
            }
            case "CocktailSort" -> {

                // Create a CocktailSort object
                CocktailSort cocktailSort = new CocktailSort();

                // Sort the array using the cocktail sort algorithm
                cocktailSort.cocktailSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = cocktailSort.getTotalExecutionTimeCocktailSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(cocktailSort.getComparisonsCocktailSort());
                lbComparisonsTwo.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(cocktailSort.getSwapsCocktailSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Cocktail Sort");
            }
            case "CombSort" -> {

                // Create a CombSort object
                CombSort combSort = new CombSort();

                // Sort the array using the comb sort algorithm
                combSort.combSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = combSort.getTotalExecutionTimeCombSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(combSort.getComparisonsCombSort());
                lbComparisonsTwo.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(combSort.getSwapsCombSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Comb Sort");
            }
            case "CycleSort" -> {

                // Create a CycleSort object
                CycleSort cycleSort = new CycleSort();

                // Sort the array using the cycle sort algorithm
                cycleSort.cycleSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = cycleSort.getTotalExecutionTimeCycleSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(cycleSort.getComparisonsCycleSort());
                lbComparisonsTwo.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(cycleSort.getSwapsCycleSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Cycle Sort");
            }
            case "GnomeSort" -> {

                // Create a GnomeSort object
                GnomeSort gnomeSort = new GnomeSort();

                // Sort the array using the gnome sort algorithm
                gnomeSort.gnomeSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = gnomeSort.getTotalExecutionTimeGnomeSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(gnomeSort.getComparisonsGnomeSort());
                lbComparisonsTwo.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(gnomeSort.getSwapsGnomeSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Gnome Sort");
            }
            case "HeapSort" -> {

                // Create a HeapSort object
                HeapSort heapSort = new HeapSort();

                // Sort the array using the heap sort algorithm
                heapSort.heapSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = heapSort.getTotalExecutionTimeHeapSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(heapSort.getComparisonsHeapSort());
                lbComparisonsOne.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(heapSort.getSwapsHeapSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Heap Sort");
            }
            case "OddEvenSort" -> {

                //Create an OddEvenSort Object
                OddEvenSort oddEvenSort = new OddEvenSort();

                // Sort the array using the odd-even sort algorithm
                oddEvenSort.oddEvenSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = oddEvenSort.getTotalExecutionTimeOddEvenSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(oddEvenSort.getComparisonsOddEvenSort());
                lbComparisonsTwo.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(oddEvenSort.getSwapsOddEvenSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Odd/Even Sort");
            }
            case "InsertionSort" -> {

                //Create an InsertionSort Object
                InsertionSort insertionSort = new InsertionSort();

                // Sort the array using the insertion sort algorithm
                insertionSort.insertionSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = insertionSort.getTotalExecutionTimeInsertionSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(insertionSort.getComparisonsInsertionSort());
                lbComparisonsTwo.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(insertionSort.getSwapsInsertionSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Insertion Sort");
            }
            case "SelectionSort" -> {

                //Create a SelectionSort Object
                SelectionSort selectionSort = new SelectionSort();

                // Sort the array using the selection sort algorithm
                selectionSort.selectionSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = selectionSort.getTotalExecutionTimeSelectionSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(selectionSort.getComparisonsSelectionSort());
                lbComparisonsTwo.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(selectionSort.getSwapsSelectionSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Selection Sort");
            }
            case "QuickSort" -> {

                //Create a QuickSort Object
                QuickSort quickSort = new QuickSort();

                // Sort the array using the quick sort algorithm
                quickSort.quickSort(randomArrayAlgorithmTwo);

                // Get the execution time and store it in the totalExecutionTimeTwo variable
                totalExecutionTimeTwo = quickSort.getTotalExecutionTimeQuickSort();

                // Set the text for the execution time label
                lbExecutionTimeTwo.setText(df.format(totalExecutionTimeTwo / 1000000F) + " ms");

                // Set the text for the comparisons label
                String comparisons = String.valueOf(quickSort.getComparisonsQuickSort());
                lbComparisonsTwo.setText(comparisons);

                // Set the text for the swaps label
                String swaps = String.valueOf(quickSort.getSwapsQuickSort());
                lbArraySwapsTwo.setText(swaps);

                // Set the text for the selected algorithm label
                lBSelectedAlgorithmTwo.setText("Quick Sort");
            }
            default -> {
            }
        }
    }

    /**
     * This method is called when the "Full sorting algorithm list" button is clicked. It changes the scene to the first page.
     *
     * @param event the action event that triggered this method
     * @throws IOException if there is an error loading the FXML file for the second page
     */
    @FXML
    protected void onChangeToFirstScene (ActionEvent event) throws IOException {

        // Get the Stage and set it to the current window
        Stage stage;
        stage = (Stage) btnPage1.getScene().getWindow();

        // Load the FXML file for the second page and set it as the root node
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("firstPage.fxml")));

        // Create a new Scene with the loaded FXML file as the root node
        Scene scene = new Scene(root);

        // Set the Scene for the Stage and show it
        stage.setScene(scene);
        stage.show();
    }



}
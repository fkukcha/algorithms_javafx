package at.ac.fhcampuswien.algorithms_javafx;

import at.ac.fhcampuswien.algorithms_javafx.alerts.Alerts;
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
    final DecimalFormat df = new DecimalFormat("0.0000");

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
     * Method for resetting the combo boxes and the labels when an exception occurs
     */
    public void resetBoxes(){

        cBSelectedAlgorithmOne.setValue(null);
        lBSelectedAlgorithmOne.setText(null);
        lbExecutionTimeOne.setText(null);
        lbComparisonsOne.setText(null);
        lbArraySwapsOne.setText(null);

        cBSelectedAlgorithmTwo.setValue(null);
        lbExecutionTimeTwo.setText(null);
        lbComparisonsTwo.setText(null);
        lbArraySwapsTwo.setText(null);
        lBSelectedAlgorithmTwo.setText(null);
    }

    public void bubbleSortOne(long executionTime, int[] randomArray) {
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Bubble Sort");

        // Create a new BubbleSort object
        BubbleSort bubbleSort = new BubbleSort();

        // Sort the array using the bubble sort algorithm
        bubbleSort.bubbleSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = bubbleSort.getTotalExecutionTimeBubbleSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(bubbleSort.getComparisonsBubbleSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(bubbleSort.getSwapsBubbleSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void bubbleSortTwo(long executionTime, int[] randomArray) {
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Bubble Sort");

        // Create a new BubbleSort object
        BubbleSort bubbleSort = new BubbleSort();

        // Sort the array using the bubble sort algorithm
        bubbleSort.bubbleSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = bubbleSort.getTotalExecutionTimeBubbleSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(bubbleSort.getComparisonsBubbleSort());
        lbComparisonsTwo.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(bubbleSort.getSwapsBubbleSort());
        lbArraySwapsTwo.setText(swaps);
    }

    public void cocktailSortOne(long executionTime, int[] randomArray) {
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Cocktail Sort");

        // Create a CocktailSort object
        CocktailSort cocktailSort = new CocktailSort();

        // Sort the array using the cocktail sort algorithm
        cocktailSort.cocktailSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = cocktailSort.getTotalExecutionTimeCocktailSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(cocktailSort.getComparisonsCocktailSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(cocktailSort.getSwapsCocktailSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void cocktailSortTwo(long executionTime, int[] randomArray) {
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Cocktail Sort");

        // Create a CocktailSort object
        CocktailSort cocktailSort = new CocktailSort();

        // Sort the array using the cocktail sort algorithm
        cocktailSort.cocktailSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = cocktailSort.getTotalExecutionTimeCocktailSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(cocktailSort.getComparisonsCocktailSort());
        lbComparisonsTwo.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(cocktailSort.getSwapsCocktailSort());
        lbArraySwapsTwo.setText(swaps);
    }

    public void combSortOne(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Comb Sort");

        // Create a CombSort object
        CombSort combSort = new CombSort();

        // Sort the array using the comb sort algorithm
        combSort.combSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = combSort.getTotalExecutionTimeCombSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(combSort.getComparisonsCombSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(combSort.getSwapsCombSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void combSortTwo(long executionTime, int[] randomArray) {
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Comb Sort");

        // Create a CombSort object
        CombSort combSort = new CombSort();

        // Sort the array using the comb sort algorithm
        combSort.combSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = combSort.getTotalExecutionTimeCombSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(combSort.getComparisonsCombSort());
        lbComparisonsTwo.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(combSort.getSwapsCombSort());
        lbArraySwapsTwo.setText(swaps);
    }

    public void cycleSortOne(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Cycle Sort");

        // Create a CycleSort object
        CycleSort cycleSort = new CycleSort();

        // Sort the array using the cycle sort algorithm
        cycleSort.cycleSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = cycleSort.getTotalExecutionTimeCycleSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(cycleSort.getComparisonsCycleSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(cycleSort.getSwapsCycleSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void cycleSortTwo(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Cycle Sort");

        // Create a CycleSort object
        CycleSort cycleSort = new CycleSort();

        // Sort the array using the cycle sort algorithm
        cycleSort.cycleSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = cycleSort.getTotalExecutionTimeCycleSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(cycleSort.getComparisonsCycleSort());
        lbComparisonsTwo.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(cycleSort.getSwapsCycleSort());
        lbArraySwapsTwo.setText(swaps);
    }

    public void gnomeSortOne(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Gnome Sort");

        // Create a GnomeSort object
        GnomeSort gnomeSort = new GnomeSort();

        // Sort the array using the gnome sort algorithm
        gnomeSort.gnomeSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = gnomeSort.getTotalExecutionTimeGnomeSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(gnomeSort.getComparisonsGnomeSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(gnomeSort.getSwapsGnomeSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void gnomeSortTwo(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Gnome Sort");

        // Create a GnomeSort object
        GnomeSort gnomeSort = new GnomeSort();

        // Sort the array using the gnome sort algorithm
        gnomeSort.gnomeSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = gnomeSort.getTotalExecutionTimeGnomeSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(gnomeSort.getComparisonsGnomeSort());
        lbComparisonsTwo.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(gnomeSort.getSwapsGnomeSort());
        lbArraySwapsTwo.setText(swaps);
    }

    public void heapSortOne(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Heap Sort");

        // Create a HeapSort object
        HeapSort heapSort = new HeapSort();

        // Sort the array using the heap sort algorithm
        heapSort.heapSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = heapSort.getTotalExecutionTimeHeapSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(heapSort.getComparisonsHeapSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(heapSort.getSwapsHeapSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void heapSortTwo(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Heap Sort");

        // Create a HeapSort object
        HeapSort heapSort = new HeapSort();

        // Sort the array using the heap sort algorithm
        heapSort.heapSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = heapSort.getTotalExecutionTimeHeapSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(heapSort.getComparisonsHeapSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(heapSort.getSwapsHeapSort());
        lbArraySwapsTwo.setText(swaps);
    }

    public void insertionSortOne(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Insertion Sort");

        //Create an InsertionSort Object
        InsertionSort insertionSort = new InsertionSort();

        // Sort the array using the insertion sort algorithm
        insertionSort.insertionSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = insertionSort.getTotalExecutionTimeInsertionSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(insertionSort.getComparisonsInsertionSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(insertionSort.getSwapsInsertionSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void insertionSortTwo(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Insertion Sort");

        //Create an InsertionSort Object
        InsertionSort insertionSort = new InsertionSort();

        // Sort the array using the insertion sort algorithm
        insertionSort.insertionSort(randomArray);

        // Get the execution time and store it in the totalExecutionTimeTwo variable
        executionTime = insertionSort.getTotalExecutionTimeInsertionSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(insertionSort.getComparisonsInsertionSort());
        lbComparisonsTwo.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(insertionSort.getSwapsInsertionSort());
        lbArraySwapsTwo.setText(swaps);
    }

    public void oddEvenSortOne(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Odd/Even Sort");

        //Create an OddEvenSort Object
        OddEvenSort oddEvenSort = new OddEvenSort();

        // Sort the array using the odd-even sort algorithm
        oddEvenSort.oddEvenSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = oddEvenSort.getTotalExecutionTimeOddEvenSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(oddEvenSort.getComparisonsOddEvenSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(oddEvenSort.getSwapsOddEvenSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void oddEvenSortTwo(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Odd/Even Sort");

        //Create an OddEvenSort Object
        OddEvenSort oddEvenSort = new OddEvenSort();

        // Sort the array using the odd-even sort algorithm
        oddEvenSort.oddEvenSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = oddEvenSort.getTotalExecutionTimeOddEvenSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(oddEvenSort.getComparisonsOddEvenSort());
        lbComparisonsTwo.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(oddEvenSort.getSwapsOddEvenSort());
        lbArraySwapsTwo.setText(swaps);
    }

    public void quickSortOne(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Quick Sort");

        //Create a QuickSort Object
        QuickSort quickSort = new QuickSort();

        // Sort the array using the quick sort algorithm
        quickSort.quickSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = quickSort.getTotalExecutionTimeQuickSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(quickSort.getComparisonsQuickSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(quickSort.getSwapsQuickSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void quickSortTwo(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Quick Sort");

        //Create a QuickSort Object
        QuickSort quickSort = new QuickSort();

        // Sort the array using the quick sort algorithm
        quickSort.quickSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = quickSort.getTotalExecutionTimeQuickSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(quickSort.getComparisonsQuickSort());
        lbComparisonsTwo.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(quickSort.getSwapsQuickSort());
        lbArraySwapsTwo.setText(swaps);
    }

    public void selectionSortOne(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmOne.setText("Selection Sort");

        //Create a SelectionSort Object
        SelectionSort selectionSort = new SelectionSort();

        // Sort the array using the selection sort algorithm
        selectionSort.selectionSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = selectionSort.getTotalExecutionTimeSelectionSort();

        // Set the text for the execution time label
        lbExecutionTimeOne.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(selectionSort.getComparisonsSelectionSort());
        lbComparisonsOne.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(selectionSort.getSwapsSelectionSort());
        lbArraySwapsOne.setText(swaps);
    }
    public void selectionSortTwo(long executionTime, int[] randomArray){
        // Set the text for the selected algorithm label
        lBSelectedAlgorithmTwo.setText("Selection Sort");

        //Create a SelectionSort Object
        SelectionSort selectionSort = new SelectionSort();

        // Sort the array using the selection sort algorithm
        selectionSort.selectionSort(randomArray);

        // Get the execution time and store it in the executionTime variable
        executionTime = selectionSort.getTotalExecutionTimeSelectionSort();

        // Set the text for the execution time label
        lbExecutionTimeTwo.setText(df.format(executionTime / 1000000F) + " ms");

        // Set the text for the comparisons label
        String comparisons = String.valueOf(selectionSort.getComparisonsSelectionSort());
        lbComparisonsTwo.setText(comparisons);

        // Set the text for the swaps label
        String swaps = String.valueOf(selectionSort.getSwapsSelectionSort());
        lbArraySwapsTwo.setText(swaps);
    }

    /**
     * This method is called when the "Sort Arrays" button is clicked. It gets the selected sorting algorithms
     * and array size, creates 2 random arrays, sorts them using the selected algorithms, and displays the
     * execution time, number of comparisons, and number of swaps of both arrays.
     * Also it gets checked if the user selected two different sorting algorithms.
     */
    @FXML
    protected void onBtnSortArrayClick() {
        try {
            // Get the selected algorithms and array size from the combo boxes
            String selectedAlgorithmOne = cBSelectedAlgorithmOne.getValue().toString();
            String selectedAlgorithmTwo = cBSelectedAlgorithmTwo.getValue().toString();
            String selectedArraySize = cBArraySize.getValue().toString();

            // Making sure that the chosen algorithms are not the same
            if (selectedAlgorithmOne.equals(selectedAlgorithmTwo)) {
                // show an alert when the selected algorithms are identical
                Alerts.identicalAlgorithms();
                //Resets the choices and value from previous runs
                resetBoxes();

                return;
            }

            // Convert the selected array size to an integer
            int arraySize = switch (selectedArraySize) {
                case "Thousand" -> 1000;
                case "Ten thousand" -> 10000;
                case "Hundred thousand" -> 100000;
                default -> 0;
            };

            // Creation of a random array of the selected size
            CreateRandomArray createRandomArray = new CreateRandomArray(arraySize);
            int[] randomArray = createRandomArray.getRandomArray();

            // creation of two array copies to avoid altering the original array
            int[] randomArrayAlgorithmOne = randomArray.clone();
            int[] randomArrayAlgorithmTwo = randomArray.clone();

            // Initialize the total execution times for both algorithms
            long totalExecutionTimeOne = 0;
            long totalExecutionTimeTwo = 0;

            // Using a switch statement to sort the array using the first selected algorithm
            // to display the execution time, number of comparisons, and number of swaps

            switch (selectedAlgorithmOne) {
                case "BubbleSort" -> bubbleSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                case "CocktailSort" -> cocktailSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                case "CombSort" -> combSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                case "CycleSort" -> cycleSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                case "GnomeSort" -> gnomeSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                case "HeapSort" -> heapSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                case "OddEvenSort" -> oddEvenSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                case "InsertionSort" -> insertionSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                case "SelectionSort" -> selectionSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                case "QuickSort" -> quickSortOne(totalExecutionTimeOne, randomArrayAlgorithmOne);

                default -> {
                }
            }

            // Using a switch statement to sort the array using the second selected algorithm
            // to display the execution time, number of comparisons, and number of swaps
            switch (selectedAlgorithmTwo) {
                case "BubbleSort" -> bubbleSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                case "CocktailSort" -> cocktailSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                case "CombSort" -> combSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                case "CycleSort" -> cycleSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                case "GnomeSort" -> gnomeSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                case "HeapSort" -> heapSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                case "OddEvenSort" -> oddEvenSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                case "InsertionSort" -> insertionSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                case "SelectionSort" -> selectionSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                case "QuickSort" -> quickSortTwo(totalExecutionTimeTwo, randomArrayAlgorithmTwo);

                default -> {
                }
            }
        } catch (NullPointerException e) {
            Alerts.emptySelection();
        }
    }

    /**
     * This method is called when the "Full sorting algorithm list" button is clicked. It changes the scene to the first page.
     *
     * @param event the action event that triggered this method
     * @throws IOException if there is an error loading the FXML file for the second page
     */
    @FXML
    protected void onChangeToFirstScene(ActionEvent event) throws IOException {

        // Get the Stage and set it to the current window
        Stage switchToSceneOne;
        switchToSceneOne = (Stage) btnPage1.getScene().getWindow();

        // Load the FXML file for the second page and set it as the root node
        Parent root;
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("firstPage.fxml")));

        // Create a new Scene with the loaded FXML file as the root node
        Scene scene = new Scene(root);

        // Set the Scene for the Stage and show it
        switchToSceneOne.setScene(scene);
        switchToSceneOne.show();
    }


}
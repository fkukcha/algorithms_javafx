package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the insertion sort algorithm, and also measures
 * the execution time, total number of comparisons, and total
 * number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.1
 */
public class InsertionSort {

    /**
     * Represents the total execution time of the Insertion Sort algorithm.
     */
    private long totalExecutionTimeInsertionSort;

    /**
     * Represents the number of comparisons made during the Insertion Sort algorithm.
     */
    private long comparisonsInsertionSort;

    /**
     * Represents the number of swaps made during the Insertion Sort algorithm.
     */
    private long swapsInsertionSort;


    /**
     * Returns the total execution time of the Insertion Sort algorithm.
     *
     * @return the total execution time of the Insertion Sort algorithm
     */
    public long getTotalExecutionTimeInsertionSort() {
        return totalExecutionTimeInsertionSort;
    }

    /**
     * Returns the number of comparisons made during the Insertion Sort algorithm.
     *
     * @return the number of comparisons made during the Insertion Sort algorithm
     */
    public long getComparisonsInsertionSort() {
        return comparisonsInsertionSort;
    }

    /**
     * Returns the number of swaps made during the Insertion Sort algorithm.
     *
     * @return the number of swaps made during the Insertion Sort algorithm
     */
    public long getSwapsInsertionSort() {
        return swapsInsertionSort;
    }

    /**
     * Sorts an array using the insertion sort algorithm and prints out the execution time,
     * number of comparisons, and number of swaps.
     *
     * @param inputArray the array to sort
     */
    public void insertionSort(int[] inputArray) {

        // Get the current time in nanoseconds
        long startTime = System.nanoTime();

        // Get the length of the array.
        int arrayLength = inputArray.length;

        // Iterate through the array, starting at the second element.
        for (int i = 1; i < arrayLength; i++) {

            // Save the value of the current element as the key.
            int key = inputArray[i];

            // Initialize a counter to the index of the element before the current element.
            int j = i - 1;

            /* Move elements of inputArray[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && inputArray[j] > key) {

                // Shift the element one position to the right.
                inputArray[j + 1] = inputArray[j];

                // Decrement the counter.
                j = j - 1;

                this.swapsInsertionSort++;

                this.comparisonsInsertionSort++;
            }

            // Insert the key into its proper position.
            inputArray[j + 1] = key;

            this.comparisonsInsertionSort++;
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();

        this.totalExecutionTimeInsertionSort = endTime - startTime;
    }
}
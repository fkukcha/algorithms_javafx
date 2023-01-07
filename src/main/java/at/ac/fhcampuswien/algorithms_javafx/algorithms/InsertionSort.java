package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the insertion sort algorithm, and also measures
 * the execution time, total number of comparisons, and total
 * number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class InsertionSort {

    /**
     * Represents the total execution time of the Insertion Sort algorithm.
     */
    private long totalExecutionTimeInsertionSort;

    /**
     * Sets the total execution time of the Insertion Sort algorithm.
     *
     * @param totalExecutionTime the total execution time of the Insertion Sort algorithm
     */
    public void setTotalExecutionTimeInsertionSort(long totalExecutionTime) {
        this.totalExecutionTimeInsertionSort = totalExecutionTime;
    }

    /**
     * Returns the total execution time of the Insertion Sort algorithm.
     *
     * @return the total execution time of the Insertion Sort algorithm
     */
    public long getTotalExecutionTimeInsertionSort() {
        return totalExecutionTimeInsertionSort;
    }


    /**
     * Represents the number of comparisons made during the Insertion Sort algorithm.
     */
    private int comparisonsInsertionSort;

    /**
     * Sets the number of comparisons made during the Insertion Sort algorithm.
     *
     * @param comparisons the number of comparisons made during the Insertion Sort algorithm
     */
    public void setComparisonsInsertionSort(int comparisons) {
        this.comparisonsInsertionSort = comparisons;
    }

    /**
     * Returns the number of comparisons made during the Insertion Sort algorithm.
     *
     * @return the number of comparisons made during the Insertion Sort algorithm
     */
    public int getComparisonsInsertionSort() {
        return comparisonsInsertionSort;
    }


    /**
     * Represents the number of swaps made during the Insertion Sort algorithm.
     */
    private int swapsInsertionSort;

    /**
     * Sets the number of swaps made during the Insertion Sort algorithm.
     *
     * @param swaps the number of swaps made during the Insertion Sort algorithm
     */
    public void setSwapsInsertionSort(int swaps) {
        this.swapsInsertionSort = swaps;
    }

    /**
     * Returns the number of swaps made during the Insertion Sort algorithm.
     *
     * @return the number of swaps made during the Insertion Sort algorithm
     */
    public int getSwapsInsertionSort() {
        return swapsInsertionSort;
    }

    public void insertionSort(int[] inputArray) {

        // Get the length of the array.
        int arrayLength = inputArray.length;

        // Start the timer
        long startTime = System.nanoTime();

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

                // Increment the counter for the number of swaps made in the Insertion Sort algorithm.
                setSwapsInsertionSort(getSwapsInsertionSort()+1);

                // Increment the counter for the number of comparisons made in the Insertion Sort algorithm.
                setComparisonsInsertionSort(getComparisonsInsertionSort()+1);
            }

            // Insert the key into its proper position.
            inputArray[j + 1] = key;

            // Increment the counter for the number of comparisons made in the Insertion Sort algorithm.
            setComparisonsInsertionSort(getComparisonsInsertionSort()+1);
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeInsertionSort(executionTime);
    }
}
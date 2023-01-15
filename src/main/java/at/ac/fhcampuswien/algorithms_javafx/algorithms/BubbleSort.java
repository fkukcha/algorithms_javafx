package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the bubble sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */

public class BubbleSort {
    /**
     * The total execution time of the bubble sort algorithm, in nanoseconds.
     */
    private long totalExecutionTimeBubbleSort;

    /**
     * Sets the total execution time of the bubble sort algorithm.
     * @param totalExecutionTime the total execution time, in nanoseconds
     */
    public void setTotalExecutionTimeBubbleSort(long totalExecutionTime) {
        this.totalExecutionTimeBubbleSort = totalExecutionTime;
    }

    /**
     * Gets the total execution time of the bubble sort algorithm.
     * @return the total execution time, in nanoseconds
     */
    public long getTotalExecutionTimeBubbleSort() {
        return totalExecutionTimeBubbleSort;
    }

    /**
     * The total comparisons of the bubble sort algorithm.
     */
    private long comparisonsBubbleSort;

    /**
     * Sets the number of comparisons made by the bubble sort algorithm.
     *
     * @param comparisons the number of comparisons
     */
    public void setComparisonsBubbleSort(long comparisons) {
        this.comparisonsBubbleSort = comparisons;
    }

    /**
     * Gets the number of comparisons made by the bubble sort algorithm.
     *
     * @return the number of comparisons
     */
    public long getComparisonsBubbleSort() {
        return comparisonsBubbleSort;
    }

    /**
     * The number of swaps made by the bubble sort algorithm.
     */
    private long swapsBubbleSort;

    /**
     * Sets the number of swaps made by the bubble sort algorithm.
     *
     * @param swaps the number of swaps
     */
    public void setSwapsBubbleSort(long swaps) {
        this.swapsBubbleSort = swaps;
    }

    /**
     * Gets the number of swaps made by the bubble sort algorithm.
     *
     * @return the number of swaps
     */
    public long getSwapsBubbleSort() {
        return swapsBubbleSort;
    }

    /**
     * Sorts the specified array using the bubble sort algorithm.
     *
     * @param  inputArray the array to be sorted
     */
    public void bubbleSort(int[] inputArray) {

        // record start time
        long startTime = System.nanoTime();

        // perform bubble sort
        for (int i = 0; i < inputArray.length - 1; i++) {

            // Iterate through the array, comparing pairs of elements
            for (int j = 0; j < inputArray.length - i - 1; j++) {

                // Increment the comparison count
                setComparisonsBubbleSort(getComparisonsBubbleSort()+1);

                // If the current element is greater than the next element, swap them
                if (inputArray[j] > inputArray[j + 1]) {
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;

                    // Increment the swap count
                    setSwapsBubbleSort(getSwapsBubbleSort()+1);
                }
            }
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeBubbleSort(executionTime);
    }
}
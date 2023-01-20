package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the selection sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.1
 */
public class SelectionSort {

    /**
     * Represents the total execution time of the Selection Sort algorithm.
     */
    private long totalExecutionTimeSelectionSort;

    /**
     * Represents the number of comparisons made during the Selection Sort algorithm.
     */
    private long comparisonsSelectionSort;

    /**
     * Represents the number of swaps made during the Selection Sort algorithm.
     */
    private long swapsSelectionSort;

    /**
     * Returns the total execution time of the Selection Sort algorithm.
     *
     * @return  the total execution time of the Selection Sort algorithm
     */
    public long getTotalExecutionTimeSelectionSort() {
        return totalExecutionTimeSelectionSort;
    }

    /**
     * Returns the number of comparisons made during the Selection Sort algorithm.
     *
     * @return the number of comparisons made during the Selection Sort algorithm
     */
    public long getComparisonsSelectionSort() {
        return comparisonsSelectionSort;
    }

    /**
     * Returns the number of swaps made during the Selection Sort algorithm.
     *
     * @return the number of swaps made during the Selection Sort algorithm
     */
    public long getSwapsSelectionSort() {
        return swapsSelectionSort;
    }

    /**
     * Sorts an array using the selection sort algorithm and prints out the execution time,
     * number of comparisons, and number of swaps.
     *
     * @param inputArray the array to sort
     */
    public void selectionSort(int[] inputArray) {

        // Get the current time in nanoseconds
        long startTime = System.nanoTime();

        // set the array length
        int arrayLength = inputArray.length;

        // Loop through the array, starting at the first element
        for (int i = 0; i < arrayLength - 1; i++) {

            // Assume that the current element is the minimum
            int minIndex = i;

            // Loop through the rest of the array, starting at the next element
            for (int j = i + 1; j < arrayLength; j++) {

                // If the current element is smaller than the assumed minimum, set it as the new minimum
                if (inputArray[j] < inputArray[minIndex]) {
                    minIndex = j;

                    this.comparisonsSelectionSort++;
                }
            }

            // Swap the found minimum element with the first element
            int temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = temp;

            this.swapsSelectionSort++;
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();

        this.totalExecutionTimeSelectionSort = endTime - startTime;
    }
}
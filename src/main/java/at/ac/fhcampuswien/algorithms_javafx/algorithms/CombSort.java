package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the comb sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.1
 */
public class CombSort {
    /**
     * The total execution time of the comb sort algorithm, in nanoseconds.
     */
    private long totalExecutionTimeCombSort;

    /**
     * The number of comparisons made by the comb sort algorithm.
     */
    private long comparisonsCombSort;

    /**
     * The number of swaps made by the comb sort algorithm.
     */
    private long swapsCombSort;

    /**
     * Gets the total execution time of the comb sort algorithm.
     *
     * @return the total execution time, in nanoseconds
     */
    public long getTotalExecutionTimeCombSort() {
        return totalExecutionTimeCombSort;
    }

    /**
     * Gets the number of comparisons made by the comb sort algorithm.
     *
     * @return the number of comparisons
     */
    public long getComparisonsCombSort() {
        return comparisonsCombSort;
    }

    /**
     * Gets the number of swaps made by the comb sort algorithm.
     *
     * @return the number of swaps
     */
    public long getSwapsCombSort() {
        return swapsCombSort;
    }

    /**
     * Sorts an array using the comb sort algorithm and prints out the execution time,
     * number of comparisons, and number of swaps.
     *
     * @param inputArray the array to sort
     */
    public void combSort(int[] inputArray) {

        // Get the current time in nanoseconds.
        long startTime = System.nanoTime();

        // get the length of the array
        int arrayLength = inputArray.length;

        // initialize gap size to the length of the array
        int gap = arrayLength;

        // flag to keep track of whether any swaps have been made
        boolean swapped = true;

        // loop until the array is sorted
        while (gap > 1 || swapped) {

            // update the gap value for the next comb
            gap = (int) (gap / 1.3);

            // if the gap size is less than 1, set it to 1 to ensure that all elements are compared
            if (gap < 1) {
                gap = 1;
            }

            // reset the swapped flag
            swapped = false;

            // loop through the array, comparing elements separated by the gap
            for (int i = 0; i + gap < arrayLength; i++) {

                // calculate the index of the element to compare
                int j = i + gap;

                // compare elements at i and j and swap if necessary
                if (inputArray[i] > inputArray[j]) {

                    //swap the elements
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[j];
                    inputArray[j] = temp;

                    //set the swapped flag to true
                    swapped = true;

                    this.swapsCombSort++;
                }

                this.comparisonsCombSort++;
            }
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();

        this.totalExecutionTimeCombSort = endTime - startTime;
    }
}
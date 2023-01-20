package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the cocktail sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.1
 */
public class CocktailSort {
    /**
     * The total execution time of the cocktail sort algorithm, in nanoseconds.
     */
    private long totalExecutionTimeCocktailSort;

    /**
     * The number of comparisons made by the cocktail sort algorithm.
     */
    private long comparisonsCocktailSort;

    /**
     * The number of swaps made by the cocktail sort algorithm.
     */
    private long swapsCocktailSort;


    /**
     * Returns the total execution time for the Cocktail Sort algorithm.
     *
     * @return the total execution time, in nanoseconds
     */
    public long getTotalExecutionTimeCocktailSort() {
        return totalExecutionTimeCocktailSort;
    }

    /**
     * Returns the number of comparisons performed during the Cocktail Sort algorithm.
     *
     * @return the number of comparisons
     */
    public long getComparisonsCocktailSort() {
        return comparisonsCocktailSort;
    }

    /**
     * Returns the number of swaps performed during the Cocktail Sort algorithm.
     *
     * @return the number of swaps
     */
    public long getSwapsCocktailSort() {
        return swapsCocktailSort;
    }

    /**
     * Sorts an array using the cocktail sort algorithm, and also measures the
     * execution time, total number of comparisons, and total number of swaps.
     *
     * @param inputArray The array to be sorted.
     */
    public void cocktailSort(int[] inputArray) {

        // Get the current time in nanoseconds.
        long startTime = System.nanoTime();

        // Initialize a flag to track whether the array is sorted or not.
        // Initially, we assume that the array is not sorted.
        boolean isSorted = false;

        //Initialize variables "start" and "end" to 0 and the length of the input array
        int start = 0;
        int end = inputArray.length;

        // The sorting process will continue until the array is sorted (i.e., "isSorted" is true).
        while (!isSorted) {

            // Set "isSorted" to true, as we assume the array is sorted until proven otherwise.
            isSorted = true;

            // Loop through the array from index "start" to index "end - 1".
            for (int i = start; i < end - 1; i++) {

                // Increment the counter for the number of comparisons made in the Cocktail Sort algorithm.
                this.comparisonsCocktailSort++;

                if (inputArray[i] > inputArray[i + 1]) {

                    this.swapsCocktailSort++;

                    //Swap the elements and set "isSorted" to false indicating that the array is not yet sorted
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    isSorted = false;
                }
            }

            //if the array is already sorted we can exit the loop
            if (isSorted) {
                break;
            }

            // Set "isSorted" to true, as we assume the array is sorted until proven otherwise.
            isSorted = true;

            // Decrement "end" to exclude the last element, which is now in its correct position.
            end--;

            // Loop through the array from index "end - 1" down to index "start".
            for (int i = end - 1; i >= start; i--) {

                this.comparisonsCocktailSort++;

                if (inputArray[i] > inputArray[i + 1]) {

                    this.swapsCocktailSort++;

                    //Swap the elements and set "isSorted" to false indicating that the array is not yet sorted
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    isSorted = false;
                }
            }

            // Increment "start" to exclude the first element, which is now in its correct position.
            start++;
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();

        this.totalExecutionTimeCocktailSort = endTime - startTime;
    }
}
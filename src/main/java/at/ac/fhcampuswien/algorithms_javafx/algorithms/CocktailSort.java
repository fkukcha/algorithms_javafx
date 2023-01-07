package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the cocktail sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class CocktailSort {

    /**
     * The total execution time of the cocktail sort algorithm, in milliseconds.
     */
    private long totalExecutionTimeCocktailSort;

    /**
     * Sets the total execution time for the Cocktail Sort algorithm.
     *
     * @param totalExecutionTime the total execution time, in milliseconds
     */
    public void setTotalExecutionTimeCocktailSort(long totalExecutionTime) {
        this.totalExecutionTimeCocktailSort = totalExecutionTime;
    }

    /**
     * Returns the total execution time for the Cocktail Sort algorithm.
     *
     * @return the total execution time, in milliseconds
     */
    public long getTotalExecutionTimeCocktailSort() {
        return totalExecutionTimeCocktailSort;
    }

    /**
     * The number of comparisons made by the cocktail sort algorithm.
     */
    private long comparisonsCocktailSort;

    /**
     * Sets the number of comparisons performed during the Cocktail Sort algorithm.
     *
     * @param comparisons the number of comparisons
     */
    public void setComparisonsCocktailSort(long comparisons) {
        this.comparisonsCocktailSort = comparisons;
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
     * The number of swaps made by the cocktail sort algorithm.
     */
    private long swapsCocktailSort;

    /**
     * Sets the number of swaps performed during the Cocktail Sort algorithm.
     *
     * @param swaps the number of swaps
     */
    public void setSwapsCocktailSort(long swaps) {
        this.swapsCocktailSort = swaps;
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

        // Perform cocktail sort

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
                setComparisonsCocktailSort(getComparisonsCocktailSort()+1);


                if (inputArray[i] > inputArray[i + 1]) {

                    //Increment the counter for the number of swaps made in the Cocktail Sort Algorithm
                    setSwapsCocktailSort(getSwapsCocktailSort()+1);

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

                // Increment the counter for the number of comparisons made in the Cocktail Sort algorithm.
                setComparisonsCocktailSort(getComparisonsCocktailSort()+1);


                if (inputArray[i] > inputArray[i + 1]) {

                    //Increment the counter for the number of swaps made in the Cocktail Sort Algorithm
                    setSwapsCocktailSort(getSwapsCocktailSort()+1);

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
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeCocktailSort(executionTime);
    }
}
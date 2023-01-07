package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the quick sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class QuickSort {

    /**
     * Represents the total execution time of the Quick Sort algorithm.
     */
    private long totalExecutionTimeQuickSort;

    /**
     * Sets the total execution time of the Quick Sort algorithm.
     *
     * @param totalExecutionTime the total execution time of the Quick Sort algorithm
     */
    public void setTotalExecutionTimeQuickSort(long totalExecutionTime) {
        this.totalExecutionTimeQuickSort = totalExecutionTime;
    }

    /**
     * Returns the total execution time of the Quick Sort algorithm.
     *
     * @return the total execution time of the Quick Sort algorithm
     */
    public long getTotalExecutionTimeQuickSort() {
        return totalExecutionTimeQuickSort;
    }


    /**
     * Represents the number of comparisons made during the Quick Sort algorithm.
     */
    private int comparisonsQuickSort;

    /**
     * Sets the number of comparisons made during the Quick Sort algorithm.
     *
     * @param comparisons the number of comparisons made during the Quick Sort algorithm
     */
    public void setComparisonsQuickSort(int comparisons) {
        this.comparisonsQuickSort = comparisons;
    }

    /**
     * Returns the number of comparisons made during the Quick Sort algorithm.
     *
     * @return the number of comparisons made during the Quick Sort algorithm
     */
    public int getComparisonsQuickSort() {
        return comparisonsQuickSort;
    }


    /**
     * Represents the number of swaps made during the Quick Sort algorithm.
     */
    private int swapsQuickSort;

    /**
     * Sets the number of swaps made during the Quick Sort algorithm.
     *
     * @param swaps the number of swaps made during the Quick Sort algorithm
     */
    public void setSwapsQuickSort(int swaps) {
        this.swapsQuickSort = swaps;
    }

    /**
     * Returns the number of swaps made during the Quick Sort algorithm.
     *
     * @return the number of swaps made during the Quick Sort algorithm
     */
    public int getSwapsQuickSort() {
        return swapsQuickSort;
    }


    /**
     * Sorts an array using the quick sort algorithm and prints out the execution time,
     * number of comparisons, and number of swaps.
     *
     * @param inputArray the array to sort
     */
    public void quickSort(int[] inputArray) {

        //Set the length of the array
        int arrayLength = inputArray.length;

        // Start the timer
        long startTime = System.nanoTime();

        //Call the quickSortHelperMethod to sort the array
        quickSortHelperMethod(inputArray, 0, arrayLength - 1);

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeQuickSort(executionTime);
    }


    /**
     * Helper method for the QuickSort algorithm that sorts the elements of the array between
     * the low and high indices (inclusive).
     *
     * @param array the array to sort
     * @param low the low index
     * @param high the high index
     */
    private void quickSortHelperMethod(int[] array, int low, int high) {

        // If the low index is less than the high index, there is at least one element in the partition
        if (low < high) {

            /* pi is partitioning index, array[pi] is
              now at right place */
            int pi = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSortHelperMethod(array, low, pi - 1);
            quickSortHelperMethod(array, pi + 1, high);
        }
    }

    /**
     * Helper method for the QuickSort algorithm that partition the elements of the array between
     * the low and high indices (inclusive) around the pivot element.
     *
     * @param array the array to sort
     * @param low the low index
     * @param high the high index
     * @return the partition index
     */
    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choose the pivot element as the last element in the partition
        int i = low - 1; // index of smaller element

        // Iterate through the partition and find the smaller elements
        for (int j = low; j < high; j++) {

            // If the current element is smaller than or equal to the pivot, swap it with the element at index i+1
            if (array[j] <= pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                // Increment the number of swaps
                setSwapsQuickSort(getSwapsQuickSort()+1);

                // Increment the number of comparisons
                setComparisonsQuickSort(getComparisonsQuickSort()+1);
            }

            // Increment the number of comparisons
            setComparisonsQuickSort(getComparisonsQuickSort()+1);
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Increment the number of swaps
        setSwapsQuickSort(getSwapsQuickSort()+1);

        //Return partition index
        return i + 1;
    }
}
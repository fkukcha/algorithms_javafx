package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the selection sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class SelectionSort {


    /**
     * Represents the total execution time of the Selection Sort algorithm.
     */
    private long totalExecutionTimeSelectionSort;

    /**
     * Sets the total execution time of the Selection Sort algorithm.
     *
     * @param totalExecutionTime the total execution time of the Selection Sort algorithm
     */
    public void setTotalExecutionTimeSelectionSort(long totalExecutionTime) {
        this.totalExecutionTimeSelectionSort = totalExecutionTime;
    }

    /**
     * Returns the total execution time of the Selection Sort algorithm.
     *
     * @return  the total execution time of the Selection Sort algorithm
     */
    public long getTotalExecutionTimeSelectionSort() {
        return totalExecutionTimeSelectionSort;
    }


    /**
     * Represents the number of comparisons made during the Selection Sort algorithm.
     */
    private int comparisonsSelectionSort;

    /**
     * Sets the number of comparisons made during the Selection Sort algorithm.
     *
     * @param comparisons the number of comparisons made during the Selection Sort algorithm
     */
    public void setComparisonsSelectionSort(int comparisons) {
        this.comparisonsSelectionSort = comparisons;
    }

    /**
     * Returns the number of comparisons made during the Selection Sort algorithm.
     *
     * @return the number of comparisons made during the Selection Sort algorithm
     */
    public int getComparisonsSelectionSort() {
        return comparisonsSelectionSort;
    }


    /**
     * Represents the number of swaps made during the Selection Sort algorithm.
     */
    private int swapsSelectionSort;

    /**
     * Sets the number of swaps made during the Selection Sort algorithm.
     *
     * @param swaps the number of comparisons made during the Selection Sort algorithm
     */
    public void setSwapsSelectionSort(int swaps) {
        this.swapsSelectionSort = swaps;
    }

    /**
     * Returns the number of swaps made during the Selection Sort algorithm.
     *
     * @return the number of swaps made during the Selection Sort algorithm
     */
    public int getSwapsSelectionSort() {
        return swapsSelectionSort;
    }


    public void selectionSort(int[] inputArray) {
        int arrayLength = inputArray.length;

        // Start the timer
        long startTime = System.nanoTime();

        // Loop through the array, starting at the first element
        for (int i = 0; i < arrayLength - 1; i++) {

            // Assume that the current element is the minimum
            int minIndex = i;

            // Loop through the rest of the array, starting at the next element
            for (int j = i + 1; j < arrayLength; j++) {

                // If the current element is smaller than the assumed minimum, set it as the new minimum
                if (inputArray[j] < inputArray[minIndex]) {
                    minIndex = j;

                    //Increment the number of comparisons made by the Selection Sort
                    setComparisonsSelectionSort(getComparisonsSelectionSort()+1);
                }
            }

            // Swap the found minimum element with the first element
            int temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = temp;

            //Increment the number of swaps
            setSwapsSelectionSort(getSwapsSelectionSort()+1);
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeSelectionSort(executionTime);
    }
}
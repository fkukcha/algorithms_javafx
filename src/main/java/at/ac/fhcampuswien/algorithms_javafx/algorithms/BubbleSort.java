package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the bubble sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */

public class BubbleSort {
    private long totalExecutionTimeBubbleSort;
    public void setTotalExecutionTimeBubbleSort(long totalExecutionTime) {
        this.totalExecutionTimeBubbleSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeBubbleSort() {
        return totalExecutionTimeBubbleSort;
    }

    private int comparisonsBubbleSort;
    public void setComparisonsBubbleSort(int comparisons) {
        this.comparisonsBubbleSort = comparisons;
    }
    public int getComparisonsBubbleSort() {
        return comparisonsBubbleSort;
    }

    private int swapsBubbleSort;
    public void setSwapsBubbleSort(int swaps) {
        this.swapsBubbleSort = swaps;
    }
    public int getSwapsBubbleSort() {
        return swapsBubbleSort;
    }


    /**
     * Sorts the specified array using the bubble sort algorithm.
     *
     * @param  inputArray the array to be sorted
     */
    public void bubbleSort(int[] inputArray) {

        long startTime = System.nanoTime();  // record start time

        // perform bubble sort
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = 0; j < inputArray.length - i - 1; j++) {
                setComparisonsBubbleSort(getComparisonsBubbleSort()+1);  // increment comparison count
                if (inputArray[j] > inputArray[j + 1]) {
                    // swap elements if necessary
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                    setSwapsBubbleSort(getSwapsBubbleSort()+1);  // increment swap count
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
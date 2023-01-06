package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the comb sort algorithm, and also measures
 * the execution time total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class CombSort {

    private long totalExecutionTimeCombSort;
    public void setTotalExecutionTimeCombSort(long totalExecutionTime) {
        this.totalExecutionTimeCombSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeCombSort() {
        return totalExecutionTimeCombSort;
    }

    private long comparisonsCombSort = 0;
    public void setComparisonsCombSort(long comparisons) {
        this.comparisonsCombSort = comparisons;
    }
    public long getComparisonsCombSort() {
        return comparisonsCombSort;
    }

    private long swapsCombSort = 0;
    public void setSwapsCombSort(long swaps) {
        this.swapsCombSort = swaps;
    }
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

        long startTime = System.nanoTime();  // start timer

        int n = inputArray.length;
        int gap = n;  // initialize gap size
        boolean swapped = true;

        // loop until the array is sorted
        while (gap > 1 || swapped) {
            // update the gap value for the next comb
            gap = (int) (gap / 1.3);
            if (gap < 1) {
                gap = 1;
            }

            swapped = false;
            for (int i = 0; i + gap < n; i++) {
                int j = i + gap;
                // compare elements at i and j and swap if necessary
                if (inputArray[i] > inputArray[j]) {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[j];
                    inputArray[j] = temp;
                    swapped = true;
                    setSwapsCombSort(getSwapsCombSort()+1);
                }
                setComparisonsCombSort(getComparisonsCombSort()+1);
            }
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeCombSort(executionTime);
    }
}
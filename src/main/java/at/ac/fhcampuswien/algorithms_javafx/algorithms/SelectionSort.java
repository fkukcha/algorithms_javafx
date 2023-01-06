package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the selection sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class SelectionSort {

    private long totalExecutionTimeSelectionSort;
    public void setTotalExecutionTimeSelectionSort(long totalExecutionTime) {
        this.totalExecutionTimeSelectionSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeSelectionSort() {
        return totalExecutionTimeSelectionSort;
    }

    private int comparisonsSelectionSort;
    public void setComparisonsSelectionSort(int comparisons) {
        this.comparisonsSelectionSort = comparisons;
    }
    public int getComparisonsSelectionSort() {
        return comparisonsSelectionSort;
    }

    private int swapsSelectionSort;
    public void setSwapsSelectionSort(int swaps) {
        this.swapsSelectionSort = swaps;
    }
    public int getSwapsSelectionSort() {
        return swapsSelectionSort;
    }

    public void selectionSort(int[] inputArray) {
        int arrayLength = inputArray.length;

        // Start the timer
        long startTime = System.nanoTime();

        for (int i = 0; i < arrayLength - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayLength; j++) {
                if (inputArray[j] < inputArray[minIndex]) {
                    minIndex = j;
                    setComparisonsSelectionSort(getComparisonsSelectionSort()+1);
                }
            }

            // Swap the found minimum element with the first element
            int temp = inputArray[minIndex];
            inputArray[minIndex] = inputArray[i];
            inputArray[i] = temp;
            setSwapsSelectionSort(getSwapsSelectionSort()+1);
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeSelectionSort(executionTime);
    }
}
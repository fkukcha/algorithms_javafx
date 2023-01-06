package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the insertion sort algorithm, and also measures
 * the execution time, total number of comparisons, and total
 * number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class InsertionSort {

    private long totalExecutionTimeInsertionSort;
    public void setTotalExecutionTimeInsertionSort(long totalExecutionTime) {
        this.totalExecutionTimeInsertionSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeInsertionSort() {
        return totalExecutionTimeInsertionSort;
    }

    private int comparisonsInsertionSort;
    public void setComparisonsInsertionSort(int comparisons) {
        this.comparisonsInsertionSort = comparisons;
    }
    public int getComparisonsInsertionSort() {
        return comparisonsInsertionSort;
    }

    private int swapsInsertionSort;
    public void setSwapsInsertionSort(int swaps) {
        this.swapsInsertionSort = swaps;
    }
    public int getSwapsInsertionSort() {
        return swapsInsertionSort;
    }

    public void insertionSort(int[] inputArray) {
        int arrayLength = inputArray.length;

        // Start the timer
        long startTime = System.nanoTime();

        for (int i = 1; i < arrayLength; i++) {
            int key = inputArray[i];
            int j = i - 1;

            /* Move elements of inputArray[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && inputArray[j] > key) {
                inputArray[j + 1] = inputArray[j];
                j = j - 1;
                setSwapsInsertionSort(getSwapsInsertionSort()+1);
                setComparisonsInsertionSort(getComparisonsInsertionSort()+1);
            }
            inputArray[j + 1] = key;
            setComparisonsInsertionSort(getComparisonsInsertionSort()+1);
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeInsertionSort(executionTime);
    }
}
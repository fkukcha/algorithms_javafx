package at.ac.fhcampuswien.algorithms_javafx.algorithms;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * A class that sorts an array using the cycle sort algorithm, and also measures
 * the execution time, memory consumption, total number of comparisons, and total
 * number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class CycleSort {

    private long totalExecutionTimeCycleSort;
    public void setTotalExecutionTimeCycleSort(long totalExecutionTime) {
        this.totalExecutionTimeCycleSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeCycleSort() {
        return totalExecutionTimeCycleSort;
    }


    private long comparisonsCycleSort;
    public void setComparisonsCycleSort(long comparisons) {
        this.comparisonsCycleSort = comparisons;
    }
    public long getComparisonsCycleSort() {
        return comparisonsCycleSort;
    }

    private long swapsCycleSort;
    public void setSwapsCycleSort(long swaps) {
        this.swapsCycleSort = swaps;
    }
    public long getSwapsCycleSort() {
        return swapsCycleSort;
    }

    /**
     * Sorts an array using the cycle sort algorithm and prints out the execution time,
     * memory consumption, number of comparisons, and number of swaps.
     *
     * @param inputArray the array to sort
     */
    public void cycleSort(int[] inputArray) {


        long startTime = System.nanoTime();  // start timer

        int arrayLength = inputArray.length;


        // loop through the array
        for (int cycleStart = 0; cycleStart < arrayLength - 1; cycleStart++) {
            int item = inputArray[cycleStart];

            // find the position where the item belongs
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < arrayLength; i++) {
                if (inputArray[i] < item) {
                    pos++;
                }
                setComparisonsCycleSort(getComparisonsCycleSort()+1);
            }

            // if the item is already in the correct position, move on to the next item
            if (pos == cycleStart) {
                continue;
            }

            // put the item into the correct position
            while (item == inputArray[pos]) {
                pos++;
            }
            int temp = item;
            item = inputArray[pos];
            inputArray[pos] = temp;
            setSwapsCycleSort(getSwapsCycleSort()+1);

            // rotate the rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < arrayLength; i++) {
                    if (inputArray[i] < item) {
                        pos++;
                    }
                }
                while (item == inputArray[pos]) {
                    pos++;
                }
                temp = item;
                item = inputArray[pos];
                inputArray[pos] = temp;
                setSwapsCycleSort(getSwapsCycleSort()+1);
            }
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;


        // set execution time, comparison count, swap count, and memory consumption
        setTotalExecutionTimeCycleSort(executionTime);
    }

}
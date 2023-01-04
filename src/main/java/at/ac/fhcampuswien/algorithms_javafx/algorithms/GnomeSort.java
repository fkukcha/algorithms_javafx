package at.ac.fhcampuswien.algorithms_javafx.algorithms;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;


/**
 * A class that sorts an array using the gnome sort algorithm, and also measures
 * the execution time, memory consumption, total number of comparisons, and total
 * number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class GnomeSort {

    private long totalExecutionTimeGnomeSort;
    public void setTotalExecutionTimeGnomeSort(long totalExecutionTime) {
        this.totalExecutionTimeGnomeSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeGnomeSort() {
        return totalExecutionTimeGnomeSort;
    }

    private long comparisonsGnomeSort;
    public void setComparisonsGnomeSort(long comparisons) {
        this.comparisonsGnomeSort = comparisons;
    }
    public long getComparisonsGnomeSort() {
        return comparisonsGnomeSort;
    }

    private long swapsGnomeSort;
    public void setSwapsGnomeSort(long swaps) {
        this.swapsGnomeSort = swaps;
    }
    public long getSwapsGnomeSort() {
        return swapsGnomeSort;
    }

    /**
     * Sorts an array using the gnome sort algorithm and prints out the execution time,
     * memory consumption, number of comparisons, and number of swaps.
     *
     * @param inputArray the array to sort
     */
    public void gnomeSort(int[] inputArray) {

        long startTime = System.nanoTime();  // start timer

        int index = 0;

        // While the index is less than the length of the array
        while (index < inputArray.length) {
            // If the index is zero or the element at the index is greater
            // than or equal to the element at the previous index, move to the
            // next index
            if (index == 0 || inputArray[index] >= inputArray[index - 1]) {
                index++;
            }
            // If the element at the index is less than the element at the
            // previous index, swap the elements and move the index back by one
            else {
                int temp = inputArray[index];
                inputArray[index] = inputArray[index - 1];
                inputArray[index - 1] = temp;

                // Increment the number of swaps
                setSwapsGnomeSort(getSwapsGnomeSort()+1);

                index--;
            }

            // Increment the number of comparisons
            setComparisonsGnomeSort(getComparisonsGnomeSort()+1);
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;


        // set execution time, comparison count, swap count, and memory consumption
        setTotalExecutionTimeGnomeSort(executionTime);
    }
}
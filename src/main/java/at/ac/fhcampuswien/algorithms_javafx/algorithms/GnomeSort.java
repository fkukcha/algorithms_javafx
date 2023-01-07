package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the gnome sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class GnomeSort {

    /**
     * Represents the total execution time of the Gnome Sort algorithm.
     */
    private long totalExecutionTimeGnomeSort;

    /**
     * Sets the total execution time of the Gnome Sort algorithm.
     *
     * @param totalExecutionTime the total execution time of the Gnome Sort algorithm
     */
    public void setTotalExecutionTimeGnomeSort(long totalExecutionTime) {
        this.totalExecutionTimeGnomeSort = totalExecutionTime;
    }

    /**
     * Returns the total execution time of the Gnome Sort algorithm.
     *
     * @return the total execution time of the Gnome Sort algorithm
     */
    public long getTotalExecutionTimeGnomeSort() {
        return totalExecutionTimeGnomeSort;
    }

    /**
     * Represents the number of comparisons made during the Gnome Sort algorithm.
     */
    private long comparisonsGnomeSort;

    /**
     * Sets the number of comparisons made during the Gnome Sort algorithm.
     *
     * @param comparisons the number of comparisons made during the Gnome Sort algorithm
     */
    public void setComparisonsGnomeSort(long comparisons) {
        this.comparisonsGnomeSort = comparisons;
    }

    /**
     * Returns the number of comparisons made during the Gnome Sort algorithm.
     *
     * @return the number of comparisons made during the Gnome Sort algorithm
     */
    public long getComparisonsGnomeSort() {
        return comparisonsGnomeSort;
    }

    /**
     * Represents the number of swaps made during the Gnome Sort algorithm.
     */
    private long swapsGnomeSort;

    /**
     * Sets the number of swaps made during the Gnome Sort algorithm.
     *
     * @param swaps the number of swaps made during the Gnome Sort algorithm
     */
    public void setSwapsGnomeSort(long swaps) {
        this.swapsGnomeSort = swaps;
    }

    /**
     * Returns the number of swaps made during the Gnome Sort algorithm.
     *
     * @return the number of swaps made during the Gnome Sort algorithm
     */
    public long getSwapsGnomeSort() {
        return swapsGnomeSort;
    }

    /**
     * Sorts an array using the gnome sort algorithm and prints out the execution time,
     * number of comparisons, and number of swaps.
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


        // set execution time
        setTotalExecutionTimeGnomeSort(executionTime);
    }
}
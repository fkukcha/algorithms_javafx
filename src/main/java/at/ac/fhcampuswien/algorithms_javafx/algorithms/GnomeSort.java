package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the gnome sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.1
 */
public class GnomeSort {

    /**
     * Represents the total execution time of the Gnome Sort algorithm.
     */
    private long totalExecutionTimeGnomeSort;

    /**
     * Represents the number of comparisons made during the Gnome Sort algorithm.
     */
    private long comparisonsGnomeSort;

    /**
     * Represents the number of swaps made during the Gnome Sort algorithm.
     */
    private long swapsGnomeSort;

    /**
     * Returns the total execution time of the Gnome Sort algorithm.
     *
     * @return the total execution time of the Gnome Sort algorithm
     */
    public long getTotalExecutionTimeGnomeSort() {
        return totalExecutionTimeGnomeSort;
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

        // Get the current time in nanoseconds.
        long startTime = System.nanoTime();

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

                this.swapsGnomeSort++;

                index--;
            }

            this.comparisonsGnomeSort++;
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();

        this.totalExecutionTimeGnomeSort = endTime - startTime;
    }
}
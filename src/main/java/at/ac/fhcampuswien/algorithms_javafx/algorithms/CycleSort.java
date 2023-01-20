package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the cycle sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.1
 */
public class CycleSort {

    /**
     * The total execution time of the cycle sort algorithm, in nanoseconds.
     */
    private long totalExecutionTimeCycleSort;

    /**
     * The number of comparisons made by the cycle sort algorithm.
     */
    private long comparisonsCycleSort;

    /**
     * The number of swaps made by the cycle sort algorithm.
     */
    private long swapsCycleSort;

    /**
     * Gets the total execution time of the cycle sort algorithm.
     *
     * @return the total execution time, in nanoseconds
     */
    public long getTotalExecutionTimeCycleSort() {
        return totalExecutionTimeCycleSort;
    }

    /**
     * Gets the number of comparisons made by the cycle sort algorithm.
     *
     * @return the number of comparisons
     */
    public long getComparisonsCycleSort() {
        return comparisonsCycleSort;
    }

    /**
     * Gets the number of swaps made by the cycle sort algorithm.
     *
     * @return the number of swaps
     */
    public long getSwapsCycleSort() {
        return swapsCycleSort;
    }

    /**
     * Sorts an array using the cycle sort algorithm and prints out the execution time,
     * number of comparisons, and number of swaps.
     *
     * @param inputArray the array to sort
     */
    public void cycleSort(int[] inputArray) {

        // Get the current time in nanoseconds.
        long startTime = System.nanoTime();

        int arrayLength = inputArray.length;

        // loop through the array
        for (int cycleStart = 0; cycleStart < arrayLength - 1; cycleStart++) {

            //get current item
            int item = inputArray[cycleStart];

            // find the position where the item belongs
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < arrayLength; i++) {

                // if the current item is greater than the item at the current index, increment the position
                if (inputArray[i] < item) {
                    pos++;
                }

                this.comparisonsCycleSort++;
            }

            // if the item is already in the correct position, move on to the next item
            if (pos == cycleStart) {
                continue;
            }

            // skip any duplicates of the item
            while (item == inputArray[pos]) {
                pos++;
            }

            // swap the item into the correct position
            int temp = item;
            item = inputArray[pos];
            inputArray[pos] = temp;

            this.swapsCycleSort++;

            // rotate the rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                for (int i = cycleStart + 1; i < arrayLength; i++) {

                    // if the current item is greater than the item at the current index, increment the position
                    if (inputArray[i] < item) {
                        pos++;
                    }
                }

                // skip any duplicates of the item
                while (item == inputArray[pos]) {
                    pos++;
                }

                // swap the item into the correct position

                temp = item;
                item = inputArray[pos];
                inputArray[pos] = temp;

                this.swapsCycleSort++;
            }
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();

        this.totalExecutionTimeCycleSort = endTime - startTime;
    }
}
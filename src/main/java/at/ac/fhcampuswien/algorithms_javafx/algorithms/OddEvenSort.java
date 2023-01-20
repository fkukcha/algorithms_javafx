package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the odd/even sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.1
 */
public class OddEvenSort {

    /**
     * Represents the total execution time of the Odd-Even Sort algorithm.
     */
    private long totalExecutionTimeOddEvenSort;

    /**
     * Represents the number of comparisons made during the Odd-Even Sort algorithm.
     */
    private long comparisonsOddEvenSort;

    /**
     * Represents the number of swaps made during the Odd-Even Sort algorithm.
     */
    private long swapsOddEvenSort;


    /**
     * Returns the total execution time of the Odd-Even Sort algorithm.
     *
     * @return the total execution time of the Odd-Even Sort algorithm
     */
    public long getTotalExecutionTimeOddEvenSort() {
        return totalExecutionTimeOddEvenSort;
    }

    /**
     * Returns the number of comparisons made during the Odd-Even Sort algorithm.
     *
     * @return the number of comparisons made during the Odd-Even Sort algorithm
     */
    public long getComparisonsOddEvenSort() {
        return comparisonsOddEvenSort;
    }

    /**
     * Returns the number of swaps made during the Odd-Even Sort algorithm.
     *
     * @return the number swaps made during the Odd-Even Sort algorithm
     */
    public long getSwapsOddEvenSort() {
        return swapsOddEvenSort;
    }

    /**
     * Sorts an array using the odd-even sort algorithm and prints out the execution time,
     * number of comparisons, and number of swaps.
     *
     * @param inputArray the array to sort
     */
    public void oddEvenSort(int[] inputArray) {

        // Get the current time in nanoseconds
        long startTime = System.nanoTime();

        // Set the sorted flag to false
        boolean isSorted = false;

        // While the array is not sorted
        while (!isSorted) {
            // Set the sorted flag to true (assume the array is sorted)
            isSorted = true;

            // Perform the sort on the even indices
            for (int i = 0; i < inputArray.length - 1; i += 2) {
                // If the current element is greater than the next element, swap them and set the
                // sorted flag to false
                if (inputArray[i] > inputArray[i + 1]) {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    isSorted = false;

                    this.swapsOddEvenSort++;
                }

                this.comparisonsOddEvenSort++;
            }

            // Perform the sort on the odd indices
            for (int i = 1; i < inputArray.length - 1; i += 2) {
                // If the current element is greater than the next element, swap them and set the
                // sorted flag to false
                if (inputArray[i] > inputArray[i + 1]) {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    isSorted = false;

                    this.swapsOddEvenSort++;
                }

                this.comparisonsOddEvenSort++;
            }

            // Get the current time in nanoseconds and calculate the execution time.
            long endTime = System.nanoTime();

            this.totalExecutionTimeOddEvenSort = endTime - startTime;
        }
    }
}
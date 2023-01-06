package at.ac.fhcampuswien.algorithms_javafx.algorithms;


/**
 * A class that sorts an array using the odd/even sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class OddEvenSort {

    private long totalExecutionTimeOddEvenSort;
    public void setTotalExecutionTimeOddEvenSort(long totalExecutionTime) {
        this.totalExecutionTimeOddEvenSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeOddEvenSort() {
        return totalExecutionTimeOddEvenSort;
    }

    private long comparisonsOddEvenSort;
    public void setComparisonsOddEvenSort(long comparisons) {
        this.comparisonsOddEvenSort = comparisons;
    }
    public long getComparisonsOddEvenSort() {
        return comparisonsOddEvenSort;
    }

    private long swapsOddEvenSort;
    public void setSwapsOddEvenSort(long swaps) {
        this.swapsOddEvenSort = swaps;
    }
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

        long startTime = System.nanoTime();  // start timer

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

                    // Increment the number of swaps
                    setSwapsOddEvenSort(getSwapsOddEvenSort() + 1);
                }

                // Increment the number of comparisons
                setComparisonsOddEvenSort(getComparisonsOddEvenSort() + 1);
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

                    // Increment the number of swaps
                    setSwapsOddEvenSort(getSwapsOddEvenSort() + 1);
                }

                // Increment the number of comparisons
                setComparisonsOddEvenSort(getComparisonsOddEvenSort() + 1);
            }

            // Get the current time in nanoseconds and calculate the execution time.
            long endTime = System.nanoTime();
            long executionTime = endTime - startTime;


            // set execution time
            setTotalExecutionTimeOddEvenSort(executionTime);
        }
    }
}
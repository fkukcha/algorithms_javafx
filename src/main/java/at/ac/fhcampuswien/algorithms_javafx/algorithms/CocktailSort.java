package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the cocktail sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class CocktailSort {

    private long totalExecutionTimeCocktailSort;
    public void setTotalExecutionTimeCocktailSort(long totalExecutionTime) {
        this.totalExecutionTimeCocktailSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeCocktailSort() {
        return totalExecutionTimeCocktailSort;
    }


    private long comparisonsCocktailSort;
    public void setComparisonsCocktailSort(long comparisons) {
        this.comparisonsCocktailSort = comparisons;
    }
    public long getComparisonsCocktailSort() {
        return comparisonsCocktailSort;
    }

    private long swapsCocktailSort;
    public void setSwapsCocktailSort(long swaps) {
        this.swapsCocktailSort = swaps;
    }
    public long getSwapsCocktailSort() {
        return swapsCocktailSort;
    }


    /**
     * Sorts an array using the cocktail sort algorithm, and also measures the
     * execution time, total number of comparisons, and total number of swaps.
     *
     * @param inputArray The array to be sorted.
     */
    public void cocktailSort(int[] inputArray) {

        // Get the current time in nanoseconds.
        long startTime = System.nanoTime();

        // Perform cocktail sort
        boolean isSorted = false;
        int start = 0;
        int end = inputArray.length;
        while (!isSorted) {
            isSorted = true;
            for (int i = start; i < end - 1; i++) {
                setComparisonsCocktailSort(getComparisonsCocktailSort()+1);
                if (inputArray[i] > inputArray[i + 1]) {
                    setSwapsCocktailSort(getSwapsCocktailSort()+1);
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            end--;
            for (int i = end - 1; i >= start; i--) {
                setComparisonsCocktailSort(getComparisonsCocktailSort()+1);
                if (inputArray[i] > inputArray[i + 1]) {
                    setSwapsCocktailSort(getSwapsCocktailSort()+1);
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    isSorted = false;
                }
            }
            start++;
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeCocktailSort(executionTime);
    }
}
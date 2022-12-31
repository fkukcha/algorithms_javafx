package at.ac.fhcampuswien.algorithms_javafx.algorithms;

public class CocktailSort {
    /**
     * The totalExecutionTimeCocktailSort variable is used for the storage
     * of the value of the total execution time of the Cocktail Sort algorithm to perform the sorting
     */
    private long totalExecutionTimeCocktailSort;
    public void setTotalExecutionTimeCocktailSort(long totalExecutionTime) {
        this.totalExecutionTimeCocktailSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeCocktailSort() {
        return totalExecutionTimeCocktailSort;
    }

    /**
     * The usedMemoryCocktailSort variable is used for the storage
     * of the used memory of the Cocktail Sort algorithm to perform the sorting
     */
    private long usedMemoryCocktailSort;
    public void setUsedMemoryCocktailSort(long usedMemory) {
        this.usedMemoryCocktailSort = usedMemory;
    }
    public long getUsedMemoryCocktailSort() {
        return usedMemoryCocktailSort;
    }

    void cocktailSort(int[] inputArray)
    {
        boolean swapped = true;
        int start = 0;
        int end = inputArray.length;

        // using the Runtime object to determine the total memory usage
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        // start of time counter of the algorithm execution
        long startTime = System.nanoTime();

        while (swapped)
        {
            // reset the swapped flag on entering the
            // loop, because it might be true from a previous iteration.
            swapped = false;

            // loop from bottom to top same as
            // the bubble sort
            for (int i = start; i < end - 1; ++i)
            {
                if (inputArray[i] > inputArray[i + 1]) {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    swapped = true;
                }
            }

            // if nothing moved, then array is sorted.
            if (!swapped)
                break;

            // otherwise, reset the swapped flag so that it
            //can be used in the next stage
            swapped = false;

            // move the end point back by one, because
            // item at the end is in its rightful spot
            end = end - 1;

            // from top to bottom, doing the
            // same comparison as in the previous stage
            for (int i = end - 1; i >= start; i--)
            {
                if (inputArray[i] > inputArray[i + 1])
                {
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i + 1];
                    inputArray[i + 1] = temp;
                    swapped = true;
                }
            }
            // increase the starting point, because
            // the last stage would have moved the next
            // smallest number to its rightful spot.
            start = start + 1;
        }

        // end of time counter of the algorithm execution
        long endTime = System.nanoTime();
        // total execution time of bubbleSort
        long totalExecutionTime = endTime - startTime;

        // set the total execution time and the total used memory variables
        setTotalExecutionTimeCocktailSort(totalExecutionTime);
        setUsedMemoryCocktailSort(usedMemory);
    }
}

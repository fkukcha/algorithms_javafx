package at.ac.fhcampuswien.algorithms_javafx.algorithms;

public class CombSort {
    public CombSort(){
    }
    /**
     * The totalExecutionTimeCombSort variable is used for the storage
     * of the value of the total execution time of the Comb Sort algorithm to perform the sorting
     */
    private long totalExecutionTimeCombSort;
    public void setTotalExecutionTimeCombSort(long totalExecutionTime) {
        this.totalExecutionTimeCombSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeCombSort() {
        return totalExecutionTimeCombSort;
    }

    /**
     * The usedMemoryCombSort variable is used for the storage
     * of the used memory of the Comb Sort algorithm to perform the sorting
     */
    private long usedMemoryCombSort;
    public void setUsedMemoryCombSort(long usedMemory) {
        this.usedMemoryCombSort = usedMemory;
    }
    public long getUsedMemoryCombSort() {
        return usedMemoryCombSort;
    }

    // method to find gap between elements
    private int getNextGap(int gap)
    {
        // Shrink gap by Shrink factor
        gap = (gap * 10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }

    public void combSort(int[] inputArray)
    {
        int arraySize = inputArray.length;

        // initialize gap
        int gap = arraySize;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // using the Runtime object to determine the total memory usage
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        // start of time counter of the algorithm execution
        long startTime = System.nanoTime();

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped)
        {
            // Find next gap
            gap = getNextGap(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i=0; i<arraySize-gap; i++)
            {
                if (inputArray[i] > inputArray[i+gap])
                {
                    // Swap arr[i] and arr[i+gap]
                    int temp = inputArray[i];
                    inputArray[i] = inputArray[i+gap];
                    inputArray[i+gap] = temp;
                    // Set swapped
                    swapped = true;
                }
            }
        }

        // end of time counter of the algorithm execution
        long endTime = System.nanoTime();
        // total execution time of bubbleSort
        long totalExecutionTime = endTime - startTime;

        // set the total execution time and the total used memory variables
        setTotalExecutionTimeCombSort(totalExecutionTime);
        setUsedMemoryCombSort(usedMemory);
    }
}

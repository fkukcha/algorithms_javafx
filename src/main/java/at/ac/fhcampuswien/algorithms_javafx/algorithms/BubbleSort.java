package at.ac.fhcampuswien.algorithms_javafx.algorithms;

public class BubbleSort {
    /**
     * The totalExecutionTimeBubbleSort variable is used for the storage
     * of the value of the total execution time of the Bubble Sort algorithm to perform the sorting
     */
    private long totalExecutionTimeBubbleSort;
    public void setTotalExecutionTimeBubbleSort(long totalExecutionTime) {
        this.totalExecutionTimeBubbleSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeBubbleSort() {
        return totalExecutionTimeBubbleSort;
    }

    /**
     * The usedMemoryBubbleSort variable is used for the storage
     * of the used memory of the Bubble Sort algorithm to perform the sorting
     */
    private long usedMemoryBubbleSort;
    public void setUsedMemoryBubbleSort(long usedMemory) {
        this.usedMemoryBubbleSort = usedMemory;
    }
    public long getUsedMemoryBubbleSort() {
        return usedMemoryBubbleSort;
    }

    public void bubbleSort(int[] inputArray) {

        int arraySize = inputArray.length;

        // using the Runtime object to determine the total memory usage
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        // start of time counter of the algorithm execution
        long startTime = System.nanoTime();

        // loop over each element of the array to access them
        for (int i = 0; i < arraySize - 1; i++) {
            // compare the elements of the array with a loop
            for (int j = 0; j < arraySize - i - 1; j++) {
                // compare two adjacent elements in the array
                if (inputArray[j] > inputArray[j + 1]) {
                    // Swap if the elements aren't in the right order
                    int temp = inputArray[j];
                    inputArray[j] = inputArray[j + 1];
                    inputArray[j + 1] = temp;
                }
            }
        }
        // end of time counter of the algorithm execution
        long endTime = System.nanoTime();
        // total execution time of bubbleSort
        long totalExecutionTime = endTime - startTime;

        // set the total execution time and the total used memory variables
        setTotalExecutionTimeBubbleSort(totalExecutionTime);
        setUsedMemoryBubbleSort(usedMemory);
    }
}
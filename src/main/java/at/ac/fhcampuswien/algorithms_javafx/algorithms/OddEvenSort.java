package at.ac.fhcampuswien.algorithms_javafx.algorithms;

public class OddEvenSort {
    public OddEvenSort(){
    }
    /**
     * The totalExecutionTimeOddEvenSort variable is used for the storage
     * of the value of the total execution time of the Odd Even Sort algorithm to perform the sorting
     */
    private long totalExecutionTimeOddEvenSort;
    public void setTotalExecutionTimeOddEvenSort(long totalExecutionTime) {
        this.totalExecutionTimeOddEvenSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeOddEvenSort() {
        return totalExecutionTimeOddEvenSort;
    }

    /**
     * The usedMemoryOddEvenSort variable is used for the storage
     * of the used memory of the Odd Even Sort algorithm to perform the sorting
     */
    private long usedMemoryOddEvenSort;
    public void setUsedMemoryOddEvenSort(long usedMemory) {
        this.usedMemoryOddEvenSort = usedMemory;
    }
    public long getUsedMemoryOddEvenSort() {
        return usedMemoryOddEvenSort;
    }

    public void oddEvenSort(int[]inputArray)
    {
        int arraySize = inputArray.length;
        boolean isSorted = false; // Initially array is unsorted

        // using the Runtime object to determine the total memory usage
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        // start of time counter of the algorithm execution
        long start = System.nanoTime();

        while (!isSorted)
        {
            isSorted = true;
            int temp = 0;

            // Perform Bubble sort on odd indexed element
            for (int i=1; i <= arraySize-2; i = i+2)
            {
                if (inputArray[i] > inputArray[i+1])
                {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i+1];
                    inputArray[i+1] = temp;
                    isSorted = false;
                }
            }
            // Perform Bubble sort on even indexed element
            for (int i = 0; i <= arraySize-2; i = i+2)
            {
                if (inputArray[i] > inputArray[i+1])
                {
                    temp = inputArray[i];
                    inputArray[i] = inputArray[i+1];
                    inputArray[i+1] = temp;
                    isSorted = false;
                }
            }
            // end of time counter of the algorithm execution
            long end = System.nanoTime();
            // total execution time of the algorithm
            long totalExecutionTime = end - start;

            // set the total execution time and the total used memory variables
            setTotalExecutionTimeOddEvenSort(totalExecutionTime);
            setUsedMemoryOddEvenSort(usedMemory);
        }
    }
}
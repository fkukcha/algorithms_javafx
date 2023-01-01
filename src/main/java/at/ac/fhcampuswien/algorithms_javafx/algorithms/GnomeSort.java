package at.ac.fhcampuswien.algorithms_javafx.algorithms;

public class GnomeSort {
    public GnomeSort(){
    }
    /**
     * The totalExecutionTimeGnomeSort variable is used for the storage
     * of the value of the total execution time of the Gnome Sort algorithm to perform the sorting
     */
    private long totalExecutionTimeGnomeSort;
    public void setTotalExecutionTimeGnomeSort(long totalExecutionTime) {
        this.totalExecutionTimeGnomeSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeGnomeSort() {
        return totalExecutionTimeGnomeSort;
    }

    /**
     * The usedMemoryGnomeSort variable is used for the storage
     * of the used memory of the Gnome Sort algorithm to perform the sorting
     */
    private long usedMemoryGnomeSort;
    public void setUsedMemoryGnomeSort(long usedMemory) {
        this.usedMemoryGnomeSort = usedMemory;
    }
    public long getUsedMemoryGnomeSort() {
        return usedMemoryGnomeSort;
    }

    public void gnomeSort(int[] inputArray)
    {
        int arraySize = inputArray.length;
        int index = 0;

        // using the Runtime object to determine the total memory usage
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        // start of time counter of the algorithm execution
        long startTime = System.nanoTime();

        while (index < arraySize) {
            if (index == 0)
                index++;
            if (inputArray[index] >= inputArray[index - 1])
                index++;
            else {
                int temp = 0;
                temp = inputArray[index];
                inputArray[index] = inputArray[index - 1];
                inputArray[index - 1] = temp;
                index--;
            }
        }
        // end of time counter of the algorithm execution
        long endTime = System.nanoTime();
        // total execution time of bubbleSort
        long totalExecutionTime = endTime - startTime;

        // set the total execution time and the total used memory variables
        setTotalExecutionTimeGnomeSort(totalExecutionTime);
        setUsedMemoryGnomeSort(usedMemory);
    }
}

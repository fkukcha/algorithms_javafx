package at.ac.fhcampuswien.algorithms_javafx.algorithms;

public class CycleSort {
    /**
     * The totalExecutionTimeCycleSort variable is used for the storage
     * of the value of the total execution time of the Cycle Sort algorithm to perform the sorting
     */
    private long totalExecutionTimeCycleSort;
    public void setTotalExecutionTimeCycleSort(long totalExecutionTime) {
        this.totalExecutionTimeCycleSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeCycleSort() {
        return totalExecutionTimeCycleSort;
    }

    /**
     * The usedMemoryCycleSort variable is used for the storage
     * of the used memory of the Cycle Sort algorithm to perform the sorting
     */
    private long usedMemoryCycleSort;
    public void setUsedMemoryCycleSort(long usedMemory) {
        this.usedMemoryCycleSort = usedMemory;
    }
    public long getUsedMemoryCycleSort() {
        return usedMemoryCycleSort;
    }

    public void cycleSort(int[] inputArray)
    {
        int arraySize = inputArray.length;

        // using the Runtime object to determine the total memory usage
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        // start of time counter of the algorithm execution
        long startTime = System.nanoTime();

        // traverse array elements and put it to on
        // the right place
        for (int cycle_start = 0; cycle_start <= arraySize - 2; cycle_start++) {
            // initialize item as starting point
            int item = inputArray[cycle_start];

            // Find position where we put the item. We basically
            // count all smaller elements on right side of item.
            int position = cycle_start;
            for (int i = cycle_start + 1; i < arraySize; i++)
                if (inputArray[i] < item)
                    position++;

            // If item is already in correct position
            if (position == cycle_start)
                continue;

            // ignore all duplicate elements
            while (item == inputArray[position])
                position += 1;

            // put the item to it's right position
            if (position != cycle_start) {
                int temp = item;
                item = inputArray[position];
                inputArray[position] = temp;
            }

            // Rotate rest of the cycle
            while (position != cycle_start) {
                position = cycle_start;

                // Find position where we put the element
                for (int i = cycle_start + 1; i < arraySize; i++)
                    if (inputArray[i] < item)
                        position += 1;

                // ignore all duplicate elements
                while (item == inputArray[position])
                    position += 1;

                // put the item to it's right position
                if (item != inputArray[position]) {
                    int temp = item;
                    item = inputArray[position];
                    inputArray[position] = temp;
                }
            }
        }
        // end of time counter of the algorithm execution
        long endTime = System.nanoTime();
        // total execution time of bubbleSort
        long totalExecutionTime = endTime - startTime;

        // set the total execution time and the total used memory variables
        setTotalExecutionTimeCycleSort(totalExecutionTime);
        setUsedMemoryCycleSort(usedMemory);
    }
}

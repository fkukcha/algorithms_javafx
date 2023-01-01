package at.ac.fhcampuswien.algorithms_javafx.algorithms;

public class HeapSort {
    public HeapSort(){
    }
    /**
     * The totalExecutionTimeHeapSort variable is used for the storage
     * of the value of the total execution time of the Heap Sort algorithm to perform the sorting
     */
    private long totalExecutionTimeHeapSort;
    public void setTotalExecutionTimeHeapSort(long totalExecutionTime) {
        this.totalExecutionTimeHeapSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeHeapSort() {
        return totalExecutionTimeHeapSort;
    }

    /**
     * The usedMemoryHeapSort variable is used for the storage
     * of the used memory of the Heap Sort algorithm to perform the sorting
     */
    private long usedMemoryHeapSort;
    public void setUsedMemoryHeapSort(long usedMemory) {
        this.usedMemoryHeapSort = usedMemory;
    }
    public long getUsedMemoryHeapSort() {
        return usedMemoryHeapSort;
    }

    public void heapSort(int[] inputArray)
    {
        int arrayLength = inputArray.length;

        // using the Runtime object to determine the total memory usage
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        // start of time counter of the algorithm execution
        long startTime = System.nanoTime();
        // Build heap (rearrange array)
        for (int i = arrayLength / 2 - 1; i >= 0; i--)
            heapify(inputArray, arrayLength, i);

        // One by one extract an element from heap
        for (int i = arrayLength - 1; i > 0; i--) {
            // Move current root to end
            int temp = inputArray[0];
            inputArray[0] = inputArray[i];
            inputArray[i] = temp;

            // call max heapify on the reduced heap
            heapify(inputArray, i, 0);
        }
        // end of time counter of the algorithm execution
        long endTime = System.nanoTime();

        // total execution time of the algorithm
        long totalExecutionTime = endTime - startTime;

        // set the total execution time and the total used memory variables
        setTotalExecutionTimeHeapSort(totalExecutionTime);
        setUsedMemoryHeapSort(usedMemory);
    }

    // To heapify a subtree rooted with node i which is an index in inputArray[]. heapSize is size of heap
    private void heapify(int[] inputArray, int heapSize, int i)
    {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (left < heapSize && inputArray[left] > inputArray[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < heapSize && inputArray[right] > inputArray[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            int swap = inputArray[i];
            inputArray[i] = inputArray[largest];
            inputArray[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(inputArray, heapSize, largest);
        }
    }
}

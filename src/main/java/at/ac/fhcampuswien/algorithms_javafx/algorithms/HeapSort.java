package at.ac.fhcampuswien.algorithms_javafx.algorithms;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * A class that sorts an array using the heap sort algorithm, and also measures
 * the execution time, memory consumption, total number of comparisons, and total
 * number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.0
 */
public class HeapSort {

    private long totalExecutionTimeHeapSort;
    public void setTotalExecutionTimeHeapSort(long totalExecutionTime) {
        this.totalExecutionTimeHeapSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeHeapSort() {
        return totalExecutionTimeHeapSort;
    }


    private long comparisonsHeapSort;
    public void setComparisonsHeapSort(long comparisons) {
        this.comparisonsHeapSort = comparisons;
    }
    public long getComparisonsHeapSort() {
        return comparisonsHeapSort;
    }

    private long swapsHeapSort;
    public void setSwapsHeapSort(long swaps) {
        this.swapsHeapSort = swaps;
    }
    public long getSwapsHeapSort() {
        return swapsHeapSort;
    }

    /**
     * Sorts an array using the heap sort algorithm and prints out the execution time,
     * number of comparisons, and number of swaps.
     *
     * @param inputArray the array to sort
     */
    public void heapSort(int[] inputArray) {

        long startTime = System.nanoTime();  // start timer


        // Build the heap
        for (int i = inputArray.length / 2 - 1; i >= 0; i--) {
            heapify(inputArray, inputArray.length, i);
        }

        // Perform the sort
        for (int i = inputArray.length - 1; i >= 0; i--) {
            // Move the current root to the end
            swap(inputArray, 0, i);
            // Sift the new root to its proper position
            heapify(inputArray, i, 0);
        }

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;


        // set execution time, comparison count, swap count
        setTotalExecutionTimeHeapSort(executionTime);
    }

    private void heapify(int[] array, int heapSize, int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Compare the root with its left child
        if (leftChild < heapSize) {
            setComparisonsHeapSort(getComparisonsHeapSort()+1);
            if (array[leftChild] > array[largest]) {
                largest = leftChild;
            }
        }

        // Compare the root with its right child
        if (rightChild < heapSize) {
            setComparisonsHeapSort(getComparisonsHeapSort()+1);
            if (array[rightChild] > array[largest]) {
                largest = rightChild;
            }
        }

        // If the root is not the largest, swap it with the largest
        // and continue heapifying
        if (largest != index) {
            setSwapsHeapSort(getSwapsHeapSort()+1);
            swap(array, index, largest);
            heapify(array, heapSize, largest);
        }
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
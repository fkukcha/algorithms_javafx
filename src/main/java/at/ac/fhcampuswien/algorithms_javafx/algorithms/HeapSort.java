package at.ac.fhcampuswien.algorithms_javafx.algorithms;

/**
 * A class that sorts an array using the heap sort algorithm, and also measures
 * the execution time, total number of comparisons, and total number of swaps.
 *
 * @author  Burak Kongo
 * @version 1.1
 */
public class HeapSort {

    /**
     * Represents the total execution time of the Heap Sort algorithm.
     */
    private long totalExecutionTimeHeapSort;

    /**
     * Represents the number of comparisons made during the Heap Sort algorithm.
     */
    private long comparisonsHeapSort;

    /**
     * Represents the number of swaps made during the Heap Sort algorithm.
     */
    private long swapsHeapSort;

    /**
     * Returns the total execution time of the Heap Sort algorithm.
     *
     * @return the total execution time of the Heap Sort algorithm
     */
    public long getTotalExecutionTimeHeapSort() {
        return totalExecutionTimeHeapSort;
    }

    /**
     * Returns the number of comparisons made during the Heap Sort algorithm.
     *
     * @return the number of comparisons made during the Heap Sort algorithm
     */
    public long getComparisonsHeapSort() {
        return comparisonsHeapSort;
    }

    /**
     * Returns the number of swaps made during the Heap Sort algorithm.
     *
     * @return the number of swaps made during the Heap Sort algorithm
     */
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

        // Get the current time in nanoseconds.
        long startTime = System.nanoTime();

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

        this.totalExecutionTimeHeapSort = endTime - startTime;
    }

    /**
     * Performs heapification on a given array.
     *
     * @param array the array to be heapified
     * @param heapSize the size of the heap
     * @param index the index at which to start heapification
     */
    private void heapify(int[] array, int heapSize, int index) {

        // Initialize the largest element as the root
        int largest = index;

        // Calculate the indices of the root's left and right children
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Compare the root with its left child. If the left child is larger, set it as the largest element.
        if (leftChild < heapSize) {

            this.comparisonsHeapSort++;

            if (array[leftChild] > array[largest]) {
                largest = leftChild;
            }
        }

        // Compare the root with its right child. If the right child is larger, set it as the largest element.
        if (rightChild < heapSize) {

            this.comparisonsHeapSort++;

            if (array[rightChild] > array[largest]) {
                largest = rightChild;
            }
        }

        // If the root is not the largest, swap it with the largest
        // and continue heapifying
        if (largest != index) {

            this.swapsHeapSort++;

            swap(array, index, largest);
            heapify(array, heapSize, largest);
        }
    }

    /**
     * Swaps the elements at the given indices in the given array.
     *
     * @param array the array containing the elements to be swapped
     * @param a the index of the first element to be swapped
     * @param b the index of the second element to be swapped
     */
    private static void swap(int[] array, int a, int b) {

        // Save the value at index a in a temporary variable.
        int temp = array[a];

        // Replace the value at index a with the value at index b
        array[a] = array[b];

        // Replace the value at index b with the value from the temporary variable.
        array[b] = temp;
    }
}
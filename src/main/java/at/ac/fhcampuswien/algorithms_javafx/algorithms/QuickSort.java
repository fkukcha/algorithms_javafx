package at.ac.fhcampuswien.algorithms_javafx.algorithms;

public class QuickSort {
    private long totalExecutionTimeQuickSort;
    public void setTotalExecutionTimeQuickSort(long totalExecutionTime) {
        this.totalExecutionTimeQuickSort = totalExecutionTime;
    }
    public long getTotalExecutionTimeQuickSort() {
        return totalExecutionTimeQuickSort;
    }

    private int comparisonsQuickSort;
    public void setComparisonsQuickSort(int comparisons) {
        this.comparisonsQuickSort = comparisons;
    }
    public int getComparisonsQuickSort() {
        return comparisonsQuickSort;
    }

    private int swapsQuickSort;
    public void setSwapsQuickSort(int swaps) {
        this.swapsQuickSort = swaps;
    }
    public int getSwapsQuickSort() {
        return swapsQuickSort;
    }

    public void quickSort(int[] inputArray) {
        int arrayLength = inputArray.length;

        // Start the timer
        long startTime = System.nanoTime();

        quickSortHelperMethod(inputArray, 0, arrayLength - 1);

        // Get the current time in nanoseconds and calculate the execution time.
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        // set execution time
        setTotalExecutionTimeQuickSort(executionTime);
    }

    private void quickSortHelperMethod(int[] array, int low, int high) {
        if (low < high) {
            /* pi is partitioning index, array[pi] is
              now at right place */
            int pi = partition(array, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSortHelperMethod(array, low, pi - 1);
            quickSortHelperMethod(array, pi + 1, high);
        }
    }
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1; // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (array[j] <= pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                setSwapsQuickSort(getSwapsQuickSort()+1);
                setComparisonsQuickSort(getComparisonsQuickSort()+1);
            }
            setComparisonsQuickSort(getComparisonsQuickSort()+1);
        }

        // Swap array[i+1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        setSwapsQuickSort(getSwapsQuickSort()+1);

        return i + 1;
    }
}
/**
 * Selection sort is a simple sorting algorithm that divides the input list into two parts:
 * a sorted part and an unsorted part. Initially, the sorted part is empty and the
 * unsorted part contains all the elements.
 * The algorithm repeatedly finds the smallest element from the unsorted part and appends
 * it at the end of the sorted part. This process continues until all the elements are sorted.
 * Selection sort does not perform well on large data sets, but it could be efficient on
 * smaller data set.
 */

package at.ac.fhcampuswien.algorithms_javafx.algorithms_steps;


public class SelectionSort {

    private int arraySize;
    private int[] array;
    private ArrayStructures arrayStructures = new ArrayStructures();

    public SelectionSort() {
        this.arraySize = arrayStructures.getArraySize();
        this.array = arrayStructures.getArray();
        arrayStructures.generateRandomArray();
    }

    public int[] getArray() {
        return array;
    }

    /*
    Selection sort search for the smallest number in the array
    saves it in the minimum spot and then repeats searching
    through the entire array each time.
     */
    public void selectionSort() {

        for (int m=0; m<arrayStructures.getArraySize(); m++) {
            int min = m;
            for (int n=m; n<arrayStructures.getArraySize(); n++) {
                if (arrayStructures.getArray()[min] > arrayStructures.getArray()[n]) {
                    System.out.println("Array[" + n + "] will be added to Array[" + m + "]");
                    min = n;
                }
            }
            arrayStructures.swapValues(m, min);
            arrayStructures.printHorizontalArray(m, -1);
        }
    }
}

/**
 * Insertion sort is a simple sorting algorithm that builds the final sorted list
 * one item at a time. It repeatedly takes the next unsorted element and inserts
 * it into its proper position in the already sorted portion of the list.
 * The portion of the list that is already sorted is maintained as a sublist at
 * the beginning of the array, and it grows as elements are added to it.
 */

package at.ac.fhcampuswien.algorithms_javafx.algorithms_steps;

public class InsertionSort {
    // The Insertion Sort is normally the best of
    // the elementary sorts. Unlike the other sorts that
    // had a group sorted at any given time, groups are
    // only partially sorted here.
    public void insertionSort() {
        ArrayStructures arrayStructures = new ArrayStructures();
        arrayStructures.generateRandomArray();
        for (int i=1; i<arrayStructures.getArraySize(); i++) {
            int j = i;
            int toInsert = arrayStructures.getArray()[i];
            while ((j>0) && (arrayStructures.getArray()[j-1] > toInsert)) {
                arrayStructures.getArray()[j] = arrayStructures.getArray()[j-1];
                j--;
                arrayStructures.printHorizontalArray(i, j);
            }
            arrayStructures.getArray()[j] = toInsert;
            arrayStructures.printHorizontalArray(i, j);
            System.out.println("\nArray[i] = " + arrayStructures.getArray()[i] +
                    " Array[j] = " + arrayStructures.getArray()[j] + " toInsert = " + toInsert);
        }
    }
}

/**
 * Bubble sort is an algorithm for sorting an array of elements.
 * It repeatedly steps through the list, compares adjacent elements
 * and swaps them if they are in the wrong order.
 * The pass through the list is repeated until the list is sorted.
 * The algorithm, which is a comparison sort, is named for the way
 * smaller or larger elements "bubble" to the top of the list as the
 * sort iterates.
 */

package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

public class BubbleSort {

    private int arraySize;
    private int[] array;
    private ArrayStructures arrayStructures = new ArrayStructures();

    public BubbleSort() {
        this.arraySize = arrayStructures.getArraySize();
        this.array = arrayStructures.getArray();
        arrayStructures.generateRandomArray();
    }

    public int[] getArray() {
        return array;
    }

    public void bubbleSort() {
        /*
        i starts at the end of the Array.
        As it is decremented all indexes greater
        than it are sorted.
         */
        for (int i=arrayStructures.getArraySize()-1; i>1; i--) {
            /*
            The inner loop starts at the beginning of
            the array and compares each value next to each
            other. If the value on the left is greater than the
            value on the right then they are swapped.
             */
            for (int j=0; j<i; j++) {
                if (arrayStructures.getArray()[j] > arrayStructures.getArray()[j+1]) {
                    System.out.println(arrayStructures.getArray()[j] + " at index " + j +
                            " will be swapped with " + arrayStructures.getArray()[j+1] + " at index "
                            + (j+1));
                    arrayStructures.swapValues(j, j+1);
                    arrayStructures.printHorizontalArray(i, j);
                }
                arrayStructures.printHorizontalArray(i, j);
            }
        }
    }

}

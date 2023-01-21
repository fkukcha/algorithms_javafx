/**
 * QuickSort is an efficient sorting algorithm that uses a divide-and-conquer
 * approach to sort a list of items. It works by choosing a pivot element from
 * the list and partitioning the other elements into two sublists, according
 * to whether they are less than or greater than the pivot. The sublists are
 * then recursively sorted, and the results are combined to produce the final
 * sorted list.
 * In most situations the QuickSort is the fastest algorithm.
 */

package at.ac.fhcampuswien.algorithms_javafx.algorithms_steps;

public class QuickSort {
    private static int[] myArray;
    private static int arraySize;

    public QuickSort(int newArraySize) {
        this.arraySize = newArraySize;
        this.myArray = new int[arraySize];
        generateRandomArray();
    }

    public int[] getMyArray() {
        return myArray;
    }

    public void quickSort(int left, int right) {

        if (right - left <= 0) {
            return; // Everything is sorted
        } else {
            // It doesn't matter what the pivot is, but it must
            // be a value in the array.
            int pivot = myArray[right];
            System.out.println("Value in right " + myArray[right] +
                    " is made the pivot");
            System.out.println("left = " + left + " right= " + right +
                    " pivot= " + pivot + " sent to be partitioned");
            int pivotLocation = partitionArray(left, right, pivot);
            System.out.println("Value in left " + myArray[left] +
                    " is made the pivot");
            quickSort(left, pivotLocation - 1); // Sorts the left side
            quickSort(pivotLocation + 1, right);
        }
    }
    public int partitionArray(int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (myArray[++leftPointer] < pivot) ;
            printHorizontalArray(leftPointer, rightPointer);
            System.out.println(myArray[leftPointer] + " in index " +
                    leftPointer + " is bigger than the pivot value " + pivot);
            while (rightPointer > 0 && myArray[--rightPointer] > pivot) ;
            printHorizontalArray(leftPointer, rightPointer);
            System.out.println(myArray[rightPointer] + " in index " +
                    rightPointer + " is smaller than the pivot value " + pivot);
            printHorizontalArray(leftPointer, rightPointer);
            if (leftPointer >= rightPointer) {
                System.out.println("left is >= right so start again");
                break;
            } else {
                swapValues(leftPointer, rightPointer);
                System.out.println(myArray[leftPointer] + " was swapped for " +
                        myArray[rightPointer]);
            }
        }
        swapValues(leftPointer, right);
        return leftPointer;
    }

    public void swapValues(int indexOne, int indexTwo){
        int temp = myArray[indexOne];
        myArray[indexOne] = myArray[indexTwo];
        myArray[indexTwo] = temp;
    }

    public void generateRandomArray () {
        for (int i = 0; i < arraySize; i++) {
            // Generate a random array with values between 10 and 59.
            myArray[i] = (int) (Math.random() * 50) + 10;
        }
    }

    public static void printHorizontalArray(int i, int j) {
        for (int n = 0; n < 61; n++) {
            System.out.print("-");
        }
        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.format("| %2s " + " ", n);
        }
        System.out.println("|");
        for (int n = 0; n < 61; n++) {
            System.out.print("-");
        }
        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.print(String.format("| %2s " + " ", myArray[n]));
        }
        System.out.println("|");

        for (int n = 0; n < 61; n++) {
            System.out.print("-");
        }
        System.out.println();

        if (i != -1) {
            // Number of spaces to put before the F.
            int spacesBeforeFront = 6 * (i + 1) - 5;
            for (int k = 0; k < spacesBeforeFront; k++) {
                System.out.print(" ");
            }
            System.out.print("L" + i);
            // Number of spaces to put before the R.
            int spacesBeforeRear = 5 * (j + 1) - spacesBeforeFront;
            for (int l = 0; l < spacesBeforeRear; l++) {
                System.out.print(" ");
            }
            System.out.print("R" + j);
            System.out.println("\n");
        }
    }
}




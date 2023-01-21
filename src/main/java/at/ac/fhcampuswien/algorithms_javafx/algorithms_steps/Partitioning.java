/**
 * In Algorithms partitioning refers to the process of dividing a list of
 * items into two or more smaller lists. This is often done as part of
 * a divide-and-conquer strategy, where the list is recursively partitioned
 * until it can be easily processed or sorted.
 */

package at.ac.fhcampuswien.algorithms_javafx.algorithms_steps;

public class Partitioning {

    private static int[] myArray;
    private static int arraySize;

    public Partitioning(int newArraySize) {
        this.arraySize = newArraySize;
        this.myArray = new int[arraySize];
        generateRandomArray();
    }

    public int[] getMyArray() {
        return myArray;
    }

    public void partitionArray(int pivot) {
        /*If leftPointer finds an item that is greater
        than pivot it stops and waits for the rightPointer
        to find a value less than pivot. Then the items
        are switched.
         */

        // Starts at the left side of array before index 0.
        int leftPointer = -1;
        // Starts at the right side of the array after the last index.
        int rightPointer = arraySize;

        while (true) {
            // Cycle through array until the end is reached
            // or an item bigger than pivot is found. Then
            // wait for rightPointer to finish cycling.
            while (leftPointer < (arraySize - 1) && myArray[++leftPointer] < pivot);
            printHorizontalArray(leftPointer, rightPointer);

            System.out.println(myArray[leftPointer] + " in index " +
                    leftPointer + " is bigger than the pivot value " + pivot);
            // Cycle through array until the beginning is reached
            // or an item smaller than pivot is found.
            while (rightPointer > 0 && myArray[--rightPointer] > pivot);
            printHorizontalArray(leftPointer, rightPointer);
            System.out.println(myArray[rightPointer] + " in index " +
                    rightPointer + " is smaller than the pivot value " + pivot);
            printHorizontalArray(leftPointer, rightPointer);
            // When the 2 pointers meet at the middle break
            // out of the while loop
            if (leftPointer >= rightPointer) {
                break;
            } else {
                // Swap the values in the pointers
                swapValues(leftPointer, rightPointer);
                System.out.println(myArray[leftPointer] + " was swapped for " +
                        myArray[rightPointer]);
            }
        }
    }

    public void swapValues(int indexOne, int indexTwo) {
        int temp = myArray[indexOne];
        myArray[indexOne] = myArray[indexTwo];
        myArray[indexTwo] = temp;
    }


    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {
            // Generate a random array with values between 10 and 59.
            myArray[i] = (int) (Math.random() * 50) + 10;
        }
    }
    static void printHorizontalArray(int i, int j) {
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
            int spacesBeforeFront = 5 * i + 1;
            for (int k = 0; k < spacesBeforeFront; k++) {
                System.out.print(" ");
            }
            System.out.print("L");

            // Number of spaces to put before the R
            int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;
            for (int l = 0; l < spacesBeforeRear; l++) {
                System.out.print(" ");
            }
            System.out.print("H");
            System.out.println("\n");
        }
    }
}



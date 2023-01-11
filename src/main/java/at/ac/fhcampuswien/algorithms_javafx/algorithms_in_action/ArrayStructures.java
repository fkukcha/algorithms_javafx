/**
 * An algorithm is a series of steps to take to manipulate data.
 * Data structures are the way data is arranged in memory.
 */

package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

import java.util.Arrays;

public class ArrayStructures {
    private int[] array = new int[50];
    private int arraySize = 10;

    public int[] getArray() {
        return array;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void generateRandomArray() {
        for (int i=0; i<arraySize; i++) {
            array[i] = (int) (Math.random()*10) + 10;
        }
    }

    public void printArray() {
        System.out.println("---------");
        for (int i=0; i<arraySize; i++) {
            System.out.print("| " + i + " |");
            System.out.println(array[i] + " |");
            System.out.println("---------");
        }
    }

    // Gets value at provided index.
    public int getValueAtIndex(int index) {
        ArrayStructures newArray = new ArrayStructures();
        if (index < arraySize) {
            return array[index];
        }
        return 0;
    }

    // Returns true or false if a value is in the Array.
    public boolean doesArrayContainsThisValue(int searchValue) {
        for (int i=0; i<arraySize; i++) {
            if (array[i] == searchValue) {
                return true;
            }
        }
        return false;
    }

    public void deleteIndex(int index) {
        if (index < arraySize) {
            for (int i=index; i<(arraySize-1); i++) {
                array[i] = array[i+1];
            }
        }
        arraySize--;
    }

    public void insertValue(int value) {
        if (arraySize < 50) {
            array[arraySize] = value;
            arraySize++;
        }
    }

    // Linear Search : Every index must be looked at.
    public String linearSearchForValue(int value) {
        boolean valueInArray = false;
        String indicesWithValue = "";
        System.out.println("The Value was found in the following indices: ");
        for (int i=0; i<arraySize; i++) {
            if (array[i] == value) {
                valueInArray = true;
                System.out.println(i + " ");
                indicesWithValue += i + " ";
            }
        }
        if (!valueInArray) {
            indicesWithValue = "None";
            System.out.println(indicesWithValue);
        }
        System.out.println();
        return indicesWithValue;
    }

    public void printHorizontalArray(int i, int j) {
        for (int m=0; m<51; m++) {
            System.out.print("-");
        }
        System.out.println();

        for (int m=0; m<arraySize; m++) {
                System.out.print("| " + m + "  ");
        }
        System.out.println("|");
        for (int m=0; m<51; m++) {
            System.out.print("-");
        }
        System.out.println();

        for (int m=0; m<arraySize; m++) {
            System.out.print("| " + array[m] + " ");
        }
        System.out.println("|");

        for (int m=0; m<51; m++) {
            System.out.print("-");
        }
        System.out.println();

        if (j!=-1) {
            for (int p=0; p<((j*5)+2); p++) {
                System.out.print(" ");
            }
            System.out.print(j);
        }

        if (i!=-1) {
            for (int q=0; q<(5*(i-j)-1); q++) {
                System.out.print(" ");
            }
            System.out.print(i);
        }
        System.out.println();

    }

    public void swapValues(int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }


    // The Binary Search is quicker than the linear search
    // because all the values are sorted. Because everything
    // is sorted once you get to a number larger than what
    // you are looking for you can stop the search. Also
    // you be able to start searching from the middle
    // which speeds the search. It also works best when
    // there are no duplicates.
    public void binarySearchForValue(int value) {
        int minIndex = 0;
        int maxIndex = arraySize - 1;

        while (minIndex <= maxIndex) {
            int midIndex = (maxIndex + minIndex) / 2;
            if (array[midIndex] < value) {
                minIndex = midIndex + 1;
            } else if (array[midIndex] > value) {
                maxIndex = midIndex - 1;
            } else {
                System.out.println("A match has been found for " + value +
                        " at index " + midIndex);
                minIndex = maxIndex + 1;
            }
            printHorizontalArray(midIndex, -1);
        }
    }



    public static void main(String[] args) {
        /*
        Please uncomment the commented lines which are not separated by a new line,
        in order to see the algorithms separately in action.
         */

        ArrayStructures newArray = new ArrayStructures();
        //newArray.generateRandomArray();
        //newArray.printArray();
        //System.out.println(newArray.getValueAtIndex(2));
        //System.out.println(newArray.doesArrayContainsThisValue(18));
        //newArray.deleteIndex(3);
        //newArray.printArray();
        //newArray.insertValue(54);
        //newArray.printArray();
        //newArray.linearSearchForValue(12);

        // Bubble sort.
        //newArray.bubbleSort();

        // Binary search.
        //newArray.binarySearchForValue(15);

        // Selection sort.
        //newArray.selectionSort();

        // Insertion sort.
        //newArray.insertionSort();

        // Selection sort.
        //SelectionSort mySelection = new SelectionSort();
        //mySelection.selectionSort();

        // Insertion sort.
        //InsertionSort myInsertion = new InsertionSort();
        //myInsertion.insertionSort();

        // Bubble sort.
        //BubbleSort myBubble = new BubbleSort();
        //myBubble.bubbleSort();

        // Shell sort.
        /*ShellSort myShell = new ShellSort(10);
        System.out.println("Array to be sorted: ");
        System.out.println(Arrays.toString(myShell.getMyArray()));
        System.out.println();
        myShell.shellSort();
        System.out.println("Sorted Array: ");
        System.out.println(Arrays.toString(myShell.getMyArray()));*/

        // Partitioning.
        //Partitioning myPartition = new Partitioning(10);
        //System.out.println("Array to be partitioned: ");
        //System.out.println(Arrays.toString(myPartition.getMyArray()));
        // Every item smaller than 35 will be on the left and
        // everything bigger will be on the right
        //myPartition.partitionArray(35);
        //System.out.println("Partitioned Array: ");
        //System.out.println(Arrays.toString(myPartition.getMyArray()));

        // Quick sort.
        QuickSort myQuickSort = new QuickSort(10);
        System.out.println("Array to be sorted: ");
        System.out.println(Arrays.toString(myQuickSort.getMyArray()));
        // Every item smaller than 35 will be on the left and
        // everything bigger will be on the right
        myQuickSort.quickSort(0, 9);
        System.out.println("Sored Array: ");
        System.out.println(Arrays.toString(myQuickSort.getMyArray()));
    }
}

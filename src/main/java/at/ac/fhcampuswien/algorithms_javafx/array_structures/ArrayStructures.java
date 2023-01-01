package at.ac.fhcampuswien.algorithms_javafx.array_structures;

public class ArrayStructures {
    private int[] array = new int[50];
    private int arraySize = 10;

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

    public int getValueAtIndex(int index) {
        ArrayStructures newArray = new ArrayStructures();
        if (index < arraySize) {
            return array[index];
        }
        return 0;
    }

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

    public void bubbleSort() {
        for (int i=arraySize-1; i>1; i--) {
            for (int j=0; j<i; j++) {
                if (array[j] > array[j+1]) {
                    swapValues(j, j+1);
                    printHorizontalArray(i, j);
                }
                printHorizontalArray(i, j);
            }
        }
    }

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

    public void selectionSort() {
        for (int m=0; m<arraySize; m++) {
            int min = m;
            for (int n=m; n<arraySize; n++) {
                if (array[min] > array[n]) {
                    min = n;
                }
            }
            swapValues(m, min);
            printHorizontalArray(m, -1);
        }
    }

    public void insertionSort() {
        for (int i=1; i<arraySize; i++) {
            int j = i;
            int toInsert = array[i];
            while ((j>0) && (array[j-1] > toInsert)) {
                array[j] = array[j-1];
                j--;
                printHorizontalArray(i, j);
            }
            array[j] = toInsert;
            printHorizontalArray(i, j);
            System.out.println("\nArray[i] = " + array[i] +
                        " Array[j] = " + array[j] + " toInsert = " + toInsert);
        }
    }

    public static void main(String[] args) {
        ArrayStructures newArray = new ArrayStructures();
        newArray.generateRandomArray();
        newArray.printArray();
        System.out.println(newArray.getValueAtIndex(2));
        System.out.println(newArray.doesArrayContainsThisValue(18));
        newArray.deleteIndex(3);
        newArray.printArray();
        newArray.insertValue(54);
        newArray.printArray();
        newArray.linearSearchForValue(12);

        // Bubble sort.
        //newArray.bubbleSort();

        // Binary search.
        //newArray.binarySearchForValue(15);

        // Selection sort.
        //newArray.selectionSort();

        // Insertion sort.
        newArray.insertionSort();

    }
}

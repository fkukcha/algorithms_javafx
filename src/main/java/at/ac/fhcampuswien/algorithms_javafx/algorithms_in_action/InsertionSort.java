package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

public class InsertionSort {

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

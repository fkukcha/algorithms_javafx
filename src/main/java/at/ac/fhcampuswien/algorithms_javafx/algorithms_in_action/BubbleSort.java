package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

public class BubbleSort {

    public void bubbleSort() {
        ArrayStructures arrayStructures = new ArrayStructures();
        arrayStructures.generateRandomArray();
        for (int i=arrayStructures.getArraySize()-1; i>1; i--) {
            for (int j=0; j<i; j++) {
                if (arrayStructures.getArray()[j] > arrayStructures.getArray()[j+1]) {
                    arrayStructures.swapValues(j, j+1);
                    arrayStructures.printHorizontalArray(i, j);
                }
                arrayStructures.printHorizontalArray(i, j);
            }
        }
    }
}

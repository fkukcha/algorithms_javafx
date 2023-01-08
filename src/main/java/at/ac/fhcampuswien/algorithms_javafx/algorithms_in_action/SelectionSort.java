package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;


public class SelectionSort {

    public void selectionSort() {
        ArrayStructures arrayStructures = new ArrayStructures();
        arrayStructures.generateRandomArray();
        for (int m=0; m<arrayStructures.getArraySize(); m++) {
            int min = m;
            for (int n=m; n<arrayStructures.getArraySize(); n++) {
                if (arrayStructures.getArray()[min] > arrayStructures.getArray()[n]) {
                    min = n;
                }
            }
            arrayStructures.swapValues(m, min);
            arrayStructures.printHorizontalArray(m, -1);
        }
    }
}

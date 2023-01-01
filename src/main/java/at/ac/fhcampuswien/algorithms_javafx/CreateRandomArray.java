package at.ac.fhcampuswien.algorithms_javafx;
import java.util.Random;

/**
 * The CreateRandomArray class creates a random unsorted int array based
 * on the size that the user selects.
 */
public class CreateRandomArray {
    private int[] randomArray;
    private void setRandomArray(int[] randomArray) {
        this.randomArray = randomArray;
    }
    public int[] getRandomArray() {
        return randomArray;
    }

    /**
     * @param numberOfArrayElements
     *        The number of array elements that are selected by the user
     */
    public CreateRandomArray(int numberOfArrayElements) {
        Random randomNumber = new Random();
        int[] randomlyCreatedArray = new int[numberOfArrayElements];
        for (int i = 0; i < randomlyCreatedArray.length; i++) {
            randomlyCreatedArray[i] = randomNumber.nextInt();
        }
        setRandomArray(randomlyCreatedArray);
    }
}
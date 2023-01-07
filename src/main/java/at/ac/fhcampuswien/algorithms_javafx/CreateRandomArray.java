package at.ac.fhcampuswien.algorithms_javafx;
import java.util.Random;

/**
 * The CreateRandomArray class creates a random unsorted int array based
 * on the size that the user selects.
 */
public class CreateRandomArray {

    /**
     * An array of integers used for storing random values.
     */
    private int[] randomArray;

    /**
     * Sets the value for the random Array.
     *
     * @param randomArray the new value for the random Array.
     */
    private void setRandomArray(int[] randomArray) {
        this.randomArray = randomArray;
    }

    /**
     * Get the value of the random Array.
     *
     * @return the value of the random Array.
     */
    public int[] getRandomArray() {
        return randomArray;
    }

    /**
     * @param numberOfArrayElements
     *        The number of array elements that are selected by the user
     */
    public CreateRandomArray(int numberOfArrayElements) {

        // Create a new Random object
        Random randomNumber = new Random();

        // Create a new array with the specified number of elements
        int[] randomlyCreatedArray = new int[numberOfArrayElements];

        // Fill the array with random numbers
        for (int i = 0; i < randomlyCreatedArray.length; i++) {
            randomlyCreatedArray[i] = randomNumber.nextInt();
        }
        // Set the class's randomArray field to the newly created array
        setRandomArray(randomlyCreatedArray);
    }
}
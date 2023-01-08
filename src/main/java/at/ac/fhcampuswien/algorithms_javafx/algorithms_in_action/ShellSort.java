/**
 * Shell sort is an algorithm that is a generalized version of insertion sort.
 * It is a comparison-based sorting algorithm that allows you to sort a list
 * of elements by comparing elements that are a certain number of positions
 * apart, rather that comparing adjacent elements like in insertion sort.
 * Shell sort improves performance compared to insertion sort, because we
 * eliminate the need to shift many indexes in the array, while at the same
 * time remaining pretty simple to use.
 */

package at.ac.fhcampuswien.algorithms_javafx.algorithms_in_action;

public class ShellSort {

    private int arraySize;
    private int[] myArray;

    public ShellSort(int arraySize) {
        this.arraySize = arraySize;
        this.myArray = new int[arraySize];
        generateRandomArray();
    }

    public void shellSort() {
        /*
        The inner part of the array stands for value that is being
        sorted with its outer part of the array. The inner and outer parts of  the array
        are separated by some number of spaces(interval).
         */
        int inner;
        int outer;
        int temp;
        int interval = 1;  // Interval stands for number of spaces between items.
        int store_interval;

        while (interval <= arraySize / 3) {
            interval = interval * 3 + 1;  // Array items which are 4 spaces apart are being sorted.
            store_interval = interval;

            while (interval > 0) {
                // We keep looping until the interval is 1.
                // After the interval is one, this becomes an insertion sort.
                // Then we can use insertion sort to sort out our array completely.

                for (outer=interval; outer<arraySize; outer++) {
                    // We continue incrementing outer until the end of the array is reached.

                    /*
                    Store the value of the array in temp unless it has to be copied to a space
                    occupied by a bigger number closer to the beginning.
                     */
                    temp = myArray[outer];
                    System.out.println("Store " + myArray[outer] + " into temp");

                    /*
                    We assign inner the value of the highest index to check against all values that
                    proceed it.
                    If a number is greater than temp along the way it will be moved up in the array.
                     */
                    inner = outer;
                    System.out.println("Make sure " + myArray[inner-interval] + " in index "
                        + (inner - interval) + " is bigger than " + temp);

                    while (inner>interval-1 && (inner-interval>=0 && myArray[inner-interval]>=temp)) {
                        /*
                        As long as there is a number bigger than temp move it further up in the array.
                         */
                        System.out.println("In while checking if " + myArray[inner-interval] +
                                " in index " + (inner - interval) + " is bigger than " + temp);

                        printHorizontalArray(inner, outer, interval);
                        /*
                        Make room for the smaller temp by moving values in the array up one space
                        if they are greater than temp.
                         */
                        myArray[inner] = myArray[inner-interval];
                        System.out.println(myArray[inner-interval] + " moved to index " + inner);

                        inner -= interval;
                        System.out.println("inner = " + inner);
                        printHorizontalArray(inner, outer, interval);

                        System.out.println("outer = " + outer);
                        System.out.println("temp = " + temp);
                        System.out.println("interval = " + interval);
                    }
                    /*
                    Now that everything has been moved into place put the value stored in temp into
                    the index above the first value smaller than it is.
                     */
                    myArray[inner] = temp;
                    System.out.println(temp + " moved to index " + inner);
                    printHorizontalArray(inner, outer, interval);
                }
                interval = (interval - 1) / 3;  // Decrement spaces between indexes that are being compared.

            }
            interval = store_interval * 3 + 1;
            //break;
        }
    }

    public int[] getMyArray() {
        return this.myArray;
    }

    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {
            /*
            Generate a random array with values between 10 and 59.
             */
            myArray[i] = (int) (Math.random() * 50) + 10;
        }
    }

    public void printHorizontalArray(int i, int j, int h) {

        if (i == j) {
            i = i - h;
        }

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }
        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.print("| " + n + "  ");
        }
        System.out.println("|");

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }
        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.print("| " + myArray[n] + " ");
        }
        System.out.println("|");

        for (int n = 0; n < 51; n++) {
            System.out.print("-");
        }
        System.out.println();

        if (i != -1) {
            // Number of spaces to put before the F.
            int spacesBeforeFront = 5 * i + 1;
            for (int k = 0; k < spacesBeforeFront; k++) {
                System.out.print(" ");
            }
            System.out.print("I");

            // Number of spaces to put before the R.
            int spacesBeforeRear = (5 * j + 1 - 1) - spacesBeforeFront;
            for (int l = 0; l < spacesBeforeRear; l++) {
                System.out.print(" ");
            }
            System.out.print("O");
            System.out.println("\n");
        }
    }
}




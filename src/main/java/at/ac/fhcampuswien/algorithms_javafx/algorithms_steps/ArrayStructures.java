/**
 * An algorithm is a series of steps to take to manipulate data.
 * Data structures are the way data is arranged in memory.
 */

package at.ac.fhcampuswien.algorithms_javafx.algorithms_steps;

import javafx.application.Application;

import java.util.Arrays;
import java.util.Scanner;


public class ArrayStructures {
    private int[] array = new int[10];
    private int arraySize = 10;

    public int[] getArray() {
        return array;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void generateRandomArray() {
        for (int i=0; i<arraySize; i++) {
            // Numbers between 10 bis 19.
            array[i] = (int) (Math.random()*10) + 10;
        }
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



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("Choose an algorithm from the following list to see" +
                    "how it sorts step by step:");
            System.out.println("[1 = BubbleSort, 2 = BubbleSortVisualization, 3 = InsertionSort,  4 = InsertionSortVisualization, " +
                    "5 = QuickSort, 6 = QuickSortVisualization, 7 = SelectionSort, 8 = SelectionSortVisualization, " +
                    "9 = ShellSort, 10 = ShellSortVisualization]");
            System.out.println("Enter (exit) to quit.");
            userInput = scanner.next();

            switch (userInput) {
                case "1":
                    BubbleSort myBubble = new BubbleSort();
                    System.out.println("Array to be sorted: ");
                    System.out.println(Arrays.toString(myBubble.getArray()));
                    System.out.println();
                    myBubble.bubbleSort();
                    System.out.println();
                    System.out.println("Sorted Array: ");
                    System.out.println(Arrays.toString(myBubble.getArray()));
                    System.out.println();
                    break;
                case "2":
                    BubbleSortVisualization bubbleSortVisualization = new BubbleSortVisualization();
                    try {
                        Application.launch(bubbleSortVisualization.getClass());
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println();
                    }
                    break;
                case "3":
                    InsertionSort myInsertion = new InsertionSort();
                    System.out.println("Array to be sorted: ");
                    System.out.println(Arrays.toString(myInsertion.getArray()));
                    System.out.println();
                    myInsertion.insertionSort();
                    System.out.println();
                    System.out.println("Sorted Array: ");
                    System.out.println(Arrays.toString(myInsertion.getArray()));
                    System.out.println();
                    break;
                case "4":
                    InsertionSortVisualization insertionSortVisualization = new InsertionSortVisualization();
                    try {
                        Application.launch(insertionSortVisualization.getClass());
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println();
                    }
                    break;
                case "5":
                    QuickSort myQuickSort = new QuickSort(10);
                    System.out.println("Array to be sorted: ");
                    System.out.println(Arrays.toString(myQuickSort.getMyArray()));
                    // Every item smaller than 35 will be on the left and
                    // everything bigger will be on the right
                    myQuickSort.quickSort(0, 9);
                    System.out.println("Sored Array: ");
                    System.out.println(Arrays.toString(myQuickSort.getMyArray()));
                    System.out.println();
                    break;
                case "6":
                    QuickSortVisualization quickSortVisualization = new QuickSortVisualization();
                    try {
                        Application.launch(quickSortVisualization.getClass());
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println();
                    }
                    break;
                case "7":
                    SelectionSort mySelection = new SelectionSort();
                    System.out.println("Array to be sorted: ");
                    System.out.println(Arrays.toString(mySelection.getArray()));
                    System.out.println();
                    mySelection.selectionSort();
                    System.out.println();
                    System.out.println("Sorted Array: ");
                    System.out.println(Arrays.toString(mySelection.getArray()));
                    System.out.println();
                    break;
                case "8":
                    SelectionSortVisualization selectionSortVisualization = new SelectionSortVisualization();
                    try {
                        Application.launch(selectionSortVisualization.getClass());
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println();
                    }
                    break;
                case "9":
                    ShellSort myShell = new ShellSort(10);
                    System.out.println("Array to be sorted: ");
                    System.out.println(Arrays.toString(myShell.getMyArray()));
                    System.out.println();
                    myShell.shellSort();
                    System.out.println();
                    System.out.println("Sorted Array: ");
                    System.out.println(Arrays.toString(myShell.getMyArray()));
                    System.out.println();
                    break;
                case "10":
                    ShellSortVisualization shellSortVisualization = new ShellSortVisualization();
                    try {
                        Application.launch(shellSortVisualization.getClass());
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println();
                    }
                    break;
                case "exit":
                    userInput = "exit";
                    break;
                default:
                    System.out.println("Please choose an algorithm from the given list.");
                    System.out.println();
            }
        } while (!(userInput.equals("exit"))) ;

    }
}

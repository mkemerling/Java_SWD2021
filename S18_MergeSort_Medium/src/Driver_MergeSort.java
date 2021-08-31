import java.util.Random;

/**
 * This is the driver class for the entire program and holds the main method
 */
public class Driver_MergeSort {
    static int[]  temp2; // original array

    /**
     * This is the main method for the program which creates an object of the MergeSortAlgo class
     * @param args
     */
    public static void main(String[] args) {
        MergeSortAlgo mergeSort = new MergeSortAlgo(); //create an object of the MergeSortAlgo class

        temp2 = new int[100]; // initialize

        Random rand = new Random(); //instance of random class
        int upperbound = 1000; // setting upperbound of random numbers
        System.out.println("Here is your unsorted array:");
        for(int i = 0; i < 100; i++){ // adding the numbers to the array
            int int_random = rand.nextInt(upperbound);
            temp2[i] = int_random; // adding random #
            System.out.println(int_random); // printing out unsorted array
        }
        mergeSort.SortAlgorithm(temp2); // merging and sorting array
        System.out.println("Here is your sorted array:");
        for(int i = 0; i < temp2.length; i++){ // adding the numbers to the array
            //int int_random = rand.nextInt(upperbound);
            System.out.println(temp2[i]); // print out sorted array
        }
    }


}

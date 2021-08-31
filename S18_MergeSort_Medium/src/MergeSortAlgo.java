import java.util.Arrays;

/**
 * This class holds all of the functionality for the program
 * It sorts and merges a random integer array of 100 ints from 0-1000
 */
public class MergeSortAlgo {
    /**
     * This is a recursive method that sorts the array until broken down to length of 1
     * @param input
     */
    public void SortAlgorithm(int[] input){
        if(input.length <= 1){ // exit statement for recursion
            return;
        }
        int half = input.length/2; // length/2
        int[] leftHalf = new int[half]; // new array with half of the inputted length
        int[] rightHalf = new int[half]; // new array with half of the inputted length
        int[] finalArray1 = new int[100]; // making a new final array

        //copying the integers
        leftHalf = Arrays.copyOfRange(input,0, half);
        rightHalf = Arrays.copyOfRange(input, half, input.length);

        //recursively call
        SortAlgorithm(leftHalf);
        SortAlgorithm(rightHalf);
        int temp = leftHalf.length /2;
        MergeAlgo(leftHalf,rightHalf,input, rightHalf.length,temp );

}

    /**
     * This is the Merge Algorithm that takes all of the integer arrays and merges them in order
     * @param left Left half of the array
     * @param right Right half of the array
     * @param finalArray the final array
     * @param rightSize the size of the right array
     * @param mid the middle point of the array
     */
    public void MergeAlgo(int[] left, int[] right, int[] finalArray, int rightSize, int mid){

        // 'Pointers' for each of my arrays
        int a=0;
        int b=0;
        int c=0;

    // While a is less than left length and b is left than right length
    while(a < left.length && b < right.length) {
        // checking which is lowest
        //then increments that 'pointer'
        if (left[a] < right[b]) {
            finalArray[c] = left[a];
            a++;
        } else {
            finalArray[c] = right[b];
            b++;
        }
        c++; // increments the final array pointer
    }
    // if the right array is finished
    while(a < left.length){
        finalArray[c] = left[a];
        a++;
        c++;
    }
    //if the left array is finished
    while(b < right.length){
        finalArray[c] = right[b];
        b++;
        c++;
    }
}
}

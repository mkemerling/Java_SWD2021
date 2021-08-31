import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


/**
 * This class is to Decode the messages that were inputted
 */
public class Decode {
    /**
     * This method is to search through the alphabet for the targeted character,
     * and replacing it with the n-shifted new character. Only for Decoding
     * @param alphabet is for the alphabet array
     * @param targetLetter is the letter to shift by n
     * @param start is the location the key should be starting at
     * @param toDecode is the string inputted, that will be decoded
     * @return is a string of the 'decoded' message
     */

    public static String search2(char[] alphabet, Character targetLetter, String toDecode, int start) {
        String decoded= "";
        char space = ' ';
        int startHere = start; // getting the starting position for the key
        Scanner scanIn = null;
        // try catch loop incase you cannon read in the file
        try {
            scanIn = new Scanner(new File("encodeKeys"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int[] nValues = new int[100]; // creating a new array from the read in file
        int k = 0;
        for(int a=0; a <= 99; a++){ // filling the array with the same keys as encode
            nValues[a]= scanIn.nextInt();
        }
        int[] invertedNValues = new int[100]; // creating a new array of the inverted key array
        for(int w=0; w <+ invertedNValues.length; w++){ // filling the new array of inverted key array

            invertedNValues[w]= nValues[99-w];
        }
        System.out.println(Arrays.toString(nValues)); //These are able to be commented out to see the full arrays
        System.out.println(Arrays.toString(invertedNValues));

        if((startHere - toDecode.length()) < 0){
            startHere = 100 - Math.abs(startHere-toDecode.length());
        }

        else{ startHere = startHere - toDecode.length();} // Giving the starting point the correct beginning key
        for (int j = 0; j < toDecode.length(); j++) {
            targetLetter = toDecode.charAt(j); // finds & creates a target for each letter of the string
            for (int i = 0; i < alphabet.length; i++) { // searches through alphabet for target letter
                if (alphabet[i] == targetLetter) {
                    System.out.println(startHere);
                    System.out.println(invertedNValues[startHere]);
                    System.out.println(invertedNValues[startHere]);
                    if (((i % alphabet.length) - invertedNValues[99- startHere]) < 0) { // this creates a circular array for my alphabet to be accessed
                        int b = i % alphabet.length - invertedNValues[99- startHere] + alphabet.length; // circular array calculation
                        decoded = decoded + alphabet[b];// adds the encoded letter to the new string
                    } else {
                        decoded = decoded + alphabet[(i % alphabet.length) - invertedNValues[99-startHere]];// adds the encoded letter to the new string
                    }
                }
            }
            startHere++; // This traverses the N value over to the next one
            if (startHere < 0) { // Creates a circular array incase the N value goes over
                startHere = 99;
            }
            if (startHere > 99) {
                startHere = 0;
            }
            if (targetLetter == space) { // This is to add spaces where necessary
                decoded += " ";
            }
        }
        //System.out.println("The new location of the key is at " + startHere);
        return decoded; //returning the decoded string
    }
}

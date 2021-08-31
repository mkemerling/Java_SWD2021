import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * This Class is to Encode an inputted message
 */
public class Encode {

    /**
     * This method is to search through the alphabet for the targeted character,
     * and replacing it with the n-shifted new character. Only for Encoding
     * @param alphabet is for the alphabet array
     * @param targetLetter is the letter to shift by n
     * @param toEncode is the string inputted, that will be encoded
     * @return is a string of the 'encoded' message
     */
    public static String search(char[] alphabet, Character targetLetter, String toEncode, int start) {
        String encoded = "";
        int startHere = start; // inputting the int where the user wanted the key to begin
        char space = ' '; // In case a space is put into the message
        //A try-catch method to catch any exception or issue
        try {
            Scanner scanIn = new Scanner(new File("encodeKeys")); //reading from the file of generated keys
            int[] nValues = new int[100]; // creates a new array for the file inputs
            int k = 0;
            for(int a=0; a <= 99; a++){
                nValues[a]= scanIn.nextInt(); // while the scanner is able to get the next input, it puts it into the array
            }
            //System.out.println(Arrays.toString(nValues)); Able to be commented out to get the arrays of keys

            for (int j = 0; j < toEncode.length(); j++) {
                targetLetter = toEncode.charAt(j); // finds & creates a target for each letter of the string
                for (int i = 0; i < alphabet.length; i++) { // searches through alphabet for target letter
                    if (alphabet[i] == targetLetter) {
                        if (((i % alphabet.length) + nValues[startHere]) >= 26) { // this creates a circular array for my alphabet to be accessed
                            int b = i % alphabet.length + nValues[startHere] - alphabet.length; // circular array calculation
                            encoded = encoded + alphabet[b];// adds the encoded letter to the new string
                        } else {
                            encoded = encoded + alphabet[(i % alphabet.length) + nValues[startHere]];// adds the encoded letter to the new string

                        }
                    }
                }
                startHere++; // moving the key over 1
                if(startHere > 99){ //creates a circular array
                    startHere = 0;
                }
                if(targetLetter == space) {
                    encoded += " "; // keeps adding a space every time
                }
            }
        } catch (FileNotFoundException e) { // if the file is not found
            e.printStackTrace();
        }

        System.out.println("The new location of the key is at " + startHere); // printing out the location of the keys
        return encoded; // returning the encoded string
    }
}


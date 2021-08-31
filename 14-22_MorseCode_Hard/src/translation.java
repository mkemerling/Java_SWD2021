import java.util.Arrays;

/**
 * This class is the class that translates from alphabet to morse and from morse to alphabet
 */
public class translation {
    /**
     * Array of alphabet letters and numbers, final to ensure it is not used outside of this class, and static so the reference cannot be changed
     */
    final static char alphabetLetters[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','1','2','3','4','5','6','7','8','9','0'};
    /**
     * Array of morse letters and numbers, final to ensure it is not used outside of this class, and static to the reference cannot be changed
     */
    final static String morseCode[] = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----"};

    /**
     * This class takes a string of alphabet letters and returns it in morse
     * @param alphabetInput The string input of alphabet letters
     * @return String of morse
     */
    public static String alphabetToMorse(String alphabetInput){
        String string = " ";
        //for loop going through the string input and making it a character array
        for(char c : alphabetInput.toCharArray()){
            char temp; // making a temp character
            temp = c; // assigning it to whatever iteration the loop is on
            if((c >= 97) && (c <= 122)){ // this is ensuring it is uppercase if the user inputs lowercase
                temp -= 32; // see ASCII tables
            }
            //for loops going through upper and lowercase alphabets
            for(int i = 0; i < alphabetLetters.length; i++){
                if (alphabetLetters[i] == temp) { // uppercase letters
                    string += morseCode[i];
                }
            }
            string += " "; // adding a space between the words
        }
        return string;
    }

    /**
     * This class takes a String of morse letters and words and returns its english alphabet equivalent
     * @param morseInput The morse code phrase to be translated
     * @return String of english alphabet letters
     */
    public static String morseToAlphabet(String morseInput){
       String finalString = "";
        String [] morseWords = morseInput.split("\\s{3}");
        // splitting up morse words which are separated by 3 spaces
        for (String morseWord : morseWords) {
            String[] morseLetters = morseWord.split("\\s");
            // splitting up the morse words into individual letters
            for (String morseLetter : morseLetters) { // goes through each of those letters to find corresponding letter
                for (int k=0; k < morseCode.length; k++) {
                    if (morseLetter.equals(morseCode[k])) {
                        finalString += alphabetLetters[k];
                    }
                }
            }
            finalString += " "; // creating spaces between the words
        }
        return finalString;
    }
}

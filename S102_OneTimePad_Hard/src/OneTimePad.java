import java.util.Scanner;

/**
 * This class is the driver class to Encode/Decode 'Passwords'
 *  Utilizes an input message and number to shift by
 *  Outputs an encoded or decoded message
 */
public class OneTimePad {
    /**
     * This is the main method for writing the program
     * @param args This is the normal Main parameter
     */
    public static void main(String[] args) {
        //Declarations
        final char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String toEncode; //What will be encoded
        String toDecode; // What will be decoded
        //int nEncode; //The n shift of the coding (This is for the easy One Time Pad)
        //int nDecode; // The n shift of the decoding (This is for the easy One Time Pad)
        String encoded; //The encoded string
        String decoded; // The decoded string
        int nShift; // N values to be generated
        final int numberOfKeys = 100; // hard coded the number of keys to be generated
        int current; //Where the keys start from, the user will input


        //User Input and calling different methods
        Scanner in = new Scanner(System.in); // Creating Scanner input
        System.out.print("Would you like to encode or decode a message...put 1 for encode, 2 for decode, 3 to exit: ");
        // Input to encode/decode/exit
        String input = in.next();
        if (input.length() > 1) { // This is if the user puts in giberish
            System.out.println(" Invalid Input:Please try again.");
        } else {
            char c = input.charAt(0);
            if ((c == '1') || (c == '2')) { // If they want to encode or decode
                if (c == '1') {  // This is the if loop for encoding
                    in.nextLine();
                    System.out.print("Please type the message you would like to encode: ");
                    toEncode = in.nextLine(); // message to be encoded
                    toEncode = toEncode.toUpperCase(); // ensuring it is all in uppercase

                    KeyGenerator toEncodeKey = new KeyGenerator(); // Creating a new Key
                    toEncodeKey.Key("encodeKeys", 100); //Filling the new key
                    System.out.print("Where in the keys where you like to start? Type an integer between 0-99." );
                    current= in.nextInt(); // Where the user would like the key to start
                    if((current < 0) || (current > 99)){
                        System.out.println("Please try again by entering an integer between 0-99");
                        current = in.nextInt();
                        if((current < 0) || (current > 99)){
                            System.out.println("You failed to put in an integer between 0-99. The key position will automatically be set to 20");
                            current = 20;
                        }
                    }

                    //System.out.print("What is the n offset for your message? Integer only. :"); (This is for the Easy version)
                    //nEncode = in.nextInt(); // n shift for encoding (This is for the Easy version)
                    encoded = Encode.search(alphabet, null, toEncode, current); // calling the search function to encode
                    System.out.print(encoded); // printing out the encoded
                } else {
                    in.nextLine();
                    System.out.print("Please type the message you would like to decode: "); //user input
                    toDecode = in.nextLine(); // message to be encoded
                    toDecode = toDecode.toUpperCase(); // making it all uppercase

                    System.out.print("Where in the keys where you like to start? Type an integer." ); // where the key should start
                    current= in.nextInt(); //taking in the input
                    //This was to check exceptions,  I implemented it into the code, so there is no need
                    //if (current - toDecode.length() < 0){ //if the length is greater than the current key location
                     //   System.out.println(" Your input was invalid, please try again");
                      //  System.out.print("Where in the keys where you like to start? Type an integer." );
                      //  current= in.nextInt(); //2nd attempt
                      //  if(current - toDecode.length() < 0){
                      //      System.out.println("You had another invalid input, please re-run the program and try again.");
                            //return;
                       // }
                   // }
                    //System.out.print("What is the n offset for your message? Integer only. :"); (For easy version)
                    //nDecode = in.nextInt(); // n shift for encoding (For easy version)
                    decoded = Decode.search2(alphabet, null, toDecode, current); // Calling the search function
                    System.out.print(decoded); // printing out the decoded message
                }
            } else if (c == '3') { // This is if somebody wanted to leave the program
                System.out.println("You chose to exit the program. Have a nice day!");
            } else { // This is if there was an invalid input to the program
                System.out.println("Your input was invalid. Please try again.");
            }
        }
    }
}


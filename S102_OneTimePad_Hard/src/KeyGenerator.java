import java.io.*;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;

/**
 * This class is to generate the keys to the file
 */
public class KeyGenerator {
   Random randomKeys = new Random(); //Making the new random keys

   /**
    * This method creates the key into a file
    * @param file This is the file the key will be put into
    * @param numberOfKeys This is the number of random n values to be created
    */
   public void Key(String file, int numberOfKeys){
      try{
         BufferedWriter enterFile = new BufferedWriter(new FileWriter(file)); // Making a new file to write to
         for(int i = 0; i <= numberOfKeys; i++){ // Create random integers
            int randomInteger = randomKeys.nextInt(25 );
            enterFile.write(randomInteger+""); //Writing it to file
            enterFile.write(' '); // ensuring a space between
         }
         enterFile.close(); // closing the file
      }
      catch(IOException io){ //catching any exception
         System.out.println("Could not create file.");
      }
   }
}


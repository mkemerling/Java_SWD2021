import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import java.util.Locale;

/**
 * This is the guiComponent class that extends the JFrame class which makes the gui possible
 */
public class guiComponent extends JFrame {
    /**
     * This is the integer for guesses left
     */
    private int guessesLeftInt = 6;
    /**
     * This is the String for letters previously guessed by user
     */
    private String lettersGuessedString = "";
    /**
     * This is the String the user needs to guess
     */
    private String wordGuessString = "spring";
    /**
     * This is the corresponding character array to the word the user needs to guess
     */
    private char[] wordGuessCharArray = wordGuessString.toCharArray();
    /**
     * This is what the user sees as the word to guess, until they correctly guess letters
     */
    private String hiddenWord = "------";
    /**
     * This is the hidden Word to a character array for easier computation on the back end
     */
    private char[] hiddenWordArray = hiddenWord.toCharArray();

    /**
     * This is a private variable for a JLabel on a JTextField
     */
    private final JLabel title1;

    /**
     * This is a private variable for a JTextField in the GUI
     */
    private final JTextField wordGuess;
        /**
        * This is a private variable for a JLabel on a JTextField
        */
        private final JLabel title2;
         /**
         * This is a private variable for a JTextField in the GUI
        */
        private final JTextField lettersGuessed;
         /**
         *    This is a private variable for a JTextField in the GUI
        */
        private final JTextField numberOfGuessesLeft;
         /**
        * This is a private variable for a JLabel on a JTextField
        */
        private final JLabel title3;
        /**
         *    This is a private variable for a JTextField in the GUI
        */
        private final JTextField wordToGuess;
        /**
        * This is a private variable for a JLabel on a JTextField
        */
         private final JLabel title4;
        /**
        * This is a private variable for a JLabel on a JTextField
        */
         private final JLabel title5;
        /**
        *    This is a private variable for a JTextField in the GUI
        */
         private final JTextField letterGuess;
        /**
        * This is a private variable for a JLabel on a JTextField
         */
         private final JLabel hangman9Title;

    /**
     * This is the constructor for the JFrame
     */
    public guiComponent(){ // this is the J frame gui constructor
            //Calling super constructor
            super("Hangman"); // setting JFrame title
            setLayout(new FlowLayout()); // Setting layout to flow

            //Editable text box to enter word guess
            title1 = new JLabel("Guess the word here:"); //initializing the JLabel
            add(title1); // Adding the label to the frame
            wordGuess = new JTextField(20);
            add(wordGuess); // adding to GUI
            title1.setLabelFor(wordGuess); // setting label

            //Uneditable text field to see previous guesses
            title2 = new JLabel("Letters Previously Guessed"); //initializing the JLabel
            add(title2); // adding the label to the frame
            lettersGuessed = new JTextField(20);
            add(lettersGuessed); //adding to GUI
            title2.setLabelFor(lettersGuessed);
            lettersGuessed.setEditable(false); // the user cannot edit it
            lettersGuessed.setText(lettersGuessedString.toLowerCase(Locale.ROOT)); // making it lowercase

            //Uneditable text Field showing number of guesses left
            title3 = new JLabel("Number Of Guesses Left"); //setting JLabel
            add(title3); //adding to GUI
            numberOfGuessesLeft = new JTextField();
            add(numberOfGuessesLeft); //adding to the GUI
            title3.setLabelFor(numberOfGuessesLeft);
            numberOfGuessesLeft.setEditable(false); // the user cannot edit it
            numberOfGuessesLeft.setText(String.valueOf(guessesLeftInt)); // setting the text

            //Hidden Words to guess
            title4 = new JLabel("This is the word to guess");
            add(title4); //adding to GUI
            wordToGuess = new JTextField(Arrays.toString(hiddenWordArray)); // showing the hidden word
            add(wordToGuess); // add passwordField to JFrame
            title4.setLabelFor(wordToGuess); //setting the label
            wordToGuess.setEditable(false); // uneditable to user

            //Where the user can guess a letter
            title5 = new JLabel("Type in a letter to guess");
            add(title5); // adding the title
            letterGuess = new JTextField(1); //initializing
            add(letterGuess); //adding to GUI
            title5.setLabelFor(letterGuess); //setting the label

            eventHandler eventHandler = new eventHandler(); // creating a new KeyListener event handler
            wordHandler eventHandlerWord = new wordHandler(); // ActionListener for wordHandler

            letterGuess.addKeyListener(eventHandler); //adding key listener to letter Guess JTextField
            wordGuess.addActionListener(eventHandlerWord); // adding action to word guess JTextField

            //Adding a title for the hangman
            hangman9Title = new JLabel("Here is your Hangman");
            add(hangman9Title); //Add to GUI
}
    /**
     * This is the function that checks the users input against the hidden worf
     * @param letterGuessed This is what the user inputs to the GUI
     */
    public void letterGuessedFunction(char letterGuessed){
        //If the input is a capital letter
        if((letterGuessed >= 65) && (letterGuessed <= 90)){ // this is ensuring it is uppercase if the user inputs lowercase
            letterGuessed -= 32; // see ASCII tables
        }
        //character array of guess of user
        char [] guessOfUser = new char[wordGuessCharArray.length]; // makes guessOfUser same length as wordGuessCharArray
        int correct = 0; // throwaway variable
        Arrays.fill(guessOfUser, '-'); // making a "copy" of the ray
        for(int i = 0; i < wordGuessCharArray.length; i++){ //copying the array bc you can't just assign in in java
           if(wordGuessCharArray[i] == letterGuessed){ // if the letter of the word = the guessed letter
               hiddenWordArray[i] = letterGuessed; // it is revealed in the hidden array
               wordToGuess.setText(String.valueOf(hiddenWordArray)); //showing the value
               correct++; // this is incrementing the throwaway variable
           }
           else {
               correct = correct + 2; //if the guess was not correct
           }
        }
        if(correct % 2  == 0){ // if correct is divisible by 2 with a remainder of 0
            guessesLeftInt--; // guesses decrement
            numberOfGuessesLeft.setText(String.valueOf(guessesLeftInt)); //setting text in numberOfGuessesLeft
            lettersGuessedString += letterGuessed; // adding the letter on to the string
            lettersGuessed.setText(lettersGuessedString); // setting the text in the GUI
            repaint(); // calling the paint function to update
        }
        // if the user ran out of guesses
        if(guessesLeftInt <= 0){
            wordGuess.setText("GAME-OVER, YOU LOSE!");
            letterGuess.setEditable(false); // the user is no longer able to edit it
        }
    }

    /**
     * This is to check if the game has been completed or not
     * @return boolean True or False depending on the game
     */
    private boolean completed(){
            int count = 0; // throwaway variable
        for(int j = 0; j < hiddenWordArray.length; j++){
            if(hiddenWordArray[j] =='-'){ // if the hiddenWord still has a blank spot
               count++;
            }
        }
       if(count == 0){ // if there are no blank spots in the hidden word
           return true;
       }
       else{
           return false; // still blank spots, game is not over
       }
    }

    /**
     * This is the event handler to listen if the user types in the word to guess
     */
    private class wordHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            String guess = wordGuess.getText(); //getting the word they guessed
            if(wordGuessString.equals(guess)){ // if it is the same
                wordGuess.setText("GAME-OVER. YOU WON!");
            }
            else{
                wordGuess.setText("TRY AGAIN, INCORRECT"); // if the user guessed incorreclt
                guessesLeftInt--; // decrement guess
                numberOfGuessesLeft.setText(String.valueOf(guessesLeftInt));

            }
        }
    }

    /**
     * This is the event handler to get the letter typed by the user
     * Because this implements KeyListener which is an interface, it needs to implement every method of the interface
     */
    private class eventHandler implements KeyListener{
        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) { //only method implemented
            String text = letterGuess.getText(); //gets text
            letterGuessedFunction(text.charAt(0)); // only gets the first char
            letterGuess.setText(""); // sets JTextField to 0 to clear it
            if(completed()){ // checks if game is completed
                wordGuess.setText("GAME-OVER, YOU WIN");
            }
        }
    }

    /**
     * This paint function is a method of the container, called by repaint()
     * This draws the hang man for each incorrect guess
     * @param g Graphics
     */
    public void paint(Graphics g){
        super.paint(g); // calling the super from JComponent which JFrame is a JComponent
        Graphics2D g2d = (Graphics2D) g; //casting g as 2DGraphic
        g2d.setPaint(Color.BLACK); // setting color to black
        if(guessesLeftInt == 5) { // if the user has guessed 1 incorrect
            g2d.drawOval(150, 300, 50, 50); // head
        }
        if(guessesLeftInt == 4) { // if the users 2 incorrect guesses
            g2d.drawOval(150, 300, 50, 50); // head
            g2d.drawLine(175, 350, 175, 450); // body
        }
        if(guessesLeftInt == 3) { // if the user has 3 incorrect guesses
            g2d.drawOval(150, 300, 50, 50); // head
            g2d.drawLine(175, 350, 175, 450); // body
            g2d.drawLine(175, 375, 225, 425); // arm
        }
        if(guessesLeftInt == 2) { // if the user has 4 incorrect guesses
            g2d.drawOval(150, 300, 50, 50); // head
            g2d.drawLine(175, 350, 175, 450); // body
            g2d.drawLine(175, 375, 225, 425); // arm
            g2d.drawLine(175, 375, 125, 425); //arm
        }
        if(guessesLeftInt == 1) { // if the user has 5 incorrect guesses
            g2d.drawOval(150, 300, 50, 50); // head
            g2d.drawLine(175, 350, 175, 450); // body
            g2d.drawLine(175, 375, 225, 425); // arm
            g2d.drawLine(175, 375, 125, 425); //arm
            g2d.drawLine(175, 450, 225, 525); //leg
        }
        if(guessesLeftInt == 0) { // if the user has 6 incorrect guesses
            g2d.drawOval(150, 300, 50, 50); // head
            g2d.drawLine(175, 350, 175, 450); // body
            g2d.drawLine(175, 375, 225, 425); // arm
            g2d.drawLine(175, 375, 125, 425); //arm
            g2d.drawLine(175, 450, 225, 525); //leg
            g2d.drawLine(175, 450, 125, 525); //leg
        }
    }
}




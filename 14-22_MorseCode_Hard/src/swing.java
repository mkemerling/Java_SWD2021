import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This is the swing class that extends JFrame to display a frame on the user's screen
 */
public class swing extends JFrame {
    /**
     * This is the label for the first text box that is Alphabet to Morse
     */
    private final JLabel title1; // Creating a label for alphabet to morse
    /**
     * This is the first user editable text box for Alphabet to Morse
     */
    private final JTextField toMorse; // Creating a text field to enter for alphabet to morse
    /**
     * This is the label for the second text box, that is Morse to Alphabet
     */
    private final JLabel title2; // Creating a label for alphabet to morse
    /**
     * This is the second user editable text box for Morse to Alphabet
     */
    private final JTextField toAlphabet; // Creating a text field to enter for morse to alphabet

    /**
     * This is the J Frame constructor
     */
    public swing(){ // this is the J frame gui constructor
        //Calling super constructor
        super("Morse/Alphabet Conversion"); // setting JFrame title
        setLayout(new FlowLayout()); // Setting layout to flow

        title1 = new JLabel("Alphabet to Morse Code");
        add(title1); // Adding the label to the frame

        toMorse = new JTextField(20); //Setting "to Morse"  as new text field
        add(toMorse); // adding "to Morse" to the JFrame

        title1.setLabelFor(toMorse); // Setting the label for toMorse

        title2 = new JLabel("Morse Code to Alphabet");
        add(title2); // adding the label to the frame

        toAlphabet = new JTextField(20); // Setting "To alphabet" as new text fields
        add(toAlphabet); // Adding "To Alphabet" to the JFrame

        title2.setLabelFor(toAlphabet); //setting the label for toAlphabet

        realTime eventHandler = new realTime(); // creating a new KeyListener event handler

        toMorse.addKeyListener(eventHandler); // assigning the event handler
        toAlphabet.addKeyListener(eventHandler); // assigning the event handler
    }

    /**
     * This is the realTime class which implements KeyListener as the event handler
     */
    private class realTime implements KeyListener{
        @Override
        /**
         * This method will be called when a key is typed in either box
         */

        /**
         * This is a given method of key listener but not implemented
         */
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        /**
         * This is a given method of key listener but not implemented
         */
        public void keyPressed(KeyEvent keyEvent) {
        }

        @Override
        /**
         * This is the method that determines which box will be translated from
         * This class is a given method of key listener
         */
        public void keyReleased(KeyEvent keyEvent) {
            String returnedFromToMorse; // the string of morse returned
            String returnedFromToAlphabet; // the character returned
            char inputtedToAlphabet = '.';
            if(keyEvent.getSource() == toMorse){ // if the key is typed in toMorse box
                returnedFromToMorse = translation.alphabetToMorse(toMorse.getText()); // the returned string is what is returned
                toAlphabet.setText(returnedFromToMorse); // setting the toAlphabet box to the corresponding morse
            }
            else if (keyEvent.getSource() == toAlphabet){// if the key is typed in toAlphabet
                returnedFromToAlphabet = translation.morseToAlphabet(toAlphabet.getText()); // returns the character associated with inputted morse
                toMorse.setText(returnedFromToAlphabet); // sets the to morse box
            }
        }
    }
}

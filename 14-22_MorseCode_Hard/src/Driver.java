import javax.swing.*;

/**
 * This is the driver class for the swing GUI
 */
public class Driver {
    /**
     * This is the main method that creates a new swing object, sets default close, visibility and size
     * @param args
     */
    public static void main(String[] args) {
        swing textFieldFrame = new swing(); // creating a new swing gui object
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setting closing operations
        textFieldFrame.setSize(400, 200); // setting the ares
        textFieldFrame.setVisible(true); // Making the frame visible
    }
}

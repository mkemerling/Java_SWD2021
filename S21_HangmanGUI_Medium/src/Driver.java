import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;

/**
 * This is the driver class for the swing GUI
 */
public class Driver {
    /**
     * This is the main method that creates a new swing object, sets default close, visibility and size
     * @param args
     */
    public static void main(String[] args) {
        guiComponent textFieldFrame = new guiComponent(); // creating a new swing gui object
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setting closing operations
        textFieldFrame.setSize(300, 600); // setting the ares
        textFieldFrame.setVisible(true); // Making the frame visible
    }
}
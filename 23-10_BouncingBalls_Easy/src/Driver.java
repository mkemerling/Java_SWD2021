import javax.swing.*;
import java.awt.*;

/**
 * This is the Driver class for this program
 */
public class Driver {

    /**
     * This is the main method that holds the implementation for my Driver class
     * @param args Normal input
     */
    public static void main(String[] args) {
        BouncingBall bouncingBall = new BouncingBall(); // creates a new bouncing ball object
        bouncingBall.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit program on close
        bouncingBall.setSize(500,500); //size of frame
        bouncingBall.setVisible(true); //true, we want to see it
        bouncingBall.setBackground(Color.white); //color
    }
}

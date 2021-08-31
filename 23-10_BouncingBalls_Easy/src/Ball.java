import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
//Import statements

/**
 * This class Ball, extends JPanel and implements Runnable
 * The JPanel gives us the capability to draw a ball on the screen
 * And Runnable helps us make this multithreaded program
 */
public class Ball extends JPanel implements Runnable {
    /**
     * This is a variable for the starting point of the ball in the panel
     */
    private double x= 0;
    /**
     * This is a variable for the starting point of the ball in the panel
     */
    private double y = 0;
    /**
     * This is the initialization of the xVelocity, or how much the ball will move by in the x direction
     */
    private double xVelocity = .2;
    /**
     * This is the initialization of the yVelocity, or how much the ball will move by in the y direction
     */
    private double yVelocity = .3;
    /**
     * This is the boolean value to determine if the user has clicked the screen or not
     */
    private boolean clicked = false;

    /**
     * This is the constructor for the ball class
     * Properties of the JPanel are set here
     * A Click Listener is also added here
     */
    public Ball() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(500,500));

        //Adding a click listener to the panel
        clickListener clickListener = new clickListener(); // event handler for the click of the mouse
        this.addMouseListener(clickListener); //adding it to frame
    }

    /**
     * This is the event handler for when the mouse is pressed in the JPanel
     * Since it extends MouseListener, an interface, all of the methods needed to be implemented
     */
    public class clickListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
        }

        @Override
        /**
         * mousePressed will change the clicked boolean value when the mouse is pressed
         */
        public void mousePressed(MouseEvent mouseEvent) {
            clicked = true;
        }
        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
        }
        @Override
        public void mouseEntered(MouseEvent mouseEvent) {
        }
        @Override
        public void mouseExited(MouseEvent mouseEvent) {
        }
    }

    @Override
    /**
     * This is called automatically in the class
     * This is the implementation of the interface Runnable
     */
    public void run() {
        while(true) { // while its being executed
            if (clicked) {
                bounce(); //bounce it
                repaint(); //repaint it
            }
            try {
                Thread.sleep(2); // this is so we can smoothly see the movement
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    /**
     * This is the paintComponent that helps us draw the blue ball once clicked is true
     */
    public void paintComponent(Graphics g) {
       super.paintComponent(g); //calling super
        if(clicked) { // if its clicked
            Graphics2D g2d = (Graphics2D) g; //casting g as 2DGraphic
            g2d.setPaint(Color.BLUE); // setting color to blue
            g2d.fillOval((int)x, (int) y, 40, 40); //filling the ball
        }
    }

    /**
     * This is the bounce function which is responsible for the movement of the ball
     * It changes the x and y values if they go over the 'edge'
     */
    public void bounce(){

        x += xVelocity; //moving it by velocity
        y += yVelocity; // moving it by velocity

        if(x < 0){ //if it goes off the screen
            x = 0; //replace
            xVelocity *= -1; //change velocity
        }
        if(y < 0){ // if it goes off the screen
            y = 0; //replace
            yVelocity *= -1; //change velocity
        }
        if (y > 420){ //if it goes off the screen
            y = 420;
            yVelocity *= -1;
        }
        if(x > 460){ //if it goes off the screen
            x = 460;
            xVelocity *= -1;
        }
    }
}

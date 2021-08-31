import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import statements

/**
 * This class BouncingBall extends the JFrame which will be the GUI the user sees
 */
public class BouncingBall extends JFrame  {

    /**
     * This is the private Ball object that comes from the Ball class
     * The only implementation of this in the BouncingBall class is to create a ball, add it, and create and add
     * the executor service to the ball
     */
    private Ball ball;

    /**
     * This is the constructor of BouncingBall
     * Call's super to add the title to the frame, and layout
     * Creates and adds ball object
     * Creates and adds a new executor service to the ball
     */
    public BouncingBall() {
        super("Click to add bouncing ball");
        setLayout(new FlowLayout());
        ball = new Ball(); //creating the ball
        add(ball); //adding the ball

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(ball); // calling executor service on the ball

        setVisible(true);

        executor.shutdown(); // no new threads will start after this is called

    }
    }



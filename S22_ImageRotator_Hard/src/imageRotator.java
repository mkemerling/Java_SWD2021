import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
//Import statements

//class that extends JFrame to be shown int he GUI

/**
 * This is the imageRotator class that extends JFrame as the base for my GUI
 */
public class imageRotator extends JFrame
{
    /**
     * This is a private JLabel for the degrees of static rotation
     */
    private JLabel labelForDegrees;
    /**
     * This is a private JLabel for the Image to be displayed
     */
    private JLabel labelForDisplayingImg;
    /**
     * This is the private JTextField for the degrees of static rotation
     */
    private JTextField degreesToRotate;
    /**
     * This is the private JButton to start the timer
     */
    private JButton startTimer;
    /**
     * This is the private JButton to end the timer
     */
    private JButton endTimer;
    /**
     * This is the JSlider for the user to change the speed of the continuous rotation
     */
    private JSlider slideToSpeed;
    /**
     * This is the private degree integer to be changed per the user's input
     */
    private int degree = 0;
    /**
     * This is the private Timer that times all of the rotations
     * A timer basically calls its event handler each 'rotation' which is how we give the illusion it is continuous
     */
    private Timer timer;

    //constructor

    /**
     * This is the constructor for the imageRotator class, is takes in an ImageIcon as an argument for the picture to be rotated
     * @param picture
     */
    public imageRotator(ImageIcon picture){
        super("Image Rotator"); // calling the title
        setLayout(new FlowLayout()); // Setting layout to flow

        labelForDegrees = new JLabel(); // creating a new JLabel
        add(labelForDegrees); // adding it to the JFrame
        labelForDisplayingImg = new JLabel(picture){ //inline event handler instead of making a new class
            /**
             * This calls the paintComponent for the JLabel without making a new class
             * @param g Graphic
             */
            public void paintComponent(Graphics g){
                Graphics2D g2d = (Graphics2D) g; //casting g as 2DGraphic
                //rotating it by getting the static degree entered by the user
                g2d.rotate(Math.toRadians(degree), picture.getIconWidth()/2,picture.getIconHeight()/2);
                //drawing the graphic
                g2d.drawImage(picture.getImage(), AffineTransform.getRotateInstance(0),null);
            }
        };
        //setting a ActionListener to the timer
        //6 is just arbitrary, it'll be changed by the user
        timer = new Timer(6, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                degree = degree + 5; // moves by 5 degrees each time for continuous rotation
                labelForDisplayingImg.repaint(); // calling the paint component repaint
            }
        });
        //setting the preferred size for the image
        labelForDisplayingImg.setPreferredSize(new Dimension(200,200));
        add(labelForDisplayingImg); // adding to JFrame

        degreesToRotate = new JTextField(20); // initializing new JTextField
        add(degreesToRotate); // adding to the JFrame
        degreesToRotate.setEditable(true); //editable to be true
        startTimer = new JButton("Start the Rotation"); //initializing JButton
        add(startTimer); //adding
        endTimer = new JButton("End the rotation"); //initializing JButton
        add(endTimer); //adding
        slideToSpeed = new JSlider(1,10,1); //adding the timer, this is in ms
        slideToSpeed.setMinimum(1); //min
        slideToSpeed.setMaximum(10);//max
        //these next lines are for formatting of the slider
        slideToSpeed.setMinorTickSpacing(1);
        slideToSpeed.setSnapToTicks(true);
        slideToSpeed.setMajorTickSpacing(2);
        slideToSpeed.setPaintTicks(true);
        add(slideToSpeed); //adding to screen

        //initializing and assigning event handlers
        degreeHandler degreeHandler = new degreeHandler();
        degreesToRotate.addActionListener(degreeHandler);
        slideChange slideChange = new slideChange();
        slideToSpeed.addChangeListener(slideChange);
        buttonStart buttonStart = new buttonStart();
        buttonStop buttonStop = new buttonStop();
        startTimer.addActionListener(buttonStart);
        endTimer.addActionListener(buttonStop);

    }

    /**
     * This class implements Action Listener to get the static degree the user wants to spin to
     */
    private class degreeHandler implements ActionListener{
        /**
         * Overridden from interface, this is where the code for the action listener is
         * @param actionEvent
         */
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if(degreesToRotate.getText().matches("[0-9]+")){
                degree = Integer.parseInt(degreesToRotate.getText()); //gets the desired degree
            }
            else{
                degree = 0;
            }

            //degree = Integer.parseInt(degreesToRotate.getText()); //gets the desired degree
            labelForDisplayingImg.repaint(); //repaints by calling paint component
        }
    }

    /**
     * This implements Change Listener and is for the slider to know when it has been moved
     */
    private class slideChange implements ChangeListener {
        /**
         * Overridden method from interface where the change listener's computations are
         * @param changeEvent
         */
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            timer.setDelay(slideToSpeed.getValue()*20); // setting the delay, multiplied by 20 to see changes
        }
    }

    /**
     * This is implemented from ActionListener interface, for timer start
     */
    private class buttonStart implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            timer.start();
        }
    }

    /**
     * Event handler for the button to stop the timer
     */
    private class buttonStop implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            timer.stop();
        }
    }
}

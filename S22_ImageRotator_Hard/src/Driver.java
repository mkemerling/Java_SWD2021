import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        //reading in image from file
        BufferedImage image = ImageIO.read(new File("/iahome/m/mm/mmkemerling/Desktop/GIT/mmkemerling_swd/oral_exam2/S22_ImageRotator_Hard/src/golden.jpg"));
        Image resized = image.getScaledInstance(160,80, Image.SCALE_SMOOTH); //rescaling
        ImageIcon picture = new ImageIcon(resized); //setting the new one
        imageRotator textFieldFrame = new imageRotator(picture); // creating a new swing gui object
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // setting closing operations
        textFieldFrame.setSize(300, 400); // setting the area
        textFieldFrame.setVisible(true); // Making the frame visible
    }
}

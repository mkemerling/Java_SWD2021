import java.util.Scanner;

/**
 * This is the driver class to test the functionality
 */
public class Driver {
    /**
     * This is the main class to test the functionality
     * @param args
     */
    public static void main(String[] args) {
        ChangeComputation c = new ChangeComputation();
        c.inputToPennies(); // calling the first method
        c.changeToGive(); // calling the second method
    }
}

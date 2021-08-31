/**
 * This is the scoring component class which ties together the method for scoring and the points associated
 */
public class scoringComponent {

    /**
     * Gets the method name of the scoring method
     * @return The method name
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Gets the method point value
     * @return The point value associated to the method
     */
    public int getMethodPointValue() {
        return methodPointValue;
    }

    //Similar to the Team class, making a scoring component class
    // You never want a scoring component without a score
    /**
     * Private String for method name
     */
    private String methodName;
    /**
     * Private integer for method point value
     */
    private int methodPointValue;

    /**
     * Constructor for the String Component class
     * @param method String of name of method
     * @param pointValue Integer of point value of method
     */
    scoringComponent(String method, int pointValue) {
        this.methodName = method;
        this.methodPointValue = pointValue;
    }
}

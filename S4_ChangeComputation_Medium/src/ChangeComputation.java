import java.util.Scanner;

/**
 * This class holds all the methods to compute and give change to the customers
 */
public class ChangeComputation {
    private Scanner in; // creating the scanner

    //variables for GiveBack function
    private int twentyBack;
    private int tenBack;
    private int fiveBack;
    private int oneBack;
    private int quarterBack;
    private int dimeBack;
    private int nickelBack;
    private int pennyBack;

    //Declaring the user inputs of what the customer gave as payment
    private int priceInPennies;
    private int changeInPennies;
   // private int twentyDollarBills;
    private int twentyDollarBills;
    private int tenDollarBills;
    private int fiveDollarBills;
    private int oneDollarBills;
    private int quarterCoin;
    private int dimeCoin;
    private int nickelCoin;
    private int pennyCoin;

    //Static multiplication factors for each unit of payment
    private final int twentyInPennies = 2000;
    private final int tenInPennies = 1000;
    private final int fiveInPennies= 500;
    private final int oneInPennies = 100;
    private final int quarterInPennies = 25;
    private final int dimeInPennies = 10;
    private final int nickelInPennies = 5;
    private final int pennyInPennies = 1;

    //Variables for the inputs to pennies
    private int twentyPaymentToPennies;
    private int tenPaymentToPennies ;
    private int fivePaymentToPennies;
    private int onePaymentToPennies ;
    private int quarterPaymentToPennies;
    private int dimePaymentToPennies;
    private int nickelPaymentToPennies;
    private int pennyPaymentToPennies;
    private int inputPaymentToPennies;

    //Variables for the current amount of each unit of currency in the register at the time of the purchase
    //For the medium Change Computation, adding random integers to the amount in register
    private int twentyInRegister = 3;
    private int tenInRegister = 4;
    private int fiveInRegister = 5 ;
    private int oneInRegister = 6;
    private int quarterInRegister = 12;
    private int dimeInRegister = 13;
    private int nickelInRegister = 14;
    private int pennyInRegister = 15;


    //given price and payment
    // outputs how much of what unit is to be given in change

    //initializing how much of each unit there is in the register

    /**
     * The method prompts the user for price of purchase and payment given
     */
    public ChangeComputation() {
        in = new Scanner(System.in); // Creating Scanner input
        System.out.println("What was the price in pennies of the purchase? "); // prompting user
        String priceInPenniesStringForm = in.nextLine(); // inputting price

        while (!priceInPenniesStringForm.matches("\\d+")) { // if the user does input a positive integer
            System.out.println("Please input positive integers only.");
            priceInPenniesStringForm = in.nextLine(); // price in pennies
        }
        priceInPennies = Integer.parseInt(priceInPenniesStringForm);
        //Asking the cashier how much of each unit was given as payment
            try {
                System.out.println("How many twenties were given? ");
                twentyDollarBills = in.nextInt();
                System.out.println("How many tens were given? ");
                tenDollarBills = in.nextInt();
                System.out.println("How many fives were given?");
                fiveDollarBills = in.nextInt();
                System.out.println("How many ones were given? ");
                oneDollarBills = in.nextInt();
                System.out.println("How many quarters were given? ");
                quarterCoin = in.nextInt();
                System.out.println("How many dimes were given?");
                dimeCoin = in.nextInt();
                System.out.println("How many nickels were given?");
                nickelCoin = in.nextInt();
                System.out.println("How many pennies were given?");
                pennyCoin = in.nextInt();

            } catch (Exception e) { // if the amount the cashier inputted before the exception was thrown is enough the program will continue
                System.out.println("INVALID INPUT: Please input a positive integer.");
            }
        }



    /**
     * This method will take in how much payment was given
     * Then will compute how much change is due
     */
    public void inputToPennies(){
        //Adding given payments to register stock
        twentyInRegister += twentyDollarBills;
        tenInRegister += tenDollarBills;
        fiveInRegister += fiveDollarBills;
        oneInRegister += oneDollarBills;
        quarterInRegister += quarterCoin;
        dimeInRegister += dimeCoin;
        nickelInRegister += nickelCoin;
        pennyInRegister += pennyCoin;

        //Finding the amount of payment in pennies
        twentyPaymentToPennies = twentyDollarBills * twentyInPennies;
        tenPaymentToPennies = tenDollarBills * tenInPennies;
        fivePaymentToPennies = fiveDollarBills * fiveInPennies;
        onePaymentToPennies = oneDollarBills * oneInPennies;
        quarterPaymentToPennies = quarterCoin * quarterInPennies;
        dimePaymentToPennies = dimeCoin * dimeInPennies;
        nickelPaymentToPennies = nickelCoin * nickelInPennies;
        pennyPaymentToPennies = pennyCoin;

        //Total payment added up
        inputPaymentToPennies = twentyPaymentToPennies + tenPaymentToPennies + fivePaymentToPennies + onePaymentToPennies + quarterPaymentToPennies + dimePaymentToPennies + nickelPaymentToPennies + pennyPaymentToPennies;
       //The change they will receive
        changeInPennies = inputPaymentToPennies - priceInPennies;

        if(changeInPennies < 0){ // if they did not pay enough
            System.out.println("There was not enough payment received to cover the cost of this purchase...You will need "+ Math.abs(changeInPennies) + " more pennies to cover this purchase" );
            // find way to add more payment
            //if statements?
        }
        if(changeInPennies == 0){ // if they had exact change
            System.out.println("You gave the correct amount of change, thank you! ");
            //return statement
        }
        if(changeInPennies > 0){ // if they gave too much payment
            System.out.println("You should receive " + changeInPennies + " (in penny units, not as pennies) as change");

        }
    }

    /**
     * This method computes the change into available units of payment
     * Or will print out that there is not enough available change to give
     */
    public void changeToGive(){
        if(changeInPennies < 0) { // if there wasn't enough payment
            return;
        }
        // finding ideally how much of each unit should be returned
        twentyBack = changeInPennies /2000; // integer division, will find the quotient
        changeInPennies = changeInPennies % 2000; // modulus will find the remainder
        tenBack = changeInPennies/1000;
        changeInPennies = changeInPennies % 1000;
        fiveBack = changeInPennies / 500;
        changeInPennies = changeInPennies % 500;
        oneBack = changeInPennies / 100;
        changeInPennies = changeInPennies % 100;
        quarterBack = changeInPennies / 25;
        changeInPennies = changeInPennies % 25;
        dimeBack = changeInPennies / 10;
        changeInPennies = changeInPennies % 10;
        nickelBack = changeInPennies / 5;
        changeInPennies = changeInPennies % 5;
        pennyBack = changeInPennies;

        //If we don't have enough change in the register
        if(twentyBack > twentyInRegister){ //if the amount to give back is more than we have
            int remainder = twentyBack; //setting the remainder
            twentyBack = twentyInRegister ; // give what we have in the register
            remainder -= twentyInRegister; // how many more we need to give back
            tenBack += (remainder * 2); // making the twenties, tens and seeing what we need
        }
        if(tenBack > tenInRegister){
            int remainder = tenBack;
            tenBack = tenInRegister;
            remainder -= tenInRegister;
            fiveBack += (remainder * 2);
        }
        if(fiveBack > fiveInRegister){
            int remainder = fiveBack;
            fiveBack = fiveInRegister;
            remainder -= fiveInRegister;
            oneBack += (remainder * 5);
        }
        if(oneBack> oneInRegister){
            int remainder = oneBack;
            oneBack = oneInRegister;
            remainder -= oneInRegister;
            quarterBack += (remainder * 4);
        }
        if (quarterBack > quarterInRegister){
            int remainder = quarterBack;
            quarterBack = quarterInRegister;
            remainder -= quarterInRegister;
            dimeBack += (remainder * 2);
            nickelBack += remainder;
        }
        if(nickelBack > 1){
            dimeBack += nickelBack/2;
            nickelBack = nickelBack % 2;
        }
        if(dimeBack > dimeInRegister){
            int remainder = dimeBack;
            dimeBack = dimeInRegister;
            remainder -= dimeInRegister;
            nickelBack += (remainder * 2);
        }
        if (nickelBack > nickelInRegister){
            int remainder = nickelBack;
            nickelBack = nickelInRegister;
            remainder -= nickelInRegister;
            pennyBack += (remainder * 5);
        }
        if(pennyBack > pennyInRegister){
            int remainder = pennyBack;
            pennyBack = pennyInRegister;
            remainder -= pennyInRegister;
            System.out.println("We are sorry, we cannot give you the correct change... we are short " + remainder + " worth in pennies.");
        }

        else{
            //if we do have enough change to give back, then compute how much is left in the register
            twentyInRegister -= twentyBack;
            tenInRegister -= tenBack;
            fiveInRegister -= fiveBack;
            oneInRegister -= oneBack;
            quarterInRegister -= quarterBack;
            dimeInRegister -= dimeBack;
            nickelInRegister -= nickelBack;
            pennyInRegister -= pennyBack;
            // Print out the customer's change
            System.out.println("Your change is " + twentyBack + " twenties..." + tenBack + " tens..." + fiveBack + " fives...and "+ oneBack + " ones in cash.");
            System.out.println("And " + quarterBack + " quarters..." + dimeBack + " dimes..." + nickelBack+ " nickels... and "+ pennyBack + " pennies.");


        }
        //printing what is left in the register
        System.out.println("The current amount left in the register is:");
        System.out.println("Twenties: " + twentyInRegister);
        System.out.println("Tens: " + tenInRegister);
        System.out.println("Fives: " + fiveInRegister);
        System.out.println("Ones: " + oneInRegister);
        System.out.println("Quarters: " + quarterInRegister);
        System.out.println("Dimes: " + dimeInRegister);
        System.out.println("Nickels: " + nickelInRegister);
        System.out.println("Pennies: " + pennyInRegister);

    }
}

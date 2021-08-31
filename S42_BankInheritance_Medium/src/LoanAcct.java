/**
 * This is the Loan Account class that inherits from the Account class
 */
public class LoanAcct extends Account {
    // Interest
    private double interestRate = 0.06; //Hard coding the interest rate to 0.06
    private double balanceWithInterest; //Hard Coding the balance with interest
    /**
     * This method gets the assigned interest rate of the LoanAccount
     * @return interest Rate
     */
    public double getinterestRateLoan(){
        return interestRate;
    }

    /**
     * This method sets a new interest rate for the Loan Account
     * @param interestRate
     */
    public void setInterestRateLoan(double interestRate){
        this.interestRate = interestRate;
    }

    /**
     * This is the Loan Account constructor
     * @param balance The balance on the loan account
     * @param accountNumber The account number on the loan account
     * @param accountHolder The account holder on the loan account
     * @param typeOfAccount The type of account the loan account is
     * @param interestRate The interest on the loan account
     */
    LoanAcct(float balance, int accountNumber, String accountHolder, String typeOfAccount, double interestRate){
        super(balance,accountNumber, accountHolder,typeOfAccount); //Connects it to the Account constructor
        this.interestRate = interestRate;
    }
    // Able to make payments on account

    /**
     * This method gives the banker the ability to calculate the new loan total with interest
     * @return The new balance of the loan
     */
    public double calculateAddedInterestLoan(){
        System.out.println("Calculating new account balance after interest is added on loan: ");
        balanceWithInterest = ((getBalance() * interestRate)+ getBalance());
        System.out.println("The initial amount owed was " + getBalance() + " . Now, with an interest rate of " + interestRate +" ,it is now "+ balanceWithInterest);
        return balanceWithInterest;
    }

    /**
     * This method gives the banker the ability to make a payment on the loan on behalf of an account holder
     * @param payment This is how much the account holder paid
     */
    public void makePaymentOnLoan(double payment){
        double newBalanceLoan = 0;
        System.out.println("You want to make a " + payment + " dollar payment on an account with a current balance of " + getBalance());
        //If the account holder pays more than the balance is
        if(payment >= getBalance()){
            newBalanceLoan = Math.abs(getBalance()-payment);
            System.out.println("You are paying more than your debt owed is, your new total is " + newBalanceLoan);
            System.out.println(" ");
        }
        //If the account holder pays some but not all of the balance of the loan account
        if (payment < getBalance()){
            newBalanceLoan = getBalance() - payment ;
            System.out.println("You made a payment of " + payment + " on a loan debt of -" + getBalance()+" and your new balance is: -" + newBalanceLoan);
            System.out.println(" ");
        }
    }
}


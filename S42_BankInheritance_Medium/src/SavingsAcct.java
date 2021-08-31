//derived class inheriting from Account

/**
 * This class is a subclass that inherits from the Account class
 * This class should calculate interest rate
 */
public class SavingsAcct extends Account {
    private double interestRate = 0.03; //Hard coding the interest rate to 0.03
    private double balanceWithInterest; // This is the total balance with interest computed in it

    /**
     * This method is to get the interest rate defined in the SavingsAcct class
     * @return Interest Rate
     */
    public double getInterestRate(){
        return interestRate;
    }

    /**
     * This method is to set the interest rate to a new interest rate if the banker chooses
     * @param newInterestRate
     */
    public void setInterest(double newInterestRate){
        interestRate = newInterestRate;
    }

    /**
     * This is the constructor for a SavingsAcct
     * @param balance This is the balance of the Savings Account
     * @param accountNumber This is the account number of the Savings Account
     * @param accountHolder This is the name of the account holder of the Savings Account
     * @param typeOfAccount This is the type of account, either individual or company
     * @param interestRate This is the interest rate for the Savings Account
     */
    SavingsAcct(float balance, int accountNumber, String accountHolder, String typeOfAccount, double interestRate){
        super(balance,accountNumber, accountHolder,typeOfAccount); //Connects it to the Account constructor
        this.interestRate = interestRate;
    }

    /**
     * This method computes the added interest
     * @return Balance With Interest
     */
    public double calculateAddedInterest(){
        System.out.println("Calculating new account balance after interest: ");
        balanceWithInterest = ((getBalance() * interestRate)+ getBalance());
        System.out.println("The initial balance was " + getBalance() + " with an interest rate of " + interestRate +" is now "+ balanceWithInterest);
        return balanceWithInterest;
    }

}

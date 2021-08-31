/**
 * This is the Checking Account class which inherits from the Account class
 * This class will manage a checking account, and print out a warning if there was a potential overdraft
 */
public class CheckingAcct extends Account{
    //In this class I want to be able to check that the account isn't
    // over the overdraft limit, if it is, then I will print a message
    private double spentWithCheck; //This is the intended amount given to be taken from the Checking Account

    /**
     * This is the constructor for the Checking Accounts
     * @param balance The balance of the Checking Account
     * @param accountNumber This is the account number of the Checking Account
     * @param accountHolder This is the name of the account holder of the Checking Account
     * @param typeOfAccount This is the type of account that this Checking Account belongs to: individual or company
     */
    CheckingAcct(float balance, int accountNumber,String accountHolder, String typeOfAccount){
        super(balance,accountNumber, accountHolder,typeOfAccount);
        this.spentWithCheck = spentWithCheck;
    }

    /**
     * This is a method in order to calculate potential overdrafts
     * The method will announce how much is intended to be withdrawaled from an existing balance
     * If there is an overdraft a warning will print out and the check will 'bounce'
     * If there is not an overdraft, the method will print the new balance of the checking account
     */
    public void calculatePotentialOverdraft(){
        System.out.println("You are trying to withdrawal " + spentWithCheck+ " from an account with -" + getBalance());
        if((getBalance()-spentWithCheck) < 0){ // If there is an overdraft
            System.out.println("WARNING: There is an overdraft warning on this checking account, the amount will not be removed from the account.");
            System.out.println("The balance on the checking account remains: " + getBalance() );
        }
        else if((getBalance()-spentWithCheck) > 0){ // If the check clears
            double newBalance = getBalance()-spentWithCheck;
            setBalance((float) newBalance);
            System.out.println("The check amount was withdrawn from the checking account and your new balance is: " + getBalance());
        }
        System.out.println(" "); // This is just for formatting purposes
    }

    /**
     * This method is to get the amount that was withdrawn from the Checking Account
     * @return spentWithCheck
     */
    public double getSpentWithCheck() {
        return spentWithCheck;
    }

    /**
     * This method sets the amount withdrawn from the Checking Account
     * @param spentWithCheck
     */
    public void setSpentWithCheck(double spentWithCheck) {
        this.spentWithCheck = spentWithCheck;
    }
}

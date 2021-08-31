/**
 * This is the super class that CheckingAcct, SavingsAcct, and LoanAcct inherit from
 * This class is for having a general account at the bank
 */
public class Account {
    private float balance;
    private int accountNumber;
    private String accountHolder;
    private String typeOfAccount;

    /**
     * This is the Account Constructor
     * @param bal The balance of the account
     * @param acctNum The account number
     * @param acctHold The name of the account holder
     * @param type The type of account: individual or company
     */
    Account(float bal, int acctNum, String acctHold, String type){
        balance = bal;
        accountNumber = acctNum;
        accountHolder = acctHold;
        typeOfAccount = type;
    }

    /**
     * This method gets the assigned balance of an Account
     * @return balance value
     */
    public float getBalance(){
        return balance;
    }

    /**
     * This method sets a new balance to an Account
     * @param newBalance, the new balance set
     */
    public void setBalance(float newBalance){
        this.balance = newBalance;
    }

    /**
     * This method gets the assigned account number
     * @return Account Number
     */
    public int getAccountNumber(){
        return accountNumber;
    }

    /**
     * This sets the account number
     * @param newAccountNumber
     */
    public void setAccountNumber(int newAccountNumber){
        this.accountNumber = newAccountNumber;
    }

    /**
     * This method gets the Account holder associated to an account
     * @return Account Holder's name
     */
    public String getAccountHolder(){
        return accountHolder;
    }

    /**
     * This method sets the Account Holder to a new person
     * @param newAccountHolder
     */
    public void setAccountHolder( String newAccountHolder){
        this.accountHolder = newAccountHolder;
    }

    /**
     * This method gets the associated type of account
     * @return type of account
     */
    public String getTypeOfAccount(){
        return typeOfAccount;
    }

    /**
     * This method sets the type of account
     * @param typeOfAccount
     */
    public void setTypeOfAccount(String typeOfAccount){
        this.typeOfAccount = typeOfAccount;
    }

}


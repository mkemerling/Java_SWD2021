import java.sql.SQLOutput;
import java.util.ArrayList;

/**
 * This is the Bank class that holds an ArrayList of the Accounts Created
 * This is class does not inherit from any other nor does any other inherit from this class
 */
public class Bank {
    private ArrayList<Account> bank; //Array list so it grows to the necessary size every time we add one
    private int totalByName = 0; // For printing accounts by name
    /**
     * This method adds the accounts to the bank array
     * @param account
     */
    public void bankAdd(Account account) { // adds the account to the bank list
        bank.add(account);
    }

    /**
     * This initializes the arraylist bank
     */
    public Bank(){
        bank = new ArrayList<>(); //initializing the arrayList bank
    }

    /**
     * This method prints the array that holds every account in no particular order
     * This method will print account holder's name, the balance, account number, and type of account
     */
    public void printArray(){ //prints every account
        System.out.println("Here are the current number of accounts: " + bank.size());
        for(Account a : bank ){
            System.out.println("------------------------");
            System.out.println("This is the account holder: " + a.getAccountHolder());
            System.out.println("This is the account balance: "+ a.getBalance());
            System.out.println("This is the account number: "+ a.getAccountNumber());
            System.out.println("This is the type of account: " + a.getTypeOfAccount());
            //each alone
        }
        System.out.println(" ");
    }

    /**
     * This method prints all accounts belonging to a specific name or company
     * @param name
     */
    public void printAllAccountsbyName(String name){ // this goes in and prints all accounts under the same name
        for(Account a : bank){
            if(name.equals(a.getAccountHolder())){
                System.out.println("------------------------");
                System.out.println("This is the account holder:" + a.getAccountHolder());
                System.out.println("This is the account balance: "+ a.getBalance());
                System.out.println("This is the account number: "+ a.getAccountNumber());
                System.out.println("This is the type of account: " + a.getTypeOfAccount());
                totalByName++;
            }
        }
        System.out.println("The total number of accounts for " + name + " is " + totalByName);
    }

    /**
     * This method is for the banker to create a new Individual account which makes a new savings,checking,and loan account under the user
     * @param balanceSavings The balance for the savings account
     * @param balanceChecking The balance for the checking account
     * @param balanceLoan The balance for the loan account
     * @param accountNumber The account number for all 3 accounts
     * @param accountHolder The account holder's nam
     */
    public void createNewIndividualAccount(float balanceSavings, float balanceChecking, float balanceLoan,int accountNumber, String accountHolder){
        bankAdd(new CheckingAcct(balanceChecking, accountNumber,accountHolder,"individual, checking"));
        bankAdd(new LoanAcct(balanceLoan,accountNumber,accountHolder,"individual, loan", 0.06));
        bankAdd(new SavingsAcct(balanceSavings, accountNumber, accountHolder,"individual, savings", 0.03));
    }
    //I want this class to be able to make new accounts, count # of accounts

    /**
     * This method is for the banker to create a new company which entails making a new checking and loan account under the company name
     * @param balanceChecking This is the balance for the checking account
     * @param balanceLoan This is the balance for the loan account
     * @param accountNumber This is the account number for the accounts
     * @param companyName This is the company name the accounts will be under
     */
    public void createNewCompanyAccount(float balanceChecking, float balanceLoan,int accountNumber, String companyName){
        bankAdd(new CheckingAcct(balanceChecking,accountNumber,companyName,"company, checking"));
        bankAdd(new LoanAcct(balanceLoan,accountNumber,companyName,"company, loan",0.06));
    }
}

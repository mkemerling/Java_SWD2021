import java.util.ArrayList;
/**
 * Driver class driving all the functionality of the program
 */
public class Driver {
    /**
     * This is the main method to test all of the functionality
     * @param args
     */
    public static void main(String[] args) {
        Bank a = new Bank();//Makes a new bank Array

        //Account Aaron = new Account(300,98765,"Aaron","individual");
        SavingsAcct AaronSavings = new SavingsAcct(350,12345,"Aaron","individual,savings",0.04);
        //Account Chris  = new Account(400, 3456,"Chris", "individual");
        CheckingAcct AaronChecking = new CheckingAcct(700,346789, "Aaron", "individual, checking");
        LoanAcct AaronLoan = new LoanAcct(600,13579, "Aaron", "individual, loan", 0.06);

        //Adding all of the different accounts to the bank arraylist
        //a.bankAdd(Aaron); //These were just for testing purposes
        //a.bankAdd(Chris); //These were just for testing purposes
        a.bankAdd(AaronSavings);
        a.bankAdd(AaronChecking);
        a.bankAdd(AaronLoan);

        //Printing out all of the accounts in the bank
        System.out.println("Here are all of the accounts in the bank: ");
        a.printArray();

        //Printing out all of the accounts that belong to Aaron
        System.out.println("Here is where we print all accounts by person or organization: ");
        a.printAllAccountsbyName("Aaron");

        //Showing functionality of the Checking Account
        System.out.println("");
        AaronChecking.setSpentWithCheck(300);
        AaronChecking.calculatePotentialOverdraft();
        AaronChecking.setSpentWithCheck(500);
        AaronChecking.calculatePotentialOverdraft();

        //Showing functionality of Savings Account
        System.out.println("");
        AaronSavings.calculateAddedInterest();

        //Showing functionality of Loan Account
        System.out.println("");
        AaronLoan.calculateAddedInterestLoan();
        AaronLoan.makePaymentOnLoan(300);
        AaronLoan.makePaymentOnLoan(700);

        //Showing functionality of creating a new individual account
        System.out.println("" );
        System.out.println("Here is where the banker has the functionality of making an individual savings,checking, and loan account all for one user: ");
        System.out.println("The banker only has to input the balance for each, account number, account holder");
        System.out.println(" ");
        a.createNewIndividualAccount(500,400,300,6789,"Greer");
        a.printArray();

        //Showing functionality of creating a new company account
        System.out.println("");
        System.out.println("Here is where the banker has the functionality of making a checking and loan account for a company at the same time.");
        System.out.println("The banker only has to input the balance for each, account number, and account holder");
        System.out.println(" ");
        a.createNewCompanyAccount(5000,3000,123789,"BreadGarden");
        a.printArray();

        //Showing functionality that banker has for setting balances
        System.out.println("");
        System.out.println("The banker can get and set the different parts of the accounts:");
        System.out.println("Here I will show that functionality...");
        System.out.println("Here is the current balance of  "+AaronSavings.getAccountHolder() +" "+ AaronSavings.getTypeOfAccount()+ " : " + AaronSavings.getBalance() );
        AaronSavings.setBalance(1234567);
        System.out.println("The banker can change that balance to 1234567..." );
        System.out.println("Here is the current balance of  "+AaronSavings.getAccountHolder() +" "+ AaronSavings.getTypeOfAccount() + " : " + AaronSavings.getBalance() );


        //System.out.println(Aaron.getBalance());
        //System.out.println(Aaron.getAccountHolder());
        //System.out.println(AaronSavings.calculateAddedInterest());
        //a.printArray();


    }
}

package Project1;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;

/*
 * This is a Java Doc
 * This is a multi-line comment
 *  
 * Our BankAccount class will represent a bank account
 * It will have a balance and a name
 * It will have methods to deposit and withdraw money
 * It will have a method to print the balance
 * it will have a menu that the user can interact with
 * 
 * 
 */

public class BankAccount {
    private double balance;
    private String name;
    private double interestRate = 0.01;
    private int period = 4; // quarterly

    //Scanner object
    Scanner scan = new Scanner(System.in);


    // Constructor
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }
    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }
    public BankAccount(double balance){
        this.balance = balance;
        this.name = "No Name";
    }

    //Savings account constructor
    public BankAccount(String name, double balance, double interestRate, int years){
        this.name = name;
        this.balance = balance;
        this.interestRate = interestRate;
        this.period = years;
    }
    
    // Default Constructor
    // Make a BankAccount without Specifying any parameters
    public BankAccount(){
        this.balance = 0;
        this.name = "No Name";
    }

    // Create getters and setters for balance
    public double getBalance() {
        return balance;
    }

    // Create a method for printing the balance as a String
    public String printBalance() {
        return "Your Balance is: $" + balance;
    }

    // public void setBalance(double balance) {
    //     this.balance = balance;
    // }
    // Set balance is flawed in that we would never
    // be able to actually set the balance. Instead we need 
    // to create methods to deposit and withdraw money

    // Create getters and setters for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    

    // Create a method to deposit money
    public void deposit(double amount) {
        this.balance += amount;
        // above is the same as this.balance = this.balance + amount;
        // balance is 10,000
        // amount  is 2,000
        // balance = balance + amount
        // 10000 = 10000 + 2000
    }

    // Create a method to withdraw money
    public void withdraw(double amount) {
        this.balance -= amount;
        // above is the same as this.balance = this.balance - amount;
        // balance is 10,000
        // amount  is 2,000
        // balance = balance - amount
        // 10000 = 10000 - 2000
    }

    // Create a method that will subtract a monthly fee from the balance
    // This method will take a double as an argument
    // This method will subtract the fee from the balance
    public void monthlyFee(double fee) {
        withdraw(fee);
    }


    // Create a method that will calculate the interest on the balance using compound interest
    // P(1 + R/n)^(nt) - P 
    // P = Principal
    // R = Rate
    // n = number of times interest is compounded per year (annum)
    // t = number of years
    // This method will take a double as an argument
    // This method will return a double

    // P can be this.balance or getBalance() if you would like to use a getter


    public void calcInterest(double principal, int time, double rate, int annum){
        
        double amount = principal * Math.pow(1+ (rate/annum), annum*time);
        double roundedamount = Math.round(amount * 100.0) / 100.0;
        double compinterest = amount - principal;
        compinterest = Math.round(compinterest * 100.0) / 100.0;

        System.out.println("Current Rate is: "+rate+"%");
        System.out.println("Current Period is: "+annum+" times per year");
        System.out.println("Selected Time is: "+time+" years");
        System.out.println("Compound Interest after " + time + " years: $" + compinterest);
        System.out.println("Amount after " + time + " years: $" + roundedamount);
    }


    //Overdraft method 
    //Charges an extra fee for balances that are at zero or less than zero
    public static void overDraft(BankAccount account, double amount){
        if(account.getBalance() <= 0){
            //Response placeholder
            String response;

            System.out.println("If you withdraw money, your balance will go to negative and you will be charaged a fee of $35. Is this okay?");
            response = account.scan.nextLine();
            if(response.equalsIgnoreCase("yes")){
                account.withdraw(amount);
                account.monthlyFee(35);
                System.out.println("You have withdrawn $" + amount + " and have been charged a fee of $35. Your new balance is $" + account.getBalance());
            } else{
                System.out.println("Transaction cancelled");
            }
        }
    }

    //Transfer method
    public static void transferMoney(BankAccount account1, BankAccount account2, double amount){
        account2.withdraw(amount);
        account1.deposit(amount);
    }

    //Simple Interest method
    public void simpleInterest(double principal, double rate, int time){

        double interest = (principal * rate * time)/100;
        double roundedInterest = Math.round(interest *100)/100;
        double totalAmount = interest + principal;
        totalAmount = Math.round(totalAmount *100)/100;

        System.out.println("Current Rate is: " + rate + "%");
        System.out.println("Selected Time is: " + time + " years");
        System.out.println("Flat Interest after " + time + " years: $" + roundedInterest);
        System.out.println("Amount after " + time + " years: $" + totalAmount);

    }





    // Create a method that will print a menu to the user
    // this is called a helper method
    public static int menu(){
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Bank Account Menu");
        System.out.println("--------------------------------");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Print Balance");
        System.out.println("4. Calculate Interest");
        System.out.println("5. Transfer Money");
        System.out.println("6. Create Savings Account");
        System.out.println("0. Exit");
        System.out.println("Please enter your choice: ");
        choice = input.nextInt();
        return choice;
    }
    // Create a method that will interact with the user based on their choice from the menu
    // This method will take a BankAccount object as an argument
    public static void interact(BankAccount account, BankAccount account2){
        // get the choice from the menu
        int choice = menu();
        // create a scanner object
        Scanner input = new Scanner(System.in);
        // use that choice and run the method associated with that choice
        // in class we learned about recursion and how to use it
        // we will use recursion to keep the menu running until the user chooses to exit
        // This is outside of the scope of this class but it is worth knowing about

        if (choice == 1) {
            System.out.println("How much would you like to deposit?");
            double amount = input.nextDouble();
            account.deposit(amount);
            System.out.println(account.printBalance());
            // interact(account);
        } else if (choice == 2) {
            System.out.println("How much would you like to withdraw?");
            double amount = input.nextDouble();
            account.withdraw(amount);
            System.out.println(account.printBalance());
            // interact(account);
        } else if (choice == 3) {
            System.out.println(account.printBalance());
            // interact(account);
        } else if (choice == 4) {
            System.out.println("What is the time in years to invest (Whole Numbers Only)?");
            int time = input.nextInt();
            // double principal, int time, double rate, int period
            account.calcInterest(account.getBalance(), time, account.interestRate, account.period);

            System.out.println("... Thank you for using the Bank Account Menu. Have a nice day! ...");

        } else if(choice == 5){
            
            System.out.println("How much would you like to transfer?");
            double moneyAmount = input.nextDouble();
            transferMoney(account, account2, moneyAmount);
            System.out.println("First Account Balance: " + account.getBalance());
            System.out.println("Second Account Balance: " + account2.getBalance());

        } else if(choice == 6){
            
            System.out.println("Would you like to create a savings account?");
            String response = input.nextLine();

            if(response.equalsIgnoreCase("yes") & account.getBalance() >= 10000){
                
                System.out.println("How much money would you like to start with?");
                double principal = input.nextDouble();

                System.out.println("How long would you like to invest for?");
                int time = input.nextInt();

                System.out.println("What type of interest would you like? (Compound or Flat)");
                input.nextLine();//debugged due to nextInt() leaving the cursor at the int input line, it doesn't go to the next line
                String interestType = input.nextLine();

                if(interestType.equalsIgnoreCase("Compound")){

                    BankAccount savings0 = new BankAccount(account.getName(), principal, 0.0001, time);
                    savings0.calcInterest(principal, time, 0.0001, 4);

                } else if(interestType.equalsIgnoreCase("Flat")){

                    BankAccount savings1 = new BankAccount(account.getName(), principal, .001, time);
                    savings1.simpleInterest(principal, 0.001, time);

                }

            } else{

                System.out.println("You do not have enough money to create a savings account");

            }

        } else if (choice == 0) {
            System.out.println("Thank you for using the Bank Account Menu");
        } else { // this would catch 69420
            System.out.println("Invalid Choice");
            // interact(account);
        }

    }


}

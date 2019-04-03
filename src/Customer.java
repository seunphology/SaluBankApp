
/* A customer opens an account in a bank,the customer must have an initial amount of $100 whilst opening the account.

The customer can withdaw,deposit, and check account balance whenever he wants. The bank does not charge any fees for the
first transaction.But for the subsequent transactions,the bank charges transaction fees. The bank also calculates an interest
on deposits by customer as per its interest rate. Automate this using the object oriented programming.
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Customer {

    private String name;

    private Account account; // customer has an account has to be written has an object of the class Account.Java rule.










    public Customer(String n, Account a){ //A constructor is cool for proper identity of every customer object

        name = n;

        account = a;

    }

    public void display(){
System.out.println(" Name : " + name + " Account number : " + account.getAccoutNumber() + "Balance " + account.getBalance());
    }

    public String getName(){
return name;
    }

    public Account getAccount(){ // I used the type Account cuz account here is an object.

        return account;

    }


public static void main(String[]args){

        // Because we need to input data into the program from our keyboard, we introduce :

    // connectors in bytes (system.in) are converted into individual connectors(inputStreamReaders) are now converted into strings read on a line(Buffered)

   // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // reads a single line the user enters at once



        // Now,for the main operation,
    //We want this loop to keep running infinitely for customers that comes to the machine.We use the while or do while loop
        int numberOfCustomers = 0;

        Bank bank = new Bank(); // done so we can use the method under Bank class with the Customer array.

        Customer [] c = bank.getCustomer(); // this keeps track of every additional customer account added up to 10000
        while (true) {
            System.out.println(" Please enter what operation you choose to do : ");
            System.out.println(" 1 : Add Customer ");
            System.out.println(" 2 : Deposit money ");
            System.out.println(" 3 : Withdraw money ");
            System.out.println(" 4 : Check balance");
            System.out.println(" 5 : Calculate interest");
            System.out.println(" 6 : Exit");

           // bufferedReader.readLine(); // waits for user to type and and read the message as a string.However,cuz our opeations are coded in numbers(1-6),

            // we have to store the bufferedreader.readline as integer.This means converting what it reads normally as string to integers
          // int operation = Integer.parseInt(bufferedReader.readLine()); // Integer.parse method(having bufferedreader.readline() as argument) does this conversion

            // Conttrary to the buffered approach, I personally prefer the scanner and nextint() approach below for simplicity ;

            Scanner input = new Scanner(System.in);

            int operation = input.nextInt();

            switch (operation){ // This is an advanced but convinient if/else statement for all the operations. once any number is typed,it breaks

                case 1:

                    /* If the option selected by the user is 1 :
                    1. Ask the amount of money the person wants to deposit the first time while creating an account
                    2. Ask the person to enter the account number.
                    3. Create the account object that contains the money and account number.
                    4. Ask the customers name and create a customer object with that name and use the account object created above.
                    5. Add this new customer object to the list of customers the bank has.
                    6. Increment the number of customers for the bank.
                    7. Print the details of the newly added customer.
                     */

                    System.out.println("Creating a new account for a customer : ");
                    System.out.println(" Please enter the initial amount in your account : " );
                    double bal = input.nextDouble();
                    System.out.println("Please enter your account number : " );
                    String acc = input.nextLine();
                    Account account = new Account(bal,acc); // creating an account for the balance and acc number

                    System.out.println('\n');

                    System.out.println("Please enter your name : " );
                    String name = input.nextLine();
                    Customer customer = new Customer(name,account); // to show that the customer has the name and account.
                    c[numberOfCustomers] = customer;
                    numberOfCustomers++;
                    System.err.println("Number of Customers " + numberOfCustomers);
                    for(int i=0; i<numberOfCustomers; i++) {
                        System.err.println(c[i].getName() + " NAME ");
                    }



                    //System.out.println("Please enter your name : " ); // Please disregard ...should be commented out later.

                   // String p = input.nextLine();

                    break;

                case 2:

                     System.out.println("Please,enter your Account Number : ");
                     acc = input.nextLine();

                    if(numberOfCustomers==0)
                    {
                        System.err.println(" Account Number not found");
                    }
                    else
                        {
                        boolean found = false; //Initially assuming that no account number has been found
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();  // Gives us a way to browse through the customer array (database), store it as account temp
                            String acctemp = temp.getAccoutNumber();
                            if (acctemp.equals(acc)) { /*equals is used to compare 2 variables that return strings.This
                            compares the accounts in the database vs the account the user wants to deposit money into*/
                                System.out.println("Please,enter the amount you wish to deposit : ");
                                double money = input.nextDouble(); // stores what amount the user types.
                                temp.deposit(money); // deposit is a method borrowed from class Account which temp is an object of.
                                found = true; // If the 'if' code runs
                            }


                        }

                        // Outside of the 'for' loop,only found=false or true are possible,if false,do the below:
                        if (found == false) {
                            System.err.println("Account Number not found ");
                        }
                    }
                    break;

                case 3:
                    System.err.println("Please,enter your Account Number : ");
                    acc = input.nextLine();

                    if(numberOfCustomers==0)
                    {
                        System.err.println(" Account Number not found");
                    }
                    else {
                        boolean found = false; //Initially assuming that no account number has been found
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();  // Gives us a way to browse through the customer array (database), store it as account temp
                            String acctemp = temp.getAccoutNumber();
                            if (acctemp.equals(acc)) { /*equals is used to compare 2 variables that return strings.This
                            compares the accounts in the database vs the account the user wants to deposit money into*/
                                System.out.println("Please,enter the amount you wish to withdraw : ");
                                double money = input.nextDouble(); // stores what amount the user types.
                                temp.withdraw(money); // withdraw is a method borrowed from class Account which temp is an object of.
                                found = true; // If the 'if' code runs
                            }

                            // Outside of the 'for' loop,only found=false or true are possible,if false,do the below:
                            if (found == false) {
                                System.err.println("Account Number not found ");
                            }
                        }

                        // Outside of the 'for' loop,only found=false or true are possible,if false,do the below:
                        if (found == false) {
                            System.err.println("Account Number not found ");
                        }
                    }
                    break;

                case 4:
                    System.err.println("Please,enter your Account Number : ");
                    acc = input.nextLine();

                    if(numberOfCustomers==0)
                    {
                        System.err.println(" Account Number not found");
                    }
                    else {
                        boolean found = false; //Initially assuming that no account number has been found
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();  // Gives us a way to browse through the customer array (database), store it as account temp
                            String acctemp = temp.getAccoutNumber();
                            if (acctemp.equals(acc)) { /*equals is used to compare 2 variables that return strings.This
                            compares the accounts in the database vs the account the user wants to deposit money into*/
                                System.out.println("Please,enter the amount you wish to deposit : ");
                                System.out.println("your balance is : " + temp.getBalance());
                                found = true; // If the 'if' code runs
                            }

                            // Outside of the 'for' loop,only found=false or true are possible,if false,do the below:
                            if (found == false) {
                                System.err.println("Account Number not found ");
                            }
                        }

                        // Outside of the 'for' loop,only found=false or true are possible,if false,do the below:
                        if (found == false) {
                            System.err.println("Account Number not found ");
                        }
                    }
                    break;

                case 5:
                    System.err.println("Please,enter your Account Number : ");
                    acc = input.nextLine();

                    if(numberOfCustomers==0)
                    {
                        System.err.println(" Account Number not found");
                    }
                    else {
                        boolean found = false; //Initially assuming that no account number has been found
                        for (int i = 0; i < numberOfCustomers; i++) {
                            Account temp = c[i].getAccount();  // Gives us a way to browse through the customer array (database), store it as account temp
                            String acctemp = temp.getAccoutNumber();
                            if (acctemp.equals(acc)) { /*equals is used to compare 2 variables that return strings.This
                            compares the accounts in the database vs the account the user wants to deposit money into*/
                                bank.getInterestRate(c[i]); // where c[i] is the current customer using the machine.
                                found = true; // If the 'if' code runs
                            }

                            // Outside of the 'for' loop,only found=false or true are possible,if false,do the below:
                            if (found == false) {
                                System.err.println("Account Number not found ");
                            }
                        }

                        // Outside of the 'for' loop,only found=false or true are possible,if false,do the below:
                        if (found == false) {
                            System.err.println("Account Number not found ");
                        }
                    }
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:

                    break;
            }
        }


}

}



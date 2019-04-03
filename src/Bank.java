public class Bank {

    private double interestRate = 8.5;

    private double transactionFee = 10;

    Customer[] customer = new Customer[10000] ;  // this is an object array showing that the bank has several customers, hence array object.

    // An array is used here instead of arraylist,even tho arraylists are far better..with no limits to elements in list

    // now,we ask...what does a bank do (verb = method, noun = class)..so the methods here are below:

    /* Important to ask : which customer?

    Also, get customer s account,

    get customer s balance,

    calculate the interest amount on the balance and show the user what can be their balance
     */

    public void getInterestRate(Customer customer){ // answers which customer?

        Account a = customer.getAccount(); // gets the account of the customer

        double bal = a.getBalance(); // gets the balance of customer and stored as bal.This is possible because 'a' belongs to Account class which has method getBalance
        double interestAmount = bal*interestRate/100; // interest rate is in percentage,i.e 8.5%.
        double totalBalance = bal + interestAmount;

        System.out.println("Interest amount " + interestAmount + " total money after adding interest " + totalBalance);

        // returns interest rate on any available deposit

    }

    public double getTransactionFee(){

        return transactionFee;

        // returns transaction fee
    }

    public Customer[] getCustomer(){ // notice a method for array is slightly different cuz of the [] and the data type Customer

        return customer;
    }





}

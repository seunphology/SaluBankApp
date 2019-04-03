public class Account {
private double balance = 100;

private String accoutNumber;

private boolean firstTime = true;

public Account(double bal, String acc){      // making a constructor for account so every object has identity,not empty.

    balance = bal;
    accoutNumber = acc;

    if(bal>=100){  // this condition is necessary cuz the minimum balance in any account must be 100

        balance = bal;

    }
    else{

        bal = 100; // no matter what amount is written in the constructor,amount will always be set to 100,not effective tho
    }

    accoutNumber = acc;
}

public Account(String acc){   // alternative constructor taking in only account number for object identity.

    accoutNumber = acc;


}

public void deposit(double howMuch){

    if(howMuch>0){ // This condition is to ensure that a negative amount is not added to the balance or deposited.

        balance = balance+howMuch;

        System.out.println(howMuch + " Was added to your account, your new balance is : " + balance + " Thank you for banking with us");
    }
    else{

        System.err.println("Please enter an appropriate amount"); // system.err.println prints error messages in red
    }

}

public void withdraw(double howMuch){ /* Important to note: Ask the user how much they want to withdraw. If its the 1st time,check

if the money is positive.If the money is negative,tell the user they cannot perform the transaction. if the money
is positive,check if the balance left in the account after withdrawal is equal to or more than $100, if yes,
then withdraw the money.If NO,tell the user insufficient balance.*/

if(howMuch>=0){
if(firstTime==true){ // if true,perform withdrawing  the money for the first time(without transaction fee)
double tempBalance = balance; /* lets say my balance=200,hence tempBalance=200. if howMuch = 50, then
tempBalance-howMuch = 150. or written as tempBalance = tempBalance-howMuch. this is equal to 150(bigger than minimum balance of $100),so the method can run.
But if howmuch = 150,hence tempBalance=tempBalance-howMuch = 50,the method should not run.*/
tempBalance = tempBalance-howMuch;

if(tempBalance>=100){ // if after withdrawal,money left is equal or greater than 100, we can withdraw.
balance = balance-howMuch; // or balance = tempBalance . This gives how much is left after successful withdrawal.
}
else{ // error message for insufficient balance
    System.err.println(" Insufficient balance to withdraw " + howMuch + " please dheck your balance, Thank you! ");
}

firstTime=false; // this is written so that the method above only happens only the 1st time in the IF,every other time, its the ELSE that runs
}
else{ // otherwise,perform withdrawing the subsequent time (which comes with a transaction fee)

Bank bank = new Bank(); // we need the transaction fee method from the Bank class,hence,we make an object of Bank to access the method in class Bank
double tempBalance = balance;
    tempBalance = balance-howMuch-bank.getTransactionFee();

    if(tempBalance>=100){ // if after withdrawal,money left is equal or greater than 100, we can withdraw.
        balance = balance-howMuch- bank.getTransactionFee(); // or balance = tempBalance . This gives how much is left after successful withdrawal.
    }
    else{ // error message for insufficient balance
        System.err.println(" Insufficient balance to withdraw " + howMuch + " please dheck your balance, Thank you! ");
    }





}
}
else{
    System.err.println(" You cannot withdraw a negative amount, please try again ");
}

}

public double getBalance(){
return balance;
}

public String getAccoutNumber(){

    return accoutNumber;
}



}





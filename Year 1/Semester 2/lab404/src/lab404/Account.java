package lab404;

import java.util.Scanner;

public abstract class Account extends Person{
    
    //attributes
    long accNumber;
    Person accHolder;
    double balance;

    //constructor
    Account(){}

    //read accounts details
    void readAccountDetails(Scanner scan){
        System.out.print("Enter Account Number: ");
        accNumber = scan.nextLong();
        readPersonDetails(scan);
        System.out.print("Enter balance: ");
        balance = scan.nextDouble(); 
    }

    //make abstract updateBalance method
    abstract void updateBalance();

    //diplay the details of the account
    void displayAccount(){
        System.out.printf("%10d | ",accNumber);
        System.out.printf("%15s | ",getName());
        System.out.printf("%15s | ",getEmail());
        System.out.printf("%15d | ",getPhoneNumber());
        System.out.printf("%10.2f  \n",balance);
    }
}
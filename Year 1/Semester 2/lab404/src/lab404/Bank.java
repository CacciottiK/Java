package lab404;

import java.util.Scanner;

public class Bank {
    //attributes
    String name;
    Account account[];

    //Constructor
    Bank(String name,int size){
        this.name = name;
        account = new Account[size];
    }

    //show menu for accoutn type
    int menu(Scanner scan){
        System.out.println("1. Checking");
        System.out.println("1. Savings");
        System.out.print("Enter the type of account you want to create: ");
        return scan.nextInt();
    }

    //read accoutn details 
    void readAccounts(Scanner scan){
        for(int i=0;i<account.length;i++){
            int choice = menu(scan);
            if(choice==1){
                account[i] = new Checking();
            }else{
                account[i] = new Saving();
            }
            account[i].readAccountDetails(scan);
        }
    }

    //apply monthly process
    void runMonthlyProcess(){
        for(int i=0;i<account.length;i++){
            account[i].updateBalance();
        }
    }

    //display accounts details
    void displayAccounts(){
        for(int i=0;i<account.length;i++){
            account[i].displayAccount();
        }
    }

    //Prints stars to the screen
    static void printStar(){
        for(int i=0;i<80;i++){
            System.out.print("*");
        }
        System.out.println();
    }

    //Print title
    static void printTitle(){
        printStar();
        System.out.printf("%10s | ","Acc Number");
        System.out.printf("%15s | ","Name");
        System.out.printf("%15s | ","Email");
        System.out.printf("%15s | ","Phone Number");
        System.out.printf("%10s  \n","Balance");
        printStar();
    }
}

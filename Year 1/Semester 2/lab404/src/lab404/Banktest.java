package lab404;

import java.util.Scanner;
public class Banktest {
    public static void main(String[] args) {
        //make a scanner object
        Scanner scan = new Scanner(System.in);

        //enter bank name
        System.out.print("Enter the name of the bank: ");
        String name = scan.nextLine();

        //enter number of account holder
        System.out.print("How many account holders do you have: ");
        int size = scan.nextInt();

        //create bank object
        Bank bank = new Bank(name, size);

        //read Accounts details
        bank.readAccounts(scan);

        //apply montly process
        bank.runMonthlyProcess();

        //print header
        Bank.printStar();
        System.out.printf("%40s BANK \n",bank.name.toUpperCase());
        Bank.printTitle();      

        //print account details
        bank.displayAccounts();  
    }
}
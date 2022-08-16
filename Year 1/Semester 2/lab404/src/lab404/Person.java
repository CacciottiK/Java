package lab404;

import java.util.Scanner;
class Person{

    //attributes
    String firstName;
    String lastName;
    String email;
    long phoneNumber;

    //constructor
    Person(){}

    //getter for name
    public String getName() {
        return firstName + " " + lastName;
    }

    //getter for email
    public String getEmail() {
        return email;
    }

    //getter for phone number
    public long getPhoneNumber() {
        return phoneNumber;
    }

    //read person details
    void readPersonDetails(Scanner scan){
        System.out.print("Enter first name: ");
        scan.nextLine();
        firstName = scan.nextLine();
        System.out.print("Enter last name: ");
        lastName = scan.nextLine(); 
        System.out.print("Enter email: ");
        email = scan.nextLine(); 
        System.out.print("Enter phone number: ");
        phoneNumber = scan.nextLong();
    }
}

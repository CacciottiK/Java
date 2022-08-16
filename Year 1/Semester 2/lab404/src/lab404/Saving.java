package lab404;

public class Saving extends Account{
	   
	   //attributes
	    double interestRate;

	    //Constructor
	    Saving(){
	        interestRate = 3.99;
	    }

	    //override parent class method
	    @Override
	    void updateBalance() {
	        balance = balance + ((balance *interestRate)/100);
	    }
	}
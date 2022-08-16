package lab404;

public class Checking extends Account{
    //attributes
    double fees;

    //constructor
    Checking(){
        fees = 13.50;
    }

    //override parent method updateBalance
    @Override
    void updateBalance() {
        balance -= fees;
    }
    
}
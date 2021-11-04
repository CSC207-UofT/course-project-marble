package entity;

public class CreditCard extends Depositable {
    public CreditCard() {
        super(-19.9);
    }

    @Override
    public double deposit(double amount) {
        return 0;
    }

    @Override
    public void addInterest() {

    }

    @Override
    public double getValue() {
        return 0;
    }
}

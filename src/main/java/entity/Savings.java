package entity;

import java.util.Date;

public class Savings extends Depositable {

    public Savings(float annualInterestRate) {
        super(annualInterestRate);
    }

    @Override
    public double deposit(double amount) {
        double temp = this.getValue();
        temp = temp + amount;
        super.setBalance(temp);
        return super.getBalance();
    }

    @Override
    public void addInterest() {
        double monthlyInterest = super.getAnnualInterestRate() / 12;
        double temp = super.getBalance();
        temp = temp + (temp * (monthlyInterest / 100));
        super.setBalance(temp);
    }

    @Override
    public double getValue() {
        return super.getBalance();
    }
}

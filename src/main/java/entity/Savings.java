package entity;

import java.util.Date;

public class Savings extends Depositable {
    private Date lastInterestDate;

    public Savings(float annualInterestRate) {
        super(annualInterestRate);
    }

    public Date getLastInterestDate() {
        return this.lastInterestDate;
    }

    @Override
    public float deposit(float amount) {
        float temp = this.getValue();
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
    public float getValue() {
        return super.getBalance();
    }
}

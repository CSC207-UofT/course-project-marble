package entity;

import static java.lang.Math.round;

public class Savings extends Depositable {

    public Savings(double annualInterestRate, String name) {
        super(annualInterestRate, name);
    }

    /**
     * Deposits money into the savings account. Can also be used to take money out
     *
     * @param amount The amount that
     * @return The new balance after the deposit
     */
    @Override
    public double deposit(double amount) {
        double temp = this.getValue();
        temp = temp + amount;
        super.setBalance(temp);
        return super.getBalance();
    }

    /**
     * Adds a month of interest into the account
     */
    @Override
    public void addInterest() {
        double monthlyInterest = super.getAnnualInterestRate() / 12;
        double temp = super.getBalance();
        if (temp <= 0) {
            return;
        }
        temp = temp + (temp * (monthlyInterest / 100));
        temp = temp * 100;
        temp = round(temp);
        temp = temp / 100;
        super.setBalance(temp);
    }

    /**
     * Returns the current value of the Savings account
     *
     * @return Double balance of the savings account
     */
    @Override
    public double getValue() {
        return super.getBalance();
    }
}

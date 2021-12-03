package entity;

import static java.lang.Math.round;

public class CreditCard extends Depositable {
    /**
     * Constructor. Passes 19.9% interest to the super constructor
     */
    public CreditCard(String name) {
        super(19.9, name);

    }

    /**
     * Deposits money into the account
     * @param amount being deposited
     * @return new balance
     */
    @Override
    public double deposit(double amount) {
        double temp = this.getValue();
        temp = temp + amount;
        super.setBalance(temp);
        return super.getBalance();
    }

    /**
     * Adds a month of interest to the credit card
     */
    @Override
    public void addInterest() {
        double monthlyInterest = super.getAnnualInterestRate() / 12;
        double temp = super.getBalance();
        if (temp >= 0.0){
            return;
        }
        temp = temp + (temp * (monthlyInterest / 100));
        temp = temp * 100;
        temp = round(temp);
        temp = temp / 100;
        super.setBalance(temp);
    }

    /**
     * Returns value today
     * @return worth of the account
     */
    @Override
    public double getValue() {
        return super.getBalance();
    }
}

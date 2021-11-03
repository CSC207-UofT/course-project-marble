package entity;

import java.util.Date;

public class Savings extends Depositable{
    private Date lastInterestDate;
    public Savings(float annualInterestRate){
        super(annualInterestRate);
    }
    public Date getLastInterestDate() {
        return this.lastInterestDate;
    }
    @Override
    public float deposit(float amount){
        float temp = this.getValue();
        temp = temp + amount;
        super.setBalance(temp);
        return super.getBalance();
    }
    @Override
    public float withdraw() {
        return 0;
    }

    @Override
    public float getValue() {
        return 0;
    }
}

package entity;

import java.text.SimpleDateFormat;

public abstract class FinancialInstrument {
    private final Date dateCreated;
    public float annualInterestRate;

    public FinancialInstrument(Date dateCreated, float annualInterestRate) {
        this.dateCreated = dateCreated;
        this.annualInterestRate = annualInterestRate;
    }

    public abstract double getValue();

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }


    public SimpleDateFormat getDateCreated() {
        return dateCreated;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

}

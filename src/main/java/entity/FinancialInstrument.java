package entity;

import java.text.SimpleDateFormat;

public abstract class FinancialInstrument {
    private final SimpleDateFormat dateCreated;
    public double annualInterestRate;

    public FinancialInstrument(double annualInterestRate) {
        this.dateCreated = new SimpleDateFormat("MM/yyyy");
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

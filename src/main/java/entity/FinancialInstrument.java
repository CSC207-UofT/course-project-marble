package entity;

import java.util.Date;

public abstract class FinancialInstrument {
    private final Date dateCreated;
    public float annualInterestRate;

    public FinancialInstrument(Date dateCreated, float annualInterestRate) {
        this.dateCreated = dateCreated;
        this.annualInterestRate = annualInterestRate;
    }

    public abstract float getValue();

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }


    public Date getDateCreated() {
        return dateCreated;
    }

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}

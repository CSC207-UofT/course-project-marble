package entity;

import java.util.Date;

public abstract class FinancialInstrument {
    private final Date dateCreated;
    private final int volume;
    public float annualInterestRate;

    public FinancialInstrument(Date dateCreated, int volume, float annualInterestRate){
        this.dateCreated = dateCreated;
        this.volume = volume;
        this.annualInterestRate = annualInterestRate;
    }
    public abstract float withdraw();
    public abstract float getValue();

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getVolume() {
        return volume;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}

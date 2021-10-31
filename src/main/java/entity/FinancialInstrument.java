package entity;

import java.util.Date;

public abstract class FinancialInstrument {
    private final Date dateCreated;
    private final int volume;
    public float annualInterestRate;

    public FinancialInstrument(Date dateCreated, int volume, float interestRate){
        this.dateCreated = dateCreated;
        this.volume = volume;
        this.interestRate = interestRate;
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

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}

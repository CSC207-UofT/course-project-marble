package entity;

import java.util.Date;

public abstract class FinancialInstrument {
    private Date dateCreated;
    private int volume;
    public float interestRate;

    public FinancialInstrument(Date dateCreated, int volume, float interestRate){
        this.dateCreated = dateCreated;
        this.volume = volume;
        this.interestRate = interestRate;
    }

    public float getInterestRate() {
        return interestRate;
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

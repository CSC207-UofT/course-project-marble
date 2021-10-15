package entity;

import java.util.Date;

public class SavingsRecord {
    private final Date date;
    private final int accountID;
    private final double interestRate;

    public SavingsRecord(int accountID,
                         double interestRate) {

        this.date = new Date();
        this.accountID = accountID;
        this.interestRate = interestRate;
    }

    public Date getSavingsRecordDate() {
        return this.date;
    }

    public int getSavingsRecordAccountID() {
        return this.accountID;
    }

    public double getSavingsRecordInterestRate() {
        return this.interestRate;
    }

}

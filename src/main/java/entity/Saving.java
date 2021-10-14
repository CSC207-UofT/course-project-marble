package entity;

import java.util.ArrayList;

public class Saving extends Account{
    private double interestRate;
    private final ArrayList<SavingsRecord> SavingsRecordsList;


    public Saving(ArrayList<Integer> listOfAccountsID, double interestRate) {
        super(listOfAccountsID);
        this.SavingsRecordsList = new ArrayList<>();
        this.interestRate = interestRate;
        SavingsRecordsList.add(new SavingsRecord(this.getAccountID(), this.interestRate));
    }


    public ArrayList<SavingsRecord> getSavingsRecordsList() {
        return this.SavingsRecordsList;
    }

    /**
     * get the interest rate of the savings account
     * @return the current interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }


    /**
     * change the interest rate in the savings account
     * @param newInterestRate the new interest rate
     * @return true if the interest rate is set.
     */
    public boolean changeInterestRate(int newInterestRate){
        this.interestRate = newInterestRate;
        SavingsRecordsList.add(new SavingsRecord(this.getAccountID(), this.interestRate));
        return true;
    }
}

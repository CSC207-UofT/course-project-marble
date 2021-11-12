package entity;

import java.util.ArrayList;

public abstract class DepositRecord {

    private double amount;
    private Date purchaseDate;
    private ArrayList<SpendingRecord> depositRecordList;


    /**
     *
     * @param amount : the amount of deposit.
     * @param depositDate : the date of the deposit.
     */
    public DepositRecord(double amount, Date depositDate){
        this.amount = -amount;
        this.purchaseDate = depositDate;
    }

    public boolean addDepositRecord(SpendingRecord s){
        this.depositRecordList.add(s);
        return true;
    }

    public ArrayList<SpendingRecord> getDepositRecordList() {
        return depositRecordList;
    }
}

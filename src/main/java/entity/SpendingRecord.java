package entity;

import java.util.ArrayList;

public class SpendingRecord{

    private double amount;
    private Date purchaseDate;
    private ArrayList<SpendingRecord> spendingRecordList;

    /**
     * This is a constructor object to create a spending Record. When an owner purchases an item, this object is
     * created.
     *
     * @param amount : the amount for the item.
     * @param purchaseDate : the date of purchase.
     */

    public SpendingRecord(double amount, Date purchaseDate){
        this.amount = -amount;
        this.purchaseDate = purchaseDate;
    }

    public boolean addSpendingRecord(SpendingRecord s){
        this.spendingRecordList.add(s);
        return true;
    }

    public ArrayList<SpendingRecord> getSpendingRecordList() {
        return spendingRecordList;
    }
}

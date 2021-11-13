package entity;


import java.time.LocalDateTime;
import java.util.ArrayList;

public class SpendingRecord{

    private double amount;
    private LocalDateTime purchaseDate;
    private ArrayList<SpendingRecord> spendingRecordList;

    /**
     * This is a constructor object to create a spending Record. When an owner purchases an item, this object is
     * created.
     *
     * @param amount : the amount for the item.
     * @param SpendingDate : the date of purchase.
     */

    public SpendingRecord(double amount, Date SpendingDate){
        this.amount = -amount;
        this.SpendingDate = SpendingDate;
    }

    public double getAmount() {
        return amount;
    }

    public Date getSpendingDate() {
        return SpendingDate;
    }
}

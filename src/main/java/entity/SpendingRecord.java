package entity;


public class SpendingRecord{

    private double amount;
    private Date SpendingDate;
    private String category;

    /**
     * This is a constructor object to create a spending Record. When an owner purchases an item, this object is
     * created.
     *
     * @param amount : the amount for the item.
     * @param SpendingDate : the date of purchase.
     */

    public SpendingRecord(double amount, Date SpendingDate, String category){
        this.category = category;
        this.amount = -amount;
        this.SpendingDate = SpendingDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public Date getSpendingDate() {
        return this.SpendingDate;
    }
    public String getCategory(){
        return this.category;
    }
}

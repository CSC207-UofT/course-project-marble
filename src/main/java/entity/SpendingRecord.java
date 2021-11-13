package entity;

public class SpendingRecord extends Record{

    /**
     * This is a constructor object to create a spending Record. When an owner purchases an item, this object is
     * created.
     *
     * @param amount : the amount for the item.
     * @param purchaseDate : the date of purchase.
     * @param category :
     * @param description: the description of purchase.
     */

    public SpendingRecord(double amount, Date purchaseDate, String category, String description){
        super(amount, purchaseDate, category, description);
    }

}

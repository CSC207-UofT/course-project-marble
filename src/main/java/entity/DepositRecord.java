package entity;

public class DepositRecord extends Record{

    /**
     * This is a constructor object to create a deposit Record. When an owner deposits an amount, this object is
     * created.
     *
     * @param amount : the amount of deposit.
     * @param depositDate : the date of the deposit.
     * @param category :
     * @param description : the description of deposit.
     */
    public DepositRecord(double amount, Date depositDate, String category, String description){
        super(amount, depositDate, category, description);
    }

}

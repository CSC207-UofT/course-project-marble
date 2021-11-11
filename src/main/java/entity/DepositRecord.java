package entity;

public abstract class DepositRecord {

    private final double amount;
    private final Date depositDate;


    /**
     *
     * @param amount : the amount of deposit.
     * @param depositDate : the date of the deposit.
     */
    public DepositRecord(double amount, Date depositDate){
        this.amount = amount;
        this.depositDate = depositDate;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPurchaseDate() {
        return depositDate;
    }
}

package entity;
public class Savings extends FinancialInstrument{
    private int balance;
    public Savings(float annualInterestRate){
        super(new java.util.Date(), annualInterestRate);
        this.balance = 0;
    }

    @Override
    public float withdraw() {
        return 0;
    }

    @Override
    public float getValue() {
        return 0;
    }
}

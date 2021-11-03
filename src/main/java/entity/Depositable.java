package entity;

public abstract class Depositable extends FinancialInstrument{
    private float balance;
    public Depositable(float annualInterestRate){
        super(new java.util.Date(), annualInterestRate);
        this.balance = 0;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
    public abstract float deposit(float amount);
    public abstract void addInterest();
}

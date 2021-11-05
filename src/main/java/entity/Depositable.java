package entity;

public abstract class Depositable extends FinancialAsset {
    private double balance;
    public Depositable(double annualInterestRate){
        super(annualInterestRate);

        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public abstract double deposit(double amount);
    public abstract void addInterest();
}

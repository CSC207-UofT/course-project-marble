package entity;

public abstract class Depositable extends FinancialAsset {
    private double balance;

    public Depositable(double annualInterestRate, String name) {
        super(annualInterestRate, name);

        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Asset" + this.name + " created on " + super.getDateCreated() + "has a balance of " + this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public abstract double deposit(double amount);

    public abstract void addInterest();
}

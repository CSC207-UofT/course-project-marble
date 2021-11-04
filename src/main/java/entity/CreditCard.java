package entity;

public class CreditCard extends Depositable {
    public CreditCard() {
        super(19.9);
    }

    @Override
    public double deposit(double amount) {
        double temp = this.getValue();
        temp = temp - amount;
        super.setBalance(temp);
        return super.getBalance();
    }

    @Override
    public void addInterest() {
        double monthlyInterest = super.getAnnualInterestRate() / 12;
        double temp = super.getBalance();
        temp = temp - (temp * (monthlyInterest / 100));
        super.setBalance(temp);
    }

    @Override
    public double getValue() {
        return super.getBalance();
    }
}

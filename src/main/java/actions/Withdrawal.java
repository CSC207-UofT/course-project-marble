package actions;
import entity.*;

public class Withdrawal extends Actions{
    private Owner user;
    private final Date date;

    public Withdrawal(Owner user){
        this.user = user;
        this.date = new Date();
    }

    /**
     * This method withdraws money from the users balance.
     * @param num The amount to be withdrawn
     * @return true if money is withdrawn, false if money can not be withdrawn.
     */
    public boolean withdraw(int num){
        if (num <= user.getBalance()) {
            SpendingRecord spending = new SpendingRecord(num, this.date, null);
            user.addSpendingRecord(spending);
            user.setBalance(user.getBalance() - num);
            return true;
        }
        System.out.println("Unable to withdraw. Please Try Again.");
        return false;
    }
}

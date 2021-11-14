package actions;
import entity.*;
import entity.Record;
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
            Record spending = new Record(num, this.date, null, null);
            user.addRecord(spending);
            user.setBalance(user.getBalance() - num);
            return true;
        }
        System.out.println("Unable to withdraw. Please Try Again.");
        return false;
    }
}

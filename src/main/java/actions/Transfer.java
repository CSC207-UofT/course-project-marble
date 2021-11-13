package actions;
import entity.*;


public class Transfer extends Actions{
    private Owner user;
    private final Date date;

    public Transfer(Owner user){
        this.user = user;
        this.date = new Date();
    }

    /**
     * This method transfers money from the user's balance to a Depositable account.
     * @param num : the amount to be transferred.
     * @param account: the account the money is transferred to
     * @return true if money is transferred successfully, false if money can not be transferred.
     */
    public boolean transferBalance(double num, Depositable account){
        if (num <= user.getBalance()){
            user.setBalance(user.getBalance() - num);
            account.setBalance(account.getBalance() + num);
            SpendingRecord withdrawal = new SpendingRecord(num, this.date, null, "Banking transfer");
            user.addRecord(withdrawal);
            return true;
        }
        System.out.println("Unable to transfer money from account. Please try again.");
        return false;
    }

    /**
     * This method transfers money from a Depositable account to another Depositable account.
     * @param num : the amount to be transferred.
     * @param account1 : the account the money is transferred from.
     * @param account2 : the account the money is transferred to.
     * @return true if money is transferred successfully, false if money can not be transferred.
     */
    public boolean transferDepositable(double num, Depositable account1, Depositable account2){
        if (num <= account1.getBalance()){
            account1.setBalance(account1.getBalance() - num);
            account2.setBalance(account2.getBalance() + num);
            return true;
        }
        System.out.println("Unable to transfer money from account. Please try again.");
        return false;
    }

    /**
     * This method transfers money from a Depositable account to the user's balance.
     * @param num : the amount to be transferred.
     * @param account1 : the account the money is transferred from.
     * @return true if money is transferred successfully, false if money can not be transferred.
     */
    public boolean transferDepositable(double num, Depositable account1){
        if (num <= account1.getBalance()){
            account1.setBalance(account1.getBalance() - num);
            user.setBalance(user.getBalance() + num);
            DepositRecord deposit = new DepositRecord(num, this.date, null, "Banking transfer");
            user.addRecord(deposit);
            return true;
        }
        System.out.println("Unable to transfer money from account. Please try again.");
        return false;
    }

}

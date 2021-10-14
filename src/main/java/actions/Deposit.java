package actions;
import entity.*;
import java.util.HashMap;

public class Deposit extends Actions{
    public Owner own;
    public Deposit(Owner owner){
        own = owner;
    }
    public String depositIn(int num, String id){
        HashMap<Integer, Account> accounts = own.getAccounts();
        if (accounts.get(Integer.valueOf(id)) == null){
            return "Failed to deposit. Account with ID " +  id +
                    " does not exist for this user.";
        } else{
            accounts.get(Integer.valueOf(id)).increaseBalance(num);
            return "Successful deposit of $" + num +
                    " to the account with ID" + id;
        }
    }
}

package actions;
import entity.*;
import java.util.HashMap;

public class Withdrawal extends Actions{
    public Owner own;
    public Withdrawal(Owner owner){
         own = owner;
    }
    public String withdrawOut(int num, String id){
        HashMap<Integer, Account> accounts = own.getAccounts();
        if (accounts.get(Integer.valueOf(id)) == null){
            return "Failed to withdraw. Account with ID " +  id +
                    " does not exist for this user.";
        } else{
            accounts.get(Integer.valueOf(id)).decreaseBalance(num);
            return "Successfully withdrawn $" + String.valueOf(num) +
                    " from account with ID" + id;
        }
    }
}

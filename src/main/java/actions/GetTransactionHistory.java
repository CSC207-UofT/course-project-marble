package actions;
import entity.*;

import java.util.ArrayList;
import java.util.HashMap;

public class GetTransactionHistory extends Actions{
    public Owner own;
    public GetTransactionHistory(Owner owner){own = owner;}

    public ArrayList<String> displayHistory(int accountID){
        Account acc = own.getAccounts().get(accountID);
        ArrayList<Transaction> transactions = acc.getTransactionHistoryArray();
        ArrayList<String> history = new ArrayList<String>();
        String s = "";
        for (int t = transactions.size() - 1; t >= 0; t--){
            Transaction curr = transactions.get(t);
            s = "Date: " + curr.getDate() + "\n To: "
                    + String.valueOf(curr.getTargetAccount().getAccountID())
                    + "\n Type: "
                    + curr.getTransactionType() + "\n Status: "
                    + curr.getTransactionStatus();
            history.add(s);
            s = "";
        }
        return history;
    }

}

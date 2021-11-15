package actions;

import entity.*;
import entity.Record;

import java.util.Collections;

public class TransactionHistory extends Actions{
    private Owner user;

    public TransactionHistory(Owner user){ this.user = user; }

    /**
     * This method displays the transaction history of the user's balance.
     * @return String of all transaction history.
     */
    public String displayHistory(){
        StringBuilder display = new StringBuilder();
        display.append(String.format("%-22s%-22s%-22s%-22s\n","Date","Description","Withdrawals","Deposits"));
        Collections.sort(user.getListRecord());
        for (Record r : user.getListRecord()){
            if(r.getAmount()<0){
                display.append(String.format("%-22s%-22s%-22s%-22s\n",r.getDate(),r.getDescription(),"-$"+(-1*r.getAmount()),""));
            }
            else{
                display.append(String.format("%-22s%-22s%-22s%-22s\n",r.getDate(),r.getDescription(),"","$"+(r.getAmount())));
            }
        }
        return display.toString();
    }
}

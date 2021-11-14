package actions;


import entity.*;
import entity.Record;

import java.util.Collections;

public class TransactionHistory {
    private Owner user;

    public TransactionHistory(Owner user){ this.user = user; }

    /**
     * This method displays the transaction history of the user's balance.
     */
    /**public void displayTransactionHistory(){
        System.out.printf("%-22s%-22s%-22s%-22s\n","Date","Description","Withdrawals","Deposits");
        Collections.sort(user.getListRecord());
        for (Record r : user.getListRecord()){
            if(r instanceof SpendingRecord){
                System.out.printf("%-22s%-22s%-22s%-22s\n",r.getDate(),r.getDescription(),"-$"+(-1*r.getAmount()),"");
            }
            else{
                System.out.printf("%-22s%-22s%-22s%-22s\n",r.getDate(),r.getDescription(),"","$"+(-1*r.getAmount()));
            }
        }
    }*/
}

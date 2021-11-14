package actions;

import entity.Record;
import entity.Owner;

import java.util.ArrayList;

public class DisplayDepositRecord {
    private Owner user;

    public DisplayDepositRecord(Owner user){
        this.user = user;
    }

    /**
     * This method returns the users deposit record as an ArrayList
     */
    /**public ArrayList<Record> getUserDepositRecord(){
        return user.getListRecord();
    } */
}

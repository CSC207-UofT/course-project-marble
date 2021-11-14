package actions;

import entity.DepositRecord;
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
    public ArrayList<DepositRecord> getUserDepositRecord(){
        return user.getListOfDepositRecord();
    }
}

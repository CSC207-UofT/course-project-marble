package actions;
import entity.*;

import java.util.ArrayList;

public class DisplaySpendingRecord {
    private Owner user;

    public DisplaySpendingRecord(Owner user){
        this.user = user;
    }

    /**
     * This method returns the users spending record as an ArrayList
     */
    public ArrayList<SpendingRecord> getUserSpendingRecord(){
        return user.getListOfSpendingRecord();
    }
}


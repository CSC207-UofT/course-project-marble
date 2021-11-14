package action_request_response;

import entity.Record;

import java.util.ArrayList;

public class DisplayDepositRecordResponse extends ActionResponse {
    private final ArrayList<Record> result;

    /**
     * Constructor that creates a DisplayDepositRecord response returned from DisplayDepositRecord action
     * @param result an ArrayList of the users deposits.
     */
    public DisplayDepositRecordResponse(ArrayList<Record> result){
        this.result = result;
    }

    public ArrayList<Record> getResult() {
        return result;
    }
}

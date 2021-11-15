package action_request_response;

import entity.Record;

import java.util.ArrayList;

public class DisplayWithdrawalRecordResponse extends ActionResponse {
    private final ArrayList<Record> result;

    /**
     * Constructor that creates a DisplayWithdrawal response returned from DisplayWithdrawalRecord action
     *
     * @param result the list of withdrawals in the users record
     */
    public DisplayWithdrawalRecordResponse(ArrayList<Record> result) {
        this.result = result;
    }

    public ArrayList<Record> getResult() {
        return result;
    }
}

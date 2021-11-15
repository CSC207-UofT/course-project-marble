package action_request_response;

public class DisplayDepositRecordResponse extends ActionResponse {
    private final String result;

    /**
     * Constructor that creates a DisplayDepositRecord response returned from DisplayDepositRecord action
     *
     * @param result an ArrayList of the users deposits.
     */
    public DisplayDepositRecordResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

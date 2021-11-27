package action_request_response;

public class DisplayWithdrawalRecordResponse extends ActionResponse {
    private final String result;

    /**
     * Constructor that creates a DisplayWithdrawal response returned from DisplayWithdrawalRecord action
     *
     * @param result the list of withdrawals in the users record
     */
    public DisplayWithdrawalRecordResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

package action_request_response;

public class DisplayWithdrawalRecordRequest extends ActionRequest {
    /**
     * Create a request to display withdrawal record used in the DisplayWithdrawalRecord action.
     * @param username Users username
     */
    public DisplayWithdrawalRecordRequest(String username) {
        super(username);
    }
}

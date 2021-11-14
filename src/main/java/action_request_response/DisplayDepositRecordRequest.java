package action_request_response;

public class DisplayDepositRecordRequest extends ActionRequest {
    /**
     * Constructor that creates a DisplayDepositRecord request that's used in the DisplayDepositRecord action.
     * @param username the users username
     */
    public DisplayDepositRecordRequest(String username) {
        super(username);
    }
}

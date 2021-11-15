package action_request_response;

public class UpdateDepositableRequest extends ActionRequest {
    /**
     * Constructor that creates a DisplayDepositRecord request that's used in the DisplayDepositRecord action.
     *
     * @param username the users username
     */
    public UpdateDepositableRequest(String username) {
        super(username);
    }
}

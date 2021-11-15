package action_request_response;

public class ViewInvestmentsRequest extends ActionRequest {
    /**
     * Constructor that creates a DisplayDepositRecord request that's used in the DisplayDepositRecord action.
     *
     * @param username the users username
     */
    public ViewInvestmentsRequest(String username) {
        super(username);
    }
}

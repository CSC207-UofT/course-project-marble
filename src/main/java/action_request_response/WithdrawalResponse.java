package action_request_response;

public class WithdrawalResponse extends ActionResponse {
    private final boolean result;

    /**
     * Constructor that create a Withdrawal response returned from the Withdrawal action
     *
     * @param result a boolean of whether the amount was withdrawn from the users balance.
     */
    public WithdrawalResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return this.result;
    }
}

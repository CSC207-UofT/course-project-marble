package action_request_response;

/**
 * Class is responsible for keeping the information on if the
 * Deposit request was able to be done or not
 */
public class DepositResponse extends ActionResponse {
    private final boolean result;

    /**
     * Initializer
     *
     * @param result boolean value that tells us if request was
     *               successful or not
     */
    public DepositResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }
}

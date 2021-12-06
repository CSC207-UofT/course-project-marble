package action_request_response;

public class CashOutResponse extends ActionResponse {
    private final boolean result;

    /**
     * Constructor that creates an instance of CashOutResponse given a boolean result
     *
     * @param result boolean result from the related use case that generates this CashOutResponse
     */
    public CashOutResponse(boolean result) {
        this.result = result;
    }

    /**
     * Getter method for result in CashOutResponse
     *
     * @return a boolean result
     */
    public boolean getResult() {
        return result;
    }
}

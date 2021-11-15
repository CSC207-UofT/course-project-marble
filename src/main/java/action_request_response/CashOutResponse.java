package action_request_response;

public class CashOutResponse extends ActionResponse {
    private final boolean result;

    public CashOutResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }
}

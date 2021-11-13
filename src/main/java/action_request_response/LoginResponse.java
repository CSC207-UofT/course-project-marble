package action_request_response;

public class LoginResponse extends ActionResponse {
    private final boolean result;

    public LoginResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return this.result;
    }
}

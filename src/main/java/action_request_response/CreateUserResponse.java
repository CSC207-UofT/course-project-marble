package action_request_response;

public class CreateUserResponse extends ActionResponse {
    private final boolean result;

    public CreateUserResponse(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return this.result;
    }
}

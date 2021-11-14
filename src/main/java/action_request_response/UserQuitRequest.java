package action_request_response;

public class UserQuitRequest extends ActionRequest {
    public UserQuitRequest(String username) {
        super(username);
    }

    @Override
    public boolean isQuit() {
        return true;
    }
}

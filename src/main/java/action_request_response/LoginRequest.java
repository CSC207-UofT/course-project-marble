package action_request_response;

public class LoginRequest extends ActionRequest {
    private final String password;

    public LoginRequest(String username, String password) {
        super(username);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}

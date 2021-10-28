package action_request_response;

public class LoginRequest extends ActionRequest {
    private final String password;

    public LoginRequest(String username, String pwd) {
        super(username);
        this.password = pwd;
    }

    public String getPassword() {
        return password;
    }
}

package action_request_response;

public class LoginRequest extends ActionRequest {
    String username;
    String password;

    public LoginRequest(String username, String pwd) {
        this.username = username;
        this.password = pwd;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

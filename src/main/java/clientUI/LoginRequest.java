package clientUI;

public class LoginRequest extends ActionRequest{
    String username;
    String password;

    public LoginRequest(String actionName, String username, String pwd){
        super(actionName);
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

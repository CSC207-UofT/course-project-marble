package action_request_response;

public class CreateUserRequest extends ActionRequest{
    private final String fullname;
    private final String password;

    public CreateUserRequest(String fullname, String username, String pwd) {
        super(username);
        this.fullname = fullname;
        this.password = pwd;
    }

    public String getFullname() {return fullname; }

    public String getPassword() {
        return password;
    }
}

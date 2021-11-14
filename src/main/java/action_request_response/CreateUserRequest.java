package action_request_response;

public class CreateUserRequest extends ActionRequest{
    private final String fullname;
    private final String password;

    /**
     * Constructor that creates an instance of CreateUserRequest given a fullname, username, and password
     * @param fullname String full name of the user
     * @param username String username of the user
     * @param password String password of the user
     */
    public CreateUserRequest(String fullname, String username, String password) {
        super(username);
        this.fullname = fullname;
        this.password = password;
    }

    /**
     * Getter method for full name in CreateUserRequest
     * @return full name stored in this CreateUserRequest
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Getter method for password in CreateUserRequest
     * @return password stored in this CreateUserRequest
     */
    public String getPassword() {
        return password;
    }
}

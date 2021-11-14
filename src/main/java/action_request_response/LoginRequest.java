package action_request_response;

public class LoginRequest extends ActionRequest {
    private final String password;

    /**
     * Constructor that creates an instance of CreateUserRequest given a username and password
     *
     * @param username String username of the user
     * @param password String password of the user
     */
    public LoginRequest(String username, String password) {
        super(username);
        this.password = password;
    }

    /**
     * Getter method for password in LoginRequest
     *
     * @return password stored in this LoginRequest
     */
    public String getPassword() {
        return password;
    }
}

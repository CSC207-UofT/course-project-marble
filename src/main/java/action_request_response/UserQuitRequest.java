package action_request_response;

public class UserQuitRequest extends ActionRequest {
    /**
     * Constructor that creates an instance of UserQuitRequest given a username
     *
     * @param username String username of the user
     */
    public UserQuitRequest(String username) {
        super(username);
    }

    /**
     * Returns whether this is a UserQuitRequest
     *
     * @return true
     */
    @Override
    public boolean isQuit() {
        return true;
    }
}

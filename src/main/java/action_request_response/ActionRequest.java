package action_request_response;

import java.io.Serializable;

public abstract class ActionRequest implements Serializable {
    private final String username;

    /**
     * Constructor that creates an instance of ActionRequest given a username
     *
     * @param username String username of the user
     */
    public ActionRequest(String username) {
        this.username = username;
    }

    /**
     * Returns whether the ActionRequest is a UserQuitRequest
     *
     * @return a boolean of whether the ActionRequest is a UserQuitRequest
     */
    public boolean isQuit() {
        return false;
    }

    /**
     * Getter method for username in ActionRequest
     *
     * @return username stored in this ActionRequest
     */
    public String getUsername() {
        return username;
    }
}

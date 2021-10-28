package action_request_response;

import java.io.Serializable;

public abstract class ActionRequest implements Serializable {
    private final String username;

    public ActionRequest(String username) {
        this.username = username;
    }

    public boolean isQuit() {
        return false;
    }

    public String getUsername() {
        return username;
    }
}

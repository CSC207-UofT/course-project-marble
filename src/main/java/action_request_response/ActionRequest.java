package action_request_response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public  class ActionRequest implements Serializable {
    private final String username;
    private final Commands command;
    private final ArrayList<String> userInputs;

    /**
     * Constructor that creates an instance of ActionRequest given a username
     *
     * @param username String username of the user
     */
    public ActionRequest(String username, Commands command, ArrayList<String> userInputs) {
        this.username = username;
        this.command = command;
        this.userInputs = userInputs;
    }


    /**
     * Returns whether the ActionRequest is a UserQuitRequest
     *
     * @return  boolean of whether the ActionRequest is a UserQuitRequest
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

    /**
     * This is a getter for the command instance variable in the data class\
     * @return enum of the action type
     */
    public Commands getCommand() {
        return command;
    }

    public ArrayList<String> getUserInputs() {
        return userInputs;
    }
}

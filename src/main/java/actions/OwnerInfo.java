package actions;
import action_request_response.ActionResponse;
import action_request_response.OwnerInfoRequest;
import action_request_response.OwnerInfoResponse;
import java.lang.StringBuilder;

/**
 * Class is responsible for returning a String acting as a
 * "User Profile" for the User to view
 *
 */
public class OwnerInfo extends Actions{
    private final String fullname;
    private final String username;
    private final double balance;

    /**initializer for the class
     *
     * @param request contains the needed information the class
     *                object will process
     */
    public OwnerInfo(OwnerInfoRequest request){
        fullname = request.getFullName();
        username = request.getUsername();
        balance = request.getBalance();
    }

    /**
     * Processes the request
     * @return the response containing the String that will be
     * displayed and veiwed
     */
    @Override
    public ActionResponse process(){
        StringBuilder display = new StringBuilder();
        display.append("User Profile:\n Name: ");
        display.append(fullname);
        display.append("\nUsername: ");
        display.append(username);
        display.append("\nBalance: $");
        display.append(balance);
        display.append("\n");
        return new OwnerInfoResponse(display.toString());
    }

}

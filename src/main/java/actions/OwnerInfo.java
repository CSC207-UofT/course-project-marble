package actions;
import action_request_response.ActionResponse;
import action_request_response.OwnerInfoRequest;
import action_request_response.OwnerInfoResponse;

public class OwnerInfo extends Actions{
    private final String fullname;
    private final String username;
    private final double balance;

    public OwnerInfo(OwnerInfoRequest request){
        fullname = request.getFullName();
        username = request.getUsername();
        balance = request.getBalance();
    }

    @Override
    public ActionResponse process(){
        String display = "User Profile:\n Name: " + fullname +"\n";
        display = display + "Username: " + username + "\n";
        display = display + "Balance: $" + balance + "\n";
        return new OwnerInfoResponse(display);
    }

}

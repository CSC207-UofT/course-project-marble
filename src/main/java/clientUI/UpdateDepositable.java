package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;

public class UpdateDepositable {
    public ActionRequest updateDepositable(String username){
        return new ActionRequest(username, Commands.UPDATEDEPOSITABLE, new ArrayList<>());
    }
}

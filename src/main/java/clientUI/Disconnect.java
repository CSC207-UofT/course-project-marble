package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;

public class Disconnect {
    public ActionRequest Disconnect(String username){
        ActionRequest request = new ActionRequest(username,
                Commands.USERQUIT, new ArrayList<>());
        return request;
    }
}

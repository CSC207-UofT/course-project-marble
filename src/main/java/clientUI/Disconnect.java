package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;

public class Disconnect {
    public ActionRequest disconnect(String username){
        return new ActionRequest(username,
                Commands.USERQUIT, new ArrayList<>());
    }
}

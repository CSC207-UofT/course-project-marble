package clientUI;

import action_request_response.ActionRequest;
import action_request_response.Commands;

import java.util.ArrayList;

public class VIewInvestments {
    public ActionRequest ViewInvestments(String username) {
        ActionRequest request = new ActionRequest(username, Commands.VIEWINVESTMENTS, new ArrayList<>());
        return request;
    }
}

package server;


import action_request_response.ActionRequest;
import action_request_response.CreateUserRequest;
import action_request_response.LoginRequest;
import actions.Actions;
import actions.CheckLogin;
import actions.CreateOwner;

public class ActionFactory {
    public Actions getAction(ActionRequest request) {
        if (request instanceof LoginRequest) {
            return new CheckLogin((LoginRequest) request);
        } else if (request instanceof CreateUserRequest) {
            return new CreateOwner((CreateUserRequest) request);
        } else {
            return null;
        }
    }
}

package clientUI;

import action_request_response.ActionRequest;
import action_request_response.LoginRequest;
import actions.CheckLogin;

public class CallActions {
    /**
     * Takes in a ActionRequest Object and calls the according Action to process that request
     */
    public boolean processActionRequest(ActionRequest request) {
        if (request instanceof LoginRequest) {
            CheckLogin obj = new CheckLogin((LoginRequest) request);
            boolean result = obj.process();
            return result;
        }
        return false;
    }
}

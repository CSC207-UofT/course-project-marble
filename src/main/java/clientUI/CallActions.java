package clientUI;

import actions.CheckLogin;

public class CallActions {
    /**
     * Takes in a ActionRequest Object and calls the according Action to process that request
     */
    public boolean processActionRequest(ActionRequest request) {
        if (request instanceof LoginRequest) {
            CheckLogin obj = new CheckLogin((LoginRequest) request);
            boolean result = obj.Process();
            return result;
        }
        return false;
    }
}

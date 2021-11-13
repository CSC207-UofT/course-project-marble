package actions;

import action_request_response.ActionResponse;

public abstract class Actions {
    private ActionResponse result;

    public Actions() {
    }

    public ActionResponse process() {
        return result;
    }
}

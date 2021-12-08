package action_request_response;

import java.util.ArrayList;

public class SimulateResponse extends ActionResponse {
    private final ArrayList<String> result;

    /**
     * Constructor that create a Simulate response returned from the Simulate action.
     * @param result The simulated values of the financial assets
     */
    public SimulateResponse(ArrayList<String> result) {
        this.result = result;
    }

    public ArrayList<String> getResult() {
        return this.result;
    }
}

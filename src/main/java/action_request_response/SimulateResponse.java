package action_request_response;

import java.util.ArrayList;

public class SimulateResponse extends ActionResponse {
    private final ArrayList<Double> result;

    /**
     * Constructor that create a Simulate response returned from the Simulate action.
     * @param result The simulated values of the Financial Assets
     */
    public SimulateResponse(ArrayList<Double> result) {
        this.result = result;
    }

    public ArrayList<Double> getResult() {
        return this.result;
    }
}

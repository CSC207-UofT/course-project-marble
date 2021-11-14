package action_request_response;

public class SimulateResponse extends ActionResponse {
    private final double result;

    /**
     * Constructor that create a Simulate response returned from the Simulate action.
     * @param result The simulated value of the Financial Asset
     */
    public SimulateResponse(double result) {
        this.result = result;
    }

    public double getResult() {
        return this.result;
    }
}

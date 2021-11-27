package actions;

import action_request_response.ActionResponse;
import action_request_response.SimulateResponse;

public abstract class Simulate extends Actions{
    /**
     * This is a constructor method for an abstract class for simulating worth of depositable and
     * nondepositable assets.
     */
    public Simulate(){}

    public abstract double getAssetValue(); // hook method

    /** Template method: This method returns an action response for the simulated asset value
     * for a particular asset */
    @Override
    public ActionResponse process() {
        return new SimulateResponse(getAssetValue());
    }
}

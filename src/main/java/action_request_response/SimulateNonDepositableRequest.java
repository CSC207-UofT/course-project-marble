package action_request_response;

import entity.NonDepositable;

public class SimulateNonDepositableRequest extends ActionRequest {
    private final NonDepositable nonDepositableAsset;

    /**
     * Constructer that creates SimulateNonDepositable request that is used in the SimulateNonDepositable action
     * @param username the users username
     * @param asset the nondepositable asset the user is simulating on.
     */
    public SimulateNonDepositableRequest(String username, NonDepositable asset) {
        super(username);
        this.nonDepositableAsset = asset;
    }

    public NonDepositable getNonDepositableAsset() {
        return this.nonDepositableAsset;
    }
}

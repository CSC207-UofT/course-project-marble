package action_request_response;

import entity.Date;
import entity.Depositable;

public class SimulateDepositableRequest extends ActionRequest {
    private final Date endDate;
    private final Depositable depositableAsset;

    /**
     * Constructor that creates a SimulateDepositable request that is used in SimulateDepositable action
     *
     * @param username         Users username
     * @param depositableAsset The depositable financial asset the user is simulating
     * @param endDate          The future date the simulation must estimate
     */
    public SimulateDepositableRequest(String username, Depositable depositableAsset, Date endDate) {
        super(username);
        this.endDate = endDate;
        this.depositableAsset = depositableAsset;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Depositable getDepositableAsset() {
        return depositableAsset;
    }
}

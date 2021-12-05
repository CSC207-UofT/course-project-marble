package actions;

import action_request_response.SimulateNonDepositableRequest;
import entity.Date;
import entity.NonDepositable;
import entity.Owner;

public class SimulateNonDepositable extends Simulate {
    private final NonDepositable asset;
    private final Date endDate; // future date

    public SimulateNonDepositable(SimulateNonDepositableRequest request, Date endDate, Owner owner) {
        super(owner, endDate);
        this.asset = request.getNonDepositableAsset();
        this.endDate = endDate;
    }
    /**
     * This method calculates the asset value of the nondepositable asset
     * @return returns the worth of the NonDepositable asset after calculating the simulated worth of the Nondepositable.
     */

//    @Override
//    public double getAssetValue() {
//        if (endDate.compareTo(asset.getDateOfMaturity()) < 0) {
//            return 0;
//        }
//        return asset.getValue();
//        }
}

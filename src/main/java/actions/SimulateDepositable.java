package actions;

import action_request_response.SimulateDepositableRequest;
import entity.Date;
import entity.Depositable;
import entity.Owner;

public class SimulateDepositable extends Simulate {
    private final Date endDate; // future date
    private final Date startDate; // current date
    private final Depositable asset;

    public SimulateDepositable(SimulateDepositableRequest request, Owner owner){
        super(owner, request.getEndDate());
        this.endDate = request.getEndDate();
        this.startDate = new Date();
        this.asset = request.getDepositableAsset();
    }

    /**
     * This method calculates the asset value of the depositable asset
     * @return returns the worth of the Depositable asset after calculating the simulated
     * worth of the depositable.
     */

//    @Override
//    public double getAssetValue() {
//        int num_months = startDate.monthDifference(endDate);
//        double temp = asset.getValue();
//        for (int i = 1; i <= num_months; i++) {
//            asset.addInterest();
//        }
//        double assetSimulatedValue = asset.getValue();
//        asset.setBalance(temp);
//        return assetSimulatedValue;
//    }
}

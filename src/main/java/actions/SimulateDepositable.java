package actions;

import entity.Date;
import entity.Depositable;

public class SimulateDepositable extends Simulate {
    private final Date endDate; // future date
    private final Date startDate; // current date
    private final Depositable asset;

    public SimulateDepositable(Date endDate, Depositable asset) {
        super();
        this.endDate = endDate;
        this.startDate = new Date();
        this.asset = asset;
    }

    /**
     * This method calculates the asset value of a depositable asset
     * @return returns the Depositable asset after calculating the simulated worth of the depositable.
     */
    @Override
    public double getAssetValue() {
        int num_months = startDate.monthDifference(endDate);
        double temp = asset.getValue();
        for (int i = 1; i <= num_months; i++) {
            asset.addInterest();
        }
        double assetSimulatedValue = asset.getValue();
        asset.setBalance(temp);
        return assetSimulatedValue;
    }
}

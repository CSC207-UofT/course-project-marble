package actions;

import entity.Date;
import entity.Depositable;

import java.util.Formatter;

public class DepositableSimulateStrategy implements SimulateStrategy{
    private final Date endDate; // future date
    private final Date startDate; // current date
    private final Depositable asset;

    public DepositableSimulateStrategy(Depositable asset, Date endDate){
        super();
        this.endDate = endDate;
        this.startDate = new Date();
        this.asset = asset;
    }

    /**
     * Simulates the depositable asset value at a future date
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
        return Math.round(assetSimulatedValue * 100.0) / 100.0;
    }
}

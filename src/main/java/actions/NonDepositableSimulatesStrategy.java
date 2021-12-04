package actions;

import entity.Date;
import entity.NonDepositable;

public class NonDepositableSimulatesStrategy implements SimulateStrategy {
    private final NonDepositable asset;
    private final Date endDate; // future date

    public NonDepositableSimulatesStrategy(NonDepositable asset, Date endDate) {
        super();
        this.asset = asset;
        this.endDate = endDate;
    }

    /**
     * Simulates the non-depositable future value assuming the asset has not been cashed out.
     */
    @Override
    public double getAssetValue() {
        if (asset.getDateOfMaturity().compareTo(endDate) > 0) {
            return 0;
        }
        int monthDiff = asset.getDateOfMaturity().monthDifference(asset.getDateCreated());
        double interestRate = (asset.getAnnualInterestRate() / 100) * (monthDiff) / 12;
        return interestRate * asset.getVolume() * asset.getPricePerAsset() + (asset.getVolume() * asset.getPricePerAsset());
    }
}

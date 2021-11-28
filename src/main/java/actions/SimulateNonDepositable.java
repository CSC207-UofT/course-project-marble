package actions;

import entity.NonDepositable;

public class SimulateNonDepositable extends Simulate {
    private final NonDepositable asset;

    public SimulateNonDepositable(SimulateNonDepositableRequest request) {
        super();
        this.asset = request.getNonDepositableAsset();
    }
    /**
     * This method calculates the asset value of the nondepositable asset
     * @return returns the worth of the NonDepositable asset after calculating the simulated worth of the Nondepositable.
     */

    @Override
    public double getAssetValue() {
        return asset.getValue();
    }
}

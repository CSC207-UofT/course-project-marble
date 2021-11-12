package actions;

import entity.NonDepositable;

public class SimulateNonDepositable extends Simulate {
    private final NonDepositable asset;

    public SimulateNonDepositable(NonDepositable asset) {
        super();
        this.asset = asset;
    }
    /**
     * This method calculates the asset value of a nondepositable asset
     * @return returns the NonDepositable asset after calculating the simulated worth of the Nondepositable.
     */
    @Override
    public double getAssetValue() {
        return asset.getValue();
    }
}

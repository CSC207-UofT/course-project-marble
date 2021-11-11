package actions;

import entity.FinancialAsset;

public abstract class Simulate {
    /**
     * This is a constructor method for an abstract class for simulating worth of depositable and
     * nondepositable assets.
     */
    public Simulate(){}

    public abstract FinancialAsset getAssetValue(); // hook method

    /** template method: This method returns a simulated asset value for a particular asset */
    public double getSimulatedAssetValue() {
        FinancialAsset asset = getAssetValue();
        return asset.getValue();
    }
}

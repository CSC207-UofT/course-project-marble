package actions;

public abstract class Simulate {
    /**
     * This is a constructor method for an abstract class for simulating worth of depositable and
     * nondepositable assets.
     */
    public Simulate(){}

    public abstract double getAssetValue(); // hook method

    /** template method: This method returns a simulated asset value for a particular asset */
    public double getSimulatedAssetValue() {
        return getAssetValue();
    }
}

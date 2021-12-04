package actions;

public class SimulateContext {
    private SimulateStrategy strategy;

    /**
     * Constructor for the context class that acts to maintain a reference to one of the
     * strategies (depositable and nondepositable)
     * @param strategy The strategy used to simulate the asset value
     */
    public SimulateContext(SimulateStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SimulateStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * @return returns the value of the asset using the specific strategy
     */
    public double executeStrategy() {
        return strategy.getAssetValue();
    }
}

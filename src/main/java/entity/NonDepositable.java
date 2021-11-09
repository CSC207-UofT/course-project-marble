package entity;

public abstract class NonDepositable  extends FinancialAsset{
    private final int volume;
    private final Double pricePerAsset;

    /**
     * Constructor. Sets the date to todays date.
     *
     * @param annualInterestRate annual interest rate which depends on the instrument
     */
    public NonDepositable(double annualInterestRate, int volume, Double pricePerAsset) {
        super(annualInterestRate);
        this.volume = volume;
        this.pricePerAsset = pricePerAsset;
    }

    public int getVolume() {
        return volume;
    }

    public Double getPricePerAsset() {
        return pricePerAsset;
    }
    public abstract double cashOut();
}

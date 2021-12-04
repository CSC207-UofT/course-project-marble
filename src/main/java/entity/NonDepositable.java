package entity;

public abstract class NonDepositable extends FinancialAsset {
    private final int volume;
    private final Double pricePerAsset;
    private final Date dateOfMaturity;

    /**
     * Constructor. Sets the date to todays date.
     *
     * @param annualInterestRate annual interest rate which depends on the instrument
     * @param name Name of the asset
     */
    public NonDepositable(double annualInterestRate, int volume, Double pricePerAsset, String name, Date dateOfMaturity) {
        super(annualInterestRate, name);
        this.volume = volume;
        this.pricePerAsset = pricePerAsset;
        this.dateOfMaturity = dateOfMaturity;
    }

    @Override
    public String toString() {
        return "Asset" + this.name + " created on " + this.getDateCreated() + "at a price of " + this.getPricePerAsset()
                + " dollars per asset is worth " + this.getValue() + " dollars today";
    }

    public int getVolume() {
        return volume;
    }

    public Date getDateOfMaturity() {
        return dateOfMaturity;
    }

    public Double getPricePerAsset() {
        return pricePerAsset;
    }

    public abstract double cashOut();

    public String getName() {
        return name;
    }

}

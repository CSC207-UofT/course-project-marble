package entity;

public abstract class FinancialAsset {
    private final Date dateCreated;
    public double annualInterestRate;
    public String name;

    /**
     * Constructor. Sets the date to todays date.
     *
     * @param annualInterestRate annual interest rate which depends on the instrument
     */
    public FinancialAsset(double annualInterestRate, String name) {
        this.dateCreated = new Date();
        this.annualInterestRate = annualInterestRate;
        this.name = name;
    }

    /**
     * Getter for the name
     *
     * @return name of the financial asset
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the value of the asset today.
     *
     * @return amount of money
     */
    public abstract double getValue();

    /**
     * Getter for the annual interest rate
     *
     * @return Annual Interest Rate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Getter for dateCreated
     *
     * @return the Date object for the date the asset was created
     */
    public Date getDateCreated() {
        return dateCreated;
    }


}

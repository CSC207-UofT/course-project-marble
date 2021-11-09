package entity;

public abstract class FinancialAsset {
    private final Date dateCreated;
    public double annualInterestRate;

    /**
     * Constructor. Sets the date to todays date.
     * @param annualInterestRate annual interest rate which depends on the instrument
     */
    public FinancialAsset(double annualInterestRate) {
        this.dateCreated = new Date();
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Returns the value of the asset today.
     * @return amount of money
     */
    public abstract double getValue();

    /**
     * Getter for the annual interest rate
     * @return Annual Interest Rate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Getter for dateCreated
     * @return the Date object for the date the asset was created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Setter for annual interest rate if a concrete class needs to modify it
     * @param annualInterestRate The new interest rate
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
}
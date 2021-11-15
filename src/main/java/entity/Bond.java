package entity;


public class Bond extends NonDepositable {
    private final Date dateOfMaturity;
    private boolean cashedOut;

    public Bond(int volume, float annualInterestRate, double pricePerBond, Date dateOfMaturity, String name) {
        super(annualInterestRate, volume, pricePerBond, name);
        cashedOut = false;
        this.dateOfMaturity = dateOfMaturity;
    }

    /**
     * Returns the current value of the bond
     *
     * @return current value of the bond
     */
    @Override
    public double getValue() {
        if (cashedOut) {
            return 0;
        }
        Date dateToday = new Date();
        if (dateToday.compareTo(this.dateOfMaturity) < 0) {
            return 0;
        }
        int monthDiff = this.dateOfMaturity.monthDifference(super.getDateCreated());
        double interestRate = (annualInterestRate / 100) * (monthDiff) / 12;
        return interestRate * super.getVolume() * this.getPricePerBond() + (super.getVolume() * this.getPricePerBond());
    }

    /**
     * Returns the date of maturity of the bonds
     *
     * @return dateOfMaturity
     */
    public Date getDateOfMaturity() {
        return this.dateOfMaturity;
    }

    /**
     * Return the total cost of the bonds
     *
     * @return total cost of the bonds
     */
    public double getTotalCost() {
        return super.getPricePerAsset() * super.getVolume();
    }
    /**
     * Retrurns price per bond
     *
     * @return price per bond
     */
    public double getPricePerBond() {
        return super.getPricePerAsset();
    }

    /**
     * Cashes out the bond if it hasn't been already
     *
     * @return The value of the bond at cash out
     */
    @Override
    public double cashOut() {
        if (cashedOut) {
            return -1;
        }
        Date dateToday = new Date();
        if (dateToday.compareTo(this.dateOfMaturity) < 0) {
            return -1;
        }
        double returnVal = this.getValue();
        this.cashedOut = true;
        return returnVal;
    }
}


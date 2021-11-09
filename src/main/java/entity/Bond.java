package entity;


public class Bond extends NonDepositable {
    private final Date dateOfMaturity;
    private boolean cashedOut;
    public Bond(int volume, float annualInterestRate, double pricePerBond, Date dateOfMaturity) {
        super(annualInterestRate,  volume, pricePerBond);
        cashedOut = false;
        this.dateOfMaturity = dateOfMaturity;
    }

    @Override
    public double getValue() {
        if (cashedOut){
            return 0;
        }
        Date dateToday = new Date();
        if (dateToday.compareTo(this.dateOfMaturity) < 0) {
            return 0;
        }
        return this.getPricePerBond() * super.getVolume();
    }

    public Date getDateOfMaturity() {
        return this.dateOfMaturity;
    }
    public double getTotalCost(){
        return super.getPricePerAsset() * super.getVolume();}

    public double getPricePerBond() {
        return super.getPricePerAsset();
    }

    @Override
    public double cashOut() {
        if (cashedOut){
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


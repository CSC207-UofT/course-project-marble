package entity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Bond extends FinancialInstrument{
    private final Date dateOfMaturity;
    private final float pricePerBond;
    private final int volume;
    public Bond(Date dateCreated, int volume, float annualInterestRate, float pricePerBond, Date dateOfMaturity) {
        super(dateCreated, annualInterestRate);
        this.dateOfMaturity = dateOfMaturity;
        this.pricePerBond = pricePerBond;
        this.volume = volume;
    }

    @Override
    public float withdraw() {
        Date currentDate = new java.util.Date();
        boolean matured = currentDate.after(this.dateOfMaturity);
        if (matured){
            long diffInMillieSeconds = Math.abs(super.getDateCreated().getTime() - this.dateOfMaturity.getTime());
            long  diff = TimeUnit.DAYS.convert(diffInMillieSeconds, TimeUnit.MILLISECONDS);
            float periodInterest = (float) diff/365 * super.getAnnualInterestRate();
            return pricePerBond * this.volume * (1 + periodInterest);
        }

        else{
            return pricePerBond * this.volume;
        }
    }

    @Override
    public float getValue() {
        return 0;
    }

    public Date getDateOfMaturity() {
        return this.dateOfMaturity;
    }
    public float getTotalCost(){
        return this.pricePerBond * this.volume;}

    public float getPricePerBond() {
        return this.pricePerBond;
    }
}

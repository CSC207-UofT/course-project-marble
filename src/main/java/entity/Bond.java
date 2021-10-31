package entity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Bond extends FinancialInstrument{
    private final Date dateOfMaturity;
    private final float pricePerBond;

    public Bond(Date dateCreated, int volume, float annualInterestRate, float pricePerBond, Date dateOfMaturity) {
        super(dateCreated, volume, annualInterestRate);
        this.dateOfMaturity = dateOfMaturity;
        this.pricePerBond = pricePerBond;
    }

    @Override
    public float withdraw() {
        Date currentDate = new java.util.Date();
        boolean matured = currentDate.after(this.dateOfMaturity);
        
        if (matured){
            long diffInMillies = Math.abs(super.getDateCreated().getTime() - this.dateOfMaturity.getTime());
            long  diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            float periodInterest = (float) diff/365 * super.getAnnualInterestRate();
            return pricePerBond * super.getVolume() * (1 + periodInterest);
        }
        
        else{
            return pricePerBond * super.getVolume();
        }
    }

    @Override
    public float getValue() {
        return 0;
    }

    public Date getDateOfMaturity() {
        return dateOfMaturity;
    }

    public float getPricePerBond() {
        return pricePerBond;
    }
}

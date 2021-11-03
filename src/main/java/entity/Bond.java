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

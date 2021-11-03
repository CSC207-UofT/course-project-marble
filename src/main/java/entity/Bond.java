package entity;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Bond extends FinancialInstrument{
    private final Date dateOfMaturity;
    private final float pricePerBond;
    private final int volume;
    public Bond(Date dateCreated, int volume, float annualInterestRate, double pricePerBond, SimpleDateFormat dateOfMaturity) {
        super(annualInterestRate);
        this.dateOfMaturity = dateOfMaturity;
        this.pricePerBond = pricePerBond;
        this.volume = volume;
    }

    @Override
    public double getValue() {
//        if (new SimpleDateFormat("MM/yyyy").parse(date).before(new Date())) {

//        }
        return 1;
    }

    public SimpleDateFormat getDateOfMaturity() {
        return this.dateOfMaturity;
    }
    public double getTotalCost(){
        return this.pricePerBond * this.volume;}

    public float getPricePerBond() {
        return this.pricePerBond;
    }
}

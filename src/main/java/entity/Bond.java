package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bond extends FinancialInstrument{
    private final SimpleDateFormat dateOfMaturity;
    private final double pricePerBond;
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

    public double getPricePerBond() {
        return this.pricePerBond;
    }
}

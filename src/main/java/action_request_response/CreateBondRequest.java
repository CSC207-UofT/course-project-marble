package action_request_response;

import entity.Date;

public class CreateBondRequest extends ActionRequest {
    private final String name;
    private final Date dateOfMaturity;
    private final double pricePerAsset;
    private final int volume;
    private final double InterestRate;

    public CreateBondRequest(String username, String name, float interestRate, double pricePerAsset, int volume, Date dateOfMaturity) {
        super(username);
        this.name = name;
        this.pricePerAsset = pricePerAsset;
        this.volume = volume;
        this.InterestRate = interestRate;
        this.dateOfMaturity = dateOfMaturity;
    }

    public double getInterestRate() {
        return InterestRate;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public double getPricePerAsset() {
        return pricePerAsset;
    }

    public Date getDateOfMaturity() {
        return dateOfMaturity;
    }
}
